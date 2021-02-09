package com.example.dao;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDaoImplementations {

	public static void main(String[] args) {

		BatchDao1Implementation bdi = new BatchDao1Implementation();
		StudentDao1Implementation sdi = new StudentDao1Implementation();
		TeacherDao1Implementation tdi = new TeacherDao1Implementation();

		Scanner sc = new Scanner(System.in);

		String repeat;
		do {
			System.out.println("1. Add a student" + "\n" + "2. strength of science batch" + "\n"
					+ "3. get the batches which have students who have yet to pay" + "\n"
					+ "4.  Add a newly joined teacher\r\n" + "5.  Add a new batch ");
			System.out.println("enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("enter student id: ");
				int id = sc.nextInt();

				System.out.println("enter first name: ");
				String fname = sc.next();

				System.out.println("enter last name: ");
				String lname = sc.next();

				System.out.println("enter batch id: ");
				int batchId = sc.nextInt();

				System.out.println("enter gender:  ");
				String gender = sc.next();

				System.out.println("enter payment id: ");
				int paymentId = sc.nextInt();

				System.out.println("enter payment amount: ");
				int paymentAmount = sc.nextInt();

				System.out.println("enter payment status: ");
				String status = sc.next();
				try {
					sdi.addStudent(id, fname, lname, batchId, gender, paymentId, paymentAmount, status);
				} catch (SQLException e) {
					System.out.println(e);
				}
				break;

			case 2:
				bdi.getBatchStrength();
				break;

			case 3:
				bdi.getBatchPaymentStatus();
				break;

			case 4:
				System.out.println("enter teacher id: ");
				int teacher_id = sc.nextInt();

				System.out.println("enter teacher name: ");
				String teacherName = sc.next();

				System.out.println("enter designation : ");
				String designation = sc.next();

				System.out.println("enter course id: ");
				int batch_id = sc.nextInt();

				tdi.addTeacher(teacher_id, teacherName, designation, batch_id);
				break;

			case 5:
				System.out.println("enter batch id: ");
				int batchid = sc.nextInt();
				System.out.println("enter batch name: ");
				String batchName = sc.next();
				System.out.println("enter batch fee: ");
				int fee = sc.nextInt();

				bdi.addBatch(batchid, batchName, fee);
				break;

			default:
				System.out.println("invalid option");

			}

			System.out.println("do you want to continue ? : Y/N ");
			repeat = sc.next();

		} while (!("N".equalsIgnoreCase(repeat)));

	}

}
