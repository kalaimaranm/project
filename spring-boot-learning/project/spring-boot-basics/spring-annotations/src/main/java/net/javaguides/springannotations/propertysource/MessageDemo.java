package net.javaguides.springannotations.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MessageDemo {
    
    @Autowired
    private Environment environment;

//    @Value("${app.name}")
    private String appName;

//    @Value("${app.description}")
    private String description;
    
    public String getAppName() {
        return environment.getProperty("app.name");
    }
    
    public String getDescription() {
        return environment.getProperty("app.description");
    }
    
}
