package iopackages;

public class NewClass {

    public static void main(String[] args) {
        var i = 10;
        var j = 10;
        System.out.println(i == j);  // true
        var I = (Integer) 10;
        var J = (Integer) 10;

        System.out.println("Hello World");
        var n = 42; // n has type 'int' 
        method(n);   // int method  first preference is int(primitive because by default it stored as primitive)
    }

    public static void method(Integer i) {
        System.out.print("Integer method");
    }

    public static void method(int i) {
        System.out.print("int method");
    }

}
