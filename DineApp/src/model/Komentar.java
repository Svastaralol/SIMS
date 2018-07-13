package model;

public class Komentar {
	
	private String naslov;
	private String opis;
	
	public Komentar() { }
	

	public Komentar(String naslov, String opis) {
		this.naslov = naslov;
		this.opis = opis;
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
	
	

}
