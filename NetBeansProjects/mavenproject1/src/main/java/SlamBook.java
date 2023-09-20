/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.util.*;
public class SlamBook implements Comparable{
    String name;
    String hobbies;
    String colour;
    String place;
    String movie;
    String[] parameter = new String[4];
    //int 
    SlamBook(String name,String hobbies,String colour,String place,String movie){
        this.name = name;
        this.hobbies = hobbies;
        this.colour = colour;
        this.place = place;
        this.movie = movie;
       parameter[0] = name;
       parameter[1] = hobbies;
       parameter[2] = colour;
       parameter[3] = place;
       parameter[4] = movie;
    }
    public static void main(String[] args) {
        SlamBook sb1 = new SlamBook("Jagan","Eating","Black","Chennai","John wick");
        SlamBook sb2 = new SlamBook("Dinesh","Bike ride","Black","Thoothukudi","Anime");
        SlamBook sb3 = new SlamBook("Arumugam","Singing","White","Tirunelveli","Thiruchitrambalam");
        SlamBook sb4 = new SlamBook("Sai","Eating","Red","Chennai","Anime");
        SlamBook sb5 = new SlamBook("Sakthi","Coding","Grey","Madurai","Lion King");
        SlamBook sb6 = new SlamBook("Arun","Urutu","Blue","Ponneri","Kuthiraivaal");
        SlamBook sb7 = new SlamBook("Dinakaran","Siting","Black","Chennai","Ponniyin Selvan");
        SlamBook sb8 = new SlamBook("Harish","Smart Work","Orange","Kumbakonam","Money Heist");
        SlamBook sb9 = new SlamBook("Kalaimaran","Updating","Black","Kumbakonam","");
        SlamBook[] sbArr = {sb1,sb2,sb3,sb4,sb5,sb6,sb7,sb8,sb9};
       // System.out.println(sb2);
    }
    public String toString(){
        return "Name : "+name+"\nHobbies : "+this.hobbies+"\nColour : "+this.colour+"\nPlace : "+this.place+"\nMovie : "+this.movie;
    }
    public boolean equals(SlamBook ob1){
       //SlamBook obj2 = (SlamBook) ob;
        
        if(hobbies.equals(ob1.hobbies) && colour.equals(ob1.colour) && place.equals(ob.place) && movie.equals(ob1.movie)){
            return true;
        }
        return false;
    }
    public int compareTo(Object ob){
        return 10;
    }
    
}
