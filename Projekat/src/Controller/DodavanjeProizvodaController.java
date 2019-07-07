package Controller;

import java.io.File;
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

	public String dodaj(String idstr, String naziv, String opis, String nazivKategorije, String cenastr, String putanja) {
		int id = 0;
		double cena = 0;
		
		if (idstr == null) {
			return "Unesite id";
		}
		idstr = idstr.trim();
		if (idstr.isEmpty()) {
			return "Unesite id";
		}
		
		 try { 
		        Integer.parseInt(idstr); 
		    } catch(NumberFormatException e) { 
		        return "ID proizvoda mora da bude broj!"; 
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
		// vidjeti da li postoji kategorije
		// dodavanje kategorije!!
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
		
		 try { 
		        Double.parseDouble(cenastr); 
		    } catch(NumberFormatException e) { 
		        return "Niste lepo uneli cenu..."; 
		    }
		
		// provjeriti postoji li fajl na toj putanji
		
		Kategorija kategorija = new Kategorija();
		//int id = Integer.parseInt(idstr);
		//double cena = Double.parseDouble(cenastr);
		for(Kategorija k : preduzece.kategorije) {
			if(k.getNaziv().equals(nazivKategorije)) {
				kategorija = k;
				break;
			}
		}
		if(kategorija == null) {
			kategorija = new Kategorija(nazivKategorije);
		}
		
		File file = new File(putanja);
		if(!(file.exists() && !file.isDirectory())) { 
		    return "Nevalidna putanja";
		}
		if (!(putanja.endsWith("jpg") || putanja.endsWith("jpeg") || putanja.endsWith("png"))) {
			return "Fajl nevalidnog formata";
		}
 		
		// provjeriti jesu li floatovi i to; da li postoji fajl na putanji itd itd
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date datum = new Date(System.currentTimeMillis());
		
		Proizvod p = new Proizvod(id, naziv, opis, kategorija, putanja);
		StavkaCenovnika sc = new StavkaCenovnika(cena, datum, p);
		p.setAktuelnaCena(sc);
		
		dpview.setProizvod(p);
		preduzece.addProizvod(p);
		
		// TODO Auto-generated method stub
		return "Proizvod je uspesno kreiran";
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public DodavanjeProizvodaView getDpview() {
		return dpview;
	}

	public void setDpview(DodavanjeProizvodaView dpview) {
		this.dpview = dpview;
	}
	
	
}
