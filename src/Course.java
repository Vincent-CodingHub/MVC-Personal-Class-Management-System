
public class Course {
	private String course_code, course_name, credit_hour, course_set, time_slot;
	
	public Course() {};
	
	public void setCourseCode(String course_code) {
		this.course_code = course_code;
	}
	
	public String getCourseCode() {
		return course_code;
	}
	
	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}
	
	public String getCourseName() {
		return course_name;
	}
	
	public void setCreditHour(String credit_hour) {
		this.credit_hour = credit_hour;
	}
	
	public String getCreditHour() {
		return credit_hour;
	}
	
	public void setCourseSet(String course_set) {
		this.course_set = course_set;
	}
	
	public String getCourseSet() {
		return course_set;
	}
	
	public void setTimeSlot(String time_slot) {
		this.time_slot = time_slot;
	}
	
	public String getTimeSlot() {
		return time_slot;
	}
}
