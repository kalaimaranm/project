/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class StringConcate {
    public static void main(String[] args) {
        
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your name ");
    String name = scan.nextLine();
        System.out.println("Your concatenate output is "+ concate(name));
    
}
    public static String concate(String namee){
        return namee+"programming";
    }
}
