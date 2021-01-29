package dao_example_3;

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

				System.out.println("enter student name: ");
				String name = sc.next();

				System.out.println("enter course id: ");
				int cid = sc.nextInt();

				System.out.println("enter payment status: ");
				String payment_status = sc.next();
				sdi.addStudent(id, name, cid, payment_status);
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

				System.out.println("enter contact no: ");
				long contact = sc.nextLong();

				System.out.println("enter course id: ");
				int course_id = sc.nextInt();

				tdi.addTeacher(teacher_id, teacherName, contact, course_id);
				break;

			case 5:
				System.out.println("enter course id: ");
				int courseId = sc.nextInt();
				System.out.println("enter course name: ");
				String courseName = sc.next();
				System.out.println("enter course fee: ");
				int courseFee = sc.nextInt();

				bdi.addBatch(courseId, courseName, courseFee);
				break;

			default:
				System.out.println("invalid option");

			}

			System.out.println("do you want to continue ? : Y/N ");
			repeat = sc.next();

		} while (!("N".equalsIgnoreCase(repeat)));

	}

}
