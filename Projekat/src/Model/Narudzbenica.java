/***********************************************************************
 * Module:  Narudzbenica.java
 * Author:  Marija
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

package Model;

import java.io.Serializable;
import java.util.*;

/** @pdOid 7d690466-1672-4fa2-bf50-08a840f9ef17 */
public class Narudzbenica implements Serializable {
   /** @pdOid 433982e1-84b9-4fdf-a30a-828bd7c99d5c */
   private int id;
   /** @pdOid a69610ee-ca2a-472f-9399-9ec0b7a792a5 */
   private Date datum;
   /** @pdOid 5d9aab56-ab40-4881-bbae-02f6af50dacb */
   private String ime;
   /** @pdOid d2abacda-04ee-4a84-87b7-e15a7fe6be55 */
   private String prezime;
   /** @pdOid d17fa62c-3a2e-485b-bda7-c2ed0579ccab */
   private String telefon;
   private int kartica;
  
   private double ukupanIznos = 0.0;
   
   /** @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association7 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<StavkaNarudzbenice> stavkeNarudzbenice;
   /** @pdRoleInfo migr=no name=Mesto assc=association15 mult=1..1 */
   public Mesto mesto;
   
   public RegistrovaniKupac regKupac;
   
   private Stanje stanje;
   
   public Narudzbenica() {
	   this.stavkeNarudzbenice = new ArrayList<StavkaNarudzbenice>();
	   this.ukupanIznos = 0;
	   this.stanje = new Formiranje();

   }
   
   public Narudzbenica(int id, Date datum, String ime, String prezime, String telefon, Mesto mesto) {
	   this.ime = ime;
	   this.prezime = prezime;
	   this.datum = datum;
	   this.id = id;
	   this.telefon = telefon;
	   this.mesto = mesto;
	   this.stavkeNarudzbenice = new ArrayList<StavkaNarudzbenice>();
	   this.ukupanIznos = 0;
	   this.stanje = new Formiranje();
   }
   
   public Narudzbenica(int id, Date datum, String ime, String prezime, String telefon, Mesto mesto, StavkaNarudzbenice sn) {
	   this.ime = ime;
	   this.prezime = prezime;
	   this.datum = datum;
	   this.id = id;
	   this.telefon = telefon;
	   this.mesto = mesto;
	   stavkeNarudzbenice.add(sn);
	   ukupanIznos += sn.getUkupnaCena();
	   this.stanje = new Formiranje();
   }
   
   /*public void dodajUKorpu(StavkaNarudzbenice s) {
	   stavkeNarudzbenice.add(s);
	   ukupanIznos += s.getUkupnaCena();
   }*/
   /** @pdOid 7f329260-9504-4d66-b24f-291c5a27d786 */
   public void aktivirajZavrsetak() {
      // TODO: implement
	   
   }
   
   /** @pdOid 373fc6f7-a0c0-49ca-b088-b275e4d6c52d */
   public void obavljenoPlacanje() {
      // TODO: implement
   }
   
   /** @pdOid 836ac968-dbee-4ede-a0c9-afea639812f4 */
   public void otkazanoPlacanje() {
      // TODO: implement
   }
   
   /** @pdOid 5e3d44b1-e46a-4eda-b3a6-66c0c75a1808 */
   public void izvrsenaIsporuka() {
      // TODO: implement
   }
   
   /** @pdOid f5eaf139-bdb2-4142-abb3-632e0c4cea75 */
   public void zabraniIzmenu() {
      // TODO: implement
   }
   
   /** @param s
    * @pdOid b59e6d34-1c2b-4c35-9200-e3b8b5870de2 */
   public void promeniStanje(Stanje s) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<StavkaNarudzbenice> getStavkaNarudzbenice() {
      if (stavkeNarudzbenice == null)
         stavkeNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      return stavkeNarudzbenice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaNarudzbenice() {
      if (stavkeNarudzbenice == null)
         stavkeNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      return stavkeNarudzbenice.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavkaNarudzbenice */
   public void setStavkaNarudzbenice(java.util.List<StavkaNarudzbenice> newStavkaNarudzbenice) {
      removeAllStavkaNarudzbenice();
      for (java.util.Iterator iter = newStavkaNarudzbenice.iterator(); iter.hasNext();)
         addStavkaNarudzbenice((StavkaNarudzbenice)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaNarudzbenice */
   public void addStavkaNarudzbenice(StavkaNarudzbenice newStavkaNarudzbenice) {
      if (newStavkaNarudzbenice == null)
         return;
      if (this.stavkeNarudzbenice == null)
         this.stavkeNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      /*if (!this.stavkeNarudzbenice.contains(newStavkaNarudzbenice))
         this.stavkeNarudzbenice.add(newStavkaNarudzbenice);*/
      this.stavkeNarudzbenice.add(newStavkaNarudzbenice);
      this.ukupanIznos += newStavkaNarudzbenice.getUkupnaCena();
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbenice */
   public void removeStavkaNarudzbenice(StavkaNarudzbenice oldStavkaNarudzbenice) {
      if (oldStavkaNarudzbenice == null)
         return;
      if (this.stavkeNarudzbenice != null)
         if (this.stavkeNarudzbenice.contains(oldStavkaNarudzbenice))
            this.stavkeNarudzbenice.remove(oldStavkaNarudzbenice);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaNarudzbenice() {
      if (stavkeNarudzbenice != null)
         stavkeNarudzbenice.clear();
   }
   
   public double update() {
	   ukupanIznos = 0;
	   for(StavkaNarudzbenice sn : stavkeNarudzbenice) {
		   ukupanIznos+=sn.getUkupnaCena();
	   }
	   return ukupanIznos;
   }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
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
	
	public double getUkupanIznos() {
		return ukupanIznos;
	}
	
	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
	
	public Mesto getMesto() {
		return mesto;
	}
	
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}
	
	public RegistrovaniKupac getRegKupac() {
		return regKupac;
	}
	
	public void setRegKupac(RegistrovaniKupac regKupac) {
		this.regKupac = regKupac;
	}
	
	public java.util.List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}
	
	public void setStavkeNarudzbenice(java.util.List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}
	
	public Stanje getStanje() {
		return stanje;
	}
	
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public int getKartica() {
		return kartica;
	}

	public void setKartica(int kartica) {
		this.kartica = kartica;
	}
   
   

}