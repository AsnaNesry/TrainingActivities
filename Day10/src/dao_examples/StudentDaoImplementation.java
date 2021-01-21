package dao_examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplementation implements StudentDao {

	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "asna1997");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");

			while (rs.next()) {

				Student student = new Student();
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

	public int getStudentMark(String name) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "asna1997");

			Statement stmt = con.createStatement();

			ResultSet str = stmt.executeQuery("select mark from students where name='" + name + "'");

			while (str.next()) {

				result = str.getInt("mark");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

}
