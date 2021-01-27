package dao_example_3;

public class TeacherDetails {
	private int teacherId;
	private String name;
	private int contact;
	private int courseId;

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

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "TeacherDetails [teacherId=" + teacherId + ", name=" + name + ", contact=" + contact + ", courseId="
				+ courseId + "]";
	}

}
