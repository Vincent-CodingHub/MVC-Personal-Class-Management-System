import java.util.ArrayList;

public class ModelCourse {
	private ArrayList<Course> courses = new ArrayList<>();

	public void addCourse(String courseCode, String courseName, String creditHour, String set, String timeSlot) {
		Course course = new Course();
		course.setCourseCode(courseCode);
		course.setCourseName(courseName);
		course.setCreditHour(creditHour);
		course.setCourseSet(set);
		course.setTimeSlot(timeSlot);
		courses.add(course);
	}

	public Boolean checkDuplicateCourse(String courseCode) {
		for (Course course : courses) {
			if (course.getCourseCode().equals(courseCode)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Course> getRegisteredCourseList() {
		return courses;
	}

	public void dropCourse(String course_code, String course_name, String credit_hour, String set,
			String time_slot) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(course_code)) {
				courses.remove(i);
				break;
			}
		}
	}
}
