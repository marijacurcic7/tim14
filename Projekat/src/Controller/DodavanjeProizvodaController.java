package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.AplikacijaPreduzece;
import Model.Kategorija;
import Model.Proizvod;
import Model.StavkaCenovnika;
import View.DodavanjeProizvodaView;

public class DodavanjeProizvodaController {
	
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;

	private DodavanjeProizvodaView dpview;
	
	public DodavanjeProizvodaController(DodavanjeProizvodaView dpview, AplikacijaPreduzece preduzece) {
		// TODO Auto-generated constructor stub
		this.preduzece = preduzece;
		this.dpview = dpview;
	}

	public String dodaj(String idstr, String naziv, String opis, String nazivKategorije, String cenastr) {
		
		if (idstr == null) {
			return "Unesite id";
		}
		idstr = idstr.trim();
		if (idstr.isEmpty()) {
			return "Unesite id";
		}
		
		if (naziv == null) {
			return "Unesite naziv";
		}
		naziv = naziv.trim();
		if (naziv.isEmpty()) {
			return "Unesite naziv";
		}
		
		if (opis == null) {
			return "Unesite opis";
		}
		opis = opis.trim();
		if (opis.isEmpty()) {
			return "Unesite opis";
		}
		
		if (nazivKategorije == null) {
			return "Unesite kategoriju";
		}
		nazivKategorije = nazivKategorije.trim();
		if (nazivKategorije.isEmpty()) {
			return "Unesite kategoriju";
		}
		
		if (cenastr == null) {
			return "Unesite cenu";
		}
		cenastr = cenastr.trim();
		if (cenastr.isEmpty()) {
			return "Unesite cenu";
		}
		
		Kategorija kategorija = new Kategorija();
		int id = Integer.parseInt(idstr);
		double cena = Double.parseDouble(cenastr);
		for(Kategorija k : preduzece.kategorije) {
			if(k.getNaziv().equals(nazivKategorije)) {
				kategorija = k;
			}
		}
		if(kategorija == null) {
			kategorija = new Kategorija(nazivKategorije);
		}
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date datum = new Date(System.currentTimeMillis());
		
		Proizvod p = new Proizvod(id, naziv, opis, kategorija);
		StavkaCenovnika sc = new StavkaCenovnika(cena, datum, p);
		p.setAktuelnaCena(sc);
		
		dpview.setProizvod(p);
		
		// TODO Auto-generated method stub
		return "Proizvod je uspesno kreiran";
	}}
