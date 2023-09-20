package com.workshop.security.appsecurity;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ApplicationSecurity {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//http.authorizeHttpRequests()
//        .requestMatchers("sldjf").hasRole("ksfldj")
//        .and()
//        .authorizeHttpRequests()
//        .requestMatchers(HttpMethod.GET)


        http.authorizeHttpRequests(auth
                -> {
            auth.anyRequest().authenticated();
            
        });
        
        return http.build();
        
    }
}
