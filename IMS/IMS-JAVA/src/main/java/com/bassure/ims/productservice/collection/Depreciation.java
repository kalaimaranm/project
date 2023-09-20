package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Depreciation {

    @Field(value = "initial_value")
    private double initialValue;

    @Field(value = "depreciation_value")
    private double depreciationValue;

    @Field(value = "depreciation_Year")
    private LocalDateTime depreciationYear;
}
