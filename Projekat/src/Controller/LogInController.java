package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;

import Model.Korisnik;
import Model.Nalog;
import View.LogInView;
import View.RegistracijaView;

public class LogInController {
	
	private LogInView loginv;
	private String korisnickoIme;
	private String lozinka;
	
	public LogInController(LogInView lv) {
		this.loginv = lv;
		//this.loginv.btnReg.addActionListener(new ActionListener() {

		/*@Override
		public void actionPerformed(ActionEvent e) {
				//loginv.setVisible(false);
				RegistracijaView rv = new RegistracijaView();
				lv.add(rv);
				rv.setVisible(true);
				
			}
		});*/
	}
	
	public void login(String kime, String lozinka) {
		this.korisnickoIme = kime;
		this.lozinka = lozinka;
	}

	public LogInView getLoginv() {
		return loginv;
	}

	public void setLoginv(LogInView loginv) {
		this.loginv = loginv;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	

}
