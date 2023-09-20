package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.dao.OrdersDAO;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDAOImpl implements OrdersDAO {

    KhatabookDAO khatabook = new MysqlKhatabookImplTest();

    @Override
    public int genOrderID() throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into korder (total) values (0.1)"); PreparedStatement preparedStatement2 = connection.prepareStatement("select id from korder where total = 0.1 limit 1");) {
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement2.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return 0;
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        OrderDAOImpl d = new OrderDAOImpl();
//        d.genOrderID();
//    }

    @Override
    public boolean orderEntry(Order order) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("update korder set customer_id = ?,total = ?,date_time = ?,status = ? where id = ?");) {
//           int id = genOrderID();
            preparedStatement.setInt(1, order.getCustomerID());
            preparedStatement.setDouble(2, order.getTotal());
            preparedStatement.setString(3, order.getDateTime());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.setInt(5, order.getId());

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return false;
    }

    @Override
    public Order getOrderById(int orderId) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM korder WHERE id = ?"); PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM lineitem WHERE order_id = ?")) {
            preparedStatement.setInt(1, orderId);
            preparedStatement2.setInt(1, orderId);
            ResultSet result = preparedStatement.executeQuery();
            ResultSet result2 = preparedStatement2.executeQuery();
            Order order;
            LineItem[] lineItems = new LineItem[0];
            while (result2.next()) {
                lineItems = Arrays.copyOf(lineItems, lineItems.length + 1);
                lineItems[lineItems.length - 1] = new LineItem(result2.getInt(1),
                        result2.getInt(2),
                        result2.getInt(5),
                        result2.getString(3),
                        result2.getDouble(4)
                );
            }
            result.next();
            order = new Order(result.getInt(1),
                    result.getInt(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getString(5),
                    lineItems
            );
            return order;
        }

    }

    public boolean updateOrderStatus(String status, int orderId) throws SQLException, ClassNotFoundException {

        try (Connection connection = DbConnection.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement("update korder set status = ? where id = ?");) {
            prepareStatement.setString(1, status);
            prepareStatement.setInt(2, orderId);
            int result = prepareStatement.executeUpdate();

            return result != 0;
        } catch (SQLException | ClassNotFoundException ex) {

            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM korder WHERE customer_id = ?"); PreparedStatement prepareStatement2 = connection.prepareStatement("SELECT * FROM lineitem WHERE order_id = ?");) {
            prepareStatement.setInt(1, customerId);
            ResultSet result = prepareStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (result.next()) {

                prepareStatement2.setInt(1, result.getInt(1));
                ResultSet result2 = prepareStatement2.executeQuery();
                LineItem[] lineItems = new LineItem[0];
                while (result2.next()) {
                    lineItems = Arrays.copyOf(lineItems, lineItems.length + 1);
                    lineItems[lineItems.length - 1] = new LineItem(result2.getInt(1),
                            result2.getInt(2),
                            result2.getInt(5),
                            result2.getString(3),
                            result2.getDouble(4)
                    );

                }
                orders.add(new Order(result.getInt(1),
                        result.getInt(2),
                        result.getDouble(3),
                        result.getString(4),
                        result.getString(5),
                        lineItems));

            }
            return orders;

        }

    }

    public List<Order> getAllPendingOrders() throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM korder WHERE status = \"Pending\"");) {
            PreparedStatement prepareStatement2 = connection.prepareStatement("SELECT * FROM lineitem WHERE order_id = ?");
            ResultSet result = prepareStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (result.next()) {

                prepareStatement2.setInt(1, result.getInt(1));
                ResultSet result2 = prepareStatement2.executeQuery();
                LineItem[] lineItems = new LineItem[0];
                while (result2.next()) {
                    lineItems = Arrays.copyOf(lineItems, lineItems.length + 1);
                    lineItems[lineItems.length - 1] = new LineItem(result2.getInt(1),
                            result2.getInt(2),
                            result2.getInt(5),
                            result2.getString(3),
                            result2.getDouble(4)
                    );
                }
                orders.add(new Order(result.getInt(1),
                        result.getInt(2),
                        result.getDouble(3),
                        result.getString(4),
                        result.getString(5),
                        lineItems));

            }
            return orders;
        }

    }

    public boolean increaseProductQuantity(Order order) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); 
             PreparedStatement prepareStatement = connection.prepareStatement("update product set quantity = quantity + ? where id = ?");) {
            int count = 0;
            for (LineItem lineItem : order.getLineItem()) {
                prepareStatement.setInt(2, lineItem.getProductID());
                prepareStatement.setInt(1, lineItem.getQuantity());
                prepareStatement.executeUpdate();
                ++count;
            }
            return count == order.getLineItem().length;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return false;
    }

    @Override
    public void placeOrder() throws ClassNotFoundException, SQLException {

    }

}
