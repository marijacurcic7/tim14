/***********************************************************************
 * Module:  AplikacijaPreduzece.java
 * Author:  Marija
 * Purpose: Defines the Class AplikacijaPreduzece
 ***********************************************************************/
package Model;

import java.util.*;

/** @pdOid a3801020-fe7a-49f9-950a-ee11d9039e33 */
public class AplikacijaPreduzece {
   /** @pdRoleInfo migr=no name=Osoba assc=association2 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Osoba> korisnici;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association3 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Narudzbenica> narudzbenice;
   /** @pdRoleInfo migr=no name=Proizvod assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Proizvod> proizvod;
   /** @pdRoleInfo migr=no name=Prodavnica assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Prodavnica> prodavnica;
   /** @pdRoleInfo migr=no name=Kategorija assc=association19 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Kategorija> kategorija;
   /** @pdRoleInfo migr=no name=Osoba assc=korisnik mult=0..1 */
   public Osoba trenutnoUlogovani;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association22 mult=1..1 */
   public Narudzbenica korpa;
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association21 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<StavkaCenovnika> stavkaCenovnika;
   
   // komentar
   
   /** @pdOid 88b72526-db73-439f-877b-52c47f05da53 */
   public void kreirajMenadzera() {
      // TODO: implement
   }
   
   /** @pdOid 961eadbf-f80a-41d7-a722-cf176e3c5e3e */
   public int kreirajNarudzbenicu() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Osoba> getKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Osoba>();
      return korisnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Osoba>();
      return korisnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnici */
   public void setKorisnici(java.util.List<Osoba> newKorisnici) {
      removeAllKorisnici();
      for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext();)
         addKorisnici((Osoba)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOsoba */
   public void addKorisnici(Osoba newOsoba) {
      if (newOsoba == null)
         return;
      if (this.korisnici == null)
         this.korisnici = new java.util.ArrayList<Osoba>();
      if (!this.korisnici.contains(newOsoba))
         this.korisnici.add(newOsoba);
   }
   
   /** @pdGenerated default remove
     * @param oldOsoba */
   public void removeKorisnici(Osoba oldOsoba) {
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
      if (proizvod == null)
         proizvod = new java.util.ArrayList<Proizvod>();
      return proizvod;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvod() {
      if (proizvod == null)
         proizvod = new java.util.ArrayList<Proizvod>();
      return proizvod.iterator();
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
      if (this.proizvod == null)
         this.proizvod = new java.util.ArrayList<Proizvod>();
      if (!this.proizvod.contains(newProizvod))
         this.proizvod.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.proizvod != null)
         if (this.proizvod.contains(oldProizvod))
            this.proizvod.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvod() {
      if (proizvod != null)
         proizvod.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Prodavnica> getProdavnica() {
      if (prodavnica == null)
         prodavnica = new java.util.ArrayList<Prodavnica>();
      return prodavnica;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProdavnica() {
      if (prodavnica == null)
         prodavnica = new java.util.ArrayList<Prodavnica>();
      return prodavnica.iterator();
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
      if (this.prodavnica == null)
         this.prodavnica = new java.util.ArrayList<Prodavnica>();
      if (!this.prodavnica.contains(newProdavnica))
         this.prodavnica.add(newProdavnica);
   }
   
   /** @pdGenerated default remove
     * @param oldProdavnica */
   public void removeProdavnica(Prodavnica oldProdavnica) {
      if (oldProdavnica == null)
         return;
      if (this.prodavnica != null)
         if (this.prodavnica.contains(oldProdavnica))
            this.prodavnica.remove(oldProdavnica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProdavnica() {
      if (prodavnica != null)
         prodavnica.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Kategorija> getKategorija() {
      if (kategorija == null)
         kategorija = new java.util.ArrayList<Kategorija>();
      return kategorija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKategorija() {
      if (kategorija == null)
         kategorija = new java.util.ArrayList<Kategorija>();
      return kategorija.iterator();
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
      if (this.kategorija == null)
         this.kategorija = new java.util.ArrayList<Kategorija>();
      if (!this.kategorija.contains(newKategorija))
         this.kategorija.add(newKategorija);
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removeKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.kategorija != null)
         if (this.kategorija.contains(oldKategorija))
            this.kategorija.remove(oldKategorija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKategorija() {
      if (kategorija != null)
         kategorija.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<StavkaCenovnika> getStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      return stavkaCenovnika;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaCenovnika() {
      if (stavkaCenovnika == null)
         stavkaCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      return stavkaCenovnika.iterator();
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
      if (this.stavkaCenovnika == null)
         this.stavkaCenovnika = new java.util.ArrayList<StavkaCenovnika>();
      if (!this.stavkaCenovnika.contains(newStavkaCenovnika))
         this.stavkaCenovnika.add(newStavkaCenovnika);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavkaCenovnika(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavkaCenovnika != null)
         if (this.stavkaCenovnika.contains(oldStavkaCenovnika))
            this.stavkaCenovnika.remove(oldStavkaCenovnika);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaCenovnika() {
      if (stavkaCenovnika != null)
         stavkaCenovnika.clear();
   }

}