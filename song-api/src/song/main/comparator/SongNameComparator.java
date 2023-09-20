
package song.main.comparator;

import collections.framework.comparablecomparator.Song;
import java.util.Comparator;


public class SongNameComparator implements Comparator<Song>{

    @Override
    public int compare(Song song1, Song song2) {

      return song1.compareTo(song2);
    }
    
}
