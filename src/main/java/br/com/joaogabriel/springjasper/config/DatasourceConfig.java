package br.com.joaogabriel.springjasper.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
	
	@Bean
	public Connection getConnection(DataSource datasource) throws SQLException {
		return datasource.getConnection();
	}

}
