package khatabook;

import dao.KhatabookDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static khatabook.Customer.product;
import static khatabook.LineItem.payment;
import mysql.MysqlKhatabookImpl;

public class Khatabook {

    static Customer call = new Customer();
    static Product product = new Product();
    static Statistics stat = new Statistics();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String BLUE = "\033[0;34m"; // BLUE
    private static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    private static String user = "Kalai";
    private static String pass = "Kalai@4321";
    static String phoneNo = "";
    private static final int MINIMUM = 0;
    public static KhatabookDAO khatabook = new MysqlKhatabookImpl();

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        boolean flag = true;
//        product.viewProduct(khatabook.getProduct().getProduct(),1);
        System.err.println("                  Welcome to KhataBook          ");
        while (flag) {
            mainMenu();
            int option = 0;
            System.out.println("Enter the option from above Menu");
            while (true) {
                try {
                    option = Integer.parseInt(br.readLine());
                    break;
                } catch (NumberFormatException nfe) {
                    System.err.println("Please Enter the Numeric Value");
                }
            }

            switch (option) {
                case 1:
                    boolean flag2 = true;
                    int option2 = 0;
                    while (flag2) {
                        customerMenu();
                        while (true) {
                            try {
                                option2 = Integer.parseInt(br.readLine());
                                break;
                            } catch (NumberFormatException nfe) {
                                System.err.println("Please Enter the Numeric Value");
                            }
                        }
                        switch (option2) {
                            case 1: {
                                call.createAccount();
                                break;
                            }

                            case 2: {  // view Customer
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                call.viewCustomer(phoneNo);
                                break;
                            }
                            case 3: {  //update customer
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                call.updateCustomer(phoneNo);
                                break;
                            }
                            case 4: {
                                call.placeOrder();
                                break;
                            }
                            case 5: {   // pay debts
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                call.payDebts(phoneNo);
                                break;
                            }
                            case 6: {  // delete customer
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                call.deleteCustomer(phoneNo);
                                break;
                            }
                            case 7: {  // wallet recharge
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                if (khatabook.getCustomer().getCustomerStatus(phoneNo)) {
                                    System.out.println("Enter the recharge amount Rs. ");
                                    double amount;
                                    double balance;
                                    while (true) {
                                        try {
                                            amount = Double.parseDouble(br.readLine());
                                            if (amount > MINIMUM) {
                                                balance = call.getWalletBalance(phoneNo);
                                                payment.makePayment(amount, 0, call.getCustomerID(phoneNo), "wallet");
                                                call.rechargeCustomerWallet(phoneNo, amount);
                                                //System.out.println("wallet recharge is successfull...\nYour wallet balance is Rs. " + call.getWalletBalance(phoneNo));
                                                break;
                                            } else {
                                                System.err.println("Minimum recharge amount is Rs.1.00");
                                            }

                                        } catch (NumberFormatException nfe) {
                                            System.err.println("Please Enter the Amount in Digit");
                                        }
                                        // break;
                                    }
                                } else {
                                    System.err.println("Customer detail not Found");
                                }
                                break;
                            }
                            case 8: {  // wallet balance
                                System.out.println("Enter the Customer PhoneNo ");
                                phoneNo = phoneNoGetCheck();
                                System.out.println("Your Wallet balance is Rs." + call.getWalletBalance(phoneNo));
                                break;
                            }
                            case 9: {  //exit
                                flag2 = false;
                                break;
                            }

                            default: {
                                System.out.println("Please select a valid option");
                                break;
                            }
                        }

                    }
                    break;

                case 2: {
                    //Inventory
                    boolean flagIn = true;
                    int option3 = 0;
                    while (flagIn) {
                        inventoryMenu();
                        while (true) {
                            try {
                                option3 = Integer.parseInt(br.readLine());
                                break;

                            } catch (NumberFormatException nfe) {
                                System.err.println("Please Select Valid Option");

                            }
                        }
                        switch (option3) {
                            case 1: {
                                product.addProduct();
                                break;
                            }
                            case 2: {
                              product.viewProduct(khatabook.getProduct().getProduct(),MINIMUM);
                                break;
                            }
                            case 3: {
                                product.updateQuantity();
                                break;
                            }
                            case 4: {
                                flagIn = false;
                                break;
                            }
                            default: {
                                System.err.println("Please Select a Valid Option");
                                break;
                            }
                        }
                    }
                    break;

                }
                case 3: {
                    //Statistics
                    boolean sFlag = true;
                    int get = 0;
                    while (sFlag) {
                        statisticsMenu();
                        while (true) {
                            try {
                                get = Integer.parseInt(br.readLine());
                                break;

                            } catch (NumberFormatException nfe) {
                                System.out.println(nfe);
                                System.err.println("Please Enter the Numeric Value");

                            }
                        }
                        switch (get) {
                            case 1: {
                                // stat.minimumOrderProduct();
                                break;
                            }
                            case 2: {
                                stat.maximumOrderProduct();
                                break;
                            }
                            case 3: {
                                stat.maximumMarginProduct();
                                break;
                            }
                            case 4: {
                                //               stat.customerRank();
                                //stat.minimumMarginProduct();
                                break;
                            }
                            case 5: {
                                sFlag = false;
                                break;
                            }
                            default: {
                                System.out.println("Please Select a Valid Options");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    flag = false;
                    break;
                }

                default: {
                    System.out.println("Please select a valid option");
                    break;
                }

            }
        }

        System.out.println("~*".repeat(14) + "THANK YOU FOR USING KHATA BOOK" + "~*".repeat(14));

    }

    public static void mainMenu() {
        System.out.println("_".repeat(26));
        System.out.println("| Press 1 : Customer");
        System.out.println("| Press 2 : Inventory");
        System.out.println("| Press 3 : Statistics");
        System.out.println("| Press 4 : Exit");
        System.out.println("_".repeat(26));
    }

    public static void billHeader() {
        System.out.print("-".repeat(55));
        System.out.format("\n|%-4s|%-18s|%-10s|%-9s|%-10s|", "S.No", "Name", "Price", "Quantity", "Amount");
        System.out.print("\n");
        System.out.println("-".repeat(55));
    }

    public static void inventoryMenu() {
        System.out.println("\nPress 1 : Add Product");
        System.out.println("Press 2 : View Product");
        System.out.println("Press 3 : Update Product");
        System.out.println("Press 4 : Exit");
    }

    public static void statisticsMenu() {
        System.out.println("Press 1 : To Find Minimum Sold Item");
        System.out.println("Press 2 : To Find Maximum Sold Item");
        System.out.println("Press 3 : To Find Minimum Margin Item");
        System.out.println("Press 4 : To Find Minimum Margin Item");
        System.out.println("Press 5 : Exit");
        System.out.println("Select Any Options From Above List");
    }

    public static void customerMenu() {
        System.out.println("_".repeat(26));
        System.out.println("| Press 1 : Add Customer          |");
        System.out.println("| Press 2 : View Customer         |");
        System.out.println("| Press 3 : Update Customer       |");
        System.out.println("| Press 4 : Place Order           |");
        System.out.println("| Press 5 : Pay Debts             |");
        System.out.println("| Press 6 : Soft Delete           |");
        System.out.println("| Press 7 : Wallet Recharge       |");
        System.out.println("| Press 8 : Wallet Balance        |");
        System.out.println("| Press 9 : Exit                  |");
        System.out.println("_".repeat(26));
        System.out.println("Enter the Option From Above Menu");
    }

    public static boolean isAlphaCheck(String get) {
        for (int i = 0; i < get.length(); i++) {
            char c = get.charAt(i);
            int cc = (int) c;
            if (cc > 64 && cc < 91 || cc > 96 && c < 123 || c == 46 || c == 32) {

            } else {
                return false;
            }
        }
        return true;     // return true ->String contains only alpha
    }

    public static String phoneNoGetCheck() {  // phoneNumber - Check
        String phoneNo;
        while (true) {
            try {
                phoneNo = br.readLine();
                long ph = Long.parseLong(phoneNo);
                if (ph > 0) {
                    if (phoneNo.chars().filter(Character::isDigit).count() == 10) {
                        break;
                    } else {
                        throw new PhoneNumberFormatException();
                    }
                } else {
                    System.err.println("Please Enter a Valid Phone No \nPhoneNo Format:984xxxxx55");
                }
            } catch (PhoneNumberFormatException nfe) {
                System.err.println("Please Enter a Valid Phone No \nPhoneNo Format:984xxxxx55");
            } catch (Exception e) {
                System.err.println("Please Enter a Valid Phone No \nPhoneNo Format:984xxxxx55");
            }
        }
        return phoneNo;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
    
    
}
