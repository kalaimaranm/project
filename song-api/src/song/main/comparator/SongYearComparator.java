package song.main.comparator;

import collections.framework.comparablecomparator.Song;
import java.util.Comparator;

public class SongYearComparator implements Comparator<Song> {

    @Override    
//                     new object  old object
    public int compare(Song song1, Song song2) {

        if (song1.getYear() > song2.getYear()) {
            return 1;
        } else if (song1.getYear() < song2.getYear()) {
            return -1;
        }
        return 0;

    }

}
