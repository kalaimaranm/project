/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practise;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author bas200193
 */
public class Practise {

    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Bio> list = new ArrayList<Bio>();
//        list.add(new Bio("kalaimaran", 311417, "ECE"));
//        list.add(new Bio("Arun-Bawa", 311416, "MCA"));
//        list.add(new Bio("Dinesh", 311415, "CIVIL"));
//        list.add(new Bio("Dinakaran", 311414, "B.COM"));
//        list.add(new Bio("Harish", 311413, "CSE"));
        Stream data = list.stream();
        //data.map(n-> +" Hello").forEach(n->System.out.println(n));
        list.stream().filter(n -> n.getDepartment().equals(("CSE"))).map(n -> n.getName() + " Hello...!").forEach(n -> System.out.println(n));
        ArrayList<Integer> number = new ArrayList<Integer>();
        number.add(100);
        number.add(90);
        number.add(10);
        number.add(80);
        number.add(70);
        number.add(50);
        number.add(10);
        number.add(20);
        Stream numData = number.stream();   // stream return data in Stream type 
        // stream can be used only one(can't-re use the stream)s
        Predicate predi = new Predicate(){
            boolean test(T t){
                return t>=80;
            }
        };
        Predicate<Integer> pr = x -> x > 50;
        Predicate pred = new Predicate() {
             (n)
        
        -> n>50};
        number.stream().filter(predi).sorted().forEach(n -> System.out.println(n));

    }
}

class Bio {

    private String name;
    private int rollNo;
    private String department;

    public Bio(String name, int rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Bio{" + "name=" + name + ", rollNo=" + rollNo + ", department=" + department + "}\n";
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
