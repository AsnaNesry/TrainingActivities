package com.example.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.teacher.Teacher;
import com.example.teacher.TeacherDao;

@Path("/TeacherService")
public class TeacherService {

	TeacherDao teacherDao = new TeacherDao();
	Teacher teacher = new Teacher();

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Teacher teacher) {
		System.out.println(teacher);

		teacherDao.insert(teacher);
		return Response.status(200).entity(teacher).build();

	}

	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public List<Teacher> getAllStudents(@Context HttpHeaders headers) {
		System.out.println("accessed");
		List<Teacher> teacher = teacherDao.getTeacherDetails();
		return teacher;
	}

	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{teacher_id1}")
	public void update(@PathParam("teacher_id") int teacher_id) {
		System.out.println("accessed");
		teacherDao.updateTeacher(teacher_id);
		return;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{teacher_id}")
	public void delete(@PathParam("teacher_id") int teacher_id) {
		System.out.println("accessed");
		teacherDao.deleteTeacher(teacher_id);
		return;

	}

}