
package com;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class ListIteratorDemo {

    public static void main(String[] args) {
//        List<Integer> values = new ArrayList();
//
//        values.add(4);
//        values.add(10);
//        values.add(30);
//        values.add(0, 15);
//        
//        System.out.println(values);
//        values.listIterator();
//
//        //values.iterator().forEachRemaining(n->System.out.println(n));
//        ListIterator ite =  values.listIterator();
//        System.out.println(ite.hasPrevious());
//        System.out.println(ite.hasNext());
//
//        System.out.println(ite.next());  // [15,4,10,30]
//        ite.next();
//        ite.next();
//        System.out.println(ite.nextIndex());
//        
//        System.out.println(ite.previous());
//        System.out.println(ite.previousIndex());
//        ite.add(25);
//
//        System.out.println(ite.hasPrevious());
//        System.out.println(ite.hasNext());
//
//        System.out.println(values); 
// create empty ArrayList
        ArrayList<Integer> arrList
            = new ArrayList<Integer>();
        
        // add elements to the ArrayList
        arrList.add(5);
        arrList.add(10);
        arrList.add(15);
        arrList.add(20);
        arrList.add(25);
        arrList.add(30);
  
        // print the initial list
        System.out.println("Initial arraylist =>"
                           + arrList);
  
        // initializing ListIterator
        ListIterator<Integer> iterator
            = arrList.listIterator();
  
        // initially iterator is the beginning so
        // previousIndex() will return -1
        System.out.println("previous index =>"
                           + iterator.previousIndex());
  
        // from -1 moving iterator to the 1st index
        iterator.next();
        iterator.next();
  
        // now iterator is at 1st index 
        // so nextIterator() will return 2
        System.out.println("Next index =>"
                           + iterator.nextIndex());
        iterator.previous();
        System.out.println("Previous index => "+iterator.previousIndex());
    
    }
}
