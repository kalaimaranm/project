
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // we can treat LinkedList as stack, queue
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("G");
        System.out.println(ll);
        LinkedList lq = new LinkedList();
        lq.offer("A");
        lq.offer("B");
        lq.offer("C");
        lq.offer("D");
        lq.offer("E");
        lq.offer("G");
        System.out.println(lq);
        LinkedList lq1 = new LinkedList();
        lq1.offer(20);
        lq1.offer(10);
        lq1.offer(40);
        lq1.offer(30);
        System.out.println(lq1);
        LinkedList ls = new LinkedList(); //
        ls.push("A");
        ls.push("B");
        ls.push("C");
        ls.push("D");
        ls.push("E");
        ls.push("G");
        System.out.println(ls);
    }

//    public LinkedList<String> iterater(LinkedList<String> ll) {
//        Iterator i = ll.iterator();
//       return 
//    }
}
