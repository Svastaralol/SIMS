package model;

import java.io.Serializable;

public class Namirnica implements Serializable {
	
	private static final long serialVersionUID = -3620343728288338333L;
	private int sifra;
	private String naziv;
	private int cena;
	private boolean validna;
	
	public Namirnica() { this.validna = false;}
	
	public Namirnica(String naziv) {
		this.naziv = naziv;
		this.validna = false;
	}
	
	public Namirnica(int sifra, String naziv, int cena) {
		
		this.setSifra(sifra);
		this.naziv = naziv;
		this.setCena(cena);
		this.validna = false;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public boolean isValidna() {
		return validna;
	}

	public void setValidna(boolean validna) {
		this.validna = validna;
	}
}
