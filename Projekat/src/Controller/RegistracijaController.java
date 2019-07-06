package Controller;

import javax.swing.JOptionPane;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Nalog;
import Model.RegistrovaniKupac;
import Model.TipKorisnika;
import View.RegistracijaView;

public class RegistracijaController {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik korisnik;
	private RegistracijaView regview;

	public RegistracijaController(RegistracijaView registracijaView, AplikacijaPreduzece preduzece) {
		this.regview = registracijaView;
		this.preduzece = preduzece;
	}

	public String registrujSe(String korisnickoIme, String lozinka, String ime, String prezime, String email, String telefon) {
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
		if(preduzece.trenutnoUlogovani == null) {
			Nalog nalog = new Nalog(korisnickoIme, lozinka, email, TipKorisnika.kupac);
			korisnik = new RegistrovaniKupac(ime, prezime, telefon, null, nalog);
		}
		else if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.administrator) {
			Nalog nalog = new Nalog(korisnickoIme, lozinka, email, TipKorisnika.menadzer);
			korisnik = new Korisnik(ime, prezime, telefon, null, nalog);
		}
		
		regview.setKorisnik(korisnik);
		preduzece.korisnici.add(korisnik);
		preduzece.trenutnoUlogovani = korisnik;
		
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
