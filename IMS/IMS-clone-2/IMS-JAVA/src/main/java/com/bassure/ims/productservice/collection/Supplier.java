
package com.bassure.ims.productservice.collection;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.bassure.ims.productservice.collection.Address;
import org.springframework.data.annotation.Id;
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

    @Field(value = "supplier_name")
    private String contactPerson;

    @Field(value = "supplier_email")
    private String email;

    @Field(value = "supplier_phone")
    private Long phone;

    @Field(value = "supplier_address")
    private Address address;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "upated_at")
    private LocalDateTime updatedAt;

    @Field(value = "status")
    private String status;
    
}
