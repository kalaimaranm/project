package com.bassure.khatabook.repository;

import com.bassure.khatabook.dao.ProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Product;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import com.bassure.khatabook.model.Order;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("update product set cost_per_unit = ?,profit_per_unit = ?,weight = ?,date_time = ?, quantity = ?, name= ?, status = ? where id = ?");) {
            ps.setDouble(1, product.getPrice());
            ps.setDouble(2, product.getProfitPerUnit());
            ps.setString(3, product.getWeight());
            ps.setString(4, product.getDateTime());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getName());
            ps.setBoolean(7, product.isStatus());
            ps.setInt(8, product.getId());

            return ps.executeUpdate() >= 1;

        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateQuantity(Product product) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); //            PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
                 PreparedStatement ps = connection.prepareStatement("update product set quantity = ? where id = ?");) {
            ps.setInt(1, product.getQuantity());
            ps.setInt(2, product.getId());

            return ps.executeUpdate() == 1;

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?,cost_per_unit = ?,profit_per_unit = ?,weight = ?,quantity = quantity + ? where id = ?")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getProfitPerUnit());
            preparedStatement.setString(4, product.getWeight());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, Product> getAllProduct() throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); Statement ps = connection.createStatement();) {
            ResultSet rs = ps.executeQuery("select * from product");
            Map<Integer, Product> products = new HashMap();
            while (rs.next()) {
                products.put(rs.getInt(1), new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getBoolean(8)));
            }
            return products;
        }
    }

    @Override
    public Product getProductById(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            if (result.absolute(1)) {
                Product product = new Product(result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getDouble(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getBoolean(8));
                return product;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();

        }
        return null;
    }
//    delete product then do the update product and customer 

    @Override
    public boolean deleteProduct(int id) throws ClassNotFoundException, SQLException {

        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("update product set status = ? where id = ?")) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            Product product = getProductById(id);
            int b = preparedStatement.executeUpdate();
            System.out.println("b is " + b);
            System.out.println("status id :" + product.isStatus());
            return Objects.nonNull(product) ? product.isStatus() ? preparedStatement.executeUpdate() > 0
                    : false
                    : false;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean productEntry(Order order) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select quantity from product where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); PreparedStatement ps2 = connection.prepareStatement("update product set quantity = ? where id = ?");) {
            int i = 0;
            for (LineItem lineItem : order.getLineItem()) {
                ps.setInt(1, lineItem.getProductID());
                ResultSet rs = ps.executeQuery();
                rs.absolute(1);
                int quantity = rs.getInt(1) - lineItem.getQuantity();
                ps2.setInt(1, quantity);
                ps2.setInt(2, lineItem.getProductID());
                ps2.executeUpdate();
                ++i;
            }
            return order.getLineItem().length == i;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;
    }

    @Override
    public int generateID() throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into product (cost_per_unit) values (?)"); PreparedStatement ps2 = connection.prepareStatement("select * from product where cost_per_unit = ?");) {
            ps.setDouble(1, 0.1);
            ps.execute();
            ps2.setDouble(1, 0.1);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            return rs2.getInt(1);

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return 0;
    }

}
