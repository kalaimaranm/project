package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Order")
public class Orders {

    @Id
    private String orderId;

    @Field(value = "order_date")
    private LocalDateTime orderDate;

    @Field(value = "created_at")
    @CreatedDate
    private LocalDateTime createAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "supplier_id")
    private String supplierId;

    @Field(value = "status")
    private String status;

}
