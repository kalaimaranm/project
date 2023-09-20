/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author bas200193
 */
public class Main extends Parent {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.prints();
        Main m = new Main();
        m.prints();
        m.prints();
    }
    public void prints(){
        System.out.println("This is child class");
    }
}

class Parent{
    public void prints(){
        System.out.println("This is parent class");
    }
}