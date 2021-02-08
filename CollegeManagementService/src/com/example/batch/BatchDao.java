package com.example.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.utils.ConnectionManager;

public class BatchDao implements IBatch {
	ConnectionManager co = new ConnectionManager();

	public int getBatchStrength() {
		int res = 0;
		try {
			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery("select count(batch_id) from student where batch_id=101");

			System.out.println("strength of science batch is: ");
			while (result.next()) {
				res = result.getInt(1);
			}
			System.out.println(res);

		} catch (Exception e) {
			System.out.println(e);
		}
		return res;

	}

	public void getBatchPaymentStatus() {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String query = "select student.first_name,fee_details.payment_status,batch_details.batch_name from \r\n"
					+ "(student join fee_details on student.student_id=fee_details.student_id) \r\n"
					+ "join batch_details on student.batch_id=batch_details.batch_id \r\n"
					+ "where fee_details.payment_status='NotPaid'";

			ResultSet reslt = stmt.executeQuery(query);
			System.out.println("Batches who have students yet to pay the fees : ");

			while (reslt.next()) {

				System.out.println(reslt.getString("batch_name"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void addBatch(int batchId, String batchName, int fee) {
		try {

			Connection conn = (Connection) co.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO batch_details (batch_id,batch_name,fee) VALUES (?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, batchId);
			statement.setString(2, batchName);
			statement.setInt(3, fee);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new course inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}