package dao;

import model.Stock;
import java.sql.SQLException;
public interface StockDAO {

    public boolean stockEntry(Stock stock) throws SQLException,ClassNotFoundException;
}
