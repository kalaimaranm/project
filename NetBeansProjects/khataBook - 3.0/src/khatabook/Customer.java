package khatabook;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import static khatabook.KhataBook.billHeader;
import static khatabook.KhataBook.p;
import static khatabook.Orders.order;
import static khatabook.Product.product;
import java.time.LocalDate;
import static khatabook.KhataBook.br;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import static khatabook.KhataBook.*;
import static khatabook.KhataBook.cust;

public class Customer {

    LineItem[] lFake = new LineItem[0];
    private double debt;
    private double paidAmount;   // double tempDebt;
    int orderIdIn = 85293;   //remaining Amount
    int orderIndex = 0;
    static int k;
    static int i;
    static int j;
    Scanner scan = new Scanner(System.in);
    short custId;// = 2134;
    String name;
    String address;
    String phoneNo;       // change this to long by adding l with last (String - and add 'l' convert into long)
    String aadhaarNo;
    private int cusId;
    LineItem[] tempLine = new LineItem[0];
    int tempIndex = 0;
    String checkphoneNo;
    double tempTotal = 0;
    String status;

    //static short s;
    Customer() {

    }

    Customer(String status, double debt, short custId, String name, String address, String phoneNo, String aadharNo) {
        this.status = status;
        this.debt = debt;
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.aadhaarNo = aadharNo;
    }

    public double getDebt() {
        return this.debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    void createAccount() {
   
    }

    void view(String phoneNo2) {
        for (i = 0; i < cust.length; i++) {
            if (cust[i].phoneNo.equals(phoneNo2)) {
                System.err.println("*".repeat(15) + "Customer Detail" + "*".repeat(15));
                System.out.println(cust[i]);
                break;
            }
        }
    }

    void update() throws IOException {
        boolean flag = true;
        boolean flag2 = true;
        while (flag) {
            System.out.println("Enter the Customer PhoneNo ");
            String phoneNo = phoneNoGetCheck();
            int s = 0;
//          boolean number = Arrays.stream(cust)
//                          .filter(customer-> {
//                          if(customer.phoneNo.equals(phoneNo)){
//                           return true;} 
//                           return false;})
//                          .map(fnctn -> fnctn.phoneNo = phoneNo 
//                          return true;);

            for (i = 0; i < cust.length; i++) {//inside for
                if (cust[i].phoneNo.equals(phoneNo) && cust[i].status.equals("Active")) {
                    flag2 = false;
                    // break;
                    System.out.println("_".repeat(33));
                    System.out.println("| Press 1 : Update PhoneNo");
                    System.out.println("| Press 2 : Update Name");
                    System.out.println("| Press 3 : Update AadharNo");
                    System.out.println("| Press 4 : Exit");
                    System.out.println("_".repeat(33));
                    System.out.println("Enter the Option From Above Menu");
                    int options;
                    while (true) {
                        try {
                            options = Integer.parseInt(br.readLine());
                            break;
                        } catch (NumberFormatException nfe) {
                            System.err.println("\n Please Select a Valid Options");
                        }
                    }
                    switch (options) {
                        case 1: { // phoneNo
                            System.out.println("Enter PhoneNo You would like to change ");
                            String phoneNoChange = phoneNoGetCheck();
                            cust[i].phoneNo = phoneNoChange;
                            System.out.println(BLUE + "Your PhoneNo successfully changed ");
                            flag = false;
                            break;
                        }
                        case 2: { // name
                            System.out.println("Enter Name You would like to change ");
                            String nameChange;
                            while (true) {
                                try {
                                    nameChange = br.readLine();
                                    if (isAlphaCheck(nameChange)) {
                                        break;
                                    }
                                    System.err.println("Please Enter a Valid Name ");

                                } catch (NumberFormatException nfe) {
                                    System.err.println("\n Given Name Contains May Numeric Value, Please Make Sure Before Submit ");
                                }
                            }
                            cust[i].name = nameChange;
                            System.out.println(BLUE + "Your Name successfully changed ");
                            flag = false;
                            break;
                        }

                        case 3: {   // aadhaar
                            System.out.println("Enter Aadhaar You would like to change ");
                            String aadhaarChange;
                            while (true) {
                                aadhaarChange = br.readLine();
                                if (aadhaarChange.chars().filter(Character::isDigit).count() == 12) {
                                    break;
                                } else {
                                    System.err.println("Please Enter a Valid Aadhaar Number \nAadhaarNumber Format: 8787xxxx7763");
                                }
                            }
                            cust[i].name = aadhaarChange;
                            System.out.println(BLUE + "Your Aadhaar Number successfully changed ");
                            flag = false;
                            break;
                        }
                        case 4: { // break
                            flag = false;
                            break;
                        }
                        default: {
                            System.out.println("Please Select a valid Option");
                            break;
                        }
                    }
                    break;

                }

            } // added new 
            if (flag2 == true) {
                System.err.println("Customer Not Found");
                flag = false;
            }
        }
    }

    public String toString() {
        return "Customer ID : " + this.custId + "\n" + "Customer Name : " + "\nCustomer Address : " + this.address + this.name + "\n" + "Customer PhoneNo : " + this.phoneNo + "\n" + "Customer AadharNo : " + this.aadhaarNo + "\nCustomer Debt : " + this.getDebt() + " Rs" + "\nCustomer Status : " + this.status;
    }

    public void placeOrder() throws IOException {
        short sNo = 0;
        boolean phoneFlag = false;
        boolean quantityFlag = false;
        if (cust.length > 0) {      // customer check               // else No customer added
            System.out.println("Enter Your PhoneNo");
            checkphoneNo = phoneNoGetCheck();
            for (j = 0; j < cust.length; j++) {
                if (cust[j].phoneNo.equals(checkphoneNo) && cust[j].status.equals("Active")) {
                    phoneFlag = true;
                    System.out.println("Customer Found, Select Product From Below List");// phoneNumber check
                    break;
                }
            }
            if (phoneFlag == false) {
                System.err.println("Customer Not Found");    //  customer not
            }
            if (phoneFlag) {
                p.viewProduct();
                boolean productFlag = true;
                int check;

                while (productFlag) {
                    System.out.println("\nPress 1 : To add Products");
                    System.out.println("Press 2 : To Place order");
                    System.out.println("Press 3 : To View the Order");
                    System.out.println("Press 4 : Exit");
                    //   check = scan.nextInt();
                    while (true) {
                        try {
                            check = Integer.parseInt(br.readLine());
                            break;
                        } catch (NumberFormatException nfe) {
                            System.err.println("\n Please Select a Valid Options");
                        }
                    }
                    switch (check) {
                        case 1: {
                            System.out.println("Choose Product From Above List And Enter the Product Id");
                            int productId;
                            while (true) {
                                try {
                                    productId = Integer.parseInt(br.readLine());
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Please Enter a Valid Product Id");
                                }
                            }
                            System.out.println("Enter the Quantity");
                            int productQuantity;

                            while (true) {
                                try {
                                    productQuantity = Integer.parseInt(br.readLine());
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Please Enter a Valid Quantity");
                                }
                            }
                            boolean productQuantityCheck = false;
                            int indexStore = 0;
                            boolean proFound = false;
                            for (k = 0; k < product.length; k++) {
                                if (productId == product[k].getId()) {
                                    indexStore = k;
                                    proFound = true;
                                    break;
                                }
                            }
                            if (proFound == false) {
                                System.err.println("Product Not Found, Please Enter a Valid Product ID\n");
                            }
                            if (product[indexStore].getQuantity() >= productQuantity) {     // quantity check   else quantity not availble
                                productQuantityCheck = true;
                                //break;
                            }
                            indexStore = 0;
                            k = 0;
                            if (productQuantityCheck == false) {
                                System.err.println("Sorry, Selected Product Quantity is Not Available Please select Any other Products\n");
                            }
                            if (productQuantityCheck) {
                                outer:
                                for (int jk = 0; jk < product.length; jk++) {
                                    if (product[jk].getId() == productId) {
                                        tempLine = Arrays.copyOf(tempLine, tempLine.length + 1);
                                        //tempTotal=tempTotal + product[k].getPrice();
                                        int oldQuantity = product[jk].getQuantity();
                                        product[jk].setQuantity(oldQuantity - productQuantity);
                                        //s = ++sNo;     [tempIndex]
                                        tempLine[tempLine.length - 1] = new LineItem(++sNo, productQuantity, product[jk].getName(), productId, productQuantity * product[jk].getPrice());
                                        System.out.println(BLUE + "Item Added Successfully");
                                        ++tempIndex;
                                        break outer;
                                    }
                                }
                            }
                            break;
                        }
                        case 2: {
                            sNo = 0;
                            for (int d = 0; d < tempLine.length; d++) {
                                tempTotal = tempTotal + tempLine[d].getItemAmount() * tempLine[d].getQuantity();
                            }
                            order = Arrays.copyOf(order, order.length + 1);
                            LocalDate date = LocalDate.now();
                            LocalTime time = LocalTime.now();  //[orderIndex] , orderIdIn
                            order[order.length - 1] = new Orders(date, time, order[order.length - 2].getOrderid() + 1, cust[j].cusId, checkphoneNo, tempTotal, tempLine);
                            System.out.println("-".repeat(55));
                            System.out.println("                       JioMart        ");
                            System.out.println("-".repeat(55));
                            System.out.println("Date: " + date);
                            System.out.print("Time: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() / 1000000);
                            System.out.println("\nOrder Id: " + order[orderIndex].getOrderid());
                            billHeader();
                            for (int in = 0; in < order[order.length - 1].lineItem.length; in++) {
                                order[order.length - 1].lineItem[in].toString();
                                System.out.println("\n");
                                System.out.print("-".repeat(55));
                            }

                            System.out.print("\n                            GRAND TOTAl: Rs. " + tempTotal + "\n");
                            System.out.println("-".repeat(55));
                            System.out.print("             Thanks a Lot ! Visit again.\n");
                            System.out.println("        " + "*".repeat(37) + "          ");
                            System.out.print("-".repeat(55));
                            System.out.print("\nEnter the Amount " + tempTotal + " Rs");
                            double payment;
                            while (true) {
                                try {
                                    payment = Double.parseDouble(br.readLine());
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Please Enter the Amount in Digit");
                                }
                            }
                            if (tempTotal > payment) {
                                double cuDebt = Math.abs(tempTotal - payment);
                                double ddd = Math.abs(cust[j].getDebt() + cuDebt);
                                double process = Math.abs(ddd);
                                cust[j].setDebt(ddd);
                                System.out.println("Total Debt is  " + cust[j].getDebt());
                            }
                            System.out.println(BLUE + "order placed successfully");
                            tempTotal = 0;
                            tempIndex = 0;
                            ++orderIndex;
                            ++orderIdIn;
                            productFlag = false;
                            tempTotal = 0;
                            tempLine = Arrays.copyOf(tempLine, 0);
                            tempLine = lFake.clone();
                            tempLine = Arrays.copyOf(tempLine, 0);
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the Customer PhoneNo");
                            String orPhoneNo = phoneNoGetCheck();
                            boolean f = false;
                            int[] orderId = new int[0];
                            for (int o = 0; o < order.length; o++) {
                                if (orPhoneNo.equals(order[o].getCusPhone())) {
                                    f = true;
                                    orderId = Arrays.copyOf(orderId, orderId.length + 1);
                                    orderId[orderId.length - 1] = order[o].getOrderid();
                                }
                            }
                            if (f) {
                                for (int i = 0; i < orderId.length; i++) {
                                    System.out.println(i + 1 + "st Order are \n");
                                    for (int j = 0; j < order.length; j++) {
                                        if (order[j].getOrderid() == orderId[i]) {
                                            billHeader();
                                            for (int k = 0; k < order[j].lineItem.length; k++) {
                                                System.out.println(order[j].lineItem[k].toString());
                                            }
                                        }
                                    }
                                }
                            }
                            if (f == false) {
                                System.err.println("\nNo Order Placed\n");
                            }
                            break;
                        }
                        case 4: {
                            productFlag = false;
                            break;
                        }
                    }
                }
            }

        } else {
            System.err.println("No Customer Added Yet, Please Add Customer and Place Order");
        }
        System.out.println();
    }

    public void payDebts() throws IOException {
        boolean dcpFlag = false;
        System.out.println("Enter Your PhoneNo");
        String debtCheckPhoneNo = phoneNoGetCheck();
        for (int dcp = 0; dcp < cust.length; dcp++) {
            if (cust[dcp].phoneNo.equals(debtCheckPhoneNo)) {
                dcpFlag = true;
                System.out.println("Customer Found, Your Debt Amount to Pay Rs. " + cust[dcp].getDebt());// phoneNumber check
                System.out.println("Enter Amount ");
                double dPay;
                while (true) {
                    try {
                        dPay = Double.parseDouble(br.readLine());
                        break;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Please Enter the Amount in Digit");
                    }
                }

                double oldDebt = cust[dcp].getDebt();
                double seting = oldDebt - dPay;
                cust[dcp].setDebt(Math.abs(seting));
                System.out.println("Your Balance Debt is Rs. " + cust[dcp].getDebt());
                break;
            }
        }
        if (dcpFlag == false) {
            System.err.println("Customer Not Found");
        }
    }

    public void softDelete() {
        boolean sdFlag = false;   // else cus not found
        System.out.println("Enter the Customer PhoneNo ");
        String sdPhoneNo = phoneNoGetCheck();  // are you sure you want to delete the customer
        String deleteCus = "InActive";
        outer:
        for (int sdi = 0; sdi < cust.length; sdi++) {
            if (cust[sdi].phoneNo.equals(sdPhoneNo)) {
                System.out.println("Customer Found\n");
                System.out.println(cust[sdi]);
                if (cust[sdi].getDebt() == 0) {
                    System.out.println("Sure You Want To Delete Your Account \n If Yes Press : 1 \n If No Press  : 2");
                    int confirm = scan.nextInt();
                    if (confirm == 1) {
                        cust[sdi].status = deleteCus;
                        System.out.println(cust[sdi] + " \nYour Account Deleted Successfully" + BLUE);
                        sdFlag = true;
                        break outer;
                    } else {
                        System.out.println("Your Account Not Deleted ");
                        break outer;
                    }
                } else {
                    System.err.println("\nCustomer Have to Pay Debt Please Pay and Try to Delete the Account");
                }

            } else if (sdFlag == false) {
                System.err.println("Customer Not Found");
            }
        }
    }

    public void writeCustomer() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream("/home/bas200193/Desktop/textFiles/Customers/customerInfo.txt"); DataOutputStream dos = new DataOutputStream(fos);) {
            for (int i = 0; i < cust.length; i++) {
                dos.writeUTF(cust[i].status);
                dos.writeDouble(cust[i].debt);
                dos.writeShort(cust[i].custId);
                dos.writeUTF(cust[i].name);
                dos.writeUTF(cust[i].address);
                dos.writeUTF(cust[i].phoneNo);
                dos.writeUTF(cust[i].aadhaarNo);
            }
        }
    }

    public void readCustomer() throws IOException, FileNotFoundException {  // pending
        try (FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Customers/customerInfo.txt"); DataInputStream dis = new DataInputStream(fis);) {
            while (dis.available() > 0) {
                cust = Arrays.copyOf(cust, cust.length + 1);
                cust[cust.length - 1] = new Customer(dis.readUTF(),
                        dis.readDouble(),
                        dis.readShort(),
                        dis.readUTF(),
                        dis.readUTF(),
                        dis.readUTF(),
                        dis.readUTF());

            }

        } catch (EOFException eofe) {

        }
    }

    public void readOrder() throws FileNotFoundException, IOException {    // read orders which already placed 
        try (FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Customers/orderInfo.txt"); DataInputStream dis = new DataInputStream(fis);) {
            while (dis.available() > 0) {
                order = Arrays.copyOf(order, order.length + 1);
                LocalDate ld = LocalDate.parse(dis.readUTF());
                LocalTime lt = LocalTime.parse(dis.readUTF());
                int orId = dis.readInt();
                int cuId = dis.readInt();
                String ph = dis.readUTF();
                double amo = dis.readDouble();
                LineItem[] m = readLineItem(orId + "");
                order[order.length - 1] = new Orders(ld, lt, orId, cuId, ph, amo, m);
            }
        }
    }

    public void writeOrder() throws IOException {      // write the orders in the file old orders and today placed orders
        try (FileOutputStream fos = new FileOutputStream("/home/bas200193/Desktop/textFiles/Customers/orderInfo.txt"); DataOutputStream dos = new DataOutputStream(fos);) {
            for (int i = 0; i < order.length; i++) {
                LocalDate ld = order[i].getDate();
                LocalTime lt = order[i].getTime();
                dos.writeUTF(ld.toString());
                dos.writeUTF(lt.toString());
                dos.writeInt(order[i].getOrderid());
                dos.writeInt(order[i].getCusId());
                dos.writeUTF(order[i].getCusPhone());
                dos.writeDouble(order[i].getTotalPrice());
                writeLineItem(order[i].getOrderid() + "", order[i].lineItem);

            }
        }
    }

    public LineItem[] readLineItem(String fileName) throws FileNotFoundException, IOException {
        LineItem[] li = new LineItem[0];
        try (FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Customers/lineItem/" + fileName + ".txt"); DataInputStream dis = new DataInputStream(fis);) {
            while (dis.available() > 0) {
                li = Arrays.copyOf(li, li.length + 1);
                li[li.length - 1] = new LineItem(
                        dis.readShort(),
                        dis.readInt(),
                        dis.readUTF(),
                        dis.readInt(),
                        dis.readDouble());

            }
        }
        return li;
    }

    public void writeLineItem(String fileName, LineItem[] li) throws FileNotFoundException, IOException {
        String fileNameGen = "/home/bas200193/Desktop/textFiles/Customers/lineItem/" + fileName + ".txt";
        try (FileOutputStream fos = new FileOutputStream(fileNameGen); DataOutputStream dos = new DataOutputStream(fos);) {
            for (int i = 0; i < li.length; i++) {
                dos.writeShort(li[i].getsNo());
                dos.writeInt(li[i].getQuantity());
                dos.writeUTF(li[i].getProductName());
                dos.writeInt(li[i].getProductId());
                dos.writeDouble(li[i].getItemAmount());
            }

        }
    }

    public void duplicateOrder() throws IOException {

        LocalDate datee = LocalDate.now();
        int oid = 97233;    // change the initial order id before load to the file
        String phonw = "1234567899";
        int cuid = 3948;
        LocalTime timee = LocalTime.now();
        LineItem[] tempLinee = new LineItem[1];
        short s = 1;
        tempLinee[0] = new LineItem(s, 2, "Pringles", 1004, 119.0);
        order = Arrays.copyOf(order, order.length + 1);
        order[order.length - 1] = new Orders(datee, timee, oid, cuid, phonw, 238.0, tempLinee);

    }

}
