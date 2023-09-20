package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends MongoRepository<Customer, Integer> {
}