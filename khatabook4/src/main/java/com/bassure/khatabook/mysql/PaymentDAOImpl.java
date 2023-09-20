package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.PaymentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.sql.SQLException;

import com.bassure.khatabook.model.Payment;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean makePayment(Payment payment) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); 
             PreparedStatement ps = connection.prepareStatement("insert into payment (order_id,customer_id,amount,date_time,description) values (?,?,?,?,?)");) {
            System.out.println("Payment :" + payment);
            String date_time = LocalDateTime.now().toString();
            ps.setInt(1, payment.getOrderID());
            ps.setInt(2, payment.getCustomerID());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getDateTime());
            ps.setString(5, payment.getDiscription());
            int b = ps.executeUpdate();
            return b == 1;
//            if (b == 1) {
//                System.out.println("Payment Successfully done...");
//            } else {
//                System.err.println("Payment Failed");
//            }

        } catch (SQLException sql) {
            sql.printStackTrace();
            sql.getMessage();
        }
        return false;
    }

}
