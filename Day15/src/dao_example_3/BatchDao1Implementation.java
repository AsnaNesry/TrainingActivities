package dao_example_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchDao1Implementation implements BatchDao1 {
	ConnectionManager co = new ConnectionManager();

	public void getBatchStrength() {
		try {
			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			int res = 0;
			ResultSet result = stmt.executeQuery("select count(course_id) from student where course_id=101");

			System.out.println("strength of science batch is: ");
			while (result.next()) {
				res = result.getInt(1);
			}
			System.out.println(res);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getBatchPaymentStatus() {
		try {
			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet reslt = stmt
					.executeQuery("select fee_details.student_id,student.name from student,fee_details \r\n"
							+ "where student.student_id=fee_details.student_id and\r\n"
							+ "fee_details.payment_received='No';\r\n" + "");

			while (reslt.next()) {

				System.out.println("Batches who have students yet to pay the fees : ");
				System.out.println(reslt.getInt("student_id") + "   " + reslt.getString("name"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void addBatch(int courseId, String courseName, int courseFee) {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO course (course_id,course_name,course_fee) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, courseId);
			statement.setString(2, courseName);
			statement.setInt(3, courseFee);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new course inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}