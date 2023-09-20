/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author bas200193
 */
import java.util.*;
 class Student extends Person{
   private String program;
   private int year;
   private double fee;
   Student(String name,String address){
       super(name,address);
   }
    public String getProgram(){
        return this.program;   
    }
    public void setProgram(String program){
        this.program = program;
    } 
    public int getYear(){
        return this.year;    
    }
    public void setYear(int year){
         this.year = year; 
    }
    public double getFee(){
        return this.fee;   
    }
    public void setFee(double fee){
        this.fee = fee;
    }
    @Override
    public String toString(){
        return super.getName()+" "+super.getAddress()+" "+this.program+" "+this.year+" "+this.fee;
    }
    public static void main(String[] args) {
                Staff sf = new Staff(20000.00,"Sanjai","East Street, Kodavasal, Thiruvarur");
                sf.setSchool("St.Joseph Matriulation");
                Student std = new Student("Sai","East Street, Porur, Chennai-87");
                std.setProgram("11th Standard");
                std.setYear(2022);
                std.setFee(25000);
                System.out.println(sf);
                System.out.println(std);
    }
}
class Staff extends Person{
   private String school;
    double pay;
    Staff(double pay,String name,String address){
        super(name,address);
        this.pay = pay;
    }
    public void mainStaff() {
    }
    public String getSchool(){
        return this.school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public double getPay(){
        return pay;
    }
    public void setPay(double pay){
        this.pay = pay;
    }
    @Override
    public String toString(){
        return super.getName()+"\n"+super.getAddress()+"\n"+this.school+"\n"+this.pay;
    }
}

class Person {
    private String name;
    private String address;
    Person(String name,String address){
        this.name = name;
        this.address = address;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    @Override
    public String toString(){
        return this.name+" \n"+this.address;
    }
}
//public class Main{
    
//}