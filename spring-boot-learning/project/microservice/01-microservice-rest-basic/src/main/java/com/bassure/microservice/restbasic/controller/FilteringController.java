package com.bassure.microservice.restbasic.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public Filtering filtering() {

        return new Filtering("name", "password", "place");
    }

    @GetMapping("/filtering-list")
    public List<Filtering> filteringAList() {

        return Arrays.asList(new Filtering("name", "password", "place"),
                new Filtering("name2", "password2", "place2"));
    }

    public MappingJacksonValue filteringShowPassword() {

        Filtering filtering = new Filtering("name", "passowrd", "place");
        
        
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filtering);

        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "password");

        FilterProvider filter = new SimpleFilterProvider().addFilter("data-hiding-filter", propertyFilter);

        mappingJacksonValue.setFilters(filter);
        
        return mappingJacksonValue;
    }

    
}
