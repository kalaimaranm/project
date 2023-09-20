package collections.framework.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {

    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add("kalaimaran");
        list.add("harish");
        list.add("arun");
        list.add("vignesh");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {

            if (iterator.next().equals("arun")) {
                iterator.remove();
            }
        }
        

        System.out.println("list : " + list);

    }

}
