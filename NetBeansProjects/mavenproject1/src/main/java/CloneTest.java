
import inheritance.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
public class CloneTest implements Cloneable {
    String name;
    int id;
    Test t;
    CloneTest(String name,int id,Test tt){
        this.name=name;
        this.id = id;
        t=tt;
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        Test t = new Test(9898);
        CloneTest ct = new CloneTest("Dinakar",100,t);
        CloneTest ct2 = (CloneTest) ct.clone();
        System.out.println(ct.name);
        System.out.println(ct2.name);
        System.out.println(ct2.t.dummy);  
        Student s = new Student();
        Student ss = (Student) s.clone();
        
    }
}
class Test{
    int dummy;
    Test(int dummy){
        this.dummy = dummy;
    }
    
}
class Test2{
    int dummy2;
    Test2(int dummy2){
        this.dummy2 = dummy2;
    }
    
}