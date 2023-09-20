package net.javaguides.springannotations.config;

import net.javaguides.springannotations.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ApplicationConfiguration {

    @Bean
//    @Lazy
    public NotificationService notification() {

        return new NotificationService();
    }

}
