package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.LineItem;
import java.sql.SQLException;

public interface LineItemDAO {

    public boolean lineItemEntry(Order order) throws ClassNotFoundException,SQLException;

    public void viewLineItem(LineItem[] lineItem) throws ClassNotFoundException,SQLException;
}
