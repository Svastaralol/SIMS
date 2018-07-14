package model;

import java.io.Serializable;

public class Namirnica implements Serializable {
	
	private static final long serialVersionUID = -3620343728288338333L;
	private String sifra;
	private String naziv;
	private int cena;
	
	public Namirnica() {}
	
	public Namirnica(String naziv) {
		this.naziv = naziv;
	}
	
	public Namirnica(String sifra, String naziv, int cena) {
		super();
		this.setSifra(sifra);
		this.naziv = naziv;
		this.setCena(cena);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}
}
