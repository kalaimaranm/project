
import java.util.Vector;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200193
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet ss = new TreeSet();
        ss.add(90);
        ss.add(10);
        ss.add(9);
        ss.add(8);
        ss.add(100);
        ss.add(90);

        System.out.println("SortedSet are " + ss);

        System.out.println("First Object in SortedSet is " + ss.first());
        System.out.println("Last Object in SortedSet is " + ss.last());
        System.out.println("Smaller than the 10 is " + ss.headSet(10));
        System.out.println("Greater than the 10 is " + ss.tailSet(10));
        System.out.println("Subset of 9 to 100 is " + ss.subSet(9, 100));
        SortedSetDemo j = new SortedSetDemo();
        j.main1();//System.out.println("Subset of ");
        j.main2();
        j.main3();
    }

    public static void main1() {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(10);
        lhs.add(100);
        lhs.add(9);
        lhs.add(1);
        System.out.println("LinkedHashSet maintain the order");
        System.out.println(lhs);
        Iterator i = lhs.iterator();
        //for(;;i.hasNext()){

        //System.out.println(i.next());
        //System.out.println(i);
    }

    public static void main2() {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        al.add(60);
        al.add(70);
        al.add(80);
        // al.add(90);
        // al.add(100);
        System.out.println(al);
        System.out.println("Address of the before al is " + al.hashCode());
        al.add(90);
        al.add(100);
        al.add(94);
        System.out.println("Address of the After al is " + al.hashCode());
        System.out.println("Address of the After al is " + al.hashCode());

    }

    public static void main3() {
        Vector v = new Vector(3);    // use this also new Vector(3,2);
        v.addElement("name1");
        v.addElement("name2");
        v.addElement("name3");
        System.out.println("Before adding fourth element capacity is" + v.capacity());

        v.addElement("name4");

        System.out.println("After adding fourth element capacity is" + v.capacity());
        System.out.println("size of the Vector is " + v.size());

    }

}

