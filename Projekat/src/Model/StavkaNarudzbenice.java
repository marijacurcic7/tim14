/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * Author:  Marija
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/

package Model;

import java.util.*;

/** @pdOid f1031a6e-a25a-4da9-ac9e-8b4738f1370f */
public class StavkaNarudzbenice {
   /** @pdOid c8088f35-64f3-4ef8-ae51-36f91ca2935e */
   private int kolicina;
   /** @pdOid 99b9acc7-cb5c-4c29-962b-9c19465520fa */
   private double jedinicnaCena;
   /** @pdOid 10717086-57d2-4a0a-a3d9-ee9ca070bd1c */
   private double ukupnaCena;
   
   /** @pdRoleInfo migr=no name=Proizvod assc=association11 mult=1..1 side=A */
   public Proizvod proizvod;

}