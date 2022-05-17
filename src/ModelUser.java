import java.util.HashMap;
import java.util.Set;

public class ModelUser {
	private HashMap<String, User> userList = new HashMap<>();
	private String userGroup;

	public HashMap<String, User> getUserList() {
		return userList;
	}

	public String getCurrentUserGroup(String username) {
		return userList.get(username).getPosition();
	}
	
	public boolean createUser(String name, String password, String position) {
		User newUser = new User();
		newUser.setName(name);
		newUser.setPassword(password);
		newUser.setPosition(position);

		if (userList.containsKey(name)) {
			return false;
		}
		userList.put(name, newUser);
		return true;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String group) {
		userGroup = group;
	}

	public Set<String> getUsers() {
		return userList.keySet();
	}
}
