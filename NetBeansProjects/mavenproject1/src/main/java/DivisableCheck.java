/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class DivisableCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number ");
        int number = scan.nextInt();
        System.out.println("output is "+ check(number));
        
    }
    public static String check(int num){
         if(num%3==0 && num%5==0){
            return "FizzBuzz";
        }
         else if(num%3==0){
            return "Fizz";
        }
        else if(num%5==0){
            return "Buzz";
        }
        
        return ""+num;
    }
}
