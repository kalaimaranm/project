package song.main;

import collections.framework.comparablecomparator.Main;
import collections.framework.comparablecomparator.Song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import song.main.comparator.SongNameComparator;
import song.main.comparator.SongYearComparator;

public class SongApi {
//      util package abstract int compare(T o1,T o2) and abstract boolean equals(Object o) 
//    Comparator is used to give our own sorting logic explicitly not tightly coupled
//    Comparable is used to give default sorting technic along with the class
//    Customer implementation of sotting when you not ok with default sorting  

    public static void main(String[] args) {

        List<Song> songs = new ArrayList();

        songs.add(new Song("thaiya thaiya", 1995));
        songs.add(new Song("sulthaney", 2000));
        songs.add(new Song("hukum", 2023));
        songs.add(new Song("pala palakura", 2015));
        songs.add(new Song("ennodu nee irunthal", 2019));
        songs.add(new Song("thaiya thaiya", 1995));
        
        System.out.println("before sorting  using year");
        Main.printInfo(songs);

        Collections.sort(songs, new SongYearComparator());

        System.out.println("after sorting using year");
        
        System.out.println("sorting year in reverse order using reverse method");
        
        Collections.sort(songs, new SongYearComparator().reversed());
        
        Main.printInfo(songs);
        
        System.out.println("sorting using name ");
        
        Collections.sort(songs, new SongNameComparator());
        
        Main.printInfo(songs);
    }

}
