package dao_examples;

import java.util.List;
import java.util.Scanner;

public class StudentDaoDemoTest {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImplementation();

		List<Student> details = studentDao.getAllStudents();
		System.out.println("id" + "   " + "name" + "   " + "gender" + "   " + "stream" + "   " + "mark");

		for (Student student : details) {
			System.out.println(student);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("enter name: ");
		String name = sc.next();
		System.out.println("mark of student" + name + "is :" + studentDao.getStudentMark(name));

	}

}
