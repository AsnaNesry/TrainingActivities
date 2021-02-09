package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static ConnectionManager dbIsntance;
	private static Connection conn;
	private static Statement stmt;

	private ConnectionManager() {
		
	}

	public static ConnectionManager getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new ConnectionManager();
		}
		return dbIsntance;
	}

	public static Connection getConnection() {

		if (conn == null) {
			try {
				String host = "jdbc:mysql://localhost:3306/college";
                                conn.setAutoCommit(false);
				String username = "root";
				String password = "asna1997";
				conn = DriverManager.getConnection(host, username, password);
			} catch (SQLException ex) {

				System.out.println(ex);
			}
		}

		return conn;
	}

}
