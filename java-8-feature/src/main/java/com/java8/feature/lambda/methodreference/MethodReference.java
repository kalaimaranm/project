package com.java8.feature.lambda.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {

//    method reference did not have parameter
    public static void main(String[] args) {

//        method reference in static method
        Function<Integer, Double> sqrt = Math::sqrt;

        System.out.println("sqrt of 4 is : " + sqrt.apply(4));

//        method reference 
        Function<String, Integer> functionImpl = String::length;

        System.out.println(functionImpl.apply("James Gosling"));

//        lambda expression 
//        BiFunction<Integer, Integer, Integer> addition = (a, b) -> MethodReferenceDemo.add(a, b);
//        method reference
        BiFunction<Integer, Integer, Integer> addition = MethodReferenceDemo::add;
        System.out.println("addition of 10 + 10 is : " + addition.apply(10, 10));

//        method reference to a instance method of a object ((call-back function)
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        Printable print = methodReferenceDemo::display;
        print.lowerToUpperCase("Hello world java...!");
        
    }

}

class MethodReferenceDemo {

    public static int add(int a, int b) {

        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public void display(String word) {
        System.out.println("word is : " + word.toUpperCase());
    }
}

interface Printable {

    void lowerToUpperCase(String string);
}
