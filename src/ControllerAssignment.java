import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ControllerAssignment {
	private ViewAssignmentList view_assignmentList;
	private ViewSubmitAssignment view_submitAssignment;
	public ControllerMain controllerMain;
	public ModelAssignment model_assignment;

	public ControllerAssignment(ControllerMain controller) {
		controllerMain = controller;
		model_assignment = new ModelAssignment();
	}

	public void viewAssignment() {
		if (view_assignmentList == null) {
			view_assignmentList = new ViewAssignmentList(this);
		}
		view_assignmentList.setVisible(true);
	}

	public void closeAssignment() {
		if (view_assignmentList != null) {
			view_assignmentList.dispose();
		}
		view_assignmentList = null;
	}

	public void viewSubmit() {
		if (view_submitAssignment == null) {
			view_submitAssignment = new ViewSubmitAssignment(this);
			printTable();
		}
		view_submitAssignment.setVisible(true);
	}

	public void closeSubmit() {
		if (view_submitAssignment != null) {
			view_submitAssignment.dispose();
		}
		view_submitAssignment = null;
	}

	public void uploadAssignment() {
		Assignment work = new Assignment();
		work.setCourseCode(view_assignmentList.txt_courseCode.getText());
		work.setCourseName(view_assignmentList.txt_courseName.getText());
		work.setTitle(view_assignmentList.txt_title.getText());
		work.setDueDate(view_assignmentList.txt_date.getText());
		work.setStatus("Not submitted");
		work.setFileName(view_assignmentList.lbl_addFile.getText());
		model_assignment.uploadAssignment(work);
	}

	public void printTable() {
		DefaultTableModel model = this.view_submitAssignment.getModel();
		ArrayList<Assignment> assignmentList = model_assignment.getAssignment();
		for (Assignment work : assignmentList) {
			String temp[] = { work.getCourseCode(), work.getCourseName(), work.getTitle(), work.getFileName(),
					work.getDueDate(), work.getStatus() };
			model.addRow(temp);
		}
	}

	public void submitAssignment() {
		DefaultTableModel model = view_submitAssignment.getModel();
		int i = view_submitAssignment.getSelectedRowNo();
		String course_code = model.getValueAt(i, 0).toString();
		String course_name = model.getValueAt(i, 1).toString();
		String title = model.getValueAt(i, 2).toString();
		String dueDate = model.getValueAt(i, 3).toString();
		String fileName = model.getValueAt(i, 4).toString();

		model_assignment.submitAssignment(course_code, course_name, title, dueDate, fileName);

		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}

		ArrayList<Assignment> assignmentlist = model_assignment.getAssignment();
		for (Assignment work : assignmentlist) {
			String temp[] = { work.getCourseCode(), work.getCourseName(), work.getTitle(), work.getFileName(),
					work.getDueDate(), work.getStatus() };
			model.addRow(temp);
		}
	}
}
