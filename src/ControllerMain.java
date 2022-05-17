import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ControllerMain {
	private ViewMain mainView;
	private ViewLogin loginView;
	private ViewSignUp signupView;
	public ControllerMeeting controllerMeet;
	public ControllerGroup controllerGroup;
	public ControllerCourse controllerCourse;
	public ControllerAssignment controllerAssign;
	public ModelUser modelUser = new ModelUser();

	public ControllerMain() {
		controllerMeet = new ControllerMeeting(this);
		controllerGroup = new ControllerGroup(this);
		controllerCourse = new ControllerCourse(this);
		controllerAssign = new ControllerAssignment(this);
	}

	public void showMain() {
		if (mainView == null) {
			mainView = new ViewMain();

			mainView.b1 = new JButton("Schedule Meeting");
			mainView.b1.addActionListener((listener) -> {
				closeMain();
				controllerMeet.showCreateMeet();
			});
			mainView.b2 = new JButton("Upload Assignment");
			mainView.b2.addActionListener((listener) -> {
				closeMain();
				controllerAssign.viewAssignment();
			});
			mainView.b3 = new JButton("View Available Meeting");
			mainView.b3.addActionListener((listener) -> {
				closeMain();
				controllerMeet.showListMeet();
			});
			mainView.b4 = new JButton("Register Course");
			mainView.b4.addActionListener((listener) -> {
				closeMain();
				controllerCourse.showRegisterCourse();
			});
			mainView.b5 = new JButton("Drop Course");
			mainView.b5.addActionListener((listener) -> {
				closeMain();
				controllerCourse.showDropCourse();
			});
			mainView.b6 = new JButton("View Existing Course");
			mainView.b6.addActionListener((listener) -> {
				closeMain();
				controllerCourse.showExistCourse();
			});
			mainView.b7 = new JButton("Submit Assignment");
			mainView.b7.addActionListener((listener) -> {
				closeMain();
				controllerAssign.viewSubmit();
			});
			mainView.b8 = new JButton("Logout");
			mainView.b8.addActionListener((listener) -> {
				closeMain();
				showLogin();
			});
			mainView.b9 = new JButton("Create Group");
			mainView.b9.addActionListener((listener) -> {
				closeMain();
				controllerGroup.showCreate();
			});
			mainView.b10 = new JButton("List Group");
			mainView.b10.addActionListener((listener) -> {
				closeMain();
				controllerGroup.showList();
			});
			mainView.b11 = new JButton("Participate Group");
			mainView.b11.addActionListener((listener) -> {
				closeMain();
				controllerGroup.showParticipate();
			});
			mainView.b12 = new JButton("Course Schedule");
			mainView.b12.addActionListener((listener) -> {
				closeMain();
				controllerCourse.showCourseSchedule();
			});

			if (modelUser.getUserGroup().equals("Instructor")) {
				mainView.getContentPane().add(mainView.b1);
				mainView.getContentPane().add(mainView.b2);
				mainView.getContentPane().add(mainView.b9);
				mainView.getContentPane().add(mainView.b8);
			} else {
				mainView.getContentPane().add(mainView.b6);
				mainView.getContentPane().add(mainView.b4);
				mainView.getContentPane().add(mainView.b5);
				mainView.getContentPane().add(mainView.b12);
				mainView.getContentPane().add(mainView.b9);
				mainView.getContentPane().add(mainView.b10);
				mainView.getContentPane().add(mainView.b11);
				mainView.getContentPane().add(mainView.b3);
				mainView.getContentPane().add(mainView.b7);
				mainView.getContentPane().add(mainView.b8);
			}
		}

		mainView.setVisible(true);
	}

	public void closeMain() {
		if (mainView != null) {
			mainView.dispose();
		}
		mainView = null;
	}

	public void showLogin() {
		if (loginView == null) {
			loginView = new ViewLogin(this);
		}

		loginView.setVisible(true);
	}

	public void closeLogin() {
		if (loginView != null) {
			loginView.dispose();
		}

		loginView = null;
	}

	public void showSignUp() {
		if (signupView == null) {
			signupView = new ViewSignUp(this);
		}

		signupView.setVisible(true);
	}

	public void closeSignup() {
		if (signupView != null) {
			signupView.dispose();
		}

		signupView = null;
	}

	public boolean authorizeUser(String name, String password) {
		if (!modelUser.getUserList().containsKey(name)
				|| !modelUser.getUserList().get(name).getPassword().equals(password))
			return false;

		modelUser.setUserGroup(modelUser.getCurrentUserGroup(name));
		return true;
	}

	public boolean createUser(String name, String password, String position) {
		return modelUser.createUser(name, password, position);
	}

	public static void main(String[] args) {
		ControllerMain controller = new ControllerMain();
		controller.showLogin();
	}

}