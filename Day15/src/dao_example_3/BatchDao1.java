package dao_example_3;

public interface BatchDao1 {

	public void getBatchStrength();

	public void getBatchPaymentStatus();

	public void addBatch(int courseId, String courseName, int courseFee);

}
