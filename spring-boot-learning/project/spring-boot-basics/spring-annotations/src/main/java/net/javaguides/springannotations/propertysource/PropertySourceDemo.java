package net.javaguides.springannotations.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceDemo {

    @Value("${com.mail.id}")
    private String mailid;

    @Value("${com.mail.hostname}")
    private String hostname;

    @Value("${com.mail.password}")
    private String password;

    public String getMailid() {
        return mailid;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPassword() {
        return password;
    }
    
    

}
