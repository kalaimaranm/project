package com.advancedjava.enums;

public enum BreadType {
    WHEATBREAD(40),
    HAND_TOASTED(20),
    PLAINBREAD(0),
    FRESH_PAN(20),
    SOFT_CRUNCH(50);

    int price;

    BreadType(int price) {
        this.price = price;
    }
}
