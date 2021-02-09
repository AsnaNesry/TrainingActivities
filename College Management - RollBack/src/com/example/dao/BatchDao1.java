package com.example.dao;

public interface BatchDao1 {

	public void getBatchStrength();

	public void getBatchPaymentStatus();

	public void addBatch(int batchId, String batchName, int fee);

}
