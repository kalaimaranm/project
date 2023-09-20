package com.bassure.transaction;

import com.bassure.dao.ProductDAO;
import com.bassure.dao.ProductDAOImpl;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.bassure"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ConfigurationClass {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://bassure.in/kalaimaran_db",
                "Kalai",
                "Kalai@4321");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }

    @Bean
    public ProductDAO productDAO() {

        return new ProductDAOImpl();
    }

//    @Bean
//    public TransactionManager transactionManager(@Autowired DataSource dataSource) {
//
//        return new DataSourceTransactionManager(dataSource);
//    }

}
