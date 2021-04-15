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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.student.Student;
import com.example.student.StudentDao;

@Path("/StudentService")

public class StudentService {

	StudentDao studentDao = new StudentDao();

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Student student) {
		System.out.println("create accessed");
		try {
			studentDao.insert(student);
			return Response.ok().entity(student).build();
		} catch (Exception e) {
			return buildErrorResponse(e);
		}

	}

	private Response buildErrorResponse(Exception e) {
		// TODO Auto-generated method stub
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/all")
	public Response getStudentDetails() {
		System.out.println("getStudentDetails accessed");
		List<Student> allStudents = studentDao.getStudentDetails();
		return Response.ok().entity(allStudents).build();
	}

	@GET
	@Path("/{studentId}")
	public Response getStudentDetail(@PathParam("studentId") int studentId) {
		System.out.println("StudentDetail accessed");
		Student student = studentDao.getStudentById(studentId);
		System.out.println(student);
		return Response.ok().entity(student).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Student student) {
		System.out.println("accessed");
		studentDao.updateStudent(student);
		return Response.ok("successfully updated").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{studentId}")
	public Response delete(@PathParam("studentId") int studentId) {
		System.out.println("delete accessed");
		studentDao.deleteStudent(studentId);
		return Response.ok("Successfully deleted").build();
	}

}
