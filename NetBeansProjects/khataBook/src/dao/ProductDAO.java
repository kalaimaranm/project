package dao;

import khatabook.LineItem;
import model.Product;
import java.sql.SQLException;
import model.Order;

public interface ProductDAO {

    public boolean addProduct(Product product) throws ClassNotFoundException, SQLException;

    public boolean updateQuantity(Product product) throws SQLException, ClassNotFoundException;  // only one product update

    public void deleteProduct();

    public Product[] getProduct() throws SQLException, ClassNotFoundException;

    public void productEntry(Order order) throws SQLException, ClassNotFoundException; // array of product update, used while placing order

    public int generateID(String id) throws SQLException, ClassNotFoundException;
}
