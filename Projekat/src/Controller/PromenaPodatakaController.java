package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Nalog;
import Model.RegistrovaniKupac;
import Model.TipKorisnika;
import View.PromenaPodatakaView;

public class PromenaPodatakaController {
	
	PromenaPodatakaView ppview;
	AplikacijaPreduzece preduzece;
	boolean promenjen;
	
	public PromenaPodatakaController(PromenaPodatakaView ppv, AplikacijaPreduzece preduzece) {
		this.ppview = ppv;
		this.preduzece = preduzece;
		this.promenjen = false;
		
		ppview.getBtnOK().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
				ok();
					
					
				}
		});

		
	}

	protected void ok() {
		Window parent = SwingUtilities.getWindowAncestor(ppview);

		String lozinka = ppview.getTflozinka().getText();
		String ime = ppview.getTfime().getText();
		String prezime = ppview.getTfprezime().getText();
		String email = ppview.getTfemail().getText();
		String telefon = ppview.getTftelefon().getText();
		
		String message = promeni(lozinka, ime, prezime, email, telefon, ppview.getTfgrad().getText(), ppview.getTfdrzava().getText(), ppview.getTfadresa().getText());
		String title = "Greska";
		
		JOptionPane.showMessageDialog(parent, message);
		if (isPromenjen()){
			ppview.getBtnOK().addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, ppview.getFrame());
			    	
					ppview.add(ppv);
					ppview.remove(0);
					ppview.updateUI();
			    }
			}); 
			
		}
		
	}

	public String promeni(String lozinka, String ime, String prezime, String email, String telefon, String grad,
			String drzava, String adresa) {
		if (lozinka == null) {
			return "Unesite lozinku";
		}
		lozinka = lozinka.trim();
		if (lozinka.isEmpty()) {
			return "Unesite lozinku";
		}
		
		if (ime == null) {
			return "Unesite ime";
		}
		ime = ime.trim();
		if (ime.isEmpty()) {
			return "Unesite ime";
		}
		
		if (prezime == null) {
			return "Unesite prezime";
		}
		prezime = prezime.trim();
		if (prezime.isEmpty()) {
			return "Unesite prezime";
		}
		
		if (email == null) {
			return "Unesite e-mail";
		}
		email = email.trim();
		if (email.isEmpty()) {
			return "Unesite e-mail";
		}
		
		Mesto mesto = new Mesto(grad, drzava, adresa);
		
		preduzece.trenutnoUlogovani.nalog.setLozinka(lozinka);
		preduzece.trenutnoUlogovani.nalog.seteMail(email);
		preduzece.trenutnoUlogovani.setIme(ime);
		preduzece.trenutnoUlogovani.setPrezime(prezime);
		preduzece.trenutnoUlogovani.setTelefon(telefon);
		preduzece.trenutnoUlogovani.setMesto(mesto);
		
		promenjen = true;

		
		return "Promena podataka je izvrsena";
	}

	public PromenaPodatakaView getPpview() {
		return ppview;
	}

	public void setPpview(PromenaPodatakaView ppview) {
		this.ppview = ppview;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public boolean isPromenjen() {
		return promenjen;
	}

	public void setPromenjen(boolean promenjen) {
		this.promenjen = promenjen;
	}
	
	

}
