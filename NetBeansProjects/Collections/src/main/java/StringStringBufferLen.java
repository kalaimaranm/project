/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringStringBufferLen implements Comparator{
    public static void main(String[] args) {
        System.out.println("String and StringBuffer are in TreeSet and sort by its length");
        TreeSet tssb = new TreeSet(new StringStringBufferLen());
        tssb.add("x");
        tssb.add(new StringBuffer("ka"));
        tssb.add("ima");
        tssb.add(new StringBuffer("f"));
        tssb.add("d");
        tssb.add(new StringBuffer("b"));
         System.out.println(tssb);
    }
    public int compare(Object obj1,Object obj2){
        String s1 = obj1.toString();
        String s2 = obj2.toString();
        if(s1.length()<s2.length()){
               return -1;
        }
        else if(s1.length()>s2.length()){
                return 1;
        }
        else if(s1.length()==s2.length()){
            return s1.compareTo(s2);
        }
        return 0;
    }
}
