package khatabook;

import static khatabook.Customer.kb;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Orders {

    private int orderID;
    private int cusId;
    private String cusPhone;
    private double totalPrice;
    private String date_time;
    private double balance;
    LineItem[] lineItem = new LineItem[0];
    private double payment;

    public Orders(int orderID, String date_time, int cusId, String cusPhone, double totalPrice, LineItem[] lineItem) {
        this.date_time = date_time;
        this.orderID = orderID;
        this.cusId = cusId;
        this.cusPhone = cusPhone;
        this.totalPrice = totalPrice;
      }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LineItem[] getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItem[] lineItem) {
        this.lineItem = lineItem;
    }

    public String getDate_Time() {
        return date_time;
    }

    public void setDate_Time(String date_time) {
        this.date_time = date_time;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderid=" + orderID + ", cusId=" + cusId + ", totalPrice=" + totalPrice + '}';
    }

    Orders() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int genOrderID() throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); 
            PreparedStatement ps = connection.prepareStatement("insert into korder (status) values (?)");) {
            PreparedStatement ps2 = connection.prepareStatement("select id from korder where status = ? limit 1",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
            ps.setString(1, "pending");
            int rs = ps.executeUpdate();
            ps2.setString(1,"pending");
            ResultSet rs2 = ps2.executeQuery();
            rs2.absolute(1);
            return rs2.getInt(1);
        } catch (SQLException sql) {
            sql.printStackTrace();

        }
        return 0;
    }

    public boolean orderEntry(Orders order) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("update korder set customer_id = ?, total = ?,date_time = ?,status = ? where id = ?");) {
            ps.setInt(1, order.getCusId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setString(3, order.getDate_Time());
            ps.setString(4, "successfull");
            ps.setInt(5, order.getOrderID());// genOrderId already generated during creating Order object
            int affect = ps.executeUpdate();
            if (affect == 1) {
                LineItem li = new LineItem();
                li.lineItemEntry(order);
              //  System.out.println("order Entry successfull....");
            } else {
                System.err.println("Sorry, something went wrong order cannot be place");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return true;
    }

}
