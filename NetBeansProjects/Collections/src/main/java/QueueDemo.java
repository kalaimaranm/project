
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class QueueDemo {

    public static void main(String[] args) {
        Queue q1 = new LinkedList();    // ASC|DESC - because of Comparator and only work with priority queue
        q1.offer(20);
        q1.offer(10);
        q1.offer(40);
        q1.offer(30);
        q1.offer(60);
        q1.offer(50);
        System.out.println(q1);

        Queue pq = new PriorityQueue(Collections.reverseOrder());
        pq.offer(20);
        pq.offer(10);
        pq.offer(40);
        pq.offer(30);
        pq.offer(60);
        pq.offer(50);
        System.out.println(pq);
        TreeSet ts = new TreeSet();//Collections.reverseOrder());
        ts.add(10);
        ts.add(20);
        ts.add(30);
        ts.add(40);
        System.out.println(ts);
        Stack stack = new Stack();   // Queue(KeyboardTyping,printing) - offer,poll,peek  Stack(lastAction(undo,redo,backButton,forwardButton)) - push,pop,peek
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        System.out.println(stack.elementAt(3)); 
        System.out.println(stack.pop()); // pop(Delete) - poll
        System.out.println(stack);
        System.out.println(stack.search(30));  // return index
        System.out.println(stack.elementAt(2));
        System.out.println(stack.elements());
        System.out.println(stack.peek());
    }
}
