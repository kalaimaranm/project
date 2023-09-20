package khatabook;

import static khatabook.Customer.kb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Payment {

    private String phoneNo;
    private String paymentModeOnline;
    private double paidAmount;
    private double debt;

    public Payment(String phoneNo, String paymentModeOnline, double paidAmount, double debt) {
        this.phoneNo = phoneNo;
        this.paymentModeOnline = paymentModeOnline;
        this.paidAmount = paidAmount;
        this.debt = debt;
    }

    public Payment() {

    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPaymentModeOnline() {
        return paymentModeOnline;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDebt() {
        return debt;
    }

    public void setPaymentModeOnline(String paymentModeOnline) {
        this.paymentModeOnline = paymentModeOnline;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    void makePayment(double amount, int orderID, int customerID, String description) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("insert into payment (order_id,customer_id,amount,date_time,description) values (?,?,?,?,?)");
            String date_time = LocalDateTime.now().toString();
            ps.setInt(1, orderID);
            ps.setInt(2, customerID);
            ps.setDouble(3, amount);
            ps.setString(4, date_time);
            ps.setString(5, description);
            int b = ps.executeUpdate();
            if (b == 1) {
                System.out.println("Payment Successfully done...");

            } else {
                System.err.println("Payment Failed");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
    public void paymentView() throws ClassNotFoundException,SQLException{
        try(Connection connection = kb.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from payment");){
            
        }
    }
}
