/***********************************************************************
 * Module:  StavkaCenovnika.java
 * Author:  Marija
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid 5222bf85-9113-4076-bbd1-3603af1385f0 */
public class StavkaCenovnika implements Serializable {
   /** @pdOid 71ace8b7-228f-4e60-8794-ee53891e9e1c */
   private double redovnaCena;
   /** @pdOid f20803d8-6248-4624-a650-c247d064d404 */
   private Date vaziOdDatuma;
   
   private Proizvod proizvod;
   
   public StavkaCenovnika() {
	// TODO Auto-generated constructor stub
   }
   
   public StavkaCenovnika(double cena, Date datum, Proizvod proizvod) {
	   this.redovnaCena = cena;
	   this.vaziOdDatuma = datum;
	   this.proizvod = proizvod;
   }

	public double getRedovnaCena() {
		return redovnaCena;
	}
	
	public void setRedovnaCena(double redovnaCena) {
		this.redovnaCena = redovnaCena;
	}
	
	public Date getVaziOdDatuma() {
		return vaziOdDatuma;
	}
	
	public void setVaziOdDatuma(Date vaziOdDatuma) {
		this.vaziOdDatuma = vaziOdDatuma;
	}
	
	public Proizvod getProizvod() {
		return proizvod;
	}
	
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	   
	   

}