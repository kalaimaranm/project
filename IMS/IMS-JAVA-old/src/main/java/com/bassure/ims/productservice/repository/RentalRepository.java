
package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentalRepository extends MongoRepository<Rental,String>{
    
}
