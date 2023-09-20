package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {

    @Field(value = "city")
    private String city;
    @Field(value = "state")
    private String state;
    @Field(value = "country")
    private String country;
    @Field(value = "postal_code")
    private int postalCode;

}
