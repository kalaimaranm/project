package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.Product;
import java.sql.SQLException;
import com.bassure.khatabook.model.Order;
import java.util.Map;

public interface ProductDAO {

    public boolean addProduct(Product product) throws ClassNotFoundException, SQLException;

    public boolean updateQuantity(Product product) throws SQLException, ClassNotFoundException;  // only one product update

    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException;

    public boolean deleteProduct(int id) throws ClassNotFoundException, SQLException;

    public Product getProductById(int id) throws SQLException, ClassNotFoundException;

    public Map<Integer, Product> getAllProduct() throws SQLException, ClassNotFoundException;

    public boolean productEntry(Order order) throws SQLException, ClassNotFoundException; // array of product update, used while placing order

    public int generateID() throws SQLException, ClassNotFoundException;
}
