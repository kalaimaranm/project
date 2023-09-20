
package com.bassure.ims.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DeleteResponse {

    private boolean isSuccess;

    private String message;

    @Setter
    @Getter
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TenantResponse {

        private int tenantId;

        private String tenantName;
    }
}
