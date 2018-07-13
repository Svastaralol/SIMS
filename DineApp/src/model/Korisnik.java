package model;

public abstract class Korisnik {
	
	protected String ime;
	protected String prezime;
	protected String eMail;
	protected String korIme;
	protected String lozinka;
	
	public Korisnik() {
		
	}

	public Korisnik(String ime, String prezime, String eMail, String korIme,
			String lozinka) {
		
		this.ime = ime;
		this.prezime = prezime;
		this.eMail = eMail;
		this.korIme = korIme;
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public void uvecajOcenu(Recepat r) {
		
	}
	
	public void umanjiOcenu(Recepat r) {
		
	}
	
	
	
	
	
	

}
