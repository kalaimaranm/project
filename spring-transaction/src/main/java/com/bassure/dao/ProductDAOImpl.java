package com.bassure.dao;

import com.bassure.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductDAOImpl() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // NO TRANSACATION IS CREATED USE OLD TRANSACTION
    public boolean saveProduct(Product product) {

        System.out.println(jdbcTemplate);
        Object[] args = {product.id(), product.name(), product.expirationDate()};
        return jdbcTemplate.update("INSERT INTO pproduct VALUES (?,?,?)", args) > 0;

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
