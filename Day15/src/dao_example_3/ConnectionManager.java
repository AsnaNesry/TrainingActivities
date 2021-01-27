package dao_example_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private Object userName = "root";
	private Object password = "asna1997";
	private Object dbms = "mysql";
	private String serverName = "localhost";
	private String portNumber = "3306";
	private String dbName = "students";

	public Connection getConnection() throws SQLException {

		Connection conn = null;

		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		if (this.dbms.equals("mysql")) {
			conn = (Connection) DriverManager.getConnection(
					"jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber + "/" + this.dbName,
					connectionProps);
		} else if (this.dbms.equals("derby")) {
			conn = (Connection) DriverManager.getConnection("jdbc:" + this.dbms + ":" + this.dbName + ";create=true",
					connectionProps);
		}

		return conn;

	}

}
