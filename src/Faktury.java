
public class Faktury {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		Widok widok = new Widok(model);
		Kontroler kontroler = new Kontroler(model, widok);
	}

}
