package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.Order;
import java.sql.SQLException;

public interface OrdersDAO {

    public int genOrderID() throws ClassNotFoundException,SQLException;

    public boolean orderEntry(Order order) throws ClassNotFoundException,SQLException;

    public void placeOrder() throws ClassNotFoundException,SQLException;
}
