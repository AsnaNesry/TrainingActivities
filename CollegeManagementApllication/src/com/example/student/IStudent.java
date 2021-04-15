package com.example.student;

import java.util.List;

public interface IStudent {

	public List<Student> insert(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int student_id);

	public List<Student> getStudentDetails();

	public Student getStudentById(int student_id);

}
