package model;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  bojan
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/** @pdOid c6fe57a1-3d27-4d16-928b-0d201b4a0693 */
public class Korisnik implements Serializable {
   /** @pdOid a12c74f4-4dc2-43b1-96fd-a09d846aed60 */
   protected String ime;
   /** @pdOid 23024268-323f-4d6a-97bf-166601e0b3a0 */
   protected String prezime;
   /** @pdOid 8913f2c0-5e4c-4584-a46a-3b0def725719 */
   protected String eMail;
   /** @pdOid 6c809f38-9172-4a0e-a7ba-75309e837dd9 */
   protected String korIme;
   /** @pdOid 218220a6-9b4c-4d63-bb2d-267f900bc576 */
   protected String lozinka;
   
   /** @pdRoleInfo migr=no name=Alat assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Alat> Alat;
   /** @pdRoleInfo migr=no name=Namirnica assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Namirnica> Namirnica;
   
   public Korisnik() {
	   
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
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getKorIme() {
		return korIme;
	}
	
	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

/** @param r
    * @pdOid c4d1eacc-aca0-48f2-a5d5-a7d871ea1da9 */
   public void uvecajOcenu(Recepat r) {
      // TODO: implement
   }
   
   /** @param r
    * @pdOid 6613da25-6544-4bd0-a3d5-fbddc7722486 */
   public void umanjiOcenu(Recepat r) {
      // TODO: implement
   }
   
   /** @pdGenerated default getter */
   public java.util.Collection<Alat> getAlat() {
      if (Alat == null)
         Alat = new java.util.HashSet<Alat>();
      return Alat;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAlat() {
      if (Alat == null)
         Alat = new java.util.HashSet<Alat>();
      return Alat.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAlat */
   public void setAlat(java.util.Collection<Alat> newAlat) {
      removeAllAlat();
      for (java.util.Iterator iter = newAlat.iterator(); iter.hasNext();)
         addAlat((Alat)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAlat */
   public void addAlat(Alat newAlat) {
      if (newAlat == null)
         return;
      if (this.Alat == null)
         this.Alat = new java.util.HashSet<Alat>();
      if (!this.Alat.contains(newAlat))
         this.Alat.add(newAlat);
   }
   
   /** @pdGenerated default remove
     * @param oldAlat */
   public void removeAlat(Alat oldAlat) {
      if (oldAlat == null)
         return;
      if (this.Alat != null)
         if (this.Alat.contains(oldAlat))
            this.Alat.remove(oldAlat);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAlat() {
      if (Alat != null)
         Alat.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Namirnica> getNamirnica() {
      if (Namirnica == null)
         Namirnica = new java.util.HashSet<Namirnica>();
      return Namirnica;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNamirnica() {
      if (Namirnica == null)
         Namirnica = new java.util.HashSet<Namirnica>();
      return Namirnica.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNamirnica */
   public void setNamirnica(java.util.Collection<Namirnica> newNamirnica) {
      removeAllNamirnica();
      for (java.util.Iterator iter = newNamirnica.iterator(); iter.hasNext();)
         addNamirnica((Namirnica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNamirnica */
   public void addNamirnica(Namirnica newNamirnica) {
      if (newNamirnica == null)
         return;
      if (this.Namirnica == null)
         this.Namirnica = new java.util.HashSet<Namirnica>();
      if (!this.Namirnica.contains(newNamirnica))
         this.Namirnica.add(newNamirnica);
   }
   
   /** @pdGenerated default remove
     * @param oldNamirnica */
   public void removeNamirnica(Namirnica oldNamirnica) {
      if (oldNamirnica == null)
         return;
      if (this.Namirnica != null)
         if (this.Namirnica.contains(oldNamirnica))
            this.Namirnica.remove(oldNamirnica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNamirnica() {
      if (Namirnica != null)
         Namirnica.clear();
   }

   public String toString() {
	   return this.ime + ", " + this.prezime + ", " + this.korIme + ", " + this.lozinka;
   }
}
