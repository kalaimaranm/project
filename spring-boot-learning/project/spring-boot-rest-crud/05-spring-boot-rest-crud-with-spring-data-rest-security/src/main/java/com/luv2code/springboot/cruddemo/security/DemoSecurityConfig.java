package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails marry = User.builder()
//                .username("marry")
//                .password("{noop}marry")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails james = User.builder()
//                .username("james")
//                .password("{noop}james")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails billu = User.builder()
//                .username("billu")
//                .password("{noop}billu")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails dan = User.builder()
//                .username("dan")
//                .password("{noop}dan")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(marry, james, billu, dan);
//    }
    
    
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select * from member where user_id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select * from role where user_id = ?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer
                -> configurer.requestMatchers(HttpMethod.GET, "/magic-api/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/magic-api/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/magic-api/members").hasRole("MANAGER"));

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

}
