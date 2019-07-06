/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * Author:  Marija
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid f1031a6e-a25a-4da9-ac9e-8b4738f1370f */
public class StavkaNarudzbenice implements Serializable {
   /** @pdOid c8088f35-64f3-4ef8-ae51-36f91ca2935e */
   private int kolicina;
   /** @pdOid 99b9acc7-cb5c-4c29-962b-9c19465520fa */
   private double jedinicnaCena;
   /** @pdOid 10717086-57d2-4a0a-a3d9-ee9ca070bd1c */
   private double ukupnaCena;
   
   /** @pdRoleInfo migr=no name=Proizvod assc=association11 mult=1..1 side=A */
   public Proizvod proizvod;
   
   public StavkaNarudzbenice() {}
   
   public StavkaNarudzbenice(int kolicina, Proizvod proizvod) {
	   this.proizvod = proizvod;
	   this.kolicina = kolicina;
	   this.jedinicnaCena = proizvod.getAktuelnaCena().getRedovnaCena(); 
	   this.ukupnaCena = kolicina*this.jedinicnaCena;
   }

	public int getKolicina() {
		return kolicina;
	}
	
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
		this.ukupnaCena = kolicina*jedinicnaCena;
	}
	
	public double getJedinicnaCena() {
		return jedinicnaCena;
	}
	
	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}
	
	public double getUkupnaCena() {
		return ukupnaCena;
	}
	
	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
	
	public Proizvod getProizvod() {
		return proizvod;
	}
	
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}