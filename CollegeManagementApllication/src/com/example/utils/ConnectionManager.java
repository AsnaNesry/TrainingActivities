package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static ConnectionManager dbIsntance;
	private static Connection conn;
	private static Statement stmt;

	private ConnectionManager() {
		// private constructor //
	}

	public static ConnectionManager getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new ConnectionManager();
		}
		return dbIsntance;
	}

	public Connection getConnection() {

		try {
			if (conn == null || conn.isClosed()) {

				String host = "jdbc:mysql://localhost:3306/college";
				String username = "root";
				String password = "asna1997";
				conn = DriverManager.getConnection(host, username, password);
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return conn;
	}

}
