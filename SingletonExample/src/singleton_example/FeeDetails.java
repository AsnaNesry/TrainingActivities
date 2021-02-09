package singleton_example;

public class FeeDetails {
	private int student_id;

	private int course_id;
	private String payment_received;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getPayment_received() {
		return payment_received;
	}

	public void setPayment_received(String payment_received) {
		this.payment_received = payment_received;
	}

	@Override
	public String toString() {
		return "FeeDetails [student_id=" + student_id + ", course_id=" + course_id + ", payment_received="
				+ payment_received + "]";
	}

}
