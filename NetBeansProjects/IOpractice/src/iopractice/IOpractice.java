package iopractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import iopractice.Customers.*;
//import iopractice.Customers.customer;

public class IOpractice {

    public static void main(String[] args) throws IOException {
        try (
                 FileOutputStream fos = new FileOutputStream("/home/bas200193/Desktop/textFiles/Customers/cus.txt");  DataOutputStream dos = new DataOutputStream(fos);  FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Customers/cus.txt");  DataInputStream dis = new DataInputStream(fis);) {
            Customers cus = new Customers();

            cus.customer[cus.index++] = new Customers(cus.idInc++, "kalaimaran2", "Thiruvarur", "8610825343");
            cus.customer[cus.index++] = new Customers(cus.idInc++, "Harish2", "Kumbakonam", "9087962506");
            cus.customer[cus.index++] = new Customers(cus.idInc++, "Natraj2", "Viruthachallem", "1234567899");
            cus.customer[cus.index++] = new Customers(cus.idInc++, "Vengat2", "Chitambaram", "0987654321");
            cus.customer[cus.index++] = new Customers(cus.idInc++, "Dinakaran2s", "Chennai", "9999999999");
            for (int i = 0; i < cus.customer.length; i++) {
                dos.writeInt(cus.customer[i].id);
                dos.writeUTF(cus.customer[i].name);
                dos.writeUTF(cus.customer[i].address);
                dos.writeUTF(cus.customer[i].phoneNo);
            }
            for (int j = 0; j < cus.customer.length; j++) {
                System.out.println("Customer ID: " + dis.readInt());
                System.out.println("Customer Name: " + dis.readUTF());
                System.out.println("Customer Address: " + dis.readUTF());
                System.out.println("Customer Mobile No: " + dis.readUTF());
                System.out.println("____________________________________");
                

            }
            
//    Scanner scan = new Scanner(System.in);
//    System.out.println("Enter any int value");
//    int value = scan.nextInt();
//    dos.write(value);
//    System.out.println("Enter Your name");
//    String name = scan.next();
//    dos.writeUTF(name);
//    int i;
//    char temp;
//    String output = "";
//    while((i= dis.read())!=-1){
//        output=output+(char)i;
//    }
//    System.out.println(output);
        }

    }
    public static void findCustomer(Customers cus){
                
            }

}
