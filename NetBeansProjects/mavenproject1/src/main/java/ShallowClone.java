/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class ShallowClone implements Cloneable{
    int age;
    //sint id;
    String name;
    Initial i;
    ShallowClone(ShallowClone i,String name){
      this.age = age;
      this.name=name;
    }
    ShallowClone(int age){
        this.age = age;
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        ShallowClone sc = new ShallowClone(1000);
        //Initial ii = new Initial(1000);
        ShallowClone sc1 = new ShallowClone(sc,"BMW");
        ShallowClone sc2 = (ShallowClone) sc1.clone();
        System.out.println("shallowCopy of sc1 "+ sc1.sc.age+" "+sc1.name);
        sc2.i.id = 2000;
        System.out.println("shallowCopy of sc1 after changing the sc2 "+ sc1.i+" "+sc1.name);
        System.out.println("shallowCopy of sc1 after changing the sc2 "+ sc2.i+" "+sc1.name);

        
    }
    public String toString(){
        return this.i +" " + this.name;
    }

   
}
 