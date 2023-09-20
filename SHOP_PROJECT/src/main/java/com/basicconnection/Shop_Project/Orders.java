/*
 * Click nbrs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbrs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicconnection.Shop_Project;

/**
 *
 * @author bas200180
 */
import static com.basicconnection.Shop_Project.Customer.br;
import static com.basicconnection.Shop_Project.Customer.password;
import static com.basicconnection.Shop_Project.Customer.url;
import static com.basicconnection.Shop_Project.Customer.user_name;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Orders
    {

         public static void largeSaleProduct() throws SQLException
             {
                  Connection co = DriverManager.getConnection(url, user_name, password);
                  String query1 = "SELECT order_id,product_id,product_name,quantity,price from line_item WHERE price = (SELECT MAX(price) FROM line_item)";
                  PreparedStatement pst = co.prepareStatement(query1);
                  ResultSet rs = pst.executeQuery();

                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                  System.out.format("\n|%-15s|%-15s|%-15s|%-15s|%-15s|", "ORDER_ID", "PRODUCT_ID", "PRODUCT_NAME", "QUANTITY", "PRICE");

                  while (rs.next()) {
                           String w = rs.getInt(1) + "                " + rs.getInt(2) + "                  " + rs.getString(3) + "               " + rs.getFloat(4) + "            " + rs.getFloat(5) + "|";
                           System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                           System.out.print("\n" + w);

                  }

                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");

             }

         public static void largeAmountReceviedDay() throws IOException, SQLException
             {
                  Connection co = DriverManager.getConnection(url, user_name, password);
                  String query = "select orders.order_id,orders.ord_date,line_item.quantity,line_item.price,line_item.product_name from orders,line_item WHERE price = (SELECT MAX(price) FROM line_item)";
                  PreparedStatement pst = co.prepareStatement(query);
                  ResultSet rs = pst.executeQuery();
                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                  System.out.format("\n|%-15s|%-15s|%-15s|%-15s|%-15s|", "ORDER_ID", "DATE", "QUANTITY", "PRICE", "PRODUCT_NAME");
                  while (rs.next()) {

                           String w = "|" + rs.getInt(1) + "          " + rs.getDate(2) + "             " + rs.getFloat(3) + "             " + rs.getFloat(4) + "        " + rs.getString(5) + "|";
                           System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                           System.out.print("\n" + w);

                  }

                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");

             }

         public static void smallAmountReceviedDay() throws IOException, SQLException
             {
                  Connection co = DriverManager.getConnection(url, user_name, password);
                  String query = "select orders.order_id,orders.ord_date,line_item.quantity,line_item.price,line_item.product_name from orders,line_item WHERE price = (SELECT min(price) FROM line_item)";
                  PreparedStatement pst = co.prepareStatement(query);
                  ResultSet rs = pst.executeQuery();
                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                  System.out.format("\n|%-15s|%-15s|%-15s|%-15s|%-15s|", "ORDER_ID", "DATE", "QUANTITY", "PRICE", "PRODUCT_NAME");
                  while (rs.next()) {

                           String w = "|" + rs.getInt(1) + "          " + rs.getDate(2) + "             " + rs.getFloat(3) + "             " + rs.getFloat(4) + "        " + rs.getString(5) + "|";
                           System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                           System.out.print("\n" + w);

                  }

                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
             }

         public static void higestProfitProduct() throws SQLException
             {
                  Connection co = DriverManager.getConnection(url, user_name, password);
                  String query1 = "SELECT order_id,product_id,product_name,quantity,price from line_item WHERE product_name = (SELECT MAX(product_name) FROM line_item)";
                  PreparedStatement pst = co.prepareStatement(query1);
                  ResultSet rs = pst.executeQuery();
                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                  System.out.format("\n|%-10s|%-10s|%-10s|%-10s|%-10s|", "ORDER_ID", "PRODUCT_ID", "QUANTITY", "PRICE", "TOTAL");
                  while (rs.next()) {
                           //System.out.print("\n+"+"-".repeat(10)+"+"+"-".repeat(10)+"+"+"-".repeat(10)+"+"+"-".repeat(10)+"+"+"-".repeat(10)+"+");
                           String w = " " + rs.getInt(1) + "        " + rs.getInt(2) + "           " + rs.getString(3) + "           " + rs.getFloat(4) + "         " + rs.getFloat(5) + "|";
                           System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+");
                           System.out.print("\n" + w);
                  }
                  System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+");

             }

         public static void dateBasedOrderCustomer() throws IOException, SQLException, ParseException
             {
                  Connection co = DriverManager.getConnection(url, user_name, password);
                  String query1 = "select orders.order_id,orders.ord_date,line_item.quantity,line_item.price,line_item.product_name from orders,line_item where ord_date=?";
                  PreparedStatement pst3 = co.prepareStatement(query1);
                  System.out.println("enter the Date\"yyyy/MM/dd\"");
                  Date date = Date.valueOf(br.readLine());

                  pst3.setDate(1, date);
                  ResultSet rs = pst3.executeQuery();
                  System.out.print("\n+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+");
                  System.out.format("\n|%-10s|%-10s|%-10s|%-10s|%-10s|", "ORDER_ID", "ORDER_DATE", "QUANTITY", "PRICE", "PRODUCT_NAME");

                  while (rs.next()) {
                           String w = rs.getInt(1) + "     " + rs.getDate(2) + "       " + rs.getFloat(3) + "      " + rs.getFloat(4) + "      " + rs.getString(5) + "|";
                           System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+");
                           System.out.print("\n" + w);

                  }
                  System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+");

             }

    }
