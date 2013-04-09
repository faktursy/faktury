import java.util.ArrayList;



public class Model {
	private UserList userList = new UserList();
	private User currentUser;
	private final String USERS_FILE = "users.xml";
	
	public boolean loadUsersFromXmlFile() {
		XmlFileManagement fileManager = new XmlFileManagement();
		this.userList = fileManager.loadUsersFromFile(this.USERS_FILE);
		return true;
	}
	public boolean saveUsersToXmlFile() {
		XmlFileManagement fileManager = new XmlFileManagement();
		fileManager.saveUsersToFile(this.USERS_FILE, userList);
		return true;
	}
	public boolean addUser(String name) {
		userList.addUser(name);
		return true;
	}
	public boolean removeUser(String name) {
		userList.removeUser(name);
		return true;
	}
	public ArrayList<String> getUsers() {
		ArrayList<String> users = new ArrayList<String>();
		for (User u : userList.getUsers())
			users.add(u.getName());
		return users;
	}
	public void setCurrentUser(String userName) {
		this.currentUser = userList.selectUser(userName);
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void clearCurrentUser() {
		this.currentUser = null;
	}
}
