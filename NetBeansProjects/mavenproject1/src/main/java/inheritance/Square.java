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
public class Square extends Rectangle{
    
    ////
    int side;
    Square(int side){
        super(side,side);
        this.side=side;
    }
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            Random r = new Random();
            Square s =new Square(r.nextInt(100));
            System.out.println("The perimeter is "+s.perimeter()+"The area is "+s.area());
        }
    }
}
 class Rectangle {
    int length;
        int breadth;
        Rectangle(int length,int breadth){
        this.length = length;
        this.breadth = breadth;
        }
    public static void main2() {
        Rectangle r = new Rectangle(10,50);
        int area = (int)r.area();
    }
    public int area(){
        return this.length*this.breadth;
    }
    public int perimeter(){
        return 2*(this.length+this.breadth);
    }
}
