/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Objects {
    String name;
   // int rollNo;
    Objects(String name)//,int rollNo)
    {
        this.name=name;
        //this.rollNo = rollNo;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
//        Objects ob1 = new Objects("rajesh",100);
//        Objects ob2 = new Objects("rakesh",101);
//        System.out.println(ob1.toString());
//        System.out.println(ob2);
//        System.out.println(ob1.equals(ob2));
//        System.out.println(ob1.hashCode());
          Objects o = new Objects("java"); 
          Objects o1 = new Objects("java"); 
          Objects o2 = (Objects) o1.clone();
          String s = "java";
          String s2 = new String("java");
          String s3 = (String) s2.clone();
          String ss = new String("javajava");
          String ss2 = new String("javajava");
          System.out.println("ss hashCode "+ss.hashCode());
          System.out.println("ss2 hashCode "+ss2.hashCode());
          System.out.println("s hashCode "+s.hashCode());
          System.out.println("s2 hashCode "+s2.hashCode());
          System.out.println("ident of ss "+System.identityHashCode(ss));
          System.out.println("ident of ss2 "+System.identityHashCode(ss2));
//        
        
    }
//    public String toString(){
//        String name=this.name;
//        int rollNo = this.rollNo;
//        return ""+name + " "+ rollNo +"....";
//    }
    public boolean equals(Objects obj){
        String namee = (String) obj.name;
        int rollNoo = (int) obj.rollNo;
        CloneS.second();
        if(namee.equals(this.name) && this.rollNo==rollNoo){   // String equals method overriden for content comparision 
            return true;
        }
        return false;
    }
//    public int hashCode(){
//        return this.rollNo;   // hashCode should be unique
//    }
}
 class CloneS implements Cloneable{
    int num;
    CloneS(int num){
        this.num = num;
    }
    public static void second() throws CloneNotSupportedException{
        CloneS c = new CloneS(10);
        CloneS 2 = c.clone();
    }
}
