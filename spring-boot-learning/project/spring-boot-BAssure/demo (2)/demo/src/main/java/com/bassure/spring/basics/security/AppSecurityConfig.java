package com.bassure.spring.basics.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import static org.springframework.security.config.Customizer.withDefaults;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class AppSecurityConfig {

//    @Bean
//    public SecurityFilterChain configSecurity(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(configurer
//                -> configurer
//                        .requestMatchers(HttpMethod.GET, "/all-secured/**")   .hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
//                        .requestMatchers("WEB-INF/pages").permitAll()
//                        .anyRequest().authenticated()
//        );
////                        .requestMatchers(HttpMethod.GET, "/magic-api/members/**").hasRole("EMPLOYEE")
////                        .requestMatchers(HttpMethod.DELETE, "/magic-api/members/**").hasRole("ADMIN")
////                        .requestMatchers(HttpMethod.PUT, "/magic-api/members").hasRole("MANAGER")
////                        .requestMatchers(HttpMethod.POST, "/magic-api/members").hasRole("MANAGER"));
//
//        http.formLogin(withDefaults());
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//
//    }
//
//    @Bean
//    public UserDetailsManager userDetails(DataSource dataSource) {
//
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//
//        manager.setUsersByUsernameQuery("select email,password,active from member where email = ?");
//
//        manager.setAuthoritiesByUsernameQuery("select email,authority from role where email = ?");
//
//// http.authorizeHttpRequests(configurer
////                -> configurer.requestMatchers(HttpMethod.GET, "/magic-api/members").hasRole("EMPLOYEE")
////                        .requestMatchers(HttpMethod.GET, "/magic-api/members/**").hasRole("EMPLOYEE")
////                        .requestMatchers(HttpMethod.DELETE, "/magic-api/members/**").hasRole("ADMIN")
////                        .requestMatchers(HttpMethod.PUT, "/magic-api/members").hasRole("MANAGER")
////                        .requestMatchers(HttpMethod.POST, "/magic-api/members").hasRole("MANAGER"));
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
}
