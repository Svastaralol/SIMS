package model;

import java.io.Serializable;

import gui.ValidacijaRecepata;

@SuppressWarnings("serial")
public class Administrator extends Korisnik implements Serializable{
	
	public Administrator() {
	}
	
	public void validacijaRecepta(Recepat recepat) {
		new ValidacijaRecepata(recepat);
		
	}

}
