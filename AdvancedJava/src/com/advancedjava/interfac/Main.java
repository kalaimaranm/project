package com.advancedjava.interfac;

public class Main implements MyInterface {

//    @Override
    public static void staticMethod() {
        System.out.println(">>>>>>> inside implemented class static method() >>>>>>>>>");
   
    }

    @Override
    public void defaultMethod() {
        System.out.println(">>>>>>> inside implmentation class default method() >>>>>>>>");
        
    }

    public static void main(String[] args) {

        new Main().defaultMethod();
        new Main().staticMethod();
        MyInterface.staticMethod();
        
        
    }

}
