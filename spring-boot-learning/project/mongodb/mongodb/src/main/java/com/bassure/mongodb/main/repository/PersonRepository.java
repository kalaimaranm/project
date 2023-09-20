
package com.bassure.mongodb.main.repository;

import com.bassure.mongodb.main.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends MongoRepository<Person, Integer>{
    
}
