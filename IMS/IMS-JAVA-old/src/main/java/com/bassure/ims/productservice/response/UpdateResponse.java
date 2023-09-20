
package com.bassure.ims.productservice.response;

import com.bassure.ims.productservice.collection.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpdateResponse {
    private boolean isSuccess;
    private Supplier supplier;
}
