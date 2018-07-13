package model;

import java.util.Date;
import java.util.List;

public class Recepat {
	
	 private String naziv;
	 private String uputstvo;
	 private int ocena; //po default-u 0
	 private String sifra;
	 private Date datumObjave;
	 private List<Sastojak> namirnice;
	// private StanjeRecepta stanje;
	 
	 public Recepat() {
		 this.ocena = 0;
		 //inicijalizuj stanje na izrada
		 
	 }

	//konstruktor sa parametrima

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getUputstvo() {
		return uputstvo;
	}

	public void setUputstvo(String uputstvo) {
		this.uputstvo = uputstvo;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Date getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	
	 
	 

}
