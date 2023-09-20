package com.bassure.mongodb.main.service;

import com.bassure.mongodb.main.collection.Person;
import com.bassure.mongodb.main.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository PersonRepositoryImpl;

    @Override
    public Person save(Person person) {

        return PersonRepositoryImpl.save(person);
    }
    
    

}
