package com.bassure.spring.basics.repository;

import com.bassure.spring.basics.Product;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl {

    private static JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean addProduct(Product product) {

        return false;
//         return jdbcTemplate.update("INSERT INTO ");
    }

}
