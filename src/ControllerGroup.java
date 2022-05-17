import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerGroup {
	private ViewGroupCreate view_create;
	private ViewGroupList view_list;
	private ViewGroupParticipate view_parti;
	private ViewGroupDiscussion view_room;
	private ControllerMain controllerMain;
	private ModelGroup model_group = new ModelGroup();

	public ControllerGroup(ControllerMain controller) {
		controllerMain = controller;
	}

	public Object[] getUsersKey() {
		return controllerMain.modelUser.getUsers().toArray();
	}

	public boolean addGroup(String name, String owner) {
		return model_group.addGroup(name, owner);
	}

	public void showMain() {
		controllerMain.showMain();
	}

	public void showCreate() {
		// to prevent create duplicate window
		if (view_create == null) {
			view_create = new ViewGroupCreate(this);
		}
		view_create.setVisible(true);
	}

	public void closeCreate() {
		// to make sure we dispose non null frame
		if (view_create != null) {
			view_create.dispose();
		}
		view_create = null;
	}

	public void showList() {
		// to prevent create duplicate window
		if (view_list == null) {
			view_list = new ViewGroupList(this);
			setModel(view_list.getModel());
		}
		view_list.setVisible(true);
	}

	public void closeList() {
		// to make sure we dispose non null frame
		if (view_list != null) {
			view_list.dispose();
		}
		view_list = null;
	}

	public void showParticipate() {
		// to prevent create duplicate window
		if (view_parti == null) {
			view_parti = new ViewGroupParticipate(this);
			setModel(view_parti.getModel());
		}
		view_parti.setVisible(true);
	}

	public void showGroupRoom() {
		if (view_room == null) {
			view_room = new ViewGroupDiscussion(this, view_parti.group_name, view_parti.getIndex());
		}
		if (model_group.getConversationText(view_room.index)) {
			view_room.textPane.setText(model_group.storeText.get(view_room.index));
		}
		view_room.setVisible(true);
	}

	public void closeParticipate() {
		// to make sure we dispose non null frame
		if (view_parti != null) {
			view_parti.dispose();
		}
		view_parti = null;
	}

	public void closeGroupRoom() {
		if (view_room != null) {
			view_room.dispose();
		}
		view_room = null;
	}

	// fill model to DefaultTableModel
	public void setModel(DefaultTableModel model) {
		Set<String> keys = this.model_group.getListGroup();

		for (String key : keys) {
			Group group = this.model_group.getGroup(key);
			model.addRow(new String[] { group.getName(), group.getOwner() });
		}
	}

	public String appendText() {
		return model_group.appendText(view_room.textBox.getText(), view_room.index);
	}

	public void showNotification() {
		Set<String> groupList = model_group.getListGroup();
		String groupId = (String) groupList.toArray()[0];

		if (groupId != null) {
			Timer timer = new Timer(true);
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					Group group = model_group.getGroup(groupId);
					String message = "You have a replied on " + group.getName();
					JOptionPane.showMessageDialog(null, message);
					System.out.println(group);
				}
			}, 5 * 1000);

		}
	}

}
