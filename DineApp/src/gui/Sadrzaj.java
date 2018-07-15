package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.DineApp;
import model.Objavljen;
import model.Validacija;

@SuppressWarnings("serial")
public class Sadrzaj extends JPanel {

	public Sadrzaj() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(255, 255, 255));

	}

	public void obrisiSveKomponente() {
		for (int i = 0; i < this.getComponents().length; i++) {
			this.remove(i);
			i--;

		}
		// DineApp.getInstance().mainWindow.revalidate();

	}

	public void ucitajRecepteKorisnik() {
		for (int i = 0; i < DineApp.recepti.size(); i++) {
			if (DineApp.recepti.get(i).getStanje() instanceof Objavljen) {
				this.add(new Stavka(DineApp.recepti.get(i)));
				System.out.println("sss");
			}

		}
		// DineApp.getInstance().mainWindow.revalidate();
	}

	public void ucitajRecepteAdministrator() {
		for (int i = 0; i < DineApp.recepti.size(); i++) {
			if (DineApp.recepti.get(i).getStanje() instanceof Validacija) {
				this.add(new Stavka(DineApp.recepti.get(i)));
			}

		}
		// DineApp.getInstance().mainWindow.revalidate();
	}

	public void pretraga() {

		this.obrisiSveKomponente();
		
		
		
		Component komponenta = DineApp.getInstance().mainWindow.container.getComponents()[0];
		AlatkeKorisnika alatka = (AlatkeKorisnika) komponenta;
		String naziv = alatka.getUnosNaziva().getText();
		String namirnice = alatka.getUnosNamirnica().getText();
		String brojPorcija = alatka.getUnosBrojPorcija().getText();
		
		for (int i = 0; i < DineApp.recepti.size(); i++) {
			if (DineApp.recepti.get(i).getStanje() instanceof Objavljen) {
				
				if(naziv.equalsIgnoreCase(DineApp.recepti.get(i).getNaziv())  )
				this.add(new Stavka(DineApp.recepti.get(i)));
				System.out.println(naziv);
				
			}
		}
		
		
		MainWindow.changeFont(this);
		DineApp.getInstance().mainWindow.revalidate();
		
		
		

	}

	public void refreshRecepteKorisnik() {
		this.obrisiSveKomponente();
		this.ucitajRecepteKorisnik();
		MainWindow.changeFont(this);
		DineApp.getInstance().mainWindow.revalidate();
	}

	public void refreshRecepteAdministrator() {
		this.obrisiSveKomponente();
		this.ucitajRecepteAdministrator();
		MainWindow.changeFont(this);
		DineApp.getInstance().mainWindow.revalidate();
	}

	public void refreshKorisnike() {

	}

	public void refresNamirnice() {

	}

}
