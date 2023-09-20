package com.bassure.khatabook.dao;

import java.sql.SQLException;
import com.bassure.khatabook.model.Payment;

public interface PaymentDAO {

    boolean makePayment(Payment payment) throws ClassNotFoundException, SQLException;

    public Payment getPaymentDetail(int customerId) throws ClassNotFoundException, SQLException;
}
