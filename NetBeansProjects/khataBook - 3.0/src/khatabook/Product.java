package khatabook;

import java.time.LocalTime;
import java.io.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static khatabook.Customer.i;
import static khatabook.KhataBook.BLUE;
import static khatabook.KhataBook.br;
import static khatabook.KhataBook.isAlphaCheck;
import static khatabook.KhataBook.cust;

public class Product {

    private int id;
    private String name;
    private double profit;
    private double price;
    private int quantity;
    private String weigth;
    static Product[] product = new Product[0];   // static  - static{}
    static int index = -1;
    static int idin = 1000;
    Scanner scan = new Scanner(System.in);
    Stock stock = new Stock();
    public Product(int id, String name, double price, int quantity, String weigth, double profit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weigth = weigth;
        this.profit = profit;
    }

//    static {
//        product[++index] = new Product(idin, "Tomato Sauce", 149.00, 50, "950g", 50.00);
//        product[++index] = new Product(++idin, "Choco stick", 129.00, 200, "150g", 29.00);
//        product[++index] = new Product(++idin, "Peanut Butter", 350.00, 150, "500g", 150.00);
//        product[++index] = new Product(++idin, "Waffer", 99.00, 250, "50g", 10.00);
//        product[++index] = new Product(++idin, "Pringles", 119.00, 170, "100g", 19.00);
//    }
    Product() {

    }
//void products(){
//    
//    product[index]=new Product(idin,"Tomato Sauce",149.00,50,"950g");
//    product[++index]=new Product(++idin,"Choco stick",129.00,200,"150g");
//    product[++index]=new Product(++idin,"Peanut Butter",350.00,150,"500g");
//    product[++index]=new Product(++idin,"Waffer",99.00,250,"50g");
//    product[++index]=new Product(++idin,"Pringles",119.00,170,"100g");
//    
//            }

    void addProduct() throws IOException {
        //products();
        //product = Arrays.copyOf(product, product.length + 1);
        System.out.println("Enter Product Name");
        String productName;//scan.next();
        while (true) {
            productName = br.readLine();
            if (isAlphaCheck(productName)) {
                break;
            }
            System.err.println("Please Enter a Product Name Only in Alphabets");
        }
        System.out.println("Enter the Price of Product");
        double pricein;
        while (true) {
            try {
                pricein = Double.parseDouble(br.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter a Price in Number Format");
            }
        }
        System.out.println("Enter the Number of Quantity");
        int quantityin;
        while (true) {
            try {
                quantityin = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter a Quantity in Number Format");
            }
        }
        System.out.println("Enter the Product Weigth");
        String weigthin = scan.next();
        System.out.println("Enter the Product Profit Amount");
        double profit;//= scan.nextDouble();
        while (true) {
            try {
                profit = Double.parseDouble(br.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.err.println("Please Enter the Profit Amount in Number Format");
            }
        }
        int lastId = product.length - 2;
        int currentId = product[lastId].id + 1;//pending
        product[++index] = new Product(currentId, productName, pricein, quantityin, weigthin, profit);
        writeProduct();
        System.out.println(BLUE + "Product Added Successfully");
    }

    void updateQuantity() throws IOException {
        viewProduct();
        System.out.println("Enter the Product Name");
        String productName;
        while (true) {
            productName = br.readLine();
            if (isAlphaCheck(productName)) {
                break;
            }
            System.err.println("\n Given Product Name Contains May Numeric Value, Please Make Sure Before Submit ");
        }
        System.out.println("Enter the Quantity");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.err.println("\n Please Enter a Quantity in Numeric Format");
            }
        }
        int index = 0;
        boolean flag = true;
        for (Product p : product) {
            if (p.name.equalsIgnoreCase(productName)) {
                product[index].quantity += quantity;
                System.out.println(BLUE + "Quantity Updated \n Current Quantity is " + product[index].quantity);
                //product not available
                flag = false;
                break;
            }
            ++index;
        }
        if (flag == true) {
            System.err.println("Product Not Found \n");
        }
    }

    void viewProduct() throws IOException {
        System.out.print("+" + "-".repeat(66) + "+");//! check with this operator
        System.out.format("\n|%-6s|%-19s|%-14s|%-9s|%-14s|", "ID", "Name", "Price", "Quantity", "Weigth");
        System.out.print("\n+" + "-".repeat(66) + "+");
        for (Product p : product) {
            p.toString();    // only p before 
        }
        // readProduct();
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.err.println("Please Enter a Valid Product Name");
        }
    }

    public void setPrice(double price) {
        if (price > 5.00) {
            this.price = price;
        } else {
            System.out.println("Please Enter a Valid Price");
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeigth(String weigth) {

        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getWeigth() {
        return weigth;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String toString() {
        System.out.format("\n|%-6d|%-19s|%-14.2f|%-9d|%-14s|", id, name, price, quantity, weigth);
        System.out.print("\n+" + "-".repeat(66) + "+");
        return "";
    }

    public void writeProduct() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("/home/bas200193/Desktop/textFiles/products/productInfo.txt"); DataOutputStream dos = new DataOutputStream(fos); FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/products/productInfo.txt"); DataInputStream dis = new DataInputStream(fis);) {
            for (int i = 0; i < product.length; i++) {
                dos.writeInt(product[i].id);
                dos.writeUTF(product[i].name);
                dos.writeDouble(product[i].price);
                dos.writeInt(product[i].quantity);
                dos.writeUTF(product[i].weigth);
                dos.writeDouble(product[i].profit);

            }

        } catch (IOException ioe) {
            System.err.println("File not readed Successfully ");
        }
    }

    public void readProduct() throws IOException {
        try (FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/products/productInfo.txt"); DataInputStream dis = new DataInputStream(fis);) {
            while (dis.available() > 0) {
                try {

                    product = Arrays.copyOf(product, product.length + 1);
                    product[++index] = new Product(dis.readInt(), dis.readUTF(), dis.readDouble(), dis.readInt(), dis.readUTF(), dis.readDouble());
                } catch (EOFException eofe) {
                    --index;
                    product = Arrays.copyOf(product, product.length - 1);
                    break;
                }
            }
            //}
        }

    }
}
