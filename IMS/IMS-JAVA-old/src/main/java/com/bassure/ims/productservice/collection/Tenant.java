package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tenant")
public class Tenant {
    @Id
    private String id;

    @Field(value = "tenant_id")
    private int tenantId;

    @Field(value = "tenant_name")
    private String tenantName;
}
