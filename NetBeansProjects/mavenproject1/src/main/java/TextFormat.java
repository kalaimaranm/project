/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
public class TextFormat {

    public static void main(String[] args) {
        //System.out.println("");
        System.out.println("+" + "-".repeat(40) + "+");
        System.out.format("|%-4s|%-15s|%-19s|", "s.No", "Name", "RollNo");
        System.out.print("\n+" + "-".repeat(40) + "+");
        String[] name = {"Arun", "ArunKumar", "Jobin", "VijayAnandh", "Natraj", "Vengatakrishnan"};
        int[] rollNo = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < name.length; i++) {
            System.out.format("\n|%-4d|%-15d|%-19s|", i, rollNo[i], name[i]);
            System.out.print("\n"+"-".repeat(41));
        }
       // System.out.println("+" + "-".repeat(40) + "+");

    }

    public static String second() {
        return "";
    }
}
