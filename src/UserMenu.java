import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class UserMenu extends JFrame{
	private JPanel contentPanel;
	private JComboBox<String> usersComboBox;
	private JButton addUserButton, removeUserButton, exitButton, submitUserButton;
	
	public UserMenu() {
		this.setSize(500,400);
		this.setTitle("Faktury 2013");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPanel = new JPanel();
		contentPanel.setSize(500,400);
		
		usersComboBox = new JComboBox<String>();
		addUserButton = new JButton("Dodaj");
		removeUserButton = new JButton("Usuñ");
		submitUserButton = new JButton("Wybierz");
		exitButton = new JButton("Wyjœcie");
		
		contentPanel.add(usersComboBox);
		contentPanel.add(addUserButton);
		contentPanel.add(removeUserButton);
		contentPanel.add(submitUserButton);
		contentPanel.add(exitButton);
		
		//this.add(contentPanel);
		//contentPanel.setVisible(true);
		this.setContentPane(contentPanel);
		
		//this.pack();

	}
	public boolean setUsers(ArrayList<String> Users) {
		usersComboBox.removeAllItems();
		for (String user: Users)
			usersComboBox.addItem(user);
		return true;
	}
	public String getSelectedUser() {
		return (String) usersComboBox.getSelectedItem();
		//return usersComboBox.getItemAt(usersComboBox.getSelectedIndex());
	}
	
	public void addQuitListener(ActionListener quitListener) {
		exitButton.addActionListener(quitListener);
	}
	public void addAddUserListener(ActionListener addUserListener) {
		addUserButton.addActionListener(addUserListener);
	}
	public void addRemoveUserListener(ActionListener removeUserListener) {
		removeUserButton.addActionListener(removeUserListener);
	}
	public void addSelectUserListener(ActionListener selectUserListener) {
		// TODO Auto-generated method stub
		submitUserButton.addActionListener(selectUserListener);
		
	}
}