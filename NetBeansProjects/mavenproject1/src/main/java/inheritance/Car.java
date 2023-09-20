/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritance;

/**
 *
 * @author bas200193
 */
public class Car extends Vehicle{
  public Car(String brand){
      this.brand = brand;  // ini for super class
      System.out.println("(Car)");
  }
}
