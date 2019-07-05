/***********************************************************************
 * Module:  Osoba.java
 * Author:  Marija
 * Purpose: Defines the Class Osoba
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid f168e367-08e7-4404-af82-a7431f69f0f4 */
public class Korisnik implements Serializable {
   /** @pdOid 29049444-9ca4-4c52-b500-84bd556be10e */
   private String ime;
   /** @pdOid fd5a81c4-511e-4c15-8402-f9cfb0c83b14 */
   private String prezime;
   /** @pdOid 55b64444-63b6-4904-a9c1-c9367d2cfd29 */
   private String telefon;
   
   /** @pdRoleInfo migr=no name=Nalog assc=association1 mult=1..1 */
   public Nalog nalog;
   /** @pdRoleInfo migr=no name=Mesto assc=association23 mult=1..1 */
   public Mesto mesto;
   
   
   public Korisnik() {}
   
   public Korisnik(String ime, String prezime, String telefon, Mesto mesto, Nalog nalog) {
	   this.ime = ime;
	   this.prezime = prezime;
	   this.telefon = telefon;
	   this.mesto = mesto;
	   this.nalog = nalog;
   }

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

public String getTelefon() {
	return telefon;
}

public void setTelefon(String telefon) {
	this.telefon = telefon;
}

public Nalog getNalog() {
	return nalog;
}

public void setNalog(Nalog nalog) {
	this.nalog = nalog;
}

public Mesto getMesto() {
	return mesto;
}

public void setMesto(Mesto mesto) {
	this.mesto = mesto;
}
   
   

}