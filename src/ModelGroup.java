import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ModelGroup {
	HashMap<String, Group> groups = new HashMap<String, Group>();
	public ArrayList<String> storeText = new ArrayList<String>();

	public boolean addGroup(String name, String owner) {
		Group newGroup = new Group();
		newGroup.setName(name);
		newGroup.setOwner(owner);

		if (groups.put(name, newGroup) != null) {
			return true;
		}
		return false;
	}

	public Set<String> getListGroup() {
		return groups.keySet();
	}

	public Group getGroup(String name) {
		return groups.get(name);
	}

	public String appendText(String str, int index) {
		String temp = storeText.get(index);
		temp += (str + "\n\n");
		storeText.set(index, temp);
		return temp;
	}

	public Boolean getConversationText(int index) {
		for (int i = 0; i <= index; i++) {
			try {
				if (!storeText.get(i).equals(null)) {
					continue;
				} else {
					storeText.add(i, "");
				}
			} catch (Exception e) {
				storeText.add(i, "");
			}
		}

		if (storeText.get(index).length() < 0) {
			return false;
		}
		return true;
	}

}
