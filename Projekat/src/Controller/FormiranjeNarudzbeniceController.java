package Controller;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Narudzbenica;
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
		
	}
	
	public String formirajNarudzbenicu(String ime, String prezime, String telefon, double cena, String drzava, String grad, String adresa) {
		
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
		
		kupac.getNarudzbenice().add(korpa);
		preduzece.narudzbenice.add(korpa);
		
		preduzece.korpa = new Narudzbenica();
		
		return "";
	}

}
