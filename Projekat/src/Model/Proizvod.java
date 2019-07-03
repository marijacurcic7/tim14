/***********************************************************************
 * Module:  Proizvod.java
 * Author:  Marija
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid 5056bd82-1978-49c1-9123-3fa50bcbee10 */
public class Proizvod {
   /** @pdOid 7ab5d1ec-59bb-4d08-b6e9-c6bc165afe2d */
   private int id;
   /** @pdOid 0b826071-6ce5-478f-8322-dcee952d489e */
   private String naziv;
   /** @pdOid 61ae7609-faea-49e4-8ca8-41b4c83747b9 */
   private String opis;
   

public Proizvod(String string) {
	naziv = string;  // za potrebe gui-ja u ranoj fazi
	// TODO Auto-generated constructor stub
}   public Proizvod() {}
   
   public Proizvod(int id, String naziv, String opis) {
	   this.id = id;
	   this.naziv = naziv;
	   this.opis = opis;
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


}