
package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Orders,String>{
    
}
