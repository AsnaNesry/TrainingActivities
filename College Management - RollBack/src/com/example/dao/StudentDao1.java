package com.example.dao;

import java.sql.SQLException;

public interface StudentDao1 {

	public void addStudent(int studentId, String firstName, String lastName, int batchId, String gender, int paymentId,
			int paymentAmount, String paymentStatus) throws SQLException;

}
