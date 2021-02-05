package com.example.dao;

public class BatchDetails {

	private int batch_id;
	private String batch_name;
	private int fee;

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getBatch_name() {
		return batch_name;
	}

	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "BatchDetails [batch_id=" + batch_id + ", batch_name=" + batch_name + ", fee=" + fee + "]";
	}

}
