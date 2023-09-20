package com.bassure.ims.productservice.config;

import lombok.Getter;

public class UtilsConfig {
    @Getter
    private static final int SUCCESS_CODE = 600;
    @Getter
    private static final int ERROR_CODE = 602;
    @Getter
    private static final int BAD_REQUEST_CODE = 603;
    @Getter
    private static final String PRODUCT_SEQUENCE_NAME = "product_sequence";
    @Getter
    private static final String MODEL_SEQUENCE_NAME = "model_sequence";
    @Getter
    private static final String CATEGORY_SEQUENCE_NAME = "category_sequence";
    @Getter
    private static final String BRAND_SEQUENCE_NAME = "brand_sequence";
    @Getter
    private static final String RENTAL_SEQUENCE_NAME = "rental_sequence";
    @Getter
    private static final String ORDER_SEQUENCE_NAME = "order_sequence";
    @Getter
    private static final String SUPPLIER_SEQUENCE_NAME = "supplier_sequence";
}
