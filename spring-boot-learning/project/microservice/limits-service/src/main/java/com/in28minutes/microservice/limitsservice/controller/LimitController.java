package com.in28minutes.microservice.limitsservice.controller;

import com.in28minutes.microservice.limitsservice.model.Configurations;
import com.in28minutes.microservice.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private Configurations configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        System.out.println("limits: " + configuration);

        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
