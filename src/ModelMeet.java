import java.util.ArrayList;

public class ModelMeet {
	private ArrayList<Meeting> meeting = new ArrayList<>();
	
	public void addMeeting(String title, String startDate, String time) {
		Meeting meeting = new Meeting();
		meeting.setTitle(title);
		meeting.setStartDate(startDate);
		meeting.setTime(time);
		this.meeting.add(meeting);
	}

	public ArrayList<Meeting> getMeetingList() {
		return meeting;
	}
}
