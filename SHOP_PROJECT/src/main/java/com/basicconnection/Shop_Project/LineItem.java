/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicconnection.Shop_Project;

/**
 *
 * @author
 * bas200180
 */
public class LineItem
  {

     private int orderId;
     private int productId;
     private int quantity;
     private double price;

     public int getOrderId()
       {
          return orderId;
       }

     public void setOrderId(int orderId)
       {
          this.orderId = orderId;
       }

     public int getProductId()
       {
          return productId;
       }

     public void setProductId(int productId)
       {
          this.productId = productId;
       }

     public int getQuantity()
       {
          return quantity;
       }

     public void setQuantity(int quantity)
       {
          this.quantity = quantity;
       }

     public double getPrice()
       {
          return price;
       }

     public void setPrice(double price)
       {
          this.price = price;
       }

     public LineItem(int orderId, int productId, int quantity, double price)
       {
          this.orderId = orderId;
          this.productId = productId;
          this.quantity = quantity;
          this.price = price;
       }

     @Override
     public String toString()
       {
          return this.orderId + " " + this.productId + " " + this.quantity + " " + this.price;
       }

  }

