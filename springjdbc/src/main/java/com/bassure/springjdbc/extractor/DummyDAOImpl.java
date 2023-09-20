package com.bassure.springjdbc.extractor;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DummyDAOImpl {

    private static JdbcTemplate jdbcTemplate;

    public DummyDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void checking() {
        System.out.println("jdbc object : " + jdbcTemplate);
    }

    public void nonStaticChecking() {
        System.out.println("jdbc non Static checking :" + jdbcTemplate);
    }

}
