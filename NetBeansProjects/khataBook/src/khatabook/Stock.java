package khatabook;

import java.time.LocalDate;
import java.time.LocalTime;
import static khatabook.Customer.kb;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import static khatabook.Khatabook.BLUE;

public class Stock {

    LocalDate date;
    LocalTime time;
    int quantity;
    double price;
    double profit;

    public Stock(LocalDate date, LocalTime time, int quantity, double price, double profit) {
        this.date = date;
        this.time = time;
        this.quantity = quantity;
        this.price = price;
        this.profit = profit;
    }

    public Stock() {

    }
//    public static void main(String[] args)throws SQLException,ClassNotFoundException {
//        try(Connection connection = kb.getConnection();
//            PreparedStatement ps = connection.prepareStatement("select * from payment");){
//                   
//        }
//    }
    public void stockEntry(int id, int quantity) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into stock (product_id,quantity,date_time) values (?,?,?)");) {
            ps.setInt(1, id);
            ps.setInt(2, quantity);
            String date_time = LocalDateTime.now().toString();
            ps.setString(3, date_time);
            int status = ps.executeUpdate();
            if (status == 1) {
                System.out.println("stock entry updated successfully");
            } else {
                System.err.println("\n"+BLUE + "stock entry failed...");
            }

        }
    }

}
