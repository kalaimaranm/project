/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author bas200193
 */
import java.util.*;
public class MainShape
{
	public static void main(String[] args) {
	Square s = new Square();
	s.print();
	}
}
class Shape{
    public void print(){
       System.out.println("This is shape");
       
    }
}
class Rectangle extends Shape{
    public void print(){
        
        System.out.println("This is Rectangle");
        super.print();
    }
}
class Circle extends Shape{
    public void print(){
        System.out.println("This is Circle");
    }
}
class Square extends Rectangle{
    public void print(){
        System.out.println("Square is a Rectanlge");
        super.print();
    }
}