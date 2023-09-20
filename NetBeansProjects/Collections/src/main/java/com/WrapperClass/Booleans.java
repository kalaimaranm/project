/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.WrapperClass;

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Booleans {
    public static void main(String[] args) {
      Boolean b = new Boolean("true");       //true 
      Boolean b2 = new Boolean("boolean");  // false
        System.out.println("b2 is "+b2);
        System.out.println(b.equals(b2));
        Boolean bb = new Boolean("true"); 
        Boolean bb2 = new Boolean("True");
        System.out.println("bb2 is "+bb2);
        System.out.println("bb ad bb2 is "+bb.equals(bb2));
        Boolean bo1 = new Boolean("sensitive");   // false
        Boolean bo2 = new Boolean("sensitive");   // false
        System.out.println(bo1.equals(bo2));      // true
        Integer i = Integer.valueOf("1111",3);
        System.out.println(i);

    }
}
