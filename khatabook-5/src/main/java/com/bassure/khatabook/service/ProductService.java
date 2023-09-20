package com.bassure.khatabook.service;

import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.model.Stock;
import com.bassure.khatabook.repository.MysqlKhatabookImpl;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    public static int productQuantityBeforeUpdate;

    public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {

        product.setDateTime(LocalDateTime.now().toString());
        product.setStatus(true);
        product.setId(mysqlKhatabookImpl.getProduct().generateID());
        if (mysqlKhatabookImpl.getProduct().addProduct(product)
                && mysqlKhatabookImpl.getStock().stockEntry(new Stock(product.getId(), product.getQuantity(), product.getDateTime()))) {

            return true;
        }
        return false;

    }

    public Map<Integer, Product> getAllProduct() throws SQLException, ClassNotFoundException {

        return mysqlKhatabookImpl.getProduct().getAllProduct();

    }

    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {

        if (product.getQuantity() > 0
                && mysqlKhatabookImpl.getStock().stockEntry(new Stock(product.getId(), product.getQuantity(), LocalDateTime.now().toString()))) {

        }
        return mysqlKhatabookImpl.getProduct().updateProduct(product);

    }

    public Product getProductById(int productId) throws SQLException, ClassNotFoundException {

        return mysqlKhatabookImpl.getProduct().getProductById(productId);
    }

    public boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException {

        if (mysqlKhatabookImpl.getProduct().deleteProduct(productId)) {
            return true;
        }

        return false;
    }

}
