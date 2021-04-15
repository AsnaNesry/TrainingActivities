package com.example.teacher;

import java.util.List;

public interface ITeacher {

	public void updateTeacher(int teacher_id);

	public void deleteTeacher(int teacher_id);

	public List<Teacher> insert(Teacher teacher);

	public List<Teacher> getTeacherDetails();

}
