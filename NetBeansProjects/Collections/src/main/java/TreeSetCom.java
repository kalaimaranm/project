
import java.lang.*;
import java.util.*;
public class TreeSetCom {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(0);
        ts.add(150);
        ts.add(100);
        ts.add(200);
        ts.add(170);
        ts.add(300);
        ts.add(300);
        System.out.println(ts);
        TreeSetString t = new TreeSetString();
        t.tss();
        TreeSetStringBuffer sb = new TreeSetStringBuffer();
            sb.tsb();
    }
}
 class MyComparator implements Comparator{
    public int compare(Object obj1, Object obj2){
        Integer i1 = (Integer) obj1;
        Integer i2 = (Integer) obj2;
        return -1;//i1.compareTo(i2);   // easy method for descending order is -, 0 for only one element  
      /* if(i1<i2){                     // insertion order maintain with duplicate 1 
           return +1;                    // reverse insertion order maintain with duplicate is -1,
       }
       else if(i1>i2){
           return -1;
       }
       return 0;   */
    }
}
 class TreeSetString implements Comparator{
    public static void tss(){
        TreeSet tss = new TreeSet(new TreeSetString());
        tss.add("willber");
        tss.add("naveen");
        tss.add("dinesh");
        tss.add("kalaimaran");
        tss.add("dinakaran");
        System.out.println(tss);
        
    }
    public int compare(Object obj1,Object obj2) {
        String s1 = (String) obj1;
        String s2 = (String) obj2;
        
        return s1.compareTo(s2);   // - 
    }
}
class TreeSetStringBuffer implements Comparator{
    public static void tsb(){
        TreeSet tsb = new TreeSet(new TreeSetStringBuffer());
        System.out.println("TreeSet with StringBuffer");
        tsb.add(new StringBuffer("z"));
        tsb.add(new StringBuffer("a"));
        tsb.add(new StringBuffer("b"));
        tsb.add(new StringBuffer("x"));
        tsb.add(new StringBuffer("c"));
        System.out.println(tsb);
        
    }
    public int compare(Object obj1,Object obj2){
        String s1 = obj1.toString();   // because StringBuffer does not have compareTo();
        String s2 = obj2.toString();
        return s1.compareTo(s2);
    }
}
