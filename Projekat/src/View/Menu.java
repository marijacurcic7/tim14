package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Model.Korisnik;
import Model.TipKorisnika;

public class Menu extends JMenuBar {
	
	JMenu login;
	
	public Menu() {
		this.login = new JMenu("Log In");
		add(login);
	}

}
