package com.bassure.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.bassure.aop.ShoppingCart.addToCart(..))")
    public void logger() {

        System.out.println("logger method from LogginAspect class");
    }

    @After("execution(* com.bassure.aop.ShoppingCart.addToCart(..))")
    public void afterLogger() {
        System.out.println("afterLogger method from LoggingAspect class");

    }

}
