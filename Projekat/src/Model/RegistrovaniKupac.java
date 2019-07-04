/***********************************************************************
 * Module:  RegistrovaniKupac.java
 * Author:  Marija
 * Purpose: Defines the Class RegistrovaniKupac
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid 708c4d42-5356-4e29-a027-75697e6a03fd */
public class RegistrovaniKupac extends Korisnik {
	
	public java.util.List<Narudzbenica> narudzbenice;
	
	public RegistrovaniKupac() {
		super();
	}
	
	public void dodajNarudzbenicu(Narudzbenica n) {
		narudzbenice.add(n);
	}

	public java.util.List<Narudzbenica> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(java.util.List<Narudzbenica> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}
	
	
}