package khatabook;

import static khatabook.Product.product;
import static khatabook.Customer.kb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItem {

    static Payment payment = new Payment();
    private int quantity;
    private String productName;
    private int productId;
    private double itemAmount;
    private int sNo;

    public LineItem(int sNo, int quantity, String productName, int productId, double itemAmount) {
        this.sNo = sNo;
        this.quantity = quantity;
        this.productName = productName;
        this.productId = productId;
        this.itemAmount = itemAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    LineItem() {

    }

    @Override
    public String toString() {
        double price = 0;
        for (int i = 0; i < product.length; i++) {
            if (productId == product[i].getId()) {
                price = product[i].getPrice();
                break;
            }
        }
        System.out.format("\n|%-4d|%-18s|%-10.2f|%-9d|%-10.2f", this.sNo, this.productName, itemAmount, this.quantity, itemAmount * quantity);//this.quantity * price);
        return "";
    }

    public void lineItemEntry(Orders order) throws ClassNotFoundException, SQLException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into lineitem (order_id,product_id,product_name,price,quantity) values (?,?,?,?,?)");) {
            //PreparedStatement ps2 = connection.prepareStatement("select sum(price) from lineitem group by order_id where order_id = ?");
            int count = 0;
            int orderID = order.getOrderID();
            for (LineItem li : order.lineItem) {
                ps.setInt(1, orderID);
                ps.setInt(2, li.getProductId());
                ps.setString(3, li.getProductName());
                ps.setDouble(4, li.getItemAmount());
                ps.setInt(5, li.getQuantity());
                int execute = ps.executeUpdate();
                ++count;
            }
            if (count == order.lineItem.length) {

                payment.makePayment(order.getPayment(), order.getOrderID(), order.getCusId(), "order");
            } else {

            }
        }
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getItemAmount() {
        return itemAmount;
    }
}
