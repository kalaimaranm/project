package com.java8.feature.lambda;

public class Java8Feature {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Shape rectangle = new Rectangular();
        rectangle.colour();

        Shape circle = () -> System.out.println("shape is cirle...");

    }
}


@FunctionalInterface
interface Shape {

    void draw();

    default void colour() {
        System.out.println("colour is black");
    }

    static void staticMethod() {

        System.out.println("static method");
    }
}

class Rectangular implements Shape {

    @Override
    public void draw() {

        System.out.println("rectangle shape []");
    }

}
