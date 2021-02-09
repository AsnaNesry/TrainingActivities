package singleton_example;

import java.util.List;
import java.util.Scanner;

public class TestStudentDaoImplementation {

	public static void main(String[] args) {

		DaoImplementation Daoimp = new DaoImplementation();
		Scanner sc = new Scanner(System.in);
		String repeat;
		do {

			System.out.println("enter your choice: ");
			System.out.println("1. Show students table" + "\n" + "2. Insert new field to students table" + "\n"
					+ "3. Retrive data of particular student" + "\n" + "4. Update table students set gender Male" + "\n"
					+ "5. Delete student" + "\n" + "6. quit");

			int n = sc.nextInt();

			switch (n) {

			case 1:
				List<StudentDetails> report = Daoimp.listAllStudents();
				System.out.println("id" + "   " + "name" + "   " + "gender" + "   " + "stream" + "   " + "mark");

				for (StudentDetails student : report) {
					System.out.println(student);
				}
				break;

			case 2:
				System.out.println("enter id: ");
				int id = sc.nextInt();
				System.out.println("enter name: ");
				String name = sc.next();
				System.out.println("enter gender: ");
				String gender = sc.next();
				System.out.println("enter stream: ");
				String stream = sc.next();
				System.out.println("enter mark: ");
				int mark = sc.nextInt();
				Daoimp.addStudent(id, name, gender, stream, mark);
				break;

			case 3:
				System.out.println("enter id:");
				int id1 = sc.nextInt();
				Daoimp.getStudent(id1);
				break;

			case 4:
				System.out.println("enter id:");
				int id2 = sc.nextInt();
				Daoimp.updateStudent(id2);
				break;

			case 5:
				System.out.println("enter id of student whose details has to be removed : ");
				int id3 = sc.nextInt();
				Daoimp.deleteStudent(id3);
				break;

			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option");

			}

			System.out.println("do you want to continue ? : Y/N ");
			repeat = sc.next();

		} while (!("N".equalsIgnoreCase(repeat)));

	}

}
