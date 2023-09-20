/*
 * Click nbrs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbrs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicconnection.Shop_Project;

/**
 *
 * @author
 * bas200180
 */

import java.sql.*;
import java.io.*;

public class Inventory
  {

     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     public static void viewAvalibleProducts(Connection co) throws SQLException
       {
          Statement st = co.createStatement();
          String query = "select * from inventory";
          ResultSet rs = st.executeQuery(query);
          System.out.printf("%10s%13s%15s%15s", "Customer_id", "product_Name", "quantity", " price", "net_Weight");

          while (rs.next()) {
               
               System.out.format("\n%8s%16s%15s%15s", rs.getInt(1), " " + rs.getString(2), " " + rs.getInt(3), " " + rs.getFloat(4), " " + rs.getString(5));

          }
       }

     public static void addProduct(Connection co) throws SQLException, IOException
       {

          String q = "insert into inventory values(?,?,?,?,?)";
          PreparedStatement pst = co.prepareStatement(q);

          System.out.println("Enter the product id");
          int proid = Integer.parseInt(br.readLine());
          pst.setInt(1, proid);
          System.out.println("Enter the product name");
          String name = br.readLine();
          pst.setString(2, name);
          System.out.println("Enter the Quantity");
          int quantity = Integer.parseInt(br.readLine());
          pst.setInt(3, quantity);
          System.out.println("Enter the price");
          double price = Double.parseDouble(br.readLine());
          pst.setDouble(4, price);
          System.out.println("Enter the netweight");
          String netweight = br.readLine();
          pst.setString(5, netweight);
          int r = pst.executeUpdate();
          if (r == 1) {
               System.out.println(" product saved");
          } else {
               System.out.println("not saved");
          }

       }

     public static void updateProduct(Connection co) throws IOException, SQLException
       {
          System.out.println("Enter the product_Id");
          int productid = Integer.parseInt(br.readLine());
          String query = " select  *from inventory where product_id =" + productid;

          PreparedStatement pst = co.prepareStatement(query);
          ResultSet ra = pst.executeQuery();
          if (ra.next()) {
               System.out.println("sucess");

               System.out.println("1 Enter the product name");
               System.out.println("2 Enter the Quantity");
               int pro = Integer.parseInt(br.readLine());
               switch (pro) {
                    case 1: {

                         String query1 = "update inventory set  product_name=? where  product_id =?";
                         PreparedStatement s = co.prepareStatement(query1);
                         System.out.println("Enter the product name");
                         String name = br.readLine();
                         s.setString(1, name);
                         s.setInt(2, productid);
                         s.executeUpdate();
                         System.out.println("changed sucessfully");
                         break;
                    }
                    case 2: {

                         String query2 = "update inventory set quantity=? where product_id =?";
                         PreparedStatement s1 = co.prepareStatement(query2);
                         System.out.println("Enter the Quantity");
                         int quantity = Integer.parseInt(br.readLine());

                         s1.setInt(1, quantity);
                         s1.setInt(2, productid);
                         s1.executeUpdate();
                         System.out.println("changed sucessfully");
                         break;

                    }
               }
          } else {
               System.out.println("not sucesss");
          }

       }
  }

