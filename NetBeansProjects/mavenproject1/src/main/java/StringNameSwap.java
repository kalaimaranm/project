/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringNameSwap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first and last name");
        String name = scan.nextLine();
        System.out.println("Your swaped name is "+ swap(name));
        
    }
    public static String swap(String namee){
        int len = namee.length();
        int i=0;
        String first="";
        String last="";
        while(i<len){
        if(namee.charAt(i)!=' '){
         first =first+namee.charAt(i);             
        }
        else if(namee.charAt(i)==' '){
            break;
        }
        ++i;
    }
        ++i;  //  to eliminate space character
        while(i<len){
            last = last+namee.charAt(i);
            ++i;
        }
        return last+" "+first;
}
}
