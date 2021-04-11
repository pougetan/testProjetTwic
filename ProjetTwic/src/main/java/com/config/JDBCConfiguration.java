package com.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	@Bean
	public static Connection getonnexionBDD() {
		String url = "jdbc:mysql://127.0.0.1/twic";
		String user = "root";
		String passwd = "";
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
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
