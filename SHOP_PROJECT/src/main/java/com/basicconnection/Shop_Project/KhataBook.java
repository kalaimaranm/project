/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicconnection.Shop_Project;

/**
 *
 * @author bas200180
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class KhataBook
  {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String url = "jdbc:mysql://bassure.in:3306/deepans_db8";
    static String user_name = "deepans";
    static String password = "deepanraj.18@";

    public static void main(String[] args) throws IOException, SQLException, ParseException
      {
        Connection co = DriverManager.getConnection(url, user_name, password);

        String[] number = {"Customer", "Inventory", "Statistics", "Exit"};

        System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
        System.out.format("\n|%-10s|%-10s|", "S.NO", "NUMBERS");
        System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
          System.out.println("");

        for (int i = 0; i < number.length; i++) {
            System.out.format("\n|%-10d|%-10s|", (i + 1), number[i]);
        }
        System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");

        int mainMenu = Integer.parseInt(input.readLine());

        while (true) {
            while (mainMenu == 1) {
                String[] menu = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                for (int i = 0; i < menu.length; i++) {
                    System.out.format("\n|%-18d|%-18s|", (i + 1), menu[i]);
                }
                System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                int customerMenu = Integer.parseInt(input.readLine());
                while (customerMenu == 1) {
                    Customer.addCustomer();

                    String[] menu1 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu1.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    customerMenu = Integer.parseInt(input.readLine());
                }
                while (customerMenu == 2) {
                    Customer.viewCustomer();

                    String[] menu2 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};

                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu2.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu2[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    customerMenu = Integer.parseInt(input.readLine());
                }
                while (customerMenu == 3) {
                    Customer.updateCustomer();

                    String[] menu3 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu3.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu3[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    customerMenu = Integer.parseInt(input.readLine());

                }

                while (customerMenu == 4) {
                    Customer.viewAllCustomer();
                    String[] menu4 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu4.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu4[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    customerMenu = Integer.parseInt(input.readLine());
                }
                while (customerMenu == 5) {
                    Customer.orderPlaced();

                    String[] menu5 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu5.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu5[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.println("8.Exit");
                    customerMenu = Integer.parseInt(input.readLine());

                }

                while (customerMenu == 6) {
                    Customer.payment();

                    String[] menu6 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu6.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu6[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");

                    System.out.println("8.Exit");
                    customerMenu = Integer.parseInt(input.readLine());

                }
                while (customerMenu == 7) {
                    Customer.viewOrderDeatils();
                    String[] menu7 = {"AddCustomer", "ViewCustomer", "UpdateCustomer", "View All Customer", "OrderPlaced", "Payment", "ViewOrderDetails", "Exit"};
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    System.out.format("\n|%-18s|%-18s|", "S.NO", "Customer Menu");
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    for (int i = 0; i < menu7.length; i++) {
                        System.out.format("\n|%-18d|%-18s|", (i + 1), menu7[i]);
                    }
                    System.out.print("\n+" + "=".repeat(18) + "+" + "=".repeat(18) + "+");
                    customerMenu = Integer.parseInt(input.readLine());

                }

                if (customerMenu == 8) {

                    String[] number1 = {"Customer", "Inventory", "Statistics", "Exit"};
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    System.out.format("\n|%-10s|%-10s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    for (int i = 0; i < number1.length; i++) {
                        System.out.format("\n|%-10d|%-10s|", (i + 1), number1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    mainMenu = Integer.parseInt(input.readLine());
                }
                else {
                    System.err.println("Inavalid Option");
                    mainMenu = 1;
                }
            }
            while (mainMenu == 2) {
                String[] pro = {"VIEW AVALIBLE PRODUCTS", "ADD PRODUCTS", "UPDATE PRODUCTS", "Exit"};
                System.out.print("\n+" + "-".repeat(22) + "+" + "-".repeat(22) + "+");
                System.out.format("\n|%-22s|%-22s|", "S.NO", "NUMBERS");
                System.out.print("\n+" + "-".repeat(22) + "+" + "-".repeat(22) + "+");
                for (int i = 0; i < pro.length; i++) {
                    System.out.format("\n|%-22d|%-22s|", (i + 1), pro[i]);
                }
                System.out.print("\n+" + "-".repeat(22) + "+" + "-".repeat(22) + "+");
                int inventoryMenu = Integer.parseInt(input.readLine());;
                while (inventoryMenu == 1) {
                    Inventory.viewAvalibleProducts(co);

                    String[] pro1 = {"VIEW AVALIBLE PRODUCTS", "ADD PRODUCTS", "UPDATE PRODUCTS", "Exit"};
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    System.out.format("\n|%-22s|%-22s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    for (int i = 0; i < pro1.length; i++) {
                        System.out.format("\n|%-22d|%-22s|", (i + 1), pro1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    inventoryMenu = Integer.parseInt(input.readLine());
                }
                while (inventoryMenu == 2) {
                    Inventory.addProduct(co);
                    System.out.println("1.VIEW AVALIBLE PRODUCTS");
                    System.out.println("2.ADD PRODUCTS");
                    System.out.println("3.UPDATE PRODUCTS");
                    System.out.println("4.EXIT ");

                    inventoryMenu = Integer.parseInt(input.readLine());
                }
                while (inventoryMenu == 3) {
                    Inventory.updateProduct(co);

                    String[] pro2 = {"VIEW AVALIBLE PRODUCTS", "ADD PRODUCTS", "UPDATE PRODUCTS", "Exit"};
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    System.out.format("\n|%-22s|%-22s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    for (int i = 0; i < pro2.length; i++) {
                        System.out.format("\n|%-22d|%-22s|", (i + 1), pro2[i]);
                    }
                    System.out.print("\n+" + "=".repeat(22) + "+" + "=".repeat(22) + "+");
                    inventoryMenu = Integer.parseInt(input.readLine());
                }
                if (inventoryMenu == 4) {

                    String[] number1 = {"Customer", "Inventory", "Statistics", "Exit"};
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    System.out.format("\n|%-10s|%-10s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    for (int i = 0; i < number1.length; i++) {
                        System.out.format("\n|%-10d|%-10s|", (i + 1), number1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");

                    mainMenu = Integer.parseInt(input.readLine());
                }
                else {
                    System.err.println("Inavalid Option");
                    mainMenu = 2;
                }
            }
            while (mainMenu == 3) {

                String[] menu = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                for (int i = 0; i < menu.length; i++) {
                    System.out.format("\n|%-27d|%-27s|", (i + 1), menu[i]);
                }
                System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                int statisticsMenu = Integer.parseInt(input.readLine());;
                while (statisticsMenu == 1) {
                    Orders.largeAmountReceviedDay();

                    String[] menu1 = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    for (int i = 0; i < menu1.length; i++) {
                        System.out.format("\n|%-27d|%-27s|", (i + 1), menu1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    statisticsMenu = Integer.parseInt(input.readLine());
                }
                while (statisticsMenu == 2) {
                    Orders.smallAmountReceviedDay();
                    String[] menu2 = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    for (int i = 0; i < menu2.length; i++) {
                        System.out.format("\n|%-27d|%-27s|", (i + 1), menu2[i]);
                    }
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    statisticsMenu = Integer.parseInt(input.readLine());
                }
                while (statisticsMenu == 3) {
                    Orders.dateBasedOrderCustomer();
                    String[] menu3 = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    for (int i = 0; i < menu3.length; i++) {
                        System.out.format("\n|%-27d|%-27s|", (i + 1), menu3[i]);
                    }
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    statisticsMenu = Integer.parseInt(input.readLine());
                }
                while (statisticsMenu == 4) {
                    Orders.largeSaleProduct();
                    String[] menu4 = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    for (int i = 0; i < menu4.length; i++) {
                        System.out.format("\n|%-27d|%-27s|", (i + 1), menu4[i]);
                    }
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    statisticsMenu = Integer.parseInt(input.readLine());
                }
                while (statisticsMenu == 5) {
                    Orders.higestProfitProduct();
                    String[] menu5 = {"LARGE AMOUNT RECEVIED DAY", "SMALL AMOUNT RECEVIED DAY", "DATE BASED ORDER CUSTOMERS", "LARGE SALE PRODUCT", "HIGEST PROFIT PRODUCT", "EXIT"};
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    System.out.format("\n|%-27s|%-27s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    for (int i = 0; i < menu5.length; i++) {
                        System.out.format("\n|%-27d|%-27s|", (i + 1), menu5[i]);
                    }
                    System.out.print("\n+" + "=".repeat(27) + "+" + "=".repeat(27) + "+");
                    statisticsMenu = Integer.parseInt(input.readLine());
                }
                if (statisticsMenu == 6) {

                    String[] number1 = {"Customer", "Inventory", "Statistics", "Exit"};
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    System.out.format("\n|%-10s|%-10s|", "S.NO", "NUMBERS");
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    for (int i = 0; i < number1.length; i++) {
                        System.out.format("\n|%-10d|%-10s|", (i + 1), number1[i]);
                    }
                    System.out.print("\n+" + "=".repeat(10) + "+" + "=".repeat(10) + "+");
                    mainMenu = Integer.parseInt(input.readLine());
                }
                else {
                    System.err.println("Inavalid Option");
                    mainMenu = 3;
                }

            }
            if (mainMenu == 4) {
                System.out.println("Thank you");
                break;
            }
            else {
                System.err.println("Inavalid Option");
                mainMenu = Integer.parseInt(input.readLine());;
            }
        }
      }
  }
