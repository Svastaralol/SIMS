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
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
