package com.kalai.microservice.customer.customersservice.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class DBConnection {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public DBConnection(DataSource dataSource) {
		this.dataSource = dataSource;

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {

		return jdbcTemplate;
	}

	@Bean
	public Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

}
