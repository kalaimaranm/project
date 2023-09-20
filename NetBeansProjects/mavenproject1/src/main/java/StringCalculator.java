/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringCalculator {
    static int num1;
    static int num2;
    static char operator;
    
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        System.out.println("Enter the value for num1");
  num1 = scan.nextInt();
        System.out.println("Enter the value for num2");
  num2 = scan.nextInt();
        System.out.println("Please select Your Operator /,*,-,+");
         operator = scan.next().charAt(0);
         
        System.out.println(calculate(num1,num2,operator));
    }
    public static int calculate(int num11,int num22,char operator1){
        switch (operator1) {
            case '+':
                return num11+num22;
            case '-':
                return num11-num22;
            case '/':
                return num11/num22;
            default:
                break;
        }
        
            return num11*num22;
        
    }
}
