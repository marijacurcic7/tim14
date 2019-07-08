/***********************************************************************
 * Module:  AplikacijaPreduzece.java
 * Author:  Marija
 * Purpose: Defines the Class AplikacijaPreduzece
 ***********************************************************************/
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/** @pdOid a3801020-fe7a-49f9-950a-ee11d9039e33 */
public class AplikacijaPreduzece {
   /** @pdRoleInfo migr=no name=Osoba assc=association2 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Korisnik> korisnici;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association3 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Narudzbenica> narudzbenice;
   /** @pdRoleInfo migr=no name=Proizvod assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Proizvod> proizvodi;
   /** @pdRoleInfo migr=no name=Prodavnica assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Prodavnica> prodavnice;
   /** @pdRoleInfo migr=no name=Kategorija assc=association19 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Kategorija> kategorije;
   /** @pdRoleInfo migr=no name=Osoba assc=korisnik mult=0..1 */
   public Korisnik trenutnoUlogovani = null;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association22 mult=1..1 */
   public Narudzbenica korpa;
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association21 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<StavkaCenovnika> stavkeCenovnika;
   
   
   private static String fileString = "preduzece.ser";
   
   public int pisanjeUFajl() throws IOException {
	   File file = new File(fileString);
	   FileOutputStream fileos;
	   ObjectOutputStream out;
	   if(file.exists() && !file.isDirectory()) {
		   fileos = new FileOutputStream(file); 
	       out = new ObjectOutputStream(fileos);  
	   }
	   else {
		   fileos = new FileOutputStream(fileString); 
	       out = new ObjectOutputStream(fileos);  
	   }
         
       for(Korisnik k : korisnici) {
    	   if(k.getClass().equals(RegistrovaniKupac.class)) {
    		   RegistrovaniKupac kupac = (RegistrovaniKupac)k;
    		   out.writeObject(kupac); 
    	   }
    	   else {
    		   out.writeObject(k); 
    	   }
       }
       for(Narudzbenica n : narudzbenice) {
    	   out.writeObject(n);
       }
       for(Proizvod p : proizvodi) {
    	   out.writeObject(p);
       }
       for(Prodavnica p : prodavnice) {
    	   out.writeObject(p);
       }
       for(Kategorija k : kategorije) {
    	   out.writeObject(k);
       }
       for(StavkaCenovnika sc : stavkeCenovnika) {
    	   out.writeObject(sc);
       }
         
       out.close(); 
       fileos.close(); 
       
       File file1 = new File("korpa.ser");
	   FileOutputStream file1os;
	   ObjectOutputStream out1;
	   if(file1.exists() && !file1.isDirectory()) {
		   file1os = new FileOutputStream(file1); 
	       out1 = new ObjectOutputStream(file1os);  
	   }
	   else {
		   file1os = new FileOutputStream("korpa.ser"); 
	       out1 = new ObjectOutputStream(file1os);  
	   }
	   
	   out1.writeObject(korpa);
       
       return 1; 
   }
   
   public void citanjeIzFajla() throws IOException {
	   File file1 = new File("korpa.ser");
	   if(file1.exists() && !file1.isDirectory()) {
	       FileInputStream file1is = new FileInputStream(file1);
		   ObjectInputStream in1 = new ObjectInputStream(file1is);
		   Object object1;
		   try {
			   object1 = (Object)in1.readObject();
			   if((object1 != null) && (object1.getClass().equals(Narudzbenica.class))) {
		    	   Narudzbenica n = new Narudzbenica();
		    	   n = (Narudzbenica)object1;
		    	   korpa = n;
		       }
			   in1.close(); 
		       file1is.close();  
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
	   }
	   
	   File file = new File(fileString);
	   if(file.exists() && !file.isDirectory()) {
	       FileInputStream fileis = new FileInputStream(file);
		   ObjectInputStream in = new ObjectInputStream(fileis); 
	       
		   Object object;
	       try {
			while((object = (Object)in.readObject()) != null) {
			       if(object.getClass().equals(RegistrovaniKupac.class)) {
			    	   RegistrovaniKupac k = new RegistrovaniKupac();
			    	   k = (RegistrovaniKupac)object;
			    	   korisnici.add(k);
			       }
			       else if(object.getClass().equals(Korisnik.class)) {
			    	   Korisnik k = new Korisnik();
			    	   k = (Korisnik)object;
			    	   korisnici.add(k);
			       }
			       else if(object.getClass().equals(Proizvod.class)) {
			    	   Proizvod p = new Proizvod();
			    	   p = (Proizvod)object;
			    	   proizvodi.add(p);
			       }
			       else if(object.getClass().equals(Narudzbenica.class)) {
			    	   Narudzbenica n = new Narudzbenica();
			    	   n = (Narudzbenica)object;
			    	   narudzbenice.add(n);
			    	   
			       }
			       else if(object.getClass().equals(Kategorija.class)) {
			    	   Kategorija k = new Kategorija();
			    	   k = (Kategorija)object;
			    	   kategorije.add(k);
			       }else if(object.getClass().equals(Prodavnica.class)) {
			    	   Prodavnica p = new Prodavnica();
			    	   p = (Prodavnica)object;
			    	   prodavnice.add(p);
			       }
			       
			   }
	       } catch (ClassNotFoundException e) {
	    	   e.printStackTrace();
	       }
	       in.close(); 
	       fileis.close();  
	   }
	   
   }
   
   
   public AplikacijaPreduzece() {
		super();
		korisnici = new ArrayList<Korisnik>();
		narudzbenice = new ArrayList<Narudzbenica>();
		proizvodi = new ArrayList<Proizvod>();
		prodavnice = new ArrayList<Prodavnica>();
		kategorije = new ArrayList<Kategorija>();
		
		korpa = new Narudzbenica();
		korpa.setId(0);
		
		stavkeCenovnika = new ArrayList<StavkaCenovnika>();

		
		try {
			
			citanjeIzFajla();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println("End of file");
		} 
		
   }

   /** @pdOid 88b72526-db73-439f-877b-52c47f05da53 */
   public void kreirajMenadzera() {
      // TODO: implement
   }
   
   /** @pdOid 961eadbf-f80a-41d7-a722-cf176e3c5e3e */
   public int kreirajNarudzbenicu() {
      // TODO: implement
      return 0;
   }
   
   
   public boolean proveriRegistraciju(String korisnickoIme) {
	   for(Korisnik k : korisnici) {
		   if(k.getNalog().getKorisnickoIme().equals(korisnickoIme)) {
			   return false;
		   }
	   }
	   return true;
   }

   
   public boolean login(String korisnickoIme, String lozinka) {
	   if(korisnickoIme.equals("admin") && lozinka.equals("admin")) {
		   Nalog n = new Nalog("admin", "admin", null, TipKorisnika.administrator);
		   Korisnik k = new Korisnik();
		   k.setNalog(n);
		   trenutnoUlogovani = k;
		   return true;
	   }
	   for (Korisnik k: korisnici) {
		   if (k.getNalog().getKorisnickoIme().equals(korisnickoIme) && k.getNalog().getLozinka().equals(lozinka)) {
			   if(k.getClass().equals(RegistrovaniKupac.class)) {
				   
				   RegistrovaniKupac kupac = (RegistrovaniKupac)k;
				   trenutnoUlogovani = kupac;
			   }
			   else {
				   trenutnoUlogovani = k;
			   }
			   return true;
		   }
		   
	   }
	   return false;
   }
   
   /** @pdGenerated default getter */
   public java.util.List<Korisnik> getKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Korisnik>();
      return korisnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Korisnik>();
      return korisnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnici */
   public void setKorisnici(java.util.List<Korisnik> newKorisnici) {
      removeAllKorisnici();
      for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext();)
         addKorisnici((Korisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOsoba */
   public void addKorisnici(Korisnik newOsoba) {
      if (newOsoba == null)
         return;
      if (this.korisnici == null)
         this.korisnici = new java.util.ArrayList<Korisnik>();
      if (!this.korisnici.contains(newOsoba))
         this.korisnici.add(newOsoba);
   }
   
   /** @pdGenerated default remove
     * @param oldOsoba */
   public void removeKorisnici(Korisnik oldOsoba) {
      if (oldOsoba == null)
         return;
      if (this.korisnici != null)
         if (this.korisnici.contains(oldOsoba))
            this.korisnici.remove(oldOsoba);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorisnici() {
      if (korisnici != null)
         korisnici.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Narudzbenica> getNarudzbenice() {
      if (narudzbenice == null)
         narudzbenice = new java.util.ArrayList<Narudzbenica>();
      return narudzbenice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNarudzbenice() {
      if (narudzbenice == null)
         narudzbenice = new java.util.ArrayList<Narudzbenica>();
      return narudzbenice.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNarudzbenice */
   public void setNarudzbenice(java.util.List<Narudzbenica> newNarudzbenice) {
      removeAllNarudzbenice();
      for (java.util.Iterator iter = newNarudzbenice.iterator(); iter.hasNext();)
         addNarudzbenice((Narudzbenica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNarudzbenica */
   public void addNarudzbenice(Narudzbenica newNarudzbenica) {
      if (newNarudzbenica == null)
         return;
      if (this.narudzbenice == null)
         this.narudzbenice = new java.util.ArrayList<Narudzbenica>();
      if (!this.narudzbenice.contains(newNarudzbenica))
         this.narudzbenice.add(newNarudzbenica);
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbenica */
   public void removeNarudzbenice(Narudzbenica oldNarudzbenica) {
      if (oldNarudzbenica == null)
         return;
      if (this.narudzbenice != null)
         if (this.narudzbenice.contains(oldNarudzbenica))
            this.narudzbenice.remove(oldNarudzbenica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbenice() {
      if (narudzbenice != null)
         narudzbenice.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Proizvod> getProizvod() {
      if (proizvodi == null)
         proizvodi = new java.util.ArrayList<Proizvod>();
      return proizvodi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvod() {
      if (proizvodi == null)
         proizvodi = new java.util.ArrayList<Proizvod>();
      return proizvodi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProizvod */
   public void setProizvod(java.util.List<Proizvod> newProizvod) {
      removeAllProizvod();
      for (java.util.Iterator iter = newProizvod.iterator(); iter.hasNext();)
         addProizvod((Proizvod)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvod */
   public void addProizvod(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.proizvodi == null)
         this.proizvodi = new java.util.ArrayList<Proizvod>();
      //if (!this.proizvodi.contains(newProizvod))
      //   this.proizvodi.add(newProizvod);
      for (Proizvod p: this.proizvodi) {
    	  if (newProizvod.getId() == p.getId()) {
    		  return;
    	  }
      }
      this.proizvodi.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.proizvodi != null)
         if (this.proizvodi.contains(oldProizvod))
            this.proizvodi.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvod() {
      if (proizvodi != null)
         proizvodi.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Prodavnica> getProdavnica() {
      if (prodavnice == null)
         prodavnice = new java.util.ArrayList<Prodavnica>();
      return prodavnice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProdavnica() {
      if (prodavnice == null)
         prodavnice = new java.util.ArrayList<Prodavnica>();
      return prodavnice.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProdavnica */
   public void setProdavnica(java.util.List<Prodavnica> newProdavnica) {
      removeAllProdavnica();
      for (java.util.Iterator iter = newProdavnica.iterator(); iter.hasNext();)
         addProdavnica((Prodavnica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProdavnica */
   public void addProdavnica(Prodavnica newProdavnica) {
      if (newProdavnica == null)
         return;
      if (this.prodavnice == null)
         this.prodavnice = new java.util.ArrayList<Prodavnica>();
      if (!this.prodavnice.contains(newProdavnica))
         this.prodavnice.add(newProdavnica);
   }
   
   /** @pdGenerated default remove
     * @param oldProdavnica */
   public void removeProdavnica(Prodavnica oldProdavnica) {
      if (oldProdavnica == null)
         return;
      if (this.prodavnice != null)
         if (this.prodavnice.contains(oldProdavnica))
            this.prodavnice.remove(oldProdavnica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProdavnica() {
      if (prodavnice != null)
         prodavnice.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Kategorija> getKategorija() {
      if (kategorije == null)
         kategorije = new java.util.ArrayList<Kategorija>();
      return kategorije;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKategorija() {
      if (kategorije == null)
         kategorije = new java.util.ArrayList<Kategorija>();
      return kategorije.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKategorija */
   public void setKategorija(java.util.List<Kategorija> newKategorija) {
      removeAllKategorija();
      for (java.util.Iterator iter = newKategorija.iterator(); iter.hasNext();)
         addKategorija((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public void addKategorija(Kategorija newKategorija) {
      if (newKategorija == null)
         return;
      if (this.kategorije == null)
         this.kategorije = new java.util.ArrayList<Kategorija>();
      //if (!this.kategorije.contains(newKategorija))
      //   this.kategorije.add(newKategorija);
      for (Kategorija kat: kategorije) {
    	  if (kat.getNaziv().equals(newKategorija.getNaziv())) {
    		  return;
    	  }
      }
      this.kategorije.add(newKategorija);
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removeKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.kategorije != null)
         if (this.kategorije.contains(oldKategorija))
            this.kategorije.remove(oldKategorija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKategorija() {
      if (kategorije != null)
         kategorije.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<StavkaCenovnika> getStavkaCenovnika() {
      if (stavkeCenovnika == null)
         stavkeCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      return stavkeCenovnika;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaCenovnika() {
      if (stavkeCenovnika == null)
         stavkeCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      return stavkeCenovnika.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavkaCenovnika */
   public void setStavkaCenovnika(java.util.List<StavkaCenovnika> newStavkaCenovnika) {
      removeAllStavkaCenovnika();
      for (java.util.Iterator iter = newStavkaCenovnika.iterator(); iter.hasNext();)
         addStavkaCenovnika((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addStavkaCenovnika(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavkeCenovnika == null)
         this.stavkeCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      if (!this.stavkeCenovnika.contains(newStavkaCenovnika))
         this.stavkeCenovnika.add(newStavkaCenovnika);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavkaCenovnika(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavkeCenovnika != null)
         if (this.stavkeCenovnika.contains(oldStavkaCenovnika))
            this.stavkeCenovnika.remove(oldStavkaCenovnika);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaCenovnika() {
      if (stavkeCenovnika != null)
         stavkeCenovnika.clear();
   }

	public Korisnik getTrenutnoUlogovani() {
		return trenutnoUlogovani;
	}
	
	public void setTrenutnoUlogovani(Korisnik trenutnoUlogovani) {
		this.trenutnoUlogovani = trenutnoUlogovani;
	}
	
	public Narudzbenica getKorpa() {
		return korpa;
	}
	
	public void setKorpa(Narudzbenica korpa) {
		this.korpa = korpa;
	}

	public boolean validanId(int id) {
		for (Proizvod p: proizvodi) {
			if (p.getId() == id) {
				return false;
			}
		}
		
		return true;
	}
   
   

}