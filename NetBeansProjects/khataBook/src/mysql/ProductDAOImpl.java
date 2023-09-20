package mysql;

import dao.ProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.LineItem;
import model.Product;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import static khatabook.Customer.kb;
import model.Order;
public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean addProduct(Product product)throws ClassNotFoundException,SQLException {
      try (Connection connection = kb.getConnection();
           PreparedStatement ps = connection.prepareStatement("update product set cost_per_unit = ?,profit_per_unit = ?,weight = ?,date_time = ?,quantity = ? where id = ?");){
           ps.setDouble(1,product.getPrice());
           ps.setDouble(2,product.getProfitPerUnit());
           ps.setString(3,product.getWeight());
           ps.setString(4,product.getDateTime());
           ps.setInt(5,product.getQuantity());
           ps.setInt(6, product.getId());
           return ps.executeUpdate() >=1;

      }catch(SQLException sql){
          sql.printStackTrace();
      }
        
        
        return false;
    }

    @Override
    public boolean updateQuantity(Product product)throws SQLException,ClassNotFoundException {
            try (Connection connection = kb.getConnection();
//            PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
            PreparedStatement ps = connection.prepareStatement("update product set quantity = ? where id = ?");) {
            ps.setInt(1,product.getQuantity());
            ps.setInt(2,product.getId());
            
            return ps.executeUpdate() == 1;
            
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        return false;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product[] getProduct()throws SQLException,ClassNotFoundException {
     try (Connection connection = kb.getConnection();
     Statement ps = connection.createStatement();) {
     ResultSet rs = ps.executeQuery("select * from product");
     Product[] product = new Product[0];
            while (rs.next()) {
                product = Arrays.copyOf(product, product.length + 1);
                product[product.length - 1] = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getDouble(4),rs.getString(5),rs.getInt(6), rs.getString(7));
            }
            return product;
        }
    }

    @Override // waiting to complete place order
    public void productEntry(Order order) throws SQLException, ClassNotFoundException{
 try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select quantity from product where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); PreparedStatement ps2 = connection.prepareStatement("update product set quantity = ? where id = ?");) {

            for (LineItem li : order.getLineItem()) {
                ps.setInt(1, li.getProductId());
                ResultSet rs = ps.executeQuery();
                rs.absolute(1);
                int quantity = rs.getInt(1) - li.getQuantity();
                ps2.setInt(1, quantity);
                ps2.setInt(2, li.getProductId());
                ps2.executeUpdate();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
    public int generateID(String name) throws SQLException,ClassNotFoundException {
         try (Connection connection = kb.getConnection();            
            PreparedStatement ps = connection.prepareStatement("insert into product (name) values (?)"); 
            PreparedStatement ps2 = connection.prepareStatement("select * from product where name = ?");) {
            ps.setString(1, name);
            ps.execute();
            ps2.setString(1, name);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            return rs2.getInt(1);

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return 0;
     }

}
