


public interface FileManagement {
	public UserList loadUsersFromFile(String fileName);
	public boolean saveUsersToFile(String fileName, UserList userList);
}
