import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MysqlCon {

	public static void main(String[] args) {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "asna1997");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			// Iterate through the data in the result set and display it.
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rsmd.getColumnName(i) + "  ");

			}
			System.out.println();
			while (rs.next()) {
				// Print one row

				for (int i = 1; i <= columnsNumber; i++) {

					System.out.print(rs.getString(i) + "     ");

				}

				System.out.println();// Move to the next line to print the next row.

			}

			System.out.println("enter a name: ");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();

			ResultSet str = stmt.executeQuery("select mark from students where name='" + name + "'");

			while (str.next()) {
				System.out.println("Mark of student" + name + "is: " + str.getInt("mark"));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
