package khatabook;

import com.sun.jdi.connect.spi.Connection;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.InputMismatchException;
//import static khatabook.KhataBook.cust;

public class KhataBook {

    static short custId = 2100;
    //   static int index = 0;
    static Customer[] cust = new Customer[0];
    static Scanner scan = new Scanner(System.in);
    static Customer call = new Customer();
    static Product p = new Product();
    // static Orders o = new Orders();       //Orders order[] = new Orders[0];
//    static int orderIndex = 0;
//    static int orderId = 85648;
    static double inidebt = 0;
    static Statistics stat = new Statistics();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final String GREY = "\033[1;92m"; // GREEN
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String BLUE = "\033[0;34m"; // BLUE
    Connection connection;

    public static void main(String[] args) throws IOException {
        //  p.writeProduct();
        p.readProduct();
        call.readCustomer();
        // call.duplicateOrder();
        call.readOrder();
        boolean flag = true;
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
                                //cusArr.add();
                                cust = Arrays.copyOf(cust, cust.length + 1);
                                String name;//= scan.next();
                                while (true) {
                                    try {
                                        System.out.println("Enter Customer Name");
                                        name = br.readLine();
                                        if (isAlphaCheck(name)) {
                                            break;
                                        } else {
                                            throw new NumberFormatException();//  
                                        }
                                    } catch (NumberFormatException nfe) {
                                        System.err.println("\n Given Name Contains May Numeric Value, Please Make Sure Before Submit ");
                                    }
                                }
                                System.out.println("Enter Customer Address");
                                String address = scan.next();
                                System.out.println("Enter Customer PhoneNo");
                                String phoneNo;
                                phoneNo = phoneNoGetCheck();
                                System.out.println("Enter Customer AadharNo");
                                String aadharNo;
                                while (true) {
                                    aadharNo = br.readLine();
                                    if (aadharNo.chars().filter(Character::isDigit).count() == 12) {
                                        break;
                                    } else {
                                        System.err.println("Please Enter a Valid Aadhaar Number \nAadhaarNumber Format: 8787xxxx7763");
                                    }
                                }
                                String dupStatus = "Active";
                                cust[cust.length - 1] = new Customer(dupStatus, inidebt, custId, name, address, phoneNo, aadharNo);
                                //call.writeCustomer(cusArr[cusArr.length-1]);
                                ++custId;
                                //  ++index;
                                System.out.println("\n" + BLUE + "Customer Added Successfully");
                                break;

                            }

                            case 2: {  // view Customer
                                System.out.println("Enter the Customer PhoneNo ");
                                String phoneNo2 = phoneNoGetCheck();
                                int check = 10;
                                for (int j = 0; j < cust.length; j++) {
                                    if (cust[j].phoneNo.equals(phoneNo2)) {
                                        System.err.println("*".repeat(15) + "Customer Detail" + "*".repeat(15));
                                        System.out.println(cust[j]);
                                        check = 100;
                                        break;
                                    }
                                }
                                if (check == 10) {
                                    System.err.println("Customer Not Found");
                                }
                                break;
                            }
                            case 3: {
                                call.update();
                                break;
                            }
                            case 4: {
                                call.placeOrder();
                                break;
                            }
                            case 5: {   // pay debts
                                call.payDebts();
                                break;
                            }
                            case 6: {
                                call.softDelete();
                                break;
                            }
                            case 7: {
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
                                p.addProduct();
                                break;
                            }
                            case 2: {
                                p.viewProduct();
                                break;
                            }
                            case 3: {
                                p.updateQuantity();
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
                                stat.minimumOrderProduct();
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
                                stat.customerRank();
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
        call.writeOrder();
        p.writeProduct();
        call.writeCustomer();
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
        System.out.println("| Press 1 : Add Customer      |");
        System.out.println("| Press 2 : View Customer     |");
        System.out.println("| Press 3 : Update Customer   |");
        System.out.println("| Press 4 : Place Order       |");
        System.out.println("| Press 5 : Pay Debts         |");
        System.out.println("| Press 6 : Soft Delete       |");
        System.out.println("| Press 7 : Exit              |");
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
}
