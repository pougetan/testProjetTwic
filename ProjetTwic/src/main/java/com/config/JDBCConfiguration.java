package com.config;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.dao.VilleDao;
import com.dao.VilleDaoImpl;
import  java.sql.Connection;

public class JDBCConfiguration {

	private String url;
	private String username;
	private String password;

	JDBCConfiguration(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static JDBCConfiguration getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		JDBCConfiguration instance = new JDBCConfiguration("jdbc:mysql://127.0.0.1/twic", "root", "");
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	} 

	// Récupération du Dao
	public VilleDao getVilleDao() {
		return new VilleDaoImpl(this);
	}
}