/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Objects;

/**
 *
 * @author bas200193
 */
public class FileIODemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        main2();
//        FileInputStream fileReader = null;
//        FileOutputStream fileWriter = null;
//        try {
//            int i;
//            fileReader = new FileInputStream("/home/bas200193/NetBeansProjects/mavenproject1/src/main/java/inheritance/file2");
//            // System.out.println(fileReader);
//            while (fileReader.read()!=-1) {
//                i = fileReader.read();
//                
//                System.out.print((char) i);
//            }
//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        } finally {
//            if(Objects.nonNull(fileReader))   // is book available 
//            fileReader.close();
//        }

    }
    public static void main2() throws IOException {
        String filePath = "/home/bas200193/opt/fileOuter/fileInner/java.txt";
        String filePath2 = "/home/bas200193/opt/fileOuter/fileInner/java2.txt";
//        File file = new File(filePath);
//        boolean f = file.createNewFile();
        FileReader fr = new FileReader("/home/bas200193/NetBeansProjects/mavenproject1/src/main/java/inheritance/file"); //character
        FileOutputStream fc = new FileOutputStream(filePath2,true);
        FileInputStream file = new FileInputStream(filePath);   //bytes
        int i;
        while ((i = file.read()) != -1) {
            System.out.print((char) i);
            fc.write(i);
        }

    }
}
