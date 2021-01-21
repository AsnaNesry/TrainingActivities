package dao_examples;

import java.util.List;

public interface StudentDao {

	public List<Student> getAllStudents();

	public int getStudentMark(String name);

}
