import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class ControllerMeeting {
	private ViewMeetCreate meetCreate;
	private ViewMeetList meetList;
	private ViewMeetRoom meetRoom;
	private ControllerMain controller;
	private ModelMeet model = new ModelMeet();

	public ControllerMeeting(ControllerMain controller) {
		this.controller = controller;
	}

	public void showCreateMeet() {
		if (meetCreate == null) {
			meetCreate = new ViewMeetCreate(this);
		}

		meetCreate.setVisible(true);
	}

	public void closeCreateMeet() {
		if (meetCreate != null) {
			meetCreate.dispose();
		}
		meetCreate = null;
	}

	public void showListMeet() {
		if (meetList == null) {
			meetList = new ViewMeetList(this);

			ArrayList<Meeting> meetingList = model.getMeetingList();
			for (Meeting m : meetingList) {
				String[] row = { m.getTitle(), m.getStartDate(), m.getTime() };
				meetList.getModel().addRow(row);
			}
		}

		meetList.setVisible(true);
	}

	public void closeListMeet() {
		if (meetList != null) {
			meetList.dispose();
		}

		meetList = null;
	}

	public void closeMeetRoom() {
		if (meetRoom != null) {
			meetRoom.dispose();
		}
		meetRoom = null;
	}

	public void showMain() {
		controller.showMain();
	}

	public void addMeeting() {
		model.addMeeting(meetCreate.txt_title.getText(), meetCreate.txt_startTime.getText(),
				meetCreate.txt_startDate.getText());
		String temp[] = { meetCreate.txt_title.getText(), meetCreate.txt_startTime.getText(),
				meetCreate.txt_startDate.getText() };
		meetCreate.getModel().addRow(temp);
	}

	public void joinMeeting() {
		meetRoom = new ViewMeetRoom(this);
		meetRoom.setVisible(true);
	}

	public void showNotification() {
		ArrayList<Meeting> meetList = model.getMeetingList();
		Meeting meeting = meetList.get(meetList.size() - 1);

		if (meeting != null) {
			Timer timer = new Timer(true);
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					String message = "You have a pending meeting \n" + meeting.getTitle() + "\n"
							+ meeting.getStartDate() + "\n" + meeting.getTime();

					JOptionPane.showMessageDialog(null, message);
					System.out.println(meeting);
				}
			}, 5 * 1000);

		}
	}

}
