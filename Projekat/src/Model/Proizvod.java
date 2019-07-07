/***********************************************************************
 * Module:  Proizvod.java
 * Author:  Marija
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid 5056bd82-1978-49c1-9123-3fa50bcbee10 */
public class Proizvod implements Serializable {
   /** @pdOid 7ab5d1ec-59bb-4d08-b6e9-c6bc165afe2d */
   private int id;
   /** @pdOid 0b826071-6ce5-478f-8322-dcee952d489e */
   private String naziv;
   /** @pdOid 61ae7609-faea-49e4-8ca8-41b4c83747b9 */
   private String opis;
   
   private String putanja;
   
   private Kategorija kategorija;
   
   //private java.util.List<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();
   private StavkaCenovnika aktuelnaCena;

public Proizvod(String string) {
	naziv = string;  // za potrebe gui-ja u ranoj fazi
	// TODO Auto-generated constructor stub
	//
	this.putanja = "C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg";  // defaultna
}   public Proizvod() {}
   
   public Proizvod(int id, String naziv, String opis, Kategorija kategorija, String putanja) {
	   this.id = id;
	   this.naziv = naziv;
	   this.opis = opis;
	   this.kategorija = kategorija;
	   this.putanja = putanja;
   }
   
   public String getPutanja() {
	return putanja;
}

public void setPutanja(String putanja) {
	this.putanja = putanja;
}

public Proizvod(int id, String naziv, String opis, StavkaCenovnika sc) {
	   this.id = id;
	   this.naziv = naziv;
	   this.opis = opis;
	   this.aktuelnaCena = sc;
   }

	public Proizvod(int i, String string, String string2, Kategorija k1) {
	// TODO Auto-generated constructor stub
		 this.id = i;
		   this.naziv = string;
		   this.opis = string2;
		   this.kategorija = k1;
		   this.putanja = "C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg";
}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public StavkaCenovnika getAktuelnaCena() {
		return aktuelnaCena;
	}

	public void setAktuelnaCena(StavkaCenovnika aktuelnaCena) {
		this.aktuelnaCena = aktuelnaCena;
	}


}