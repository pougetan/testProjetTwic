package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	

	@Bean
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://127.0.0.1:15432/twic";
		String user = "postgres";
		String passwd = "postgres";
		Connection conn = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connecté");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return conn;
	}
}
