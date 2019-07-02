/***********************************************************************
 * Module:  ProizvodUProdavnici.java
 * Author:  Marija
 * Purpose: Defines the Class ProizvodUProdavnici
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid f359c7f0-ec98-48af-89b0-e4aab83512c6 */
public class ProizvodUProdavnici {
   /** @pdOid fd8c0453-61e9-4938-8a8b-3af6da024ea6 */
   private int kolicina;
   
   /** @pdRoleInfo migr=no name=Proizvod assc=association13 mult=1..1 */
   public Proizvod proizvod;

}