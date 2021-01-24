package dao_example_2;

import java.util.List;

public interface StudentDetailsDao {

	public List<StudentDetails> listAllStudents();

	public void addStudent(int id, String name, String gender, String stream, int mark);

	public void getStudent(int id);

	public void updateStudent(int id);

	public void deleteStudent(int id);

}
