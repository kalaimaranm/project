package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "rental")
public class Rental {

    @Id
    private String rentalId;

    @Field(value = "start_date")
    private LocalDateTime startDate;


    @Field(value = "end_date")
    private LocalDateTime endDate;

    @Field(value = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "product_id")
    private String productId;
}
