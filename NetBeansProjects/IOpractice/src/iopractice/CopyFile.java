/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iopractice;

import java.io.*;
import java.io.IOException;
/**
 *
 * @author bas200193
 */
public class CopyFile {

    public static void main(String[] args) throws IOException{
       try(FileInputStream fis = new FileInputStream("/home/bas200193/Downloads/Java file Handling - File Reading, Writing in Tamil - Java in Tamil - தமிழில் ஜாவா - Payilagam (1).mp4");
        FileOutputStream fos = new FileOutputStream("/home/bas200193/Downloads/aaPayilagamCopy.mp4",true);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);){
           int b;// = new byte[10];
           
           byte[] bb = new byte[10000000];
           while((bis.read(bb))!=-1){
               //System.out.println(b);
               bos.write(bb);
           }
       }

    }
}
