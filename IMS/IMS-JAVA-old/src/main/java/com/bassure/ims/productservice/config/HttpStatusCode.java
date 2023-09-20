package com.bassure.ims.productservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "inventory.statuscode")
@Setter
@Getter
@Component
public class HttpStatusCode {

    private int success;

    private int error;

    private int geoFencing;

    private int resourceNotFound;

    private int tokenUpdate;

    private int timeOut;

    private int noData;

    private int authorize;

    private int wrongEndPoint;

    private int duplication;

    private int failed;

    private int serverError;

    private int noNetworkConnection;

}
