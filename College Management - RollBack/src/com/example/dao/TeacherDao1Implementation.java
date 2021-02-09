package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TeacherDao1Implementation implements TeacherDao1 {
	public void addTeacher(int teacher_id, String name, String designation, int batch_id) {

		Connection conn = ConnectionManager.getInstance().getConnection();
            

		try {

			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO teacher(teacher_id,name,designation,batch_id) VALUES (?, ?, ?,?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, teacher_id);
			statement.setString(2, name);
			statement.setString(3, designation);
			statement.setInt(4, batch_id);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new teacher details inserted successfully!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}