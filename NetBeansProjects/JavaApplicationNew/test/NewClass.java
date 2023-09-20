

import java.util.Scanner;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
//import static khatabook.Customer.kb;

public class NewClass {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    private static String user = "Kalai";
    private static String pass = "Kalai@4321";

    public static void printCustomer() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("Enter customer id : ");
        int id = Integer.parseInt(br.readLine());
        ResultSet rs = checkCustomer(id);
        if (rs != null) {
            while (rs.next()) {
                System.out.println("id:" + rs.getString(2));
            }
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        printCustomer();
//        while (true) {
//            System.out.println("Enter your name: ");
//            String name = br.readLine();
//            if (nameValidation(name)) {
//                break;
//            }
//            while (true) {
//                System.out.println("Enter Your phNo ");
//                String num = br.readLine();
//                if (phNoValidation(num.trim())) {
//                    break;
//                }
//            }
//            while (true) {
//                System.out.println("Enter Your area pincode");
//                String pincode = br.readLine();
//                if (pincodeValidation(pincode.trim())) {
//                    break;
//                }
//
//            }
////        }
//        while (true) {
//            System.out.println("Enter Your aadhaar number ");
//            String aadhaar = br.readLine();
//            String regax = "[0-9]{12}";
//            if (aadhaar.matches(regax)) {
//                break;
//            }
//            System.out.println("Please Enter a valid aadhaar number");
//
//        }
        while (true) {
            String distric = br.readLine().trim();
            if (distric.matches("[a-zA-Z\s]{3,}")) {
                break;
            }
            System.err.println("Enter a valid distric name");
        }
    }

    static boolean nameValidation(String name) {
        String regax = "[a-zA-Z.\s]{3,}";
        if (name.matches(regax)) {
            System.out.println(name);
            return true;
        }
        return false;
    }

    static boolean phNoValidation(String num) {
        String regax = "[0-9]{10,12}";   // some brilliant may also add 91(10 Digit number)
        if (num.matches(regax)) {
            return true;
        }
        return false;
    }

    static boolean aadhaarValidation(String aadhaar) {
        //String regax = "[0-9]{12}";
        String regax = "/d{12}";
        if (aadhaar.matches(regax)) {
            return true;
        }
        return false;
    }

    static boolean pincodeValidation(String pincode) {
        String regex = "[1-9]{1}[0-9]{2}\s?[0-9]{3}";  // allowing space 612 604
        if (pincode.matches(regex)) {
            return true;
        }
        return false;
    }

    public static ResultSet checkCustomer(int id) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
        try ( Connection connection = DriverManager.getConnection(url, user, pass);
              PreparedStatement ps = connection.prepareStatement("select * from customer where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean b = rs.absolute(1);
            if (b) {
                rs.beforeFirst();
                return rs;
            }
        }
        return null;
    }

}
//public void statisticsMenu(Customer customer_[], Products product_[],Order order_[],Payment payment_[],Lineitem lineitem_[])
// {
//             System.out.println("----------------------------------------------------------------");
//             System.out.println("|              Statistics Menu                                 |");
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("|1)Product                                                     |");
//             System.out.println("|  a)The Product Which Gives Maximum Profit From a given date  |");
//             System.out.println("|  b)Products which are stored in inventory From a given date  |");
//             System.out.println("|  c)Product which were sold for a maximum quantity given date |");                 
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("|2)Customer                                                    |");
//             System.out.println("|  a)The Customers Having Debt                                     |");
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("|3)Product                                                     |");
//             System.out.println("|  a)Max Order Amount From Given Date                                   |");
//             System.out.println("|  b)Min Order Amount From Given Date                          |");
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("|4)Exit To MainMenu                                            |");
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("");
//             System.out.println("");
//             System.out.println("Select The Options From The Above Menu");
//             int selectionsta=sc.nextInt();
//             switch(selectionsta)
//             {
//             case 1:
//             System.out.println("---------------------------------------------------------------|");
//             System.out.println("|1)Product                                                     |");
//             System.out.println("|  a)The Product Which Gives Maximum Profit From Given Date    |");
//             System.out.println("|  b)Products which are stored in inventory From a given date  |");
//             System.out.println("|  c)Product which were sold from a maximum quantity given date|");                 
//             System.out.println("---------------------------------------------------------------|");
//             switch(sc.next())
//             {
//                 case "a":
//                System.out.println("Enter The Date");
//                System.out.println("Year");
//                int yearp=sc.nextInt();
//                System.out.println("Month");
//                int monthp=sc.nextInt();
//                System.out.println("Date");
//                int datep=sc.nextInt();
//                LocalDate fulldatep=LocalDate.of(yearp, monthp,datep);
//                     double profit=0;
//                     String name="",name1="";
//                     for (int i = 0; i < product_.length; i++)
//                     {double totalsellingprice=0;
//                     double totalcostprice=0;
//                     int j;
//                         for ( j = 0; j < lineitem_.length; j++) {
//                         if((product_[i].getProduct_id()==lineitem_[j].getProduct_id())&&(lineitem_[j].getCust_id()!=0)&&(fulldatep.isBefore(lineitem_[j].getDate())) )
//                         {
//                            totalsellingprice= (lineitem_[j].getselling_price()* lineitem_[j].getProduct_quantity());
//                            totalcostprice=(product_[i].getCost_price()*lineitem_[j].getProduct_quantity());
//                           name1=lineitem_[j].getProduct_name();
//                         }
//                         //name=lineitem_[j].getProduct_name();
//                         }
//                         if(profit<totalsellingprice-totalcostprice)
//                         {
//                             profit=totalsellingprice-totalcostprice;
//                             name=name1;
//                         }
//                         else{
//                             continue;}
//                     }
//                     System.out.println("The Product Which Gives Maximum Profit = "+name +"of Rs = "+profit+"From: "+fulldatep);
//                            statisticsMenu(customer_, product_,order_,payment_,lineitem_);
//                     break;
//                 case "b":
//                System.out.println("Enter The From Date");
//                System.out.println("Year");
//                 int yearp2=sc.nextInt();
//                System.out.println("Month");
//                int monthp2=sc.nextInt();
//                System.out.println("Date");
//                 int datep2=sc.nextInt();
//                LocalDate fulldatep2=LocalDate.of(yearp2, monthp2,datep2);
//                 System.out.println("Enter The To Date");
//                System.out.println("Year");
//                 int yearp3=sc.nextInt();
//                System.out.println("Month");
//                int monthp3=sc.nextInt();
//                System.out.println("Date");
//                 int datep3=sc.nextInt();
//                LocalDate fulldatep3=LocalDate.of(yearp3, monthp3,datep3);
//              System.out.println("Inventory Storage From "+fulldatep2+" To "+fulldatep3);
//                     for (int i = 0; i < lineitem_.length; i++) 
//                     {
//                         if(lineitem_[i].getCust_id()==0&&(lineitem_[i].getDate().isBefore(fulldatep3))&&(lineitem_[i].getDate().isAfter(fulldatep2)))
//                         {
//                             System.out.println( lineitem_[i].getProduct_name()+"-"+lineitem_[i].getProduct_quantity());
//                         }
//                     }
//                                                 statisticsMenu(customer_, product_,order_,payment_,lineitem_);
//                     break;
//                 case "c":
//                System.out.println("Enter The From Date");
//                System.out.println("Year");
//                int yearp4=sc.nextInt();
//                System.out.println("Month");
//                int monthp4=sc.nextInt();
//                System.out.println("Date");
//                int datep4=sc.nextInt();
//                LocalDate fulldatep4=LocalDate.of(yearp4, monthp4,datep4);
//                int maxquantity=0;
//                String proname="";
//              for (int i = 0; i < product_.length; i++) {
//                     int quantity=0;
//                for (int j = 0; j <lineitem_.length; j++) 
//                {
//                    if((product_[i].getProduct_id()==lineitem_[j].getProduct_id())&&lineitem_[j].getCust_id()!=0&&(lineitem_[j].getDate().isEqual(fulldatep4)))
//                    {
//                        quantity=quantity+lineitem_[j].getProduct_quantity();
//                    }
//                }
//                if(maxquantity<quantity)
//                {
//                    maxquantity=quantity;
//                    proname=product_[i].getProduct_name();
//                }
//                     }
//                System.out.println("Product which were sold for a maximum quantity given date ="+proname+" Quantity ="+maxquantity+"Date "+fulldatep4);
//                statisticsMenu(customer_, product_,order_,payment_,lineitem_);
//                     break;
//                  default:System.out.println("Select A Valid Option");
//                     statisticsMenu(customer_,product_,order_,payment_,lineitem_);
//             }
//                     break;
//                 case 2: 
//             System.out.println("-----------------------------------------------|");
//             System.out.println("|2)Customer                                    |");
//             System.out.println("|  a)The Customers Having Debt                 |");
//             System.out.println("-----------------------------------------------|");
//             System.out.println("Enter From Above Options");
//             String sel2=sc.next();
//             switch(sel2)
//             {
//                 case "a":
//                     System.out.println("Enter The Amount");
//                     double max=sc.nextDouble();
//                     String name_;
//                     int cu_id;
//                     System.out.println("The Customers Having Debt Above "+max);
//                     for (int i = 0; i < customer_.length; i++)
//                     {
//                         if(customer_[i].getRemainingamount()>max)
//                         {
//                             System.out.println(customer_[i].getName()+"->"+customer_[i].getCust_id()+" has a Debt Of ->"+customer_[i].getRemainingamount());
//                         }
//                     }
//                     statisticsMenu(customer_,product_,order_,payment_,lineitem_);
//                     break;
//             }
//                     break;
//             case 3:
//             System.out.println("------------------------------------------------");
//             System.out.println("|3)Order                                       |");
//             System.out.println("|  a)Max Order Amount From Given Date          |");
//             System.out.println("|  b)Min Order Amount From Given Date          |");
//             System.out.println("-----------------------------------------------|");
//             System.out.println("Enter From Above Options");
//             String sel1=sc.next();
//             switch(sel1)
//             {
//                 case "a":
//                     System.out.println("Enter The From Date");
//                System.out.println("Year");
//                 int yearp2=sc.nextInt();
//                System.out.println("Month");
//                int monthp2=sc.nextInt();
//                System.out.println("Date");
//                 int datep2=sc.nextInt();
//                LocalDate fulldatep2=LocalDate.of(yearp2, monthp2,datep2);
//                     double max=0;
//                     for (int i = 1; i < order_.length; i++)
//                     {
//                         if((max<order_[i].getTotal_amount())&&(fulldatep2.isBefore(order_[i].getDate())))
//                         {
//                             max=order_[i].getTotal_amount();
//                         }
//                     }
//                     System.out.println("The Maximum Order Amount is = "+max);
//                     statisticsMenu(customer_,product_,order_,payment_,lineitem_);
//                     break;
//                 case "b":
//                System.out.println("Enter The From Date");
//                System.out.println("Year");
//                 int yearp21=sc.nextInt();
//                System.out.println("Month");
//                int monthp21=sc.nextInt();
//                System.out.println("Date");
//                 int datep21=sc.nextInt();
//                LocalDate fulldatep21=LocalDate.of(yearp21, monthp21,datep21);
//                         double min=order_[0].getTotal_amount();
//                     int j;
//                     for (int i = 0; i < order_.length; i++)
//                     {
//                         if(order_[i].getTotal_amount()<min)
//                         {
//                             min=order_[i].getTotal_amount();
//                         }
//                     }
//                     System.out.println("The Minimum Order is = "+min);
//                     statisticsMenu(customer_,product_,order_,payment_,lineitem_);
//                     break;
//                 default:System.out.println("Select A Valid Option");
//                     statisticsMenu(customer_,product_,order_,payment_,lineitem_);
//              }
//              break;
//             case 4:mainMenu(customer_,product_,order_,payment_,lineitem_);
//             break;
// }
