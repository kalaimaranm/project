package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Depreciation {
    
    private double initialValue;
    private double depreciationValue;
    private String depreciationDate;
}
