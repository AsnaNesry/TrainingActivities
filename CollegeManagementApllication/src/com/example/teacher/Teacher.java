package com.example.teacher;

public class Teacher {
	private int teacherId;
	private String name;
	private String designation;
	private int batchId;

	public Teacher() {
	}

	public Teacher(int teacherId, String name, String designation, int batchId) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.designation = designation;
		this.batchId = batchId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "TeacherDetails [teacherId=" + teacherId + ", name=" + name + ", designation=" + designation
				+ ", batchId=" + batchId + "]";
	}

}
