package model;

import java.io.Serializable;

public class Namirnica implements Serializable {
	private String naziv;
	
	public Namirnica(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
