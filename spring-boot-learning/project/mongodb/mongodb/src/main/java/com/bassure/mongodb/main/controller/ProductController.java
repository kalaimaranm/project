
package com.bassure.mongodb.main.controller;

import com.bassure.mongodb.main.collection.Person;
import com.bassure.mongodb.main.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private PersonService personServiceImpl;
    
    
    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        
     return ResponseEntity.ok(personServiceImpl.save(person));
    }
    
    
}
