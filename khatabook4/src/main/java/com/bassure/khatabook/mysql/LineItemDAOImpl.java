package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.dao.LineItemDAO;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LineItemDAOImpl implements LineItemDAO {

    KhatabookDAO khatabook = new MysqlKhatabookImplTest();

    @Override
    public boolean lineItemEntry(Order order) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("insert into lineitem values(?,?,?,?,?)")) {
            int i = 0;
            int check = 0;
            System.out.println("order id:"+order.getId()+"\nlineitem "+order.getLineItem().length);
//        LineItem[] lineItem = order.getLineItem();
            for (LineItem tempLineItem : order.getLineItem()) {
                if (tempLineItem.getQuantity() > 0) {
                    preparedStatement.setInt(1, order.getId());
                    preparedStatement.setInt(2, tempLineItem.getProductID());
                    preparedStatement.setString(3, tempLineItem.getProductName());
                    preparedStatement.setDouble(4, tempLineItem.getPrice());
                    preparedStatement.setInt(5, tempLineItem.getQuantity());
                     check = check + preparedStatement.executeUpdate();
                    ++i;
                }
            }
            return check == i;
//            return i == order.getLineItem().length;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    @Override
    public void viewLineItem(LineItem[] lineItem) {

    }

}
