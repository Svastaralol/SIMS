package model;

import java.io.Serializable;

//ASOCIJATIVNA KLASA
public class Sastojak implements Serializable {
  
   private boolean opciona; //false po default-u
   private int kolicina;
   private Namirnica namirnica;
   
   public Sastojak() {
	   this.opciona = false;
   }
   
   public Sastojak(boolean opciona, int kolicina, Namirnica namirnica) {
	
	this.opciona = opciona;
	this.kolicina = kolicina;
	this.namirnica = namirnica;
   }

	public boolean isOpciona() {
		return opciona;
	}
	
	public void setOpciona(boolean opciona) {
		this.opciona = opciona;
	}
	
	public int getKolicina() {
		return kolicina;
	}
	
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	public Namirnica getNamirnica() {
		return namirnica;
	}
	
	public void setNamirnica(Namirnica namirnica) {
		this.namirnica = namirnica;
	}

	public String toString() {
		return this.namirnica.getNaziv();
	}
}
