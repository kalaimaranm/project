package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String generateSequence(String seqName) {
        DatabaseSequence databaseSequence = mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("lastSequence", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class
        );
        long lastSequence = Objects.requireNonNull(databaseSequence).getLastSequence();
        return UUID.randomUUID() + "-" + lastSequence;
    }
}
