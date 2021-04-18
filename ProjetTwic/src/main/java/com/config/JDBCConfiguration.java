package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	
	private  String url;
    private  String user;
    private  String psd;
    
    public JDBCConfiguration() {
	}
    JDBCConfiguration(String url, String user, String psd) {
        this.url = url;
        this.user = user;
        this.psd = psd;
    }
    
    public static JDBCConfiguration getInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

        }

        JDBCConfiguration inst = new JDBCConfiguration("jdbc:postgresql://127.0.0.1:15432/Twic", "postgres", "postgres");
        return inst;
    }
    
    public Connection getConnection() throws SQLException {
    	
    	return DriverManager.getConnection(url, user, psd);
    	} 
}
