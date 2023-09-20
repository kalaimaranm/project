
package com.advancedjava.enums;

//import Enum.Toppings;


public class OrderPizza {  
    public static void main(String[] args) {
       Size pizza=Size.LARGE;
       Size pizza2=Size.EXTRA_LARGE;
       
        System.out.println(pizza.price);
        System.out.println(pizza.name());
        System.out.println(pizza2.name());
        System.out.println(pizza2.price);
        
        
    }
    
    
    
//    public static void main(String[] args) {
//        // static final
//        // ver - 1.5 (5)
//        // cannot able instantiate the Enum(class) - because Enum already have a constant value use that value only 
//        // you can't add new value by using new keyword
//        // Enum(class) are constants 
//        // enum can be created inside the class or outside the class. But not inside the methods
//        // switch case cases only constants are allowed no other values 
//        // All the Enum(Objects) are ordered in index
//        // All enum class extends Enum class
//        // Enum can implements interface But cannot extends any other classes
//        Toppings t1 = Toppings.MUSHROOM;
//        System.out.println(t1);
//        Toppings[] values = Toppings.values();
//        for(Toppings t : values){
//            System.out.println(t);
//        }
        
//        Stack s = new Stack();
//        s.
        
//    }
}
