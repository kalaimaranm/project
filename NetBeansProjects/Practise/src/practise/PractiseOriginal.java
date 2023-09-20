/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author bas200193
 */
public class PractiseOriginal {

    public static void main(String[] args) {
        int[] ar = {100, 60, 40, 120, 50};
        ArrayList element = new ArrayList();
        element.add(100);
        element.add(60);
        element.add(40);
       element.add(120);
        element.add(50);
        Stream<Integer> data = element.stream();
        Predicate<Integer> predicate = new Predicate<Integer>(){
            @Override
            public boolean test(Integer n){
                return n>=60;
            }
        };
       var total= data.filter(predicate).map((n)-> n+1).sorted().reduce(-283,(a,b)-> a+b);  //forEach(o->System.out.println(o));
        System.out.println(total);
//        for(Object i:element)
//        System.out.println(i);
        //data.filter(n -> n >= 60).map(n -> n+n).forEach(n -> System.out.println(n));
    }
}
