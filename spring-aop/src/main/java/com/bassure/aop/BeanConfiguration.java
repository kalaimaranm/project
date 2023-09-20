
package com.bassure.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.bassure")
@EnableAspectJAutoProxy
public class BeanConfiguration {
    
    
    
}
