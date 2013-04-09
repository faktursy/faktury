import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Kontroler {
	private Model model;
	private Widok widok;
	
	public Kontroler(Model model, Widok widok) {
		// TODO Auto-generated constructor stub

		widok.addQuitListener(new QuitListener(model, widok));
		widok.addAddUserListener(new AddUserListener(model, widok));
		widok.addRemoveUserListener(new RemoveUserListener(model, widok));
		widok.addSelectUserListener(new SelectUserListener(model, widok));
		
		model.loadUsersFromXmlFile();
		widok.setUsers(model.getUsers());
	}

}

abstract class Listener implements ActionListener {
	protected Model model;
	protected Widok widok;
	public Listener(Model model, Widok widok) {
		this.model = model;
		this.widok = widok;
	}
}

class AddUserListener extends Listener implements ActionListener {

	public AddUserListener(Model model, Widok widok) {
		super(model,widok);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// to do adduserwindow
		
		String newUsername = JOptionPane.showInputDialog(null,
				"Podaj nazwê nowego u¿ytkownika",
				"Dodawanie u¿ytkownika",
				1);
		
		if (newUsername!=null)
			if (newUsername.equals(""))
				JOptionPane.showMessageDialog(null,
						"Nazwa nieprawid³owa",
						"Warning",
						JOptionPane.OK_OPTION);
			else {
				System.out.println(newUsername);
				model.addUser(newUsername);
				widok.setUsers(model.getUsers());
				model.saveUsersToXmlFile();
			}
	}
	
}

class RemoveUserListener extends Listener implements ActionListener {
	public RemoveUserListener(Model model, Widok widok) {
		super(model, widok);
	}

	public void actionPerformed(ActionEvent e) {
		String user = widok.getSelectedUser();
		int dialogButton = JOptionPane.YES_NO_OPTION;
		if (user!=null) {
			int dialogResult = JOptionPane.showConfirmDialog (null,
					"Na pewno chcesz usun¹æ tego u¿ytkownika? (" + user +")",
					"Warning",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				model.removeUser(user);
				widok.setUsers(model.getUsers());
				model.saveUsersToXmlFile();
			}
	}
	}
}

class QuitListener extends Listener implements ActionListener {
	
	public QuitListener(Model model, Widok widok) {
		super(model, widok);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}

class SelectUserListener extends Listener implements ActionListener {
	
	public SelectUserListener (Model model, Widok widok) {
		super(model, widok);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.setCurrentUser(widok.getSelectedUser());
		widok.setMainWindow();
		widok.setUser(model.getCurrentUser().getName());
	}
	
	
}
