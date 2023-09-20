package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depreciation {
    private double initialValue;
    private double depreciationValue;
    private String depreciationDate;
}
