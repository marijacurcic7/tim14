package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.TipKorisnika;
import View.AdminView;
import View.KupacView;
import View.LogInView;
import View.MenadzerView;
import View.ProizvodiView;
import View.RegistracijaView;

public class LogInController {
	
	private LogInView loginv;
	private String korisnickoIme;
	private String lozinka;
	private AplikacijaPreduzece preduzece;
	
	public LogInController(LogInView lv, AplikacijaPreduzece preduzece) {
		this.loginv = lv;
		this.preduzece = preduzece;
		
		addListeners();
	}
	
	
	private void addListeners() {
		
		loginv.btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					RegistracijaView rv = new RegistracijaView(preduzece, loginv.getFrame());
					loginv.add(rv);
					loginv.remove(0);
					loginv.updateUI();
					
				}
		});
		
		loginv.btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok1();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});
	}

	
	private void ok1()  throws IOException {
		
		String kime = loginv.getTfkorisnicko().getText();
		String lozinka = loginv.getTflozinka().getText();
		login(kime, lozinka);
		
		boolean ulogovan = preduzece.login(kime, lozinka);
		
		
		if(ulogovan == false) {
			String message = "Pogresno uneto korisnicko ime ili lozinka. Pokusajte ponovo.";
			JOptionPane.showMessageDialog(loginv, message);
		}
		else {
			
			if (loginv.getPreduzece().trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.kupac) {
			
				KupacView kv = new KupacView(preduzece, loginv.getFrame());
				
				loginv.getFrame().getHeader().getPrijava().setVisible(false);
				loginv.getFrame().getHeader().getOdjava().setVisible(true);
				loginv.getFrame().getHeader().updateUI();
				
				loginv.getFrame().getCentralni().add(kv);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
			}
			
			else if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.menadzer) {
				
				MenadzerView mv = new MenadzerView(preduzece, loginv.getFrame());
				
				loginv.getFrame().getHeader().getOdjava().setVisible(true);
				loginv.getFrame().getHeader().getKorpa().setVisible(false);
				loginv.getFrame().getHeader().updateUI();
				loginv.getFrame().getCentralni().add(mv);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
			}
			else  {
				AdminView av = new AdminView(preduzece, loginv.getFrame());
				
				loginv.getFrame().getHeader().getPrijava().setVisible(false);
				loginv.getFrame().getHeader().getOdjava().setVisible(true);
				loginv.getFrame().getHeader().getKorpa().setVisible(false);
				loginv.getFrame().getHeader().updateUI();
				loginv.getFrame().getCentralni().add(av);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
			}
		}

	}
	

	private void ok() throws IOException {
		
		String kime = loginv.getTfkorisnicko().getText();
		String lozinka = loginv.getTflozinka().getText();
		login(kime, lozinka);
		
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
