package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.dao.OrdersDAO;
import com.bassure.khatabook.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDAOImpl implements OrdersDAO {
    
    KhatabookDAO khatabook = new MysqlKhatabookImpl();
    @Override
    public int genOrderID() throws ClassNotFoundException,SQLException {
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into korder (status) values(\"pending\")");
            PreparedStatement preparedStatement2 = connection.prepareStatement("select id from korder where status = \"pending\" limit 1");){
            
            preparedStatement.executeUpdate();
          ResultSet result =  preparedStatement2.executeQuery();
          result.next();
          return result.getInt(1);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return 0;
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        OrderDAOImpl d = new OrderDAOImpl();
//        d.genOrderID();
//    }
    @Override
    public boolean orderEntry(Order order) throws ClassNotFoundException,SQLException {
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update korder set customer_id = ?,total = ?,date_time = ?,status = ? where id = ?");){
//           int id = genOrderID();
            preparedStatement.setInt(1,order.getCustomerID());
            preparedStatement.setDouble(2,order.getTotal());
            preparedStatement.setString(3, order.getDateTime());
            preparedStatement.setString(4,"successfull");
            preparedStatement.setInt(5,order.getId());
            
            return preparedStatement.executeUpdate() != 0;
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        
        
        return false;
    }

    @Override
    public void placeOrder() throws ClassNotFoundException,SQLException {
    
    }

}
