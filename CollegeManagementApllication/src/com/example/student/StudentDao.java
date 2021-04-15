package com.example.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.utils.ConnectionManager;

public class StudentDao implements IStudent {

	Connection conn = ConnectionManager.getInstance().getConnection();

	public List<Student> insert(Student student) {
		try {
			Connection conn = ConnectionManager.getInstance().getConnection();
			Statement stmt = conn.createStatement();

			String sql = "INSERT INTO student (student_id,first_name,last_name,batch_id,gender) VALUES (?, ?, ?,?,?)";
			String sql1 = "INSERT INTO fee_details(payment_id,student_id,payment_amount,payment_status) VALUES(?,?,?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			PreparedStatement statement1 = conn.prepareStatement(sql1);

			statement.setInt(1, student.getStudentId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.setInt(4, student.getBatchId());
			statement.setString(5, student.getGender());

			statement1.setInt(1, student.getPaymentId());
			statement1.setInt(2, student.getStudentId());
			statement1.setInt(3, student.getPaymentAmount());
			statement1.setString(4, student.getPaymentStatus());

			int rowsInserted = statement.executeUpdate();

			int rowInserted = statement1.executeUpdate();
			if (rowsInserted > 0 && rowInserted > 0) {
				System.out.println("A new student inserted successfully!");

			}
			conn.commit();

		} catch (SQLException e) {
			System.out.println(e);

			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw (new RuntimeException(e1));
			}

		}
		return null;
	}

	public void updateStudent(Student student) {

		try {

			String sql = "UPDATE student SET first_name=?,last_name=?,batch_id=?,gender=? where student_id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setInt(3, student.getBatchId());
			statement.setString(4, student.getGender());
			statement.setInt(5, student.getStudentId());
			System.out.println(statement);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("query executed successfully");
			}
			conn.commit();

		} catch (Exception e) {
			System.out.println(e);

			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw (new RuntimeException(e1));
			}

		}
	}

	public void deleteStudent(int student_id) {

		try {

			String sql = "delete from student where student_id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, student_id);
			System.out.println(statement);
			int rowDeleted = statement.executeUpdate();
			if (rowDeleted > 0) {
				System.out.println("student deleted successfully");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e);
		}
	}

	public List<Student> getStudentDetails() {
		List<Student> list = new ArrayList<>();
		try {

			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				Student student = new Student();
				student.setStudentId(result.getInt("student_id"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setBatchId(result.getInt("batch_id"));
				student.setGender(result.getString("gender"));
				list.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public Student getStudentById(int student_id) {
		Student student = new Student();
		try {

			Statement stmt = conn.createStatement();
			String sql = "select student.student_id,student.first_name,student.last_name,student.batch_id,student.gender,\r\n"
					+ "fee_details.payment_id,fee_details.payment_amount,fee_details.payment_status\r\n"
					+ "from student,fee_details\r\n" + "where student.student_id=fee_details.student_id\r\n"
					+ " and student.student_id=" + student_id + ";";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				student.setStudentId(result.getInt("student_id"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setBatchId(result.getInt("batch_id"));

				student.setGender(result.getString("gender"));
				student.setPaymentId(result.getInt("payment_id"));
				student.setPaymentAmount(result.getInt("payment_amount"));
				student.setPaymentStatus(result.getString("payment_status"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return student;
	}
}
