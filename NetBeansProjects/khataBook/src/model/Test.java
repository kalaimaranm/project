package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static khatabook.Khatabook.khatabook;
import static khatabook.Customer.kb;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Objects;

// wait
public class Test {
    
    String phone;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(khatabook.getCustomer().getCustomerStatus("9999999999"));
//        try(Connection connection = kb.getConnection();
//            PreparedStatement ps = connection.prepareStatement("select * from test",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);){
//            ResultSet rs = ps.executeQuery();            
//            rs.next();
//            System.out.println("ID :" +rs.getInt(1)+"  name :"+rs.getString(2));
//            System.out.println("Enter 1 to see next data");
//            Scanner scan = new Scanner(System.in);
//            int i = scan.nextInt();
//            if(i==1){
//                rs.next();
//                System.out.println("ID :" +rs.getInt(1)+"  name :"+rs.getString(2));
//            }
//        }catch(SQLException sql){
//            sql.printStackTrace();
//        }
        Test test = new Test();
        test.setPhone("8618825343");
        if (Objects.nonNull(test.phone)) {
            System.out.println("phone is nonNull");
        } else if (Objects.isNull(test.getPhone())) {
            System.out.println("phone is null");
        }
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
