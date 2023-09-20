package com.advancedjava.varargs;

import java.util.Arrays;

public class Varargs {

    // var-args internally using One-Dimensional array (automatically create a object for arguments)
    // it converted into One-Dimensional array
    // why we need var-args instead we can directly use the One-Dimensional array? mutlipurpose-we can use both number of arugument or one-Dimensional array directly
    // In One-Dimensional array we can't use above condition
    // Least priority to the var-args methods
    // Backward Compatability - the older feature should have first priority than a new feature
    public static void main(String... args) {
        System.out.println(" >>main() method ");

        System.out.println("Addition of 5 numbers: " + add(1, 2, 3, 4, 5));
        System.out.println("Addition of 4 numbers: " + add(1, 2, 3, 4));
        System.out.println("Addition of 3 numbers: " + add(1, 2, 3));
        System.out.println("Addition of 5 numbers: " + add(1, 2, 3, 4, 5, 6));

        System.out.println("Logic testing");
        byte b = 10;
        logic(b);
        System.out.println("Logic testing2");
        byte[] _byte = {10, 20, 30};
        logic2(b, b, b, b);  // here variable is converted into array
        logic2(_byte);   // here we arguments are passing as object array

    }

    public static int add(int i1, int i2) {
        return i1 + i2;
    }

    public static int add(int i1, int i2, int i3) {
        return i1 + i2 + i3;
    }

    public static int add(int i1, int i2, int i3, int i4) {
        return i1 + i2 + i3 + i4;
    }

    public static int add(int i1, int i2, int i3, int i4, int i5) {
        return i1 + i2 + i3 + i4 + i5;
    }

    public static int add(int... num) {
        return Arrays.stream(num).sum();
    }
    // CASE : 2  -> Backward compatability

    public static void logic(int i1) {
        System.out.println(" >>inside logic() method ");
    }

    public static void logic(byte... i1) {
        System.out.println(">> inside var-args method");
    }
    //CASE : 3     -> accepting the array object 
    //             -> accepting the multiple array format multiple variables

    public static void logic2(byte[] b1) {
        System.out.println(">> inside byte[] method");
    }

    public static void logic2(int... i1) {
        System.out.println(">> inside int[] method");
    }

    //  CASE : 4       -> var-args should come last in the argument
    public static void logic3(int id, String... name) {

    }
    
    //  CASE : 5 should have only one type in array   
    
//    public static void logic4(String[] names){
//        
//    }
//    
//    public static void logic4(String... names){
//        
//    }
}
