import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Widok {
	private Model model;
	private UserMenu userMenu = new UserMenu();
	private Okno okno;
	
	
	
	public Widok(Model model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
	
	public void setUser(String name) {
		userMenu.setUser(name);
	}
	public boolean setUsers(ArrayList<String> Users) {
		userMenu.setUsers(Users);
		return true;
	}
	public String getSelectedUser() {
		return userMenu.getSelectedUser();
	}
	
	public void addQuitListener(ActionListener quitListener) {
		userMenu.addQuitListener(quitListener);
	}
	public void addAddUserListener(ActionListener addUserListener) {
		userMenu.addAddUserListener(addUserListener);
	}
	public void addRemoveUserListener(ActionListener removeUserListener) {
		userMenu.addRemoveUserListener(removeUserListener);
	}

	public void addSelectUserListener(ActionListener selectUserListener) {
		// TODO Auto-generated method stub
		userMenu.addSelectUserListener(selectUserListener);
	}

	public void setMainWindow() {
		// TODO Auto-generated method stub
		userMenu.dispose();
		okno = new Okno();
		
	}

}
