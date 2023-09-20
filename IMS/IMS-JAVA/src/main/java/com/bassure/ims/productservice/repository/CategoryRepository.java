package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<List<Category>> findByParentCategoryId(String parentId);
}
