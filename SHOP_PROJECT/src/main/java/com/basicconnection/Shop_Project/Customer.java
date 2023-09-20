/*
 * Click nbrs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.basicconnection.Shop_Project;

/**
 *
 * @deepan
 * batch 8
 * shop
 * project
 */
import java.sql.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.io.BufferedReader;

public class Customer
  {

     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     static String url = "jdbc:mysql://bassure.in:3306/AK_db8";
     static String user_name = "arun";
     static String password = "arun1996";

     public static void viewAllCustomer()
       {

          try (Connection co = DriverManager.getConnection(url, user_name, password)) 
          {
               System.out.println(co.getClass());
               System.out.println("Successfully Connected...");
               Statement st = co.createStatement();
               String query = "select * from Customer";
               ResultSet rs = st.executeQuery(query);
               
               int count = 0;
               System.out.printf("%10s%9s%15s%15s", "Customer_id", "Name", "Phonenumber", " Address");
               while (rs.next()) {
                    int Customer_id = rs.getInt(1);
                    String Name = rs.getString(2);
                    String Phone_number = rs.getString(3);
                    String Address = rs.getString(4);
                    System.out.println();
                    System.out.format("%8s%13s%15s%15s", Customer_id, Name, Phone_number, Address);
                    System.out.println();
                    count++;

               }
          } catch (Exception e) {
               System.out.println(e);
          }

       }

     public static void viewCustomer() throws SQLException, IOException
       {
          Connection connection = DriverManager.getConnection(url, user_name, password);
          String query = " select  *from Customer where Phone_Number =?";

          PreparedStatement pst = connection.prepareStatement(query);
          System.out.println("Enter the phone number");
          String ph_no = br.readLine();
          pst.setString(1, ph_no);
          ResultSet rs = pst.executeQuery();
          System.out.printf("%10s%9s%15s%15s", "Customer_id", "Name", "Phonenumber", " Adress");
          while (rs.next()) {
               System.out.format("\n%8d%13s%15s%15s", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

          }
       }

     public static void addCustomer() throws SQLException, IOException
       {
          Connection co = DriverManager.getConnection(url, user_name, password);
          String q = "insert into Customer values(?,?,?,?)";
          PreparedStatement pst = co.prepareStatement(q);
          System.out.println("Enter the Customer_Id");
          int cus_id = Integer.parseInt(br.readLine());
          pst.setInt(1, cus_id);
          System.out.println("Enter the Name");
          String name = br.readLine();
          pst.setString(2, name);
          System.out.println("Enter the PhoneNumber");
          String phone = br.readLine();
          pst.setString(3, phone);
          System.out.println("Enter the Adress");
          String address = br.readLine();
          pst.setString(4, address);

          int r = pst.executeUpdate();
          if (r == 1) {
               System.out.println("saved");
          } else {
               System.out.println("not saved");
          }
       }

     public static void updateCustomer() throws IOException, SQLException
       {
          Connection co = DriverManager.getConnection(url, user_name, password);
          System.out.println("Enter the Customer-id");
          int customer = Integer.parseInt(br.readLine());
          String query = " select  *from Customer where Customer_Id =" + customer;

          PreparedStatement pst = co.prepareStatement(query);
          ResultSet rs = pst.executeQuery();
          if (rs.next()) {
               System.out.println("1.customer name");
               System.out.println("2.customer phonenumber");
               System.out.println("3.customer address");
               int select = Integer.parseInt(br.readLine());
               switch (select) {
                    case 1: {
                         System.out.println("sucess");
                         String query1 = "update Customer set  Name=? where  Customer_Id =?";
                         PreparedStatement s = co.prepareStatement(query1);
                         System.out.println("Enter the Customer name");
                         String name = br.readLine();
                         s.setString(1, name);
                         s.setInt(2, customer);
                         s.executeUpdate();
                         System.out.println("Changed sucess");
                         break;
                    }
                    case 2: {
                         String query2 = "update Customer set   Phone_Number=? where  Customer_Id =?";
                         PreparedStatement s1 = co.prepareStatement(query2);
                         System.out.println("Enter the phone number");
                         String phone = br.readLine();
                         s1.setString(1, phone);
                         s1.setInt(2, customer);
                         s1.executeUpdate();
                         System.out.println("Changed sucess");
                         break;

                    }
                    case 3: {

                         String query3 = "update Customer set  Address =? where  Customer_Id =?";
                         PreparedStatement s3 = co.prepareStatement(query3);
                         System.out.println("Enter the Address");
                         String address = br.readLine();
                         s3.setString(1, address);
                         s3.setInt(2, customer);
                         s3.executeUpdate();
                         System.out.println("Changed sucess");
                         break;
                    }
               }

          } else {
               System.err.println("\u26A0 Enter a correct AadharSNumber");
          }
       }

     public static void orderPlaced() throws SQLException, IOException
       {

          Connection co = DriverManager.getConnection(url, user_name, password);
          System.out.println("Enter the Customer-id");
          int customer = Integer.parseInt(br.readLine());
          String query = " select  * from Customer where Customer_Id =" + customer;
          PreparedStatement pst = co.prepareStatement(query);
          ResultSet rs = pst.executeQuery();
          if (rs.next()) {

               String query1 = "insert into orders values(?,?,?)";
               PreparedStatement ps = co.prepareStatement(query1);
               System.out.println("Enter the order_Id");
               int ord_id = Integer.parseInt(br.readLine());
               Date ld = Date.valueOf(LocalDate.now());
               ps.setInt(1, ord_id);
               ps.setInt(2, customer);
               ps.setDate(3, ld);
               ps.executeUpdate();
               Inventory.viewAvalibleProducts(co);
               float sum = 0;
               boolean d = true;
               while (d) {
                    System.out.println("enter the prodect id");
                    int pro_id = Integer.parseInt(br.readLine());
                    String name = getName(co, pro_id);
                    System.out.println("enter the Quandity");
                    int quan = Integer.parseInt(br.readLine());
                    float pri = getPrice(co, pro_id);
                    float price = quan * pri;
                    sum += price;
                    System.out.println("totalamount=" + sum);

                    PreparedStatement pst1 = co.prepareStatement("insert into line_item values(?,?,?,?,?)");
                    pst1.setInt(1, ord_id);
                    pst1.setInt(2, pro_id);
                    pst1.setString(3, name);
                    pst1.setInt(4, quan);
                    pst1.setFloat(5, price);
                    int row = pst1.executeUpdate();
                    System.out.println("reached....");
                    System.out.println(row + " prodect added");
                    PreparedStatement pst2 = co.prepareStatement("update inventory set quantity=? where product_id =? ");
                    int a1 = getquantity(co, pro_id) - quan;
                    pst2.setInt(1, a1);
                    pst2.setInt(2, pro_id);
                    int row1 = pst2.executeUpdate();

                    System.out.println(row1 + "update");
                    System.out.println(1 + "add product");
                    System.out.println(2 + "enough product");
                    System.out.println("enter the menu");
                    int d1 = Integer.parseInt(br.readLine());
                    switch (d1) {
                         case 1: {
                              d = true;
                              break;
                         }
                         case 2: {
                              d = false;
                              break;
                         }
                    }
               }

               System.out.println("enter the payment_id");
               int pay = Integer.parseInt(br.readLine());
               PreparedStatement pst3 = co.prepareStatement("insert into payment values(?,?,?,?,?)");
               pst3.setInt(1, pay);
               pst3.setInt(2, ord_id);
               pst3.setFloat(3, sum);
               pst3.setFloat(4, sum);
               pst3.setString(5, "not paid");
               pst3.executeUpdate();
               System.out.println("order complete");

          } else {
               System.err.println("\u26A0 Enter a Number");
          }

       }

     public static String getName(Connection co, int pro_id) throws SQLException
       {
          PreparedStatement pre = co.prepareStatement("select product_name from inventory where product_id =?");
          pre.setInt(1, pro_id);
          ResultSet rs = pre.executeQuery();
          String pri = null;
          while (rs.next()) {
               pri = rs.getString(1);
          }
          System.out.println(pri);
          return pri;
       }

     public static float getPrice(Connection co, int pro_id) throws SQLException
       {
          PreparedStatement pr = co.prepareStatement("select price from inventory where product_id=? ");

          pr.setFloat(1, pro_id);
          ResultSet re1 = pr.executeQuery();
          float pri = 0;
          while (re1.next()) {
               pri = re1.getFloat(1);
          }
          System.out.println(pri);
          return pri;
       }

     public static int getquantity(Connection co, int pro_id) throws SQLException
       {
          PreparedStatement pr1 = co.prepareStatement("select quantity  from inventory where product_id=?");
          pr1.setInt(1, pro_id);
          ResultSet re2 = pr1.executeQuery();
          System.out.println("query");
          int quandity = 0;
          while (re2.next()) {
               quandity = re2.getInt(1);

          }
          System.out.println(quandity);
          System.out.println(quandity);
          return quandity;
       }

     public static void payment() throws SQLException, IOException
       {
          Connection co = DriverManager.getConnection(url, user_name, password);
          System.out.println("1.payment");
          int bill = Integer.parseInt(br.readLine());
          switch (bill) {
               case 1: {

                    System.out.println("Enter the Customer_id");
                    int customer = Integer.parseInt(br.readLine());
                    PreparedStatement pst = co.prepareStatement(" select * from Customer where Customer_Id =?");
                    pst.setInt(1, customer);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                         System.out.println("hiii..");
                         PreparedStatement pst1 = co.prepareStatement("select *from payment where order_id in(select order_id from orders where Customer_Id=?)");
                         pst1.setInt(1, customer);
                         ResultSet re = pst1.executeQuery();
                         Float e = 0.0f;
                         int oid = 0;
                         System.out.printf("%10s%11s%15s%20s", "Payment_id", "Order_id", "Totel_amount", " Balance_amount");
                         System.out.println();

                         while (re.next()) {
                              e = re.getFloat(4);
                              oid = re.getInt(2);
                              System.out.format("%10s%9s%15s%15s", re.getInt(1), " " + re.getInt(2), " " + re.getFloat(3), " " + re.getFloat(4));
                              System.out.println(oid);
                              System.out.println();
                         }
                         float total = 0;
                         System.out.println("enter the order_id");
                         int orde = Integer.parseInt(br.readLine());
                         PreparedStatement pst3 = co.prepareStatement("select balance from payment where order_id=?");
                         pst3.setInt(1, oid);
                         ResultSet f = pst3.executeQuery();
                         f.next();
                         float balance = f.getFloat(1);
                         System.out.println("enter the your amount");
                         Float bala = Float.valueOf(br.readLine());

                         System.out.println(total);
                         System.out.println();

                         if (Objects.equals(e, bala)) {
                              total = e - bala;
                              String queryb = "update payment set balance =?,status='paid'where order_id =?";
                              PreparedStatement pst2 = co.prepareStatement(queryb);
                              pst2.setFloat(1, total);
                              pst2.setFloat(2, orde);
                              pst2.executeUpdate();
                              System.out.println("execute");
                         } else if (e > bala) {
                              total = e - bala;
                              String queryb = "update payment set balance =? where order_id =?";
                              PreparedStatement pst2 = co.prepareStatement(queryb);
                              pst2.setFloat(1, total);
                              pst2.setFloat(2, orde);
                              pst2.executeUpdate();
                              System.out.println("execute");
                         } else {
                              System.out.println("you enter extra amount of your order please enter the correct amount and confirm it");
                         }

                    }
                    break;
               }
          }

       }

     public static void viewOrderDeatils() throws SQLException, IOException
       {
          System.out.println("enter your options");
          System.out.println("1  view all orderDetails");
          System.out.println("2  single customerorder");
          int opt = Integer.parseInt(br.readLine());
          switch (opt) {

               case 1: {
                    Connection co = DriverManager.getConnection(url, user_name, password);
                    //String query="select *  from orders,line_item where orders.order_id=line_item.order_id;";
                    String query1 = "select orders.order_id,orders.customer_id,orders.ord_date,line_item.product_id,line_item.quantity,line_item.price,line_item.product_name  from orders,line_item where orders.order_id=line_item.order_id;";
                    PreparedStatement pst = co.prepareStatement(query1);
                    ResultSet rs = pst.executeQuery();
                    System.out.printf("%10s%14s%15s%12s", "order_id", "customer_id", "order_date", "quantity", "total");
                    System.out.println();
                    while (rs.next()) {
                         System.out.format("%10s%9s%15s%15s", rs.getInt(1), " " + rs.getInt(2), " " + rs.getString(3), " " + rs.getInt(4), "" + rs.getInt(5), "" + rs.getString(6));
                         System.out.println();
                    }
                    break;
               }
               case 2: {
                    Connection co = DriverManager.getConnection(url, user_name, password);
                    System.out.println("Enter the customer ID");
                    int cusid = Integer.parseInt(br.readLine());
                    String query = "select * from orders where Customer_Id =" + cusid;
                    ResultSet r;
                    try (Statement s = co.createStatement()) {
                         r = s.executeQuery(query);
                         while (r.next()) {
                              System.out.println("____________________________________");
                              int e = r.getInt(1);
                              String w1 = e + ": " + r.getInt(2) + ":  " + r.getDate(3);
                              System.out.println(w1);
                              System.out.println("|==================================|");

                              PreparedStatement pr = co.prepareStatement("select * from line_item where order_id=?");
                              pr.setInt(1, e);
                              ResultSet rs1 = pr.executeQuery();
                              while (rs1.next()) {
                                   System.out.println("|_________________________________|");
                                   String w2 = rs1.getInt(1) + " :" + rs1.getInt(2) + " :" + rs1.getString(3) + " :" + rs1.getInt(4) + " :" + rs1.getFloat(5);
                                   System.out.println(w2);

                                   System.out.println("|-----------------------------|");
                              }
                              System.out.println("|_________________________________|");

                         }
                    }

               }
               break;
          }
       }
  }
