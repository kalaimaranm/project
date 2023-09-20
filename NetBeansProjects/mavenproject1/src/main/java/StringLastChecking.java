/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringLastChecking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first String");
        String first = scan.nextLine();
        System.out.println("Enter the second String");
        String second = scan.nextLine();
        int len1 = first.length()-1;
        int len2 = second.length()-1;
        int check = len2+1;
        //boolean flag = false;
        int count=0;
        while(0<=len2){
            if(first.charAt(len1) == second.charAt(len2)){
               --len1;
               --len2;
               ++count;
            }
        }
        if(count==check){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
