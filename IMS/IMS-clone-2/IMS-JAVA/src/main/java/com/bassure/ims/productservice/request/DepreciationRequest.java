package com.bassure.ims.productservice.request;

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
public class DepreciationRequest {

    private double intialValue;
    private double depreciationValue;
    private String depreciationYear;

}
