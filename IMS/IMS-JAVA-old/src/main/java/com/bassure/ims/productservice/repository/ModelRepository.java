package com.bassure.ims.productservice.repository;

import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.request.ModelRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends MongoRepository<Model, String> {

    public Model save(ModelRequest model);
}
