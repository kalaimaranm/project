package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.Stock;
import java.sql.SQLException;

public interface StockDAO {

    public boolean stockEntry(Stock stock) throws SQLException, ClassNotFoundException;
}
