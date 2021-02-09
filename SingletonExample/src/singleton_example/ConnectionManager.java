package singleton_example;

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

		if (conn == null) {
			try {
				String host = "jdbc:mysql://localhost:3306/school";
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