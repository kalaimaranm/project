/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
public class Check {
    public static void main(String[] args) {
        String str1 = new String("naveen");
        String str2 = new String("naveen");
        String str3 = "naveen";
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
       // System.out.println(str2==str3);
        if(str2 == str3){
            System.out.println("equals using == operator");
        }
        else if(str2.equals(str3)){
            System.out.println("equals using .equals method");
        }
        
        
        
       /* if(str1 == str2)){
            System.out.println("s1 and s2 are equals");
        }
        else if(str2==str3){
                System.out.println("s2 and s3 are equals");
              
                }   */
    }
    
}
