/***********************************************************************
 * Module:  Osoba.java
 * Author:  Marija
 * Purpose: Defines the Class Osoba
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid f168e367-08e7-4404-af82-a7431f69f0f4 */
public class Osoba {
   /** @pdOid 29049444-9ca4-4c52-b500-84bd556be10e */
   private String ime;
   /** @pdOid fd5a81c4-511e-4c15-8402-f9cfb0c83b14 */
   private String prezime;
   /** @pdOid 55b64444-63b6-4904-a9c1-c9367d2cfd29 */
   private String telefon;
   
   /** @pdRoleInfo migr=no name=Nalog assc=association1 mult=1..1 */
   public Nalog nalog;
   /** @pdRoleInfo migr=no name=Mesto assc=association23 mult=1..1 */
   public Mesto mesto;

}