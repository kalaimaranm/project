package com.advancedjava.enums;

public enum Crust {
    PLAIN(0),
    CHEESE(40),
    DOUBLE_CHEESE(70),
    CHEESE_OVERLOADED(100);

    int price;

    Crust(int price) {
        this.price = price;
    }
}
