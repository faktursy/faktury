import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Okno extends JFrame{
	private JPanel content;
	private JButton exitButton;

	
	public Okno() {
		this.setSize(500,400);
		this.setTitle("Faktury 2013");
		this.setVisible(true);
		
		content = new JPanel();
		
		exitButton = new JButton("Wyjœcie");
		
		content.add(exitButton);
		this.add(content);
		

	}
}


