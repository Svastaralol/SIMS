package model;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  bojan
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Korisnik implements Serializable {
   protected String ime;
   protected String prezime;
   protected String eMail;
   protected String korIme;
   protected String lozinka;
   
   public java.util.Collection<Alat> Alat;
   public java.util.Collection<Namirnica> Namirnica;
   public Recepat omiljeni;
   
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

   public void uvecajOcenu(Recepat r) {
      // TODO: implement
   }
   
   public void umanjiOcenu(Recepat r) {
      // TODO: implement
   }
   
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
