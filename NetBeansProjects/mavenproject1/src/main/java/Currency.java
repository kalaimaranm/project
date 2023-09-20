/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class Currency {
    static String[] ones = {"zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tens = {"","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String hundred = "hundred";
    static String thousand = "Thousand";
    static String lakhs = "Lakhs";
    static String crore = "Crore";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Amount in Number ");
        int money = scan.nextInt();
        String con = String.valueOf(money);
        int len = con.length();
        if(money>=0 && money<=19){
        System.out.println(ones[money]);
        }
        else if(money>=20 && money<=99){
            
        }
        else if(money>=100 && money<=999){
            
        }
        else if(money>=1000 && money<=99999){
            
        }
//        else if(){
//            
//        }
    }
}








/*if(money>=0 && money<=19){
            System.out.println("Your Money in words" + ones[money]);
        }
        else if(money>=20 && money<=99){
            int last = money%10;
             int first = money/10;
             System.out.println("Your Money in words "+ tens[first] + " "+ones[last] );
        }*/