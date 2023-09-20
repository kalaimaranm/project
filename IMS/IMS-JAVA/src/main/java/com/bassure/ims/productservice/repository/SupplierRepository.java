
package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String>{
    
}
