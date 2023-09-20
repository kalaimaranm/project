package collections.framework.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    
//    Comparable is an interface compareTo(Object object) return int 1, -1, 0
//    It is used for sorting the object
//    It is in lang package
    
    
    public static void main2(String[] args) {
//        change the current object not the new object
//   current object
//        b come After a returns +ve 
        System.out.println("b".compareTo("a"));

//        y come After t +ve
        System.out.println("y".compareTo("t"));

//        a come before z -ve
        System.out.println("a".compareTo("z"));

//        t come before t -ve
        System.out.println("t".compareTo("u"));

//        y come before z -ve
        System.out.println("y".compareTo("z"));

    }

    public static void main(String[] args) {
//        sort() will call compareTo() internally

        List<Song> songs = new ArrayList();

        songs.add(new Song("thaiya thaiya", 1995));
        songs.add(new Song("sulthaney", 2000));
        songs.add(new Song("hukum", 2023));
        songs.add(new Song("pala palakura", 2015));
        songs.add(new Song("ennodu nee irunthal", 2019));
        songs.add(new Song("thaiya thaiya", 1995));

        System.out.println("before sorting");
        Main.printInfo(songs);
        Collections.sort(songs);
        System.out.println("after sorting");
        Main.printInfo(songs);
    }

    public static <T> void printInfo(List<T> data) {
        for (T object : data) {
            System.out.println(object);
        }
    }

}
