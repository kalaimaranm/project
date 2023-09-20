package com.bassure.khatabook.repository;

import com.bassure.khatabook.dao.PaymentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.sql.SQLException;
import com.bassure.khatabook.model.Payment;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean makePayment(Payment payment) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into payment (order_id,customer_id,amount,date_time,description) values (?,?,?,?,?)");) {
            String date_time = LocalDateTime.now().toString();
            ps.setInt(1, payment.getOrderID());
            ps.setInt(2, payment.getCustomerID());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getDateTime());
            ps.setString(5, payment.getDiscription());
            int b = ps.executeUpdate();
            return b == 1;

        } catch (SQLException sql) {
            sql.printStackTrace();
            sql.getMessage();
        }
        return false;
    }

    public Payment getPaymentDetail(int customerId) throws ClassNotFoundException, SQLException {

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment WHERE customer_id = ? ORDER BY id DESC LIMIT 1");) {
            preparedStatement.setInt(1, customerId);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return new Payment(result.getInt(1), result.getInt(3), result.getDouble(4), result.getString(5), result.getString(6));

        }

    }

}
