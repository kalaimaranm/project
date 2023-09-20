package com.bassure.khatabook.model;

//import static khatabook.Khatabook.khatabook;
//import static khatabook.Customer.kb;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// wait
public class Test {

    String phone;
   static Map<Integer, String> test = new HashMap();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println(khatabook.getCustomer().getCustomerStatus("9999999999"));
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
//        Test test = new Test();
//        test.setPhone("8618825343");
//        if (Objects.nonNull(test.phone)) {
//            System.out.println("phone is nonNull");
//        } else if (Objects.isNull(test.getPhone())) {
//            System.out.println("phone is null");
//        }
//     Test testt = new Test();
        addProduct();
        mapTest(4);
        System.out.println(test.get(4));
        

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    static void mapTest(Integer key) {
      
        if(test.containsKey(key)){
           String getValue = test.get(key);
           String value = "FOUR";
           getValue = value;
           
        }
    }

   static void addProduct() {
        test.put(1, "one");
        test.put(2, "two");
        test.put(3, "three");
        test.put(4, "four");
        test.put(5, "five");
    }

}
