/***********************************************************************
 * Module:  Narudzbenica.java
 * Author:  Marija
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid 7d690466-1672-4fa2-bf50-08a840f9ef17 */
public class Narudzbenica {
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
   
   /** @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association7 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<StavkaNarudzbenice> stavkaNarudzbenice;
   /** @pdRoleInfo migr=no name=Mesto assc=association15 mult=1..1 */
   public Mesto mesto;
   
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
      if (stavkaNarudzbenice == null)
         stavkaNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      return stavkaNarudzbenice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaNarudzbenice() {
      if (stavkaNarudzbenice == null)
         stavkaNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      return stavkaNarudzbenice.iterator();
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
      if (this.stavkaNarudzbenice == null)
         this.stavkaNarudzbenice = new java.util.ArrayList<StavkaNarudzbenice>();
      if (!this.stavkaNarudzbenice.contains(newStavkaNarudzbenice))
         this.stavkaNarudzbenice.add(newStavkaNarudzbenice);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbenice */
   public void removeStavkaNarudzbenice(StavkaNarudzbenice oldStavkaNarudzbenice) {
      if (oldStavkaNarudzbenice == null)
         return;
      if (this.stavkaNarudzbenice != null)
         if (this.stavkaNarudzbenice.contains(oldStavkaNarudzbenice))
            this.stavkaNarudzbenice.remove(oldStavkaNarudzbenice);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaNarudzbenice() {
      if (stavkaNarudzbenice != null)
         stavkaNarudzbenice.clear();
   }

}