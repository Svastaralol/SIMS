package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Recepat implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID =  -8949440908658012020L;
	private String naziv;
	 private String uputstvo;
	 private int ocena; //po default-u 0
	 private String sifra;
	 private Date datumObjave;
	 private List<Sastojak> sastojci;
	 private StanjeRecepta stanje; //inicijalno izrada
	 
	 public Recepat() {
		 this.ocena = 0;
		 this.setStanje(new Izrada());
		 
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

	public List<Sastojak> getSastojci() {
		return sastojci;
	}

	public void setSastojci(List<Sastojak> namirnice) {
		this.sastojci = namirnice;
	}
	
	public String toString() {
		return this.naziv + ", " + this.uputstvo + ", " + this.sastojci;
	}

	public StanjeRecepta getStanje() {
		return stanje;
	}

	public void setStanje(StanjeRecepta stanje) {
		this.stanje = stanje;
	}
}
