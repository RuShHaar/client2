package com.example.client;



import com.example.client.service.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
class ServiceInstanceRestController {

//@Autowired
//ClientInterface clientInterface;

@Autowired
    ControllerService controllerService;


    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
//
//    @RequestMapping(value="/test", method = RequestMethod.GET)
//    public String sayHello()
//    {
//        return "Hello!";
//    }
//
//
//    @RequestMapping(value="/terminabholung",method = RequestMethod.GET)
//    public String getVaccineDate(@RequestParam String name) {
//        return "Ergebnis: " + clientInterface.getVaccineDate(name);
//    }

    @RequestMapping(value="/umrechnung",method = RequestMethod.GET)
    public BigDecimal convertCurrency(@RequestParam BigDecimal usd){
        return controllerService.convertCurrency(usd);
    }
}

