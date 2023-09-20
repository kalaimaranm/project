package com.bassure.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAop {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.addToCart("Nuts");

    }
}
