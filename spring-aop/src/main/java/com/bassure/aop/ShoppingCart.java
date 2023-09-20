package com.bassure.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void addToCart(String product) {

        System.out.println("addToCart method from ShoppingCart class");
    }
}
