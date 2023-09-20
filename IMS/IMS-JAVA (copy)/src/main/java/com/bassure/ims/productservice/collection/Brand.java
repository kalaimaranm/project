package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "brand")
public class Brand {
    @Id
    private String branId;

    @Field(value = "brand_name")
    @Indexed(unique = true)
    private String brandName;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    private LocalDateTime updatedAt;
}
