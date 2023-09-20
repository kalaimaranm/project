/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.Map;
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(1000,"naveen");
        hm.put(1001,"pradeepan");
        hm.put(1002,"dinesh");
        hm.put(1003,"harish");
        hm.put(1004,"kalaimaran");
        hm.put(1005,"arun");
        System.out.println(hm.get(1004));      // get is used to retrive the value of the key
        System.out.println(hm.remove(1004));  // remove will remove the object and show the value
        System.out.println(hm);
        System.out.println("checking the Map is empty " + hm.isEmpty());
        System.out.println("checking the size of the Map" + hm.size());
        System.out.println("checking the Map is contains the key  " + hm.containsKey(1004));
        System.out.println("checking the Map is contains the value  " + hm.containsValue("harish"));
        System.out.println("Stored in Map {}" + hm);
        Set sm;
        sm =  hm.entrySet();
       Iterator i = sm.iterator();
        System.out.println("hm to set to iterator to Object to Map.Entry");
       while(i.hasNext()){
           Object o = i.next();
           Map.Entry mp = (Map.Entry) o;
           System.out.println(mp);
       }
        Map.Entry me = (Map.Entry)hm;
        System.out.println("type casted"+me);
      //  System.out.println("Stored in Set []" + sm);
   
    }
    
}
