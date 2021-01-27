package dao_example_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TeacherDao1Implementation implements TeacherDao1 {
	public void addTeacher(int teacher_id, String name, long contact, int course_id) {
		ConnectionManager co = new ConnectionManager();

		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO teachers(teacher_id,name,contact,course_id) VALUES (?, ?, ?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher_id);
			statement.setString(2, name);
			statement.setLong(3, contact);
			statement.setInt(4, course_id);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new teacher details inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}