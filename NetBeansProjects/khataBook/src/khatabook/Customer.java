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
import static khatabook.Khatabook.billHeader;
//import static khatabook.Product.product;
import java.time.LocalDate;
import static khatabook.Khatabook.br;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import static khatabook.Khatabook.*;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputFilter.Status;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import static khatabook.Khatabook.product;
import khatabook.LineItem.*;
import model.Address;
import static khatabook.Khatabook.khatabook;
import java.util.Objects;

public class Customer {

    static public Khatabook kb = new Khatabook();
    static Product product = new Product();
    LineItem[] lineItem = new LineItem[0];
    private double debt;
    short custId;// = 2134;
    private String name;
    private String phone;
    private String aadhaar;
    private String houseNo;
    private static int id;

    Customer() {

    }

    public double getDebt() {
        return this.debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    void createAccount() throws SQLException, ClassNotFoundException, IOException {
//        try (Connection connection = kb.getConnection();) {
        while (true) {
            System.out.println("Enter your name: ");
            name = br.readLine().trim();
            if (name.matches("[a-zA-Z.\s]{3,}")) {
                break;
            }
            System.err.println("Please Enter a valid name");
        }

        while (true) {
            System.out.println("Enter Your phone number ");
            phone = br.readLine().trim();
            if ((phone.trim().matches("[0-9]{10,12}"))) {
                break;
            }
            System.err.println("Please Enter a Valid Phone No \nPhoneNo Format:984xxxxx55");
        }
        while (true) {
            System.out.println("Enter Your 12 Digit aadhaar number ");
            aadhaar = br.readLine();
            String regax = "[0-9]{12}";
            if (aadhaar.matches(regax)) {
                break;
            }
            System.err.println("Please Enter a Valid Aadhaar Number \nAadhaarNumber Format: 8787xxxx7763");
        }
        System.out.println("Enter Your House number or Door number");
        houseNo = br.readLine().trim();
        System.out.println("Enter Your street and area name");
        String street = br.readLine().trim();
        System.out.println("Enter Your distric");
        String distric;
        while (true) {
            distric = br.readLine().trim();
            if (distric.matches("[a-zA-Z\s]{3,}")) {
                break;
            }
            System.err.println("Please Enter a proper distric");
        }
        System.out.println("Enter Your state");
        String state;
        while (true) {
            state = br.readLine().trim();
            if (state.matches("[a-zA-Z\s]{4,}")) {
                break;
            }
            System.err.println("Please Enter a proper state");
        }
        System.out.println("Enter Your pincode");
        String pincode;
        while (true) {
            pincode = br.readLine().trim();
            if (pincode.matches("[1-9]{1}[0-9]{2}\s?[0-9]{3}")) {
                break;
            }
        }
        model.Address address = new model.Address(houseNo, street, distric, state, pincode);
        model.Customer customer = new model.Customer(0, name, phone, aadhaar, 0.0, 0.0, true, address);
        if (khatabook.getCustomer().createAccount(customer) && khatabook.getAddress().insertAddress(customer)) {
            System.out.println("Account created successfully");
            //view customer
            customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
            if (Objects.nonNull(customer)) {
                System.out.println(customer);
            }
        } else {
            System.err.println("Account creation Failed \nPlease try again");
        }
    }

    void viewCustomer(String phone) throws SQLException, ClassNotFoundException {

        model.Customer customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
        System.out.println(Objects.nonNull(customer) ? "Customer ID : " + customer.getId()
                + "\nName : " + customer.getName()
                + "\nphone : " + customer.getPhone()
                + "\nDebt : " + customer.getDebtBalance()
                + "\nWallet Balance : " + customer.getWalletBalance()
                : "Customer details not found");

    }

// check if customer already deleted to delete again
    public void deleteCustomer(String phone) throws SQLException, ClassNotFoundException {
//        try (Connection connection = kb.getConnection();) {
//            PreparedStatement ps = connection.prepareStatement("select * from customer where phone = ?");
//            PreparedStatement ps = connection.prepareStatement("update customer set statuss=false where id = ?");
//            ps.setString(1, phoneNo);
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            id = rs.getInt(1);
        // add one more check ask the customer if no customer data found with out statuss check,so check id
//        if (khatabook.getCustomer().getCustomerByPhoneNo(phone) != null) {  wait checking
        model.Customer customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
        if (Objects.nonNull(customer)) {
            int id = khatabook.getCustomer().getCustomerIdByPhoneNo(phone);
//            if (khatabook.getCustomer().getCustomerBalance(phone) == 0) {   wait checking
            if (customer.getDebtBalance() == 0) {
                if (khatabook.getCustomer().deleteCustomer(id)) {
                    System.out.println("\nYour account deleted successfully...");
                }
            } else {
                System.err.println("Sorry customer have debt balance Rs. " + khatabook.getCustomer().getCustomerBalance(phone) + "\nCustomer Have to pay debt balance to delete account ");

            }
        } else {
            System.err.println("\nCustomer detail not Found");
        }
//            if (id != 0 && rs.getBoolean(8)) {
//                ps2.setInt(1, id);
//                int check = ps2.executeUpdate();
//                if (check == 1) {
//                    System.out.println("\nYour account deleted successfully...");
//                }
//            } else {
//                System.err.println("\nCustomer detail not Found");
//            }

//        }
    }

    void payDebts(String phone) throws SQLException, ClassNotFoundException, IOException {
        model.Customer customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
        double debt;
        if (khatabook.getCustomer().getCustomerStatus(phone)) {
            if (customer.getDebtBalance() > 0) {
                System.out.println("Your debt balance : " + customer.getDebtBalance());
                while (true) {
                    try {
                        while (true) {
                            System.out.println("Enter amount to pay debt");
                            debt = Double.parseDouble(br.readLine());
                            if (debt <= customer.getDebtBalance()) {
                                break;
                            }
                            System.err.println("Entered amount is higher than the debt balance");
                        }
                        if (khatabook.getCustomer().payDebts(customer.getDebtBalance() - debt, phone)) {
                            System.out.println("Your debt amount " + debt + " is paid successfully \nDebt Balance is " + khatabook.getCustomer().getCustomerBalance(phone));
                            String dateTime = LocalDateTime.now().toString();
                            model.Payment payment = new model.Payment(0, customer.getId(), debt, dateTime, "debt");
                            khatabook.getPayment().makePayment(payment);
                        }
                        break;
                    } catch (NumberFormatException nfe) {
                        System.err.println("\nPlease Enter the Amount in Digit");
                    }
                }
            } else {
                System.out.println("\nYour debts are already paid");
            }
        } else {
            System.err.println("\nCustomer detail not found");
        }
    }

    void updateCustomer(String phone) throws SQLException, ClassNotFoundException, IOException {
        // get the id here using old phno and load it in object make the field  load and make other field null and check using non values and update the value likewise using ifelse
        model.Customer customer = new model.Customer();
        customer.setId(khatabook.getCustomer().getCustomerIdByPhoneNo(phone));
        System.out.println("customer ID : " + customer.getId());
        boolean flag = true;
        while (flag) {
            System.out.println("_".repeat(33));
            System.out.println("| Press 1 : Update PhoneNo");
            System.out.println("| Press 2 : Update Name");
            System.out.println("| Press 3 : Update AadharNo");
            System.out.println("| Press 4 : Update Address");
            System.out.println("| Press 5 : Exit");
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
            if (Objects.nonNull(khatabook.getCustomer().getCustomerByPhoneNo(phone))) {
                switch (options) {
                    case 1: { // phone
                        System.out.println("Enter PhoneNo You would like to change ");
                        String phoneNoChange = phoneNoGetCheck();
                        customer.setPhone(phoneNoChange);
                        if (khatabook.getCustomer().updateCustomer(customer)) {
                            System.out.println(BLUE + "Your PhoneNo successfully updated ");

                        } else {
                            System.err.println("Phone number updation Failed\nPlease try again");
                        }
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
                        customer.setName(nameChange);
                        if (khatabook.getCustomer().updateCustomer(customer)) {
                            System.out.println(BLUE + "Your Name successfully changed ");
                        } else {
                            System.err.println("Name updation Failed \nPlease try again");
                        }
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
                        customer.setAadhaar(aadhaarChange);
                        if (khatabook.getCustomer().updateCustomer(customer)) {
                            System.out.println(BLUE + "Your Aadhaar Number successfully changed ");
                        } else {
                            System.err.println("Aadhaar updation Failed");
                        }
                        flag = false;
                        break;
                    }
                    case 4: { // address
                        System.out.println("Please Enter Your full address as per the requirement");
                        System.out.println("Enter Your House number/Door number");
                        houseNo = br.readLine().trim();
                        System.out.println("Enter Your street and area name");
                        String street = br.readLine().trim();
                        System.out.println("Enter Your distric");
                        String distric;
                        while (true) {
                            distric = br.readLine().trim();
                            if (distric.matches("[a-zA-Z\s]{3,}")) {
                                break;
                            }
                            System.err.println("Please Enter a proper distric");
                        }
                        System.out.println("Enter Your state");
                        String state;
                        while (true) {
                            state = br.readLine().trim();
                            if (state.matches("[a-zA-Z\s]{4,}")) {
                                break;
                            }
                            System.err.println("Please Enter a proper state");
                        }
                        System.out.println("Enter Your pincode");
                        String pincode;
                        while (true) {
                            pincode = br.readLine().trim();
                            if (pincode.matches("[1-9]{1}[0-9]{2}\s?[0-9]{3}")) {
                                break;
                            }
                        }
                        Address address = new Address(houseNo, street, distric, state, pincode);
                        customer.setAddress(address);
                        if (khatabook.getCustomer().updateCustomer(customer)) {
                            System.out.println("""
                                                       Your address successfully updated...
                                                       
                                                       House No : """ + houseNo + "\nStreet : " + street + "\ndistric : " + distric + "\nState : " + state + "\nPincode :" + pincode + "\ncountry : India");
                        } else {
                            System.err.println("address updation failed....");
                        }
                        flag = false;
                        break;
                    }

                    case 5: {  // break
//                                rs.updateRow();

                        flag = false;
                        break;
                    }
                    default: {
                        System.out.println("Please Select a valid Option");
                        break;
                    }
                }
            } else {
                System.err.println("customer not found\n Entered phone number : " + phone);
            }
        }
    }

    public void placeOrder() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("Enter the Customer PhoneNo ");
        phone = phoneNoGetCheck();
        model.Product[] product = khatabook.getProduct().getProduct();
        model.Customer customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
        if (Objects.nonNull(customer) && customer.isStatus()) {

        } else {
            System.err.println("customer not found");
        }
//        Product[] productCall = product.getProduct();//get the data from database 
//        try (Connection connection = kb.getConnection();
//        PreparedStatement ps = connection.prepareStatement("select * from customer where phone=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //PreparedStatement ps2 = connection.prepareStatement("select * from product where id = ?");
//                ) {
//            System.out.println("Enter the Customer PhoneNo ");
//            phone = phoneNoGetCheck();
//            ps.setString(1, phone);
//            ResultSet rs = ps.executeQuery();
//            boolean b = rs.absolute(1);
//            if (b && rs.getBoolean(8)) {
//                //rs.beforeFirst();
//                Product[] productCall = product.getProduct();//get the data from database 
//                boolean flag = true;
//                while (flag) {
//                    System.out.println("\nPress 1 : To add Products");
//                    System.out.println("Press 2 : To Place order");
//                    System.out.println("Press 3 : To View the Order");
//                    System.out.println("Press 4 : Exit");
//                    int check;
//                    while (true) {
//                        try {
//                            check = Integer.parseInt(br.readLine());
//                            break;
//                        } catch (NumberFormatException nfe) {
//                            System.err.println("\n Please Select a Valid Options");
//                        }
//                    }
//                    switch (check) {
//                        case 1: {
////                            product.viewProduct(productCall);
//                            System.out.println("\nChoose Product From Above List And Enter the Product Id");
//                            int productId;
//                            outer:
//                            while (true) {
//                                try {
//                                    productId = Integer.parseInt(br.readLine());
//                                    boolean entry = false;
//                                    for (Product p : productCall) {
////                                        if (p.getId() == productId) {
////                                            entry = true;
////                                            break outer;
////                                        }
//
//                                    }
//                                    if (!entry) {
//                                        System.err.println("Product Id not Found");
//
//                                    }
//
//                                } catch (NumberFormatException nfe) {
//                                    System.err.println("Please Enter a Valid Product Id");
//                                }
//                            }
//
////                            System.out.println("Enter the Quantity");
//                            int productQuantity;
//
//                            outer:
//                            while (true) {
//                                try {
//                                    productQuantity = Integer.parseInt(br.readLine());
////                                    for (Product p : productCall) {
////                                        if (productId == p.getId()) {
////                                            if (p.getQuantity() >= productQuantity) {
////                                                p.setQuantity(p.getQuantity() - productQuantity);
////                                                lineItem = Arrays.copyOf(lineItem, lineItem.length + 1);
////                                                lineItem[lineItem.length - 1] = new LineItem(lineItem.length, productQuantity, p.getName(), p.getId(), p.getPrice());
////                                                System.out.println(BLUE + "Item Added Successfully");
////                                                break outer;
////                                            } else {
////                                                System.err.println("Sorry, Selected Product Quantity is Not Available Please select Any other Products\n or select less quantity\n");
////                                            }
////                                        }
////                                    }
//
//                                } catch (NumberFormatException nfe) {
//                                    System.err.println("Please Enter a Valid Quantity");
//                                }
//                            }
////                            break;
//                        }
//                        
//                        case 2: {
//                            double tempTotal = 0;
//                            for (LineItem li : lineItem) {
//                                tempTotal = tempTotal + li.getItemAmount() * li.getQuantity();
//                            }
//                            String date_time = LocalDateTime.now().toString();
//                            LocalDate date = LocalDate.now();
//                            LocalTime time = LocalTime.now();
//                            Orders o = new Orders();
//                            int idTemp = o.genOrderID();
//                            Orders order = new Orders(idTemp, date_time, rs.getInt(1), phone, tempTotal, lineItem);
//                            System.out.println("-".repeat(55));
//                            System.out.println("                       JioMart        ");
//                            System.out.println("-".repeat(55));
//                            System.out.println("Date: " + date);
//                            System.out.print("Time: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() / 1000000);
//                            System.out.println("\nOrder Id: " + order.getOrderID());
//                            billHeader();
//                            for (int in = 0; in < lineItem.length; in++) {
//                                lineItem[in].toString();
//                                System.out.println("\n");
//                                System.out.print("-".repeat(55));
//                            }
//
//                            System.out.print("\n                            GRAND TOTAl: Rs. " + tempTotal + "\n");
//                            System.out.println("-".repeat(55));
//                            System.out.print("             Thanks a Lot ! Visit again.\n");
//                            System.out.println("        " + "*".repeat(37) + "          ");
//                            System.out.print("-".repeat(55));
//                            System.out.print("\nEnter the Amount " + tempTotal + " Rs\n");
//                            double payment;
//                            double balance;
//                            while (true) {
//                                try {
//                                    payment = Double.parseDouble(br.readLine());
//                                    if (tempTotal >= payment) {
//                                        balance = Math.abs(tempTotal - payment);
//                                        order.setPayment(payment);
//                                        order.setBalance(balance);
//                                        o.orderEntry(order);
//                                        product.productEntry(order);
//                                        setCustomerBalance(phone, balance);
//                                        break;
//                                    } else {
//                                        System.err.println("Please Enter a valid bill amount");
//                                    }
//
//                                } catch (NumberFormatException nfe) {
//                                    System.err.println("Please Enter the Amount in Digit");
//                                }
//                                // break;
//                            }
//                            System.out.println(BLUE + "order placed successfully");
////                           
//                            break;
//                        }
////                        case 3: { pendingggggg.....
////                            System.out.println("Enter the Customer PhoneNo");
////                            String orPhoneNo = phoneNoGetCheck();
////                            boolean f = false;
////                            int[] orderId = new int[0];
////                            for (int o = 0; o < order.length; o++) {
////                                if (orPhoneNo.equals(order[o].getCusPhone())) {
////                                    f = true;
////                                    orderId = Arrays.copyOf(orderId, orderId.length + 1);
////                                    orderId[orderId.length - 1] = order[o].getOrderid();
////                                }
////                            }
////                            if (f) {
////                                for (int i = 0; i < orderId.length; i++) {
////                                    System.out.println(i + 1 + "st Order are \n");
////                                    for (int j = 0; j < order.length; j++) {
////                                        if (order[j].getOrderid() == orderId[i]) {
////                                            billHeader();
////                                            for (int k = 0; k < order[j].lineItem.length; k++) {
////                                                System.out.println(order[j].lineItem[k].toString());
////                                            }
////                                        }
////                                    }
////                                }
////                            }
////                            if (f == false) {
////                                System.err.println("\nNo Order Placed\n");
////                            }
////                            break;
////                        }
//                        case 4: {
//                            flag = false;
//                            break;
//                        }
//                    }
//                } 
//            } else {
//                System.err.println("Customer Not Found");
//            }
//        }
    }
//    public String toString() {
//        return "Customer ID : " + this.custId + "\n" + "Customer Name : " + "\nCustomer Address : " + this.address + this.name + "\n" + "Customer PhoneNo : " + this.phoneNo + "\n" + "Customer AadharNo : " + this.aadhaarNo + "\nCustomer Debt : " + this.getDebt() + " Rs" + "\nCustomer Status : " + this.status;
//    }

    public double getCustomerBalance(String phone) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select debt_balance from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            rs.absolute(1);
            return rs.getDouble(1);
        }
    }

    // updateCustomerBalance()
    public void setCustomerBalance(String phone, double balance) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("update customer set debt_balance = ? where phone = ?");) {
            double oldBalance = getCustomerBalance(phone);
            double bal = balance + oldBalance;
            ps.setDouble(1, bal);
            ps.setString(2, phone);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Balance amount is added to your Debt \nTotal Debt Balance is Rs. " + bal);
            } else {
                System.err.println("Balance updation Failed");
            }
        }
    }

    public double getWalletBalance(String phone) throws SQLException, ClassNotFoundException {
        if (khatabook.getCustomer().getCustomerStatus(phone)) {
            try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select wallet_balance from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
                ps.setString(1, phone);
                ResultSet rs = ps.executeQuery();
                rs.absolute(1);

                return rs.getDouble(1);
            }
        }
        return 0;   //pending -  dont know where to check customer status better do it in while getting input from user(switch case)
    }
    // not yet implemented in DAO

    public void rechargeCustomerWallet(String phone, double amount) throws SQLException, ClassNotFoundException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("update customer set wallet_balance = wallet_balance+? where phone = ?");) {
            double balance = getWalletBalance(phone);
            // double total = balance+amount;
            ps.setDouble(1, amount);
            ps.setString(2, phone);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Customer Wallet successfully recharged... \nWallet Balance : " + getWalletBalance(phone));
            } else {
                System.out.println("Wallet recharge failed...\nPlease again with proper inputs");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

    }

//    public boolean checkCustomerStatus(String phone) throws SQLException, ClassNotFoundException {
//        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select statuss from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
//            ps.setString(1, phone);
//            ResultSet rs = ps.executeQuery();
//            rs.absolute(1);
//            return rs.getBoolean(1);
//        } catch (SQLException sql) {
//            sql.printStackTrace();
//        }
//        return false;
//
//    }
    public int getCustomerID(String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select id from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            rs.absolute(1);
            return rs.getInt(1);
        }
    }
}
