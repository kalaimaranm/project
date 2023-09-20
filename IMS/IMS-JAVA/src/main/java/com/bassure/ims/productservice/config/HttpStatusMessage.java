package com.bassure.ims.productservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ims.statusmessage")
@Setter
@Getter
@Component
public class HttpStatusMessage {

    private String errorKey;
    private String success;
    private String failed;
    private String deleteMessage;
    private String editMessage;
    private String addMessage;
    private String alreadyExists;
    private String noDataFound;
    private String serverError;
}
