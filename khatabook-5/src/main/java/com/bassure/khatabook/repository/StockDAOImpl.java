package com.bassure.khatabook.repository;

import com.bassure.khatabook.dao.StockDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bassure.khatabook.model.Stock;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;



@Repository
public class StockDAOImpl implements StockDAO {

    @Override
    public boolean stockEntry(Stock stock) throws ClassNotFoundException,SQLException{
     try (Connection connection = DbConnection.getConnection(); 
          PreparedStatement ps = connection.prepareStatement("insert into stock (product_id,quantity,date_time) values (?,?,?)");) {
            ps.setInt(1, stock.getProductID());
            ps.setInt(2, stock.getQuantity());
            ps.setString(3, stock.getDateTime());
            return ps.executeUpdate()==1;            
        
    } catch(SQLException sql){
        sql.printStackTrace();
    }
     return false;

}
}