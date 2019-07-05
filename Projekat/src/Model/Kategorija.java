/***********************************************************************
 * Module:  Kategorija.java
 * Author:  Marija
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/

package Model;


import java.util.*;

/** @pdOid 894ac26d-eb7b-4f1e-bbd0-0585b7cbe85f */
public class Kategorija {
   /** @pdOid 12dd548c-aa43-4761-b70e-064a5a2e6c87 */
   private String naziv;
   private Kategorija nadkategorija;
   private List<Kategorija> podkategorije;
   
   public Kategorija() {
	   podkategorije = new ArrayList<Kategorija>();
   }
   
   public Kategorija(String naziv) {
	   this.naziv = naziv;
	   podkategorije = new ArrayList<Kategorija>();
   }
   
   public Kategorija(String naziv, Kategorija nadkat) {
	   this.naziv = naziv;
	   nadkategorija = nadkat;
	   this.nadkategorija.getPodkategorije().add(this);
   }

	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kategorija getNadkategorija() {
		return nadkategorija;
	}

	public void setNadkategorija(Kategorija nadkategorija) {
		this.nadkategorija = nadkategorija;
	}

	public List<Kategorija> getPodkategorije() {
		return podkategorije;
	}

	public void setPodkategorije(List<Kategorija> podkategorije) {
		this.podkategorije = podkategorije;
	}
   
   

}