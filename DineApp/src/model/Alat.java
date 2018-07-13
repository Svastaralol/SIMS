package model;

public class Alat {
	
	private String naziv;
	private String sifra;
	
	public Alat() { }
	
	

	public Alat(String naziv, String sifra) {
		this.naziv = naziv;
		this.sifra = sifra;
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
	
	
}
