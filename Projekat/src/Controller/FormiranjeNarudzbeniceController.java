package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Narudzbenica;
import Model.Placena;
import Model.RegistrovaniKupac;
import Model.Zavrsena;
import View.FormiranjeNarudzbeniceView;


public class FormiranjeNarudzbeniceController {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik trenutnoUlogovani;
	private FormiranjeNarudzbeniceView fnview;
	private Narudzbenica korpa;
	private RegistrovaniKupac kupac;
	
	public FormiranjeNarudzbeniceController(FormiranjeNarudzbeniceView fnv, AplikacijaPreduzece ap) {
		
		this.fnview = fnv;
		this.preduzece = ap;
		this.trenutnoUlogovani = ap.trenutnoUlogovani;
		this.korpa = ap.korpa;
		kupac = (RegistrovaniKupac)trenutnoUlogovani;
		addListeners();
	}
	
	public String formirajNarudzbenicu(String ime, String prezime, String telefon, String karticastr, double cena, String drzava, String grad, String adresa) {
		
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
		
		int brKartice;
		karticastr = karticastr.trim();
		if (karticastr.isEmpty()) {
			return "Unesite karticu";
		}
		
		 try { 
			brKartice = Integer.parseInt(karticastr); 
		    } catch(NumberFormatException e) { 
		        return "Niste lepo uneli karticu..."; 
		    }
		
		
		if (drzava == null) {
			return "Unesite drzavu";
		}
		drzava = drzava.trim();
		if (drzava.isEmpty()) {
			return "Unesite drzavu";
		}
		
		if (grad == null) {
			return "Unesite grad";
		}
		grad = grad.trim();
		if (grad.isEmpty()) {
			return "Unesite grad";
		}
		
		if (adresa == null) {
			return "Unesite adresu";
		}
		adresa = adresa.trim();
		if (adresa.isEmpty()) {
			return "Unesite adresu";
		}
		
		Mesto mesto = new Mesto(grad, drzava, adresa);
		korpa.setIme(ime);
		korpa.setPrezime(prezime);
		korpa.setTelefon(telefon);
		korpa.setUkupanIznos(cena);
		korpa.setMesto(mesto);
		korpa.setStanje(new Zavrsena());
		korpa.setKartica(brKartice);
		
		kupac.getNarudzbenice().add(korpa);
		
		fnview.setNarudzbenica(korpa);
		
		preduzece.korpa = new Narudzbenica();
		korpa.setId(0);
		
		return "";
	}
	
	private void addListeners() {
		
		fnview.getBtnOK().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					ok();
				}
		});
		
	}
	
	
	public void ok() {
		
		
		Window parent = SwingUtilities.getWindowAncestor(fnview);
		
		String ime = fnview.getTfime().getText();
		String prezime = fnview.getTfprezime().getText();
		String telefon = fnview.getTftelefon().getText();
		String karticastr = fnview.getTfkartica().getText();
		
		
		double cena = korpa.getUkupanIznos();
		
		String message = formirajNarudzbenicu(ime, prezime, telefon, karticastr, cena, fnview.getTfgrad().getText(), fnview.getTfdrzava().getText(), fnview.getTfadresa().getText());
		
		
		if(message.equals("")) {
			
			int dialogbtn = JOptionPane.YES_NO_OPTION;
			int dialogrez = JOptionPane.showConfirmDialog(fnview, "Plati", "Narudzbenica je formirana", dialogbtn);
			if(dialogrez == JOptionPane.YES_OPTION) {
				fnview.getNarudzbenica().setStanje(new Placena());
			}
			
			preduzece.narudzbenice.add(fnview.getNarudzbenica());

			
			fnview.updateUI();
		}
		else {
			JOptionPane.showMessageDialog(parent, message);

		}
	}

	
	

}
