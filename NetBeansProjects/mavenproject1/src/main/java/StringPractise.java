/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringPractise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your sentense");
        String s = scan.nextLine();
        int res = wordCount(s);
        System.out.println(res);
        System.out.println('+'=='+');
    }
    public static int wordCount(String input){
        int len = input.length();
        int count=1;
        for(int i=0;i<len;i++){
            if(input.charAt(i)==' '){
                ++count;
            }
        }
        return count;
    }
   
}
