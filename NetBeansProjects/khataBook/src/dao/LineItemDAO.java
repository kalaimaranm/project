package dao;

import khatabook.Orders;

public interface LineItemDAO {

    public void lineItemEntry(model.Order order);

    public void viewLineItem(model.LineItem[] lineItem);
}
