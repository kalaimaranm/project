package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warranty {
    private String startDate;
    private String endDate;
    private String status;
}
