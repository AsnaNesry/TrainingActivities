package com.example.batch;

public interface IBatch {

	public int getBatchStrength();

	public void getBatchPaymentStatus();

	public void addBatch(int batchId, String batchName, int fee);

}
