package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category {
    @Id
    private String categoryId;

    @Field(value = "category_name")
    private String categoryName;

    @Field(value = "parent_category_id")
    private String parentCategoryId;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "status")
    private String status;
}
