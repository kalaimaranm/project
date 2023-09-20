package collections.framework.comparablecomparator;

public class Song implements Comparable<Song> {

    private String name;
    private Integer year;

    public Song(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public Song() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", year=" + year + '}';
    }

//  sorting based on year  
    
//    @Override
//    public int compareTo(Song song) {
//
//        if (this.getYear() > song.getYear()) {
//
//            return 1;
//        } else if (this.getYear() < song.getYear()) {
//
//            return -1;
//        }
//        return 0;
//
//    }
    
//    sorting based on name
    @Override
    public int compareTo(Song song) {

        return this.getName().compareTo(song.getName());
    }

}
