
package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends MongoRepository<Brand, String>{
    
}
