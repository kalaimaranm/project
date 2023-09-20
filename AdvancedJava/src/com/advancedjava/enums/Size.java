package com.advancedjava.enums;

public enum Size {
    REGULAR(100), //static final object
    MEDIUM(150), //static final object
    LARGE(210), //static final object
    EXTRA_LARGE(250);//static final object

   int price;

    Size(int price) {
       this.price = price;
    }

//    Size() {
//
//    }
//***** after the compilation java will change the enum into below format. It create object for every constant inside Enum
//    public class Size {
//
//        static final Size REGULAR = new Size();
//        static final Size MEDIUM = new Size();
//        static final Size LARGE = new Size();
//        static final Size EXTRA_LARGE = new Size();
//        int price;
//
//        Size(int price) {
//            this.price = price;
//        }
//
//        Size() {
//
//        }
//
//    }
    

}
