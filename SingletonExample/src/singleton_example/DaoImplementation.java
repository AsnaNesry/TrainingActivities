package singleton_example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements StudentDetailsDao {

	Connection conn = null;

	public List<StudentDetails> listAllStudents() {
		List<StudentDetails> studentsList = new ArrayList<StudentDetails>();
		try {
			conn = ConnectionManager.getInstance().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");

			while (rs.next()) {

				StudentDetails student = new StudentDetails();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setStream(rs.getString("stream"));
				student.setMark(rs.getInt("mark"));
				studentsList.add(student);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return studentsList;

	}

	@Override
	public void addStudent(int id, String name, String gender, String stream, int mark) {
		try {

			conn = ConnectionManager.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO students (id, name, gender, stream, mark) VALUES (?, ?, ?, ?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, gender);
			statement.setString(4, stream);
			statement.setInt(5, mark);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void getStudent(int id) {
		try {

			conn = ConnectionManager.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select *from students where id='" + id + "'");
			while (result.next()) {
				System.out.println("details of student of given id " + id + " is: ");
				System.out.println(
						result.getInt("id") + "   " + result.getString("name") + "   " + result.getString("gender")
								+ "   " + result.getString("stream") + "   " + result.getInt("mark"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void updateStudent(int id) {
		try {

			conn = ConnectionManager.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "UPDATE students set mark=? where id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 118);
			statement.setInt(2, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing students was updated successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void deleteStudent(int id) {
		try {

			conn = ConnectionManager.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM students WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
