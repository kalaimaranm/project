/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200193
 */
import java.time.LocalDateTime;
public class Watch {
    final String BRAND;
    private double price;
    String colour;
    String type;
    int PRODUCTWARRANTY;
    {
    
    }
    Watch(){                                      // default
        BRAND="Fastrack";
        price=2000.00;
        colour="silver";
        type="chain";
        PRODUCTWARRANTY = 2;
        
    }
    Watch(double price,String brand, String colour,String type){   
        this.price=price;
        this.BRAND = brand;
        this.colour = colour;
        this.type = type;
    }
    Watch(String fixBrand,int fixPrice, String fixColour, String fixType){   
        BRAND = fixBrand; 
        price = fixPrice;
        colour = fixColour;
        type = fixType;
    }
     
      public void setPrice(double price){
          this.price = price;
      } 
    
    public double getPrice(){
       return price;
    }
    
    public static void main(String[] args) {
        Watch w = new Watch(5000.00,"Titan","Gold","chain");
        System.out.println("Get price "+w.getPrice());
        w.setPrice(9000.00);
        System.out.println("Set price "+w.getPrice());
        System.out.println("brand name "+w.BRAND);
        System.out.println("watch colour is "+w.colour);
        System.out.println("watch type is "+w.type);
        
    }
}
