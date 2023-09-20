/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.time.LocalDateTime;
public class ConstructorOverloading {
    String brand;
    String colour;
    private double price;
    LocalDateTime mafacDa = LocalDateTime.now();
    ConstructorOverloading(String colour,String brand){
        brand = "Cello";
        colour = "blue";
         price = 5.0;
    }
    ConstructorOverloading(String brand){
        this("black",brand);
        
        //colour = "blue";
        //price = 5.0;
    }
    ConstructorOverloading(String brand,String colour,double price){
        this.brand=brand;
        this.price=price;
        this.colour=colour;
    }
    public void setPrice(double price){
       if(price >=5){
           this.price = price;
       }
       else{
           System.out.println("price is too low");
       }
    }
       public double getPrice(){
           return price;
       }
    
    public static void main(String[] args) {
        ConstructorOverloading co = new ConstructorOverloading("Parker");   // ConstructorOverloading(), COnstructorOverloading("Renoldsoo")
        System.out.println("brand is "+co.brand);
        System.out.println("colour is "+ co.colour);
        System.out.println("price is "+co.price);
        System.out.println(co.setPrice(-8.0));
    }
}
