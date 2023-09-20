//import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author bas200193
 */
public class CollectionDemo {

    public static void main(String[] args) throws Exception {

        /*
         * This will create ArrayList with capacity of 10.
         */
        ArrayList<Integer> aListNumbers = new ArrayList<Integer>(10);

        /*
         * Size = 0 since haven't added any elements to it
         * capacity = 10
         */
        System.out.println("ArrayList size : "
                + aListNumbers.size());
        System.out.println("ArrayList capacity : "
                + getArrayListCapacity(aListNumbers));

        //add 10 elements to ArrayList
        aListNumbers.add(1);
        aListNumbers.add(2);
        aListNumbers.add(3);
        aListNumbers.add(4);
        aListNumbers.add(5);
        aListNumbers.add(6);
        aListNumbers.add(7);
        aListNumbers.add(8);
        aListNumbers.add(9);
        aListNumbers.add(10);

        /*
         * size = 10, because we added 10 elements
         * capacity = 10 because internal array of size 10 could fit 10 elements
         */
        System.out.println("ArrayList contains: "
                + aListNumbers);
        System.out.println("ArrayList size : "
                + aListNumbers.size());
        System.out.println("ArrayList capacity : "
                + getArrayListCapacity(aListNumbers));

        //add one more element beyond the initial capacity
        aListNumbers.add(11);

        /*
         * size = 11, because we added 11 elements
         * capacity = 16 because internal array of size 10 could not fit
         * 11 element so new array has to be created. New array's 
         * size is calculated as (10 * 3)/2 + 1 = 16
         * 
         */
        System.out.println("ArrayList contains: "
                + aListNumbers);
        System.out.println("ArrayList size : "
                + aListNumbers.size());
        System.out.println("ArrayList capacity : "
                + getArrayListCapacity(aListNumbers));

    }

    private static int getArrayListCapacity(ArrayList<Integer> list) throws Exception {

        //get the elementData field from ArrayList class
        Field arrayField = ArrayList.class.getDeclaredField("elementData");

        /*
         * Since the elementData field is private, we need 
         * to make it accessible first 
         */
        arrayField.setAccessible(true);

        //now get the elementData Object array from our list
        Object[] internalArray = (Object[]) arrayField.get(list);

        //Internal array length is the ArrayList capacity!
        return internalArray.length;
    }
}

//    public static void maine(String[] args) {
//        ArrayList al = new ArrayList();
//        ArrayList al2 = new ArrayList();
//        al.add(new Name("Arun", 1234));
//        al.add(new Name("Arunkumar", 1235));
//        al.add(new Name("Arunn", 1236));
//        al2.add(new Name("Arun", 1234));
//        al2.add(new Name("Arunkumar", 1235));
//        al2.add(new Name("Arunn", 1236));
//        al2.add(new Name("Arunadfa", 934));
//        // System.out.println(List.of(al, al2));
//        if (al.contains(new Name("Arunn", 1236))) {
//            System.out.println("Data found");
//        } else {
//            System.out.println("Data Not found");
//        }
//        if (al.containsAll(al2)) {
//            System.out.println("All Data Matching");
//        } else {
//            System.out.println("Data Not Matching");
//        }
//        if (al2.retainAll(al)) {
//            System.out.println("retained values are: " + al2);
//        } else {
//            System.out.println("No Data are for retains");
//        }
//        Comparator c = (Object t1, Object t2) -> {
//            Name current = (Name) t1;
//            Name neww = (Name) t2;
//            if (current.id > neww.id) {
//                return 1;
//            } else if (current.id < neww.id) {
//                return -1;
//            }
//            return 0;
//        };
//        Collections.sort(al2, c);
//        System.out.println(al2);
//    }
//
//    public static void mainWait(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
//        ArrayList al = new ArrayList();   // loadfactor=100% - capacityIncrease=((oldCapacity*3)/2)+1;
////        al.add(100);
////        al.add(500);
////        al.add(900);
////        al.add(50);
//        al.add(10);
//        al.add(20);
//        al.add(30);
//        al.add(40);
//        al.add(50);
//        al.add(60);
//        al.add(70);
//        al.add(80);
//        al.add(90);
//        al.add(100);
//        System.out.println(al);
//        Field
//
//field = ArrayList.class  
//
//.getDeclaredField("elementData");  // elementData is a private Object[] elementData in ArrayList class
//        field.setAccessible(true);
//        Object[] data = (Object[]) field.get(al);
//        System.out.println("length of al is " + data.length);
//        System.out.println(data);
//
////        Comparator c = (Object t1, Object t2) -> {
////            int news = Integer.parseInt(t1 + "");
////            int current = Integer.parseInt(t2 + "");
////            if (current > news) {
////                return 1;
////            } else if (current < news) {
////                return -1;
////            }
////            return 0;
////            // return t2.compareTo(t1);
////        };
////        Collections.sort(al, c);
//
//
//}
//}

class Name {

    String name;
    int id;

    public Name() {

    }

    public Name(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        System.out.println("summa");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Name other = (Name) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Name{" + "name=" + name + ", id=" + id + '}';
    }

}
