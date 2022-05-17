import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ControllerCourse {
	private ViewExistingCourse viewExistCourse;
	private ViewCourseDrop viewDropCourse;
	private ViewCourseRegister viewRegisterCourse;
	private ViewCourseSchedule viewCourseSchedule;
	private ControllerMain controller;
	public ModelCourse model_course = new ModelCourse();

	public ControllerCourse(ControllerMain controller) {
		this.controller = controller;
	}

	public void showMain() {
		controller.showMain();
	}

	public void showExistCourse() {
		if (viewExistCourse == null) {
			viewExistCourse = new ViewExistingCourse(this);
		}

		ArrayList<Course> registeredCourse = model_course.getRegisteredCourseList();
		for (Course course : registeredCourse) {
			String temp[] = { course.getCourseCode(), course.getCourseName(), course.getCreditHour(),
					course.getCourseSet(), course.getTimeSlot() };
			viewExistCourse.getModel().addRow(temp);
		}

		viewExistCourse.setVisible(true);
	}

	public void showDropCourse() {
		if (viewDropCourse == null) {
			viewDropCourse = new ViewCourseDrop(this);
		}
		ArrayList<Course> registeredCourse = model_course.getRegisteredCourseList();
		for (Course course : registeredCourse) {
			String temp[] = { course.getCourseCode(), course.getCourseName(), course.getCreditHour(),
					course.getCourseSet(), course.getTimeSlot() };
			viewDropCourse.getModel().addRow(temp);
		}

		viewDropCourse.setVisible(true);
	}

	public void showRegisterCourse() {
		if (viewRegisterCourse == null) {
			viewRegisterCourse = new ViewCourseRegister(this);
		}
		String storeCourseInformation[][] = { { "TTTT1964", "DATABASE", "4", "2", "MONDAY 0800-1000" },
				{ "TTTK1143", "PROGRAMMING", "3", "1", "MONDAY 1000-1200" },
				{ "TTTK2103", "NETWORKING", "3", "1", "MONDAY 1200-1400" },
				{ "TTTU2983", "ADVANCED DATABASE", "3", "1", "MONDAY 1400-1600" },
				{ "TTTC2453", "MACHINE LEARNING", "3", "3", "MONDAY 1600-1800" },
				{ "CHIN101", "CHINESE", "4", "3", "TUESDAY 0800-1000" },
				{ "COMM102", "COMMUNICATION SKILLS", "3", "4", "TUESDAY 1000-1200" },
				{ "COOK121", "COOK ISLANDS MAORI", "2", "2", "TUESDAY 1200-1400" },
				{ "ENGL101", "ENGLISH", "1", "3", "TUESDAY 1400-1600" },
				{ "NZSL101", "NEW ZEALAND SIGN", "3", "3", "TUESDAY 1600-1800" },
				{ "INDO103", "INDONESIAN", "2", "3", "WEDNESDAY 0800-1000" },
				{ "GERM201", "GERMAN", "2", "3", "WEDNESDAY 1000-1200" },
				{ "JAPA101", "JAPANESE", "2", "4", "WEDNESDAY 1200-1400" },
				{ "KIRI101", "KIRIBATI", "2", "3", "WEDNESDAY 1400-1600" },
				{ "LATI121", "LATIN", "2", "3", "WEDNESDAY 1600-1800" },
				{ "VANU110", "VANUATU", "1", "2", "THURSDAY 0800-1000" },
				{ "SAMO110", "SAMOAN", "2", "4", "THURSDAY 1000-1200" },
				{ "TECN110", "TECHNOLOGY", "1", "2", "THURSDAY 1200-1400" },
				{ "BITE111", "BIOTECHNOLOGY", "2", "3", "THURSDAY 1400-1600" },
				{ "ELTE110", "ELECTRONICS AND CONTROL", "2", "1", "THURSDAY 1600-1800" },
				{ "SOST110", "SOCIAL STUDIES", "2", "4", "FRIDAY 0800-1000" },
				{ "HEPH110", "HEALTH AND PHYSICAL EDUCATION", "1", "2", "FRIDAY 1000-1200" },
				{ "HOME110", "HOME ECONOMICS", "2", "4", "FRIDAY 1200-1400" },
				{ "AGBU110", "AGRIBUSINESS", "2", "4", "FRIDAY 1400-1600" },
				{ "FOTY110", "FORESTRY", "1", "4", "FRIDAY 1600-1800" } };

		for (int i = 0; i < storeCourseInformation.length; i++) {
			viewRegisterCourse.getModel().addRow(storeCourseInformation[i]);
		}
		viewRegisterCourse.setVisible(true);
	}

	public void showCourseSchedule() {
		if (viewCourseSchedule == null) {
			viewCourseSchedule = new ViewCourseSchedule(this);
			printTable();
		}
		viewCourseSchedule.setVisible(true);
	}

	public void closeCourseSchedule() {
		if (viewCourseSchedule != null) {
			viewCourseSchedule.dispose();
		}

		viewCourseSchedule = null;
	}

	public void closeExistCourse() {
		if (viewExistCourse != null) {
			viewExistCourse.dispose();
		}

		viewExistCourse = null;
	}

	public void closeDropCourse() {
		if (viewDropCourse != null) {
			viewDropCourse.dispose();
		}

		viewDropCourse = null;
	}

	public void closeRegisterCourse() {
		if (viewRegisterCourse != null) {
			viewRegisterCourse.dispose();
		}

		viewRegisterCourse = null;
	}

	public void dropCourse() {
		model_course.dropCourse(viewDropCourse.txt_courseCode.getText(), viewDropCourse.txt_courseName.getText(),
				viewDropCourse.txt_creditHour.getText(), viewDropCourse.txt_set.getText(),
				viewDropCourse.txt_timeSlot.getText());

		DefaultTableModel model = viewDropCourse.getModel();
		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}

		ArrayList<Course> registeredCourse = model_course.getRegisteredCourseList();
		for (Course course : registeredCourse) {
			String temp[] = { course.getCourseCode(), course.getCourseName(), course.getCreditHour(),
					course.getCourseSet(), course.getCreditHour() };
			model.addRow(temp);
		}
	}

	public void addCourse() {
		model_course.addCourse(viewRegisterCourse.txt_courseCode.getText(), viewRegisterCourse.txt_courseName.getText(),
				viewRegisterCourse.txt_creditHour.getText(), viewRegisterCourse.txt_set.getText(),
				viewRegisterCourse.txt_timeSlot.getText());
	}

	public Boolean checkDuplicateCourse() {
		if (!model_course.checkDuplicateCourse(viewRegisterCourse.txt_courseCode.getText())) {
			return true;
		}
		return false;
	}

	public void printTable() {
		DefaultTableModel model = this.viewCourseSchedule.getModel();

		String[][] time_row = { { "MONDAY", "", "", "", "", "" }, { "TUESDAY", "", "", "", "", "" },
				{ "WEDNESDAY", "", "", "", "", "" }, { "THURSDAY", "", "", "", "", "" },
				{ "FRIDAY", "", "", "", "", "" } };

		ArrayList<Course> registeredCourse = model_course.getRegisteredCourseList();
		for (Course course : registeredCourse) {
			String time_slot[] = course.getTimeSlot().split(" ");
			int temp = 0;
			if (time_slot[1].equals("0800-1000")) {
				temp = 1;
			} else if (time_slot[1].equals("1000-1200")) {
				temp = 2;
			} else if (time_slot[1].equals("1200-1400")) {
				temp = 3;
			} else if (time_slot[1].equals("1400-1600")) {
				temp = 4;
			} else if (time_slot[1].equals("1600-1800")) {
				temp = 5;
			}

			for (int i = 0; i < time_row.length; i++) {
				if (time_row[i][0].equals(time_slot[0])) {
					time_row[i][temp] = course.getCourseCode() + " " + course.getCourseName();
					break;
				}
			}
		}
		for (int i = 0; i < time_row.length; i++) {
			model.addRow(time_row[i]);
		}
	}

}
