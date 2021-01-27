package dao_example_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StudentDao1Implementation implements StudentDao1 {
	ConnectionManager co = new ConnectionManager();

	public void addStudent(int student_id, String name, int course_id) {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO student (student_id,name,course_id) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, student_id);
			statement.setString(2, name);
			statement.setInt(3, course_id);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new student inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
