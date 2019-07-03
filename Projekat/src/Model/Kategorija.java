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
   
   public Kategorija() {}
   
   public Kategorija(String naziv) {
	   this.naziv = naziv;
   }

	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
   
   

}