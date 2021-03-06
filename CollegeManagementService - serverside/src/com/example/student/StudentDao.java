package com.example.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.example.utils.ConnectionManager;

public class StudentDao implements IStudent {
	ConnectionManager co = new ConnectionManager();

	public void addStudent(int studentId, String firstName, String lastName, int batchId, String gender, int paymentId,
			int paymentAmount, String paymentStatus) {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO student (student_id,first_name,last_name,batch_id,gender) VALUES (?, ?, ?,?,?)";
			String sql1 = "INSERT INTO fee_details(payment_id,student_id,payment_amount,payment_status,batch_id) VALUES(?,?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			PreparedStatement statement1 = conn.prepareStatement(sql1);

			statement.setInt(1, studentId);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setInt(4, batchId);
			statement.setString(5, gender);

			statement1.setInt(1, paymentId);
			statement1.setInt(2, studentId);
			statement1.setInt(3, paymentAmount);
			statement1.setString(4, paymentStatus);
			statement1.setInt(5, batchId);

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
