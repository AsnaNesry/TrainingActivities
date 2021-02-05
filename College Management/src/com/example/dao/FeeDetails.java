package com.example.dao;

public class FeeDetails {
	private int payment_id;
	private int student_id;
	private String payment_status;
	private int payment_amount;
	private int batch_id;

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	@Override
	public String toString() {
		return "fee_details [payment_id=" + payment_id + ", student_id=" + student_id + ", payment_status="
				+ payment_status + ", payment_amount=" + payment_amount + ", batch_id=" + batch_id + "]";
	}

}
