package com.bassure.ims.productservice.config;

import com.bassure.ims.productservice.ProductServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;


public class Checking {

    @Autowired
    private static HttpStatusCode status;

    public static void main2(String[] args) {

//        System.out.println("checking status code : " + HttpStatusCode.getERROR_CODE()
//                + "  " + HttpStatusCode.getSUCCESS_CODE());
//        System.out.println("checking status code2 : " + status.getErrorCode()
//                + "  " + status.getSuccess());
//        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
