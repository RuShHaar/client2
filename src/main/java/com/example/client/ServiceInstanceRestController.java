package com.example.client;


import com.example.client.service.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;


@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ControllerService controllerService;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String sayHello()
    {
        return "Hello!";
    }


    @RequestMapping(value="/terminabholung",method = RequestMethod.GET)
    public String getVaccineDate(@RequestParam String name) {
        String url = discoveryClient.getInstances("eurekaclient").get(0).getUri().toString() + "/termin?name="+name;
        RestTemplate restTemplate = new RestTemplate();
        return "Ergebnis: " + restTemplate.getForObject(url, String.class);
    }
}

