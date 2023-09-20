package com.bassure.ims.productservice.collection;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

}
