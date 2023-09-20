package com.bassure.ims.productservice.response;

import com.bassure.ims.productservice.request.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyResponse {

    private String startDate;
    private String endDate;
    private String status;
}
