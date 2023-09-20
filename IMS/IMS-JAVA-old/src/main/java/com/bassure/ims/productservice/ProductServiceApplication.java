package com.bassure.ims.productservice;

import com.bassure.ims.productservice.config.HttpStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
//@PropertySources({@PropertySource("classpath:message.properties"),
//                         @PropertySource("classpath:mail.properties")})
//@Configuration
@PropertySource("classpath:http-status-code.properties")
@EnableMongoAuditing

public class ProductServiceApplication {

//    @Autowired
//    private static HttpStatusCode status;
    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);

//        HttpStatusCode status = context.getBean(HttpStatusCode.class);
//        System.out.println(status + " checking status code2 : " + status.getErrorCode()
//                + "  " + status.getSuccessCode());

    }

}
