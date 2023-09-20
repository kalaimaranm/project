/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
public class ExceptionHandling {

    public static void main(String[] args) { // callstack tracking
        System.out.println("main() START");
        a();
        System.out.println("main() END");
    }

    public static void a() {
        System.out.println("a() START");
        b();
        System.out.println("a() END");
    }

    public static void b() {
        System.out.println("b() START");
        c();
        System.out.println("b() END");
    }

    public static void c() {
        System.out.println("c() START");
int i = Integer.parseInt("ff");
        System.out.println(i);
        System.out.println("c() END");
    }{
            System.out.println("Empty Block");}
}
