
import TreeSetAlgorithm.Customer;
import java.util.*;

public class TreeSets {

    public static void main2(String[] args) {
        TreeSet ts = new TreeSet();
//        ts.add("Kalaimaran");
//        ts.add("ajail");
//        ts.add("harish");
        // String s = null; - not allowed heterogenous data
        //ts.add(s);
        System.out.println(ts);
        //SortedSet ss= new Set();
        //ss.add("kalae");
        //ss.add(1);
        //System.out.println(ss);

        TreeSet t1 = new TreeSet();
//        Customer c = new Customer("Arun", 1000);
//        Customer c2 = new Customer("Kumar", 1001);
//        Customer c3 = new Customer("Arun", 1000);

//        t1.add(c);
//        t1.add(c2);
//        t1.add(c3);
//        t1.add(50);
//        t1.add(70);
        System.out.println(t1);

        // ts1.add(null);        // It should allow but it not allowing in latest version
        // System.out.println(ts1);
    }

    public static void main(String[] args) {
        Second s = new Second("Naveen");
        
         System.out.println(s instanceof Third);
         char[] c = {'a','b','c','d','e'};
         System.out.println();
         System.out.println("aashif".compareTo("Kalaimaran"));
    }
    char[] comparator(char[] c){
        char[] out = new char[c.length];
        for(int i=0;i<out.length;i++){
            
        }
        return out;
    }
}

class Second extends Third {
    String name;

    Second(String name) {
        super(name);
        this.name = name;
    }

  
}

class Third {

    String namee;

    public Third(String namee) {
        this.namee = namee;
    }
}
