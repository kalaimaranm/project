package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {

    public int genOrderID() throws ClassNotFoundException,SQLException;

    public boolean orderEntry(Order order) throws ClassNotFoundException,SQLException;

    public void placeOrder() throws ClassNotFoundException,SQLException;
    
    public Order getOrderById(int orderId) throws ClassNotFoundException, SQLException;
    
    public List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException, ClassNotFoundException;
}
