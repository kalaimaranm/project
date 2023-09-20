package collections.framework.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIterators {

    public static void main(String[] args) {
        List<String> list = new LinkedList();

        list.add("kalaimaran");
        list.add("harish");
        list.add("vign");
        list.add("arun");
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {

            String name = (String) iterator.next();
            if (name.equals("kalaimaran")) {
                iterator.set("kalaimaran m");
            } else if (name.equals("vign")) {
                iterator.remove();
            } else if (name.equals("arun")) {
                iterator.remove();
                iterator.add("arun kumar");

            }

        }

        System.out.println("list : " + list);

    }
}
