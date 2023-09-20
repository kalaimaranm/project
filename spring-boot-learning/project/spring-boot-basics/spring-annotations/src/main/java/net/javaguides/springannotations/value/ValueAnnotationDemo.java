package net.javaguides.springannotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationDemo {

    @Value("default-name")
    private String defaultName;

    @Value("${com.demo.email}")
    private String email;

    @Value("${com.demo.hostname}")
    private String hostName;

    @Value("${com.demo.password}")
    private String password;

    public String getDefaultName() {
        return defaultName;
    }

    public String getEmail() {
        return email;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPassword() {
        return password;
    }

}
