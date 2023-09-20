package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEntity {
    private ResponseHeader header;
    private ResponseBody body;
}
