package com.bassure.ims.productservice.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

public class Rental {
    @Id
    private String rentalId;



    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    private LocalDateTime updatedAt;
}
