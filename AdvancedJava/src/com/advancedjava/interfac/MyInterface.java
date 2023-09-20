package com.advancedjava.interfac;

public interface MyInterface {

    // all the abstract method in interface bu default cannot be final and public
    public static void staticMethod() {
        System.out.println(">>>>>>>>>>>>>> inside static method() >>>>>>>>>>>>>>>>");
    }

    public default void defaultMethod() {
        System.out.println(">>>>>>>>>>>>>> inside default method() >>>>>>>>>>>>>>>");
    }

    public default void finalDefaultMethod() {
        System.out.println("");
    }
}
