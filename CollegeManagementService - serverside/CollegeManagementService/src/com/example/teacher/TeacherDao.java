package com.example.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.utils.ConnectionManager;

public class TeacherDao implements ITeacher {

	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public void updateTeacher(int teacher_id) {

		try {

			Statement stmt = conn.createStatement();
			String sql = "update teacher set name='Reena' where teacher_id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher_id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("query executed successfully");
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

	public void deleteTeacher(int teacher_id) {

		try {

			Statement stmt = conn.createStatement();
			String sql = "delete from teacher where teacher_id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher_id);

			int rowDeleted = statement.executeUpdate();
			if (rowDeleted > 0) {
				System.out.println("Teacher deleted successfully");
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

	public List<Teacher> insert(Teacher teacher) {

		String result = "";

		try {

			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO teacher (teacher_id,name,designation,batch_id) VALUES (?, ?, ?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher.getTeacherId());
			statement.setString(2, teacher.getName());
			statement.setString(3, teacher.getDesignation());
			statement.setInt(4, teacher.getBatchId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				result = "A new teacher inserted successfully!";
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

		return null;

	}

	@Override
	public List<Teacher> getTeacherDetails() {
		List<Teacher> list = new ArrayList<>();
		try {

			Statement stmt = conn.createStatement();
			String sql = "select * from teacher";
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(result.getInt("teacher_id"));
				teacher.setName(result.getString("name"));
				teacher.setDesignation(result.getString("designation"));
				teacher.setBatchId(result.getInt("batch_id"));

				list.add(teacher);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;

	}
}