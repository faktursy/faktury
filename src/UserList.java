import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserList {
	private ArrayList<User> users = new ArrayList<User>();
	
	@XmlElement
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User selectUser(String userName) {
		User user=null;
		for (User u: users)
			if (u.getName().equals(userName))
				user=u;
		return user;
	}
	
	public boolean addUser(String name) {
		if (!userExists(name)) {
			User newUser = new User(name);
			users.add(newUser);
		}
		return true;
	}
	public boolean removeUser(String name) {
		User user = selectUser(name);
		if (user!=null)
			users.remove(user);
		return true;
	}
	
	private boolean userExists(String name) {
		boolean exists = false;
		for (User u:users)
			if (u.getName().equals(name))
				exists=true;
		return exists;
	}
	
}
