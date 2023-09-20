package khatabook;

import dao.KhatabookDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
//import static khatabook.Customer.i;
import static khatabook.Khatabook.BLUE;
import static khatabook.Khatabook.br;
import static khatabook.Khatabook.isAlphaCheck;
import static khatabook.Customer.kb;
import static khatabook.Khatabook.khatabook;

public class Product {

//    static {
//        product[++index] = new Product(idin, "Tomato Sauce", 149.00, 50, "950g", 50.00);
//        product[++index] = new Product(++idin, "Choco stick", 129.00, 200, "150g", 29.00);
//        product[++index] = new Product(++idin, "Peanut Butter", 350.00, 150, "500g", 150.00);
//        product[++index] = new Product(++idin, "Waffer", 99.00, 250, "50g", 10.00);
//        product[++index] = new Product(++idin, "Pringles", 119.00, 170, "100g", 19.00);
//    }
    Product() {

    }

    void addProduct() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Enter Product Name");
        String name;
        while (true) {
            name = br.readLine().trim();
            if (isAlphaCheck(name)) {
                break;
            }
            System.err.println("Please Enter a Product Name Only in Alphabets");
        }
        System.out.println("Enter the Cost Per Unit of Product");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(br.readLine());
                if (price > 0) {
                    break;
                } else {
                    System.err.println("Minimum cost of product is Rs.1/");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter a Price in Number Format");
            }
        }
        System.out.println("Enter the Number of Quantity");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(br.readLine());
                if (quantity > 0) {
                    break;
                } else {
                    System.err.println("Minimum quantity atleast 1 unit");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter a Quantity in Number Format");
            }
        }
        System.out.println("Enter the Product Weigth");
        String weigth = br.readLine().trim();
        System.out.println("Enter the Product Profit Per Unit Amount");
        double profitPerUnit;
        while (true) {
            try {
                profitPerUnit = Double.parseDouble(br.readLine());
                if (profitPerUnit > 0 && profitPerUnit < price) {
                    break;
                } else {
                    System.err.println("profit price should be higher than Rs.0 and less than product price");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter the Profit Amount in Number Format");
            }
        }
        String dateTime = LocalDateTime.now().toString().trim();
        int id = khatabook.getProduct().generateID(name);
        model.Product product = new model.Product(id, name, price, profitPerUnit, weigth, quantity, dateTime);
        if (khatabook.getProduct().addProduct(product)) {
            model.Stock stock = new model.Stock(product.getId(), quantity, dateTime);
            if (khatabook.getStock().stockEntry(stock)) {
                System.out.println("Stock added into Inventary\nReady for sale");
            } else {
                System.err.println("Stock not entry failed ");
            }
        } else {
            System.out.println("product not added");
        }
    }

    void updateQuantity() throws SQLException, ClassNotFoundException, IOException {
        model.Product[] product = khatabook.getProduct().getProduct();
        viewProduct(product, 0); // here why I am not using this it show only product quantity !=0
        System.out.println("\nEnter the product id");
        int id = 0;
        int tempQuantity = 0;
        boolean b = false;
        outer:
        while (true) {
            try {
                id = Integer.parseInt(br.readLine().trim());
                for (model.Product prod : product) {
                    if (prod.getId() == id) {
                        b = true;
                        tempQuantity = prod.getQuantity();
                    }
                }
                if (b) {
                    System.out.println("Entered id matched with product id");
                    break outer;
                } else {
                    System.err.println("Entered id did not match with product id\nplease enter a proper product id");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("\n Please Enter a ID in Numeric Format");
            }
        }
        System.out.println("Enter the Quantity");
        int quantity;
        model.Product p;
        while (true) {
            try {
                quantity = Integer.parseInt(br.readLine());
                if (quantity > 0) {
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("\n Please Enter a Quantity in Numeric Format");
            }
        }
        p = new model.Product();
        p.setQuantity(quantity + tempQuantity);
        p.setId(id);
        model.Stock stock = new model.Stock();
        stock.setProductID(id);
        stock.setQuantity(quantity);
        stock.setDateTime(LocalDateTime.now().toString());
        if (khatabook.getProduct().updateQuantity(p) && khatabook.getStock().stockEntry(stock)) {
            System.out.println("product quantity update successfully");
        } else {
            System.err.println("product quantity updation failed\nPlease try again");
        }
    }
// only view the given product - disgn, here minQuantity for I use this method in two differen field 1. show all product to customer - minimum quantity should 1
//                                                                                                   2. show all product in update product quantity - here I have to show all product no minimum quantity required - minimum quan = 0                                                              
    void viewProduct(model.Product[] product, int minQuantity) throws IOException, SQLException, ClassNotFoundException {
        System.out.print("+" + "-".repeat(66) + "+");//! check with this operator
        System.out.format("\n|%-6s|%-19s|%-14s|%-9s|%-14s|", "ID", "Name", "Price", "Quantity", "Weigth");
        System.out.print("\n+" + "-".repeat(66) + "+");
        for (model.Product p : product) {
            if (p.getQuantity() >= minQuantity) {
                System.out.format("\n|%-6d|%-19s|%-14.2f|%-9d|%-14s|", p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getWeight());
                System.out.print("\n+" + "-".repeat(66) + "+");
            }
        }
    }

//    @Override
//    public String toString() {
//        System.out.format("\n|%-6d|%-19s|%-14.2f|%-9d|%-14s|", id, name, price, quantity, weigth);
//        System.out.print("\n+" + "-".repeat(66) + "+");
//        return "";
//    }
    // update the product after placing the each order with respect to lineItem
    void productEntry(Orders order) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select quantity from product where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); PreparedStatement ps2 = connection.prepareStatement("update product set quantity = ? where id = ?");) {

            for (LineItem li : order.getLineItem()) {
                ps.setInt(1, li.getProductId());
                ResultSet rs = ps.executeQuery();
                rs.absolute(1);
                int quantity = rs.getInt(1) - li.getQuantity();
                ps2.setInt(1, quantity);
                ps2.setInt(2, li.getProductId());
                ps2.executeUpdate();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
}
