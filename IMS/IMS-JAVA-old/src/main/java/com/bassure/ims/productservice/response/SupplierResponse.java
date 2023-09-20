package com.bassure.ims.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.bassure.ims.productservice.collection.Address;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SupplierResponse {

    private String name;

    private String email;

    private Long phone;

    private Address address;

}
