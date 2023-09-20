package com.kalai.microservice.address.addressservice.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public class DBConnection {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	public DBConnection(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {

		return jdbcTemplate;
	}

}
