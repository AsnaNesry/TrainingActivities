package com.example.dao;

public class TeacherDetails {
	private int teacherId;
	private String name;
	private int designation;
	private int batchId;

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

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
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
