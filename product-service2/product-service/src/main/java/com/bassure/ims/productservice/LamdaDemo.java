
package com.bassure.ims.productservice;

import java.util.ArrayList;
import java.util.List;


public class LamdaDemo {
 
    
    
    public static void main(String[] args) {
        List<Integer> list=new ArrayList();
        list.add(12);
        list.add(13);
        list.add(10);
        list.add(9);
        list.add(11);
      int sum=0;
        for (int i = 0; i < list.size()-1; i++) {
           sum+=list.get(i);
            
        }
        System.out.println(sum);
    }
}
