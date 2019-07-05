/***********************************************************************
 * Module:  Nalog.java
 * Author:  Marija
 * Purpose: Defines the Class Nalog
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid 4e66f8c6-ae98-405c-9068-ebc791810d08 */
public class Nalog implements Serializable {
   /** @pdOid 5b8341fb-cfde-45c8-a2ab-084599abfca4 */
   private String korisnickoIme;
   /** @pdOid 712aa551-c618-4445-a732-917251936ff3 */
   private String lozinka;
   /** @pdOid d68fbbff-4364-4d7a-8419-6652f137307b */
   private String eMail;
   /** @pdOid cc7ae305-4788-4711-a6db-517a9463de26 */
   private TipKorisnika tipKorisnika;
   
   public Nalog() {}
   
   public Nalog(String kIme, String lozinka, String email, TipKorisnika tip) {
	   this.korisnickoIme = kIme;
	   this.lozinka = lozinka;
	   this.eMail = email;
	   this.tipKorisnika = tip;
   }

public String getKorisnickoIme() {
	return korisnickoIme;
}

public void setKorisnickoIme(String korisnickoIme) {
	this.korisnickoIme = korisnickoIme;
}

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

public TipKorisnika getTipKorisnika() {
	return tipKorisnika;
}

public void setTipKorisnika(TipKorisnika tipKorisnika) {
	this.tipKorisnika = tipKorisnika;
}
   
   

}