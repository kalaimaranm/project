package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Warranty {

    @Field(value = "start_date")
    private String startDate;

    @Field(value = "end_date")
    private String endDate;

    @Field(value = "status")
    private String status;
}
