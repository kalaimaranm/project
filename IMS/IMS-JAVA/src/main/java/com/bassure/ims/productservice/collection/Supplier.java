package com.bassure.ims.productservice.collection;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {

    @Id
    private String supplierId;

    @Field(value = "supplier_name")
    private String name;

    @Field(value = "contact_name")
    private String contactPerson;

    @Field(value = "supplier_email")
    private String email;

    @Field(value = "supplier_phone")
    private long phone;

    @Field(value = "supplier_address")
    private Address address;

    @Field(value = "created_at")
     private LocalDateTime createdAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "status")
    private String status;

}
