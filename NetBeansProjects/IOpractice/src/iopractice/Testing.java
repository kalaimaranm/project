package iopractice;

import java.beans.Introspector;
import java.io.FileInputStream;
import java.io.*;

/**
 *
 * @author bas200193
 */
public class Testing {

    public static void main2(String[] args) throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("/home/bas200193/FIS");
//        int data = fis.read();
//        int data2 = fis.read();
//        int data3 = fis.read();
//        int data4 = fis.read();
//        System.out.println((char)data);
//        System.out.println((char)data2);
//        System.out.println(data3);
//        System.out.println(data4);
        FileOutputStream fos = new FileOutputStream("/home/bas200193/FIS");
        FileOutputStream fos2 = new FileOutputStream("/home/bas200193/FIS2");
        FileInputStream fis2 = new FileInputStream("/home/bas200193/FIS2");
        FileOutputStream fos3 = new FileOutputStream("/home/bas200193/FIS3");
        
        char c = '¶';
        fos2.write(c);
        fos.write(c);
        int i;
//        System.out.println((char)fis2.read());
//        System.out.println((char)fis2.read());
        System.out.println((char) fis2.read());
        fos3.write(fis.read());
//        while ((i = fis2.read()) > -1) {
//            System.out.println((char) i);
//        }
//        while (fis.available() > 0) {
//          fos2.write(fis.read());
//        }
//        while((i=fis.read())!=-1){
//            System.out.println((char)i);
//    }

    }
    public static void main(String[] args) {
        String introspector = Introspector.decapitalize("RESTFORTUNESERVICE");
        System.out.println("Before : "+"RESTFORTUNESERVICE");
        System.out.println("After : "+introspector);
    }
}
