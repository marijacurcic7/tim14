/***********************************************************************
 * Module:  Prodavnica.java
 * Author:  Marija
 * Purpose: Defines the Class Prodavnica
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid 8f4c06cc-78d3-4be8-9cf5-7f68d7acc7c5 */
public class Prodavnica {
   /** @pdOid cf10f5fb-6320-4698-96eb-ef797c8f38d5 */
   private int id;
   
   /** @pdRoleInfo migr=no name=ProizvodUProdavnici assc=association12 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ProizvodUProdavnici> proizvodUProdavnici;
   
   
   /** @pdGenerated default getter */
   public java.util.List<ProizvodUProdavnici> getProizvodUProdavnici() {
      if (proizvodUProdavnici == null)
         proizvodUProdavnici = new java.util.ArrayList<ProizvodUProdavnici>();
      return proizvodUProdavnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvodUProdavnici() {
      if (proizvodUProdavnici == null)
         proizvodUProdavnici = new java.util.ArrayList<ProizvodUProdavnici>();
      return proizvodUProdavnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProizvodUProdavnici */
   public void setProizvodUProdavnici(java.util.List<ProizvodUProdavnici> newProizvodUProdavnici) {
      removeAllProizvodUProdavnici();
      for (java.util.Iterator iter = newProizvodUProdavnici.iterator(); iter.hasNext();)
         addProizvodUProdavnici((ProizvodUProdavnici)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvodUProdavnici */
   public void addProizvodUProdavnici(ProizvodUProdavnici newProizvodUProdavnici) {
      if (newProizvodUProdavnici == null)
         return;
      if (this.proizvodUProdavnici == null)
         this.proizvodUProdavnici = new java.util.ArrayList<ProizvodUProdavnici>();
      if (!this.proizvodUProdavnici.contains(newProizvodUProdavnici))
         this.proizvodUProdavnici.add(newProizvodUProdavnici);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvodUProdavnici */
   public void removeProizvodUProdavnici(ProizvodUProdavnici oldProizvodUProdavnici) {
      if (oldProizvodUProdavnici == null)
         return;
      if (this.proizvodUProdavnici != null)
         if (this.proizvodUProdavnici.contains(oldProizvodUProdavnici))
            this.proizvodUProdavnici.remove(oldProizvodUProdavnici);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvodUProdavnici() {
      if (proizvodUProdavnici != null)
         proizvodUProdavnici.clear();
   }

}