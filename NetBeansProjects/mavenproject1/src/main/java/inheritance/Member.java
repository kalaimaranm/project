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
public class Member {
    String name;
    int age;
    long phoneNumber;
    String address;
    double salary;
    Member(String name,int age,long phoneNumber,String addresss,double salary){
        this.name=name;
        this.age=age;
        this.phoneNumber=phoneNumber;
        this.salary=salary;
        address=addresss;

    }
    public String toString(){
        return "Name : "+ this.name + "\n phoneNumber : "+this.phoneNumber+"\n Address : "+this.address+"\n Salary : "+this.salary;
    
    }
}

 class Employee extends Member{
     String specialisation;
    
public static void main(String args[]){
    Employee e = new Employee("Raja",22,9834998349l,"No 1006, 68th Street,11th Sector, K.K Nagar,Chennai-78",250000.00,"Stock");
     Member m1 = new Member("Raja",22,9834998349l,"No 1006, 68th Street,11th Sector, K.K Nagar,Chennai-78",250000.00);
         System.out.println(m1);
     }
 Employee(String name,int age,long phoneNumber,String addresss,double salary,String specialisation)
 {       super(name,age,phoneNumber,addresss,salary);
         this.specialisation=specialisation;
     }
    
    
}
 class Manager extends Member
 {
     String department;
     
    Manager(String name,int age,long phoneNumber,String addresss,double salary,String department){
        super(name,age,phoneNumber,addresss,salary);
        this.department = department;
    }
    
    public static void main(String args[])
    {
        
     Member m2 = new Member("Ram",35,8122938098l,"No 83, East Street, Sri Nagar Colony, R.S Puram,Coimbatore-98",500000.00);
     Manager m = new Manager("Ram",35,8122938098l,"No 83, East Street, Sri Nagar Colony, R.S Puram,Coimbatore-98",500000.00,"HR");
        System.out.println(m2);
    }
}