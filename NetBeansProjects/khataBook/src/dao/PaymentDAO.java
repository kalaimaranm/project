package dao;

import java.sql.SQLException;
public interface PaymentDAO {

    void makePayment(model.Payment payment) throws ClassNotFoundException,SQLException;

}
