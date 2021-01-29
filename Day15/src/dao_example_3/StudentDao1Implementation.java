package dao_example_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StudentDao1Implementation implements StudentDao1 {
	ConnectionManager co = new ConnectionManager();

	public void addStudent(int student_id, String name, int course_id, String payment_status) {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO student (student_id,name,course_id) VALUES (?, ?, ?)";
			String sql1 = "INSERT INTO fee_details(student_id,course_id,payment_received) VALUES(?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			PreparedStatement statement1 = conn.prepareStatement(sql1);

			statement.setInt(1, student_id);
			statement.setString(2, name);
			statement.setInt(3, course_id);

			statement1.setInt(1, student_id);
			statement1.setInt(2, course_id);
			statement1.setString(3, payment_status);

			int rowsInserted = statement.executeUpdate();
			int rowInserted = statement1.executeUpdate();
			if (rowsInserted > 0 && rowInserted > 0) {
				System.out.println("A new student inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
