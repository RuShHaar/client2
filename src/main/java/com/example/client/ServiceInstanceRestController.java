package com.example.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.List;


@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping(value="/terminabholung",method = RequestMethod.GET)
    public String abholung(@RequestParam String name) {
        String url = discoveryClient.getInstances("eurekaclient").get(0).getUri().toString() + "/termin?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        return "Ergebnis: " + restTemplate.getForObject(url, String.class);
          }
}




//String url = discoveryClient.getInstances(serviceName).get(0).getUri().toString() + "/next-vaccination?lastname=ThirdClient";
//RestTemplate restTemplate = new RestTemplate();
//return "Ergebnis: " + restTemplate.getForObject(url, String.class);