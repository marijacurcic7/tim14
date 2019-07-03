/***********************************************************************
 * Module:  Mesto.java
 * Author:  Marija
 * Purpose: Defines the Class Mesto
 ***********************************************************************/

package Model;


import java.util.*;

/** @pdOid 124fa27d-9d75-455f-a9cf-5350fadbfbf0 */
public class Mesto {
   /** @pdOid b8df4c2e-03ab-41d0-996d-f1d7f2d40a75 */
   private String grad;
   /** @pdOid 65184e57-436b-4e91-b9d7-859bedcb1fd4 */
   private String drzava;
   /** @pdOid 9689ce6d-08bf-49f3-97e1-1a1d6de636fe */
   private String adresa;
   /** @pdOid 07f4170d-fb6b-40cc-be73-eeb12105be96 */
   private int ptbroj;
   
   public Mesto() {}
   
   public Mesto(String grad, String drzava, String adresa, int pbr) {
	   this.grad = grad;
	   this.drzava = drzava;
	   this.adresa = adresa;
	   this.ptbroj = pbr;
   }

public String getGrad() {
	return grad;
}

public void setGrad(String grad) {
	this.grad = grad;
}

public String getDrzava() {
	return drzava;
}

public void setDrzava(String drzava) {
	this.drzava = drzava;
}

public String getAdresa() {
	return adresa;
}

public void setAdresa(String adresa) {
	this.adresa = adresa;
}

public int getPtbroj() {
	return ptbroj;
}

public void setPtbroj(int ptbroj) {
	this.ptbroj = ptbroj;
}
   
   

}