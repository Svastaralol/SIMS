package model;

import java.io.Serializable;

public class Komentar implements Serializable{
	
	private String naslov;
	private String opis;
	private Korisnik korisnik;
	
	public Komentar() { }
	

	public Komentar(String naslov, String opis, Korisnik korisnik) {
		this.naslov = naslov;
		this.opis = opis;
		this.korisnik = korisnik;
	}



	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}
