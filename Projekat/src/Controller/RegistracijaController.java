package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Nalog;
import Model.RegistrovaniKupac;
import Model.TipKorisnika;
import View.AdminView;
import View.KupacView;
import View.ProizvodiView;
import View.RegistracijaView;

public class RegistracijaController {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik korisnik;
	private RegistracijaView regview;

	public RegistracijaController(RegistracijaView registracijaView, AplikacijaPreduzece preduzece) {
		this.regview = registracijaView;
		this.preduzece = preduzece;
		
		registracijaView.getBtnOK().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});

	}
	
	private void ok() throws IOException {
		Window parent = SwingUtilities.getWindowAncestor(regview);

		String kime = regview.getTfkorisnicko().getText();
		String lozinka = regview.getTflozinka().getText();
		String ime = regview.getTfime().getText();
		String prezime = regview.getTfprezime().getText();
		String email = regview.getTfemail().getText();
		String telefon = regview.getTftelefon().getText();
		
		String message = registrujSe(kime, lozinka, ime, prezime, email, telefon, regview.getTfgrad().getText(), regview.getTfdrzava().getText(), regview.getTfadresa().getText());
		String title = "Greska";
		
		if (regview.getKorisnik() == null){
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//JOptionPane.
			    	Window w = SwingUtilities.getWindowAncestor(btnOk);

			        if (w != null) {
			          w.setVisible(false);
			        }
			    	RegistracijaView rw = new RegistracijaView(preduzece, regview.getFrame());
					regview.add(rw);
					regview.remove(0);
					regview.updateUI();
			        //System.out.println("code excuted");
			    }
			}); 
			JOptionPane.showOptionDialog(parent, message, title, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{btnOk}, btnOk);
			
		}
		else if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.kupac)) {
			JOptionPane.showMessageDialog(parent, message);
			ProizvodiView bw = new ProizvodiView(regview.getFrame().getOvajStoSeMenja(), preduzece, regview.getPreduzece().proizvodi);	// za kupca
			KupacView kv = new KupacView(preduzece, regview.getFrame());
			//
			regview.getFrame().getHeader().getPrijava().setText("Odjava");
			regview.getFrame().getHeader().updateUI();
			regview.add(kv);
			regview.remove(0);
			regview.updateUI();
			System.out.println(preduzece.trenutnoUlogovani.getIme());
		}
		else if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.administrator)){
			// gledam koji je tip
			// promijeniti zaglavlje, na odjavi
			JOptionPane.showMessageDialog(parent, "Dodat je menadzer");
			ProizvodiView bw = new ProizvodiView(regview.getFrame().getOvajStoSeMenja(), preduzece, regview.getPreduzece().proizvodi);	// za kupca
			AdminView av = new AdminView(preduzece, regview.getFrame());
			//
			regview.getFrame().getHeader().getPrijava().setText("Odjava");
			regview.getFrame().getHeader().updateUI();
			regview.add(av);
			regview.remove(0);
			regview.updateUI();
			System.out.println(preduzece.trenutnoUlogovani.getIme());
		}
		

	}

	public String registrujSe(String korisnickoIme, String lozinka, String ime, String prezime, String email, String telefon, String grad, String drzava, String adresa) {
		/*if(!(preduzece.registracijaKupca(korisnickoIme, lozinka, email, ime, prezime, telefon, null, null, null, 0))) {
			return "Korisnicko ime vec postoji.";
		}*/
		if(!preduzece.proveriRegistraciju(korisnickoIme)) {
			return "Korisnicko ime vec postoji.";
		}
		if (korisnickoIme == null) {
			return "Unesite korisnicko ime";
		}
		korisnickoIme = korisnickoIme.trim();
		if (korisnickoIme.isEmpty()) {
			return "Unesite korisnicko ime";
		}
		
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
		
		/*TipKorisnika tip = TipKorisnika.kupac;
		korisnik = new Korisnik();
		Nalog nalog = new Nalog(korisnickoIme, lozinka, email, tip);
		korisnik.setNalog(nalog);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		regview.setKorisnik(korisnik);
		preduzece.korisnici.add(korisnik);
		preduzece.trenutnoUlogovani = korisnik;
		*/
		Mesto mesto = new Mesto(grad, drzava, adresa);
		
		if(preduzece.trenutnoUlogovani == null) {
			Nalog nalog = new Nalog(korisnickoIme, lozinka, email, TipKorisnika.kupac);
			korisnik = new RegistrovaniKupac(ime, prezime, telefon, mesto, nalog);
			preduzece.trenutnoUlogovani = korisnik;
			
		}
		else if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.administrator) {
			Nalog nalog = new Nalog(korisnickoIme, lozinka, email, TipKorisnika.menadzer);
			korisnik = new Korisnik(ime, prezime, telefon, mesto, nalog);

		}
		
		regview.setKorisnik(korisnik);
		preduzece.korisnici.add(korisnik);

		
		return "Uspesno ste se registrovali";
		
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public RegistracijaView getRegview() {
		return regview;
	}

	public void setRegview(RegistracijaView regview) {
		if (regview == null) {
			throw new NullPointerException();
		}
		this.regview = regview;
	}
	
	

}
