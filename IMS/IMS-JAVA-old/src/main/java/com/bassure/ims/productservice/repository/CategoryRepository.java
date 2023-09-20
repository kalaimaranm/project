package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Category getByCategoryId(String id);
}
