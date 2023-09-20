/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *s
 * @author bas200193
 */
public class StringStringBuilder {
    public static void main(String[] args) {
        String nname = "BAssure";
        String kname = "BAssure";
        System.out.println("without creating object "+ nname==kname);
        String onname = new String("BAssure1");
        String okname = new String("BAssure1");
        System.out.println("with creating object "+ onname==okname);   // address check - comparator
        System.out.println("with creating object but using equals method" + onname.equals(okname));   // value comparision
    }
    
}
