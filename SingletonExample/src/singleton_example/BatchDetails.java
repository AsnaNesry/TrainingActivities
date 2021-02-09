package singleton_example;

public class BatchDetails {

	private int course_id;

	private String course_name;
	private int course_fee;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(int course_fee) {
		this.course_fee = course_fee;
	}

	@Override
	public String toString() {
		return "BatchDetails [course_id=" + course_id + ", course_name=" + course_name + ", course_fee=" + course_fee
				+ "]";
	}

}
