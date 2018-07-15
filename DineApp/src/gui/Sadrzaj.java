package gui;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.DineApp;
import model.Korisnik;
import model.Recepat;

@SuppressWarnings("serial")
public class Sadrzaj extends JPanel{


	public Sadrzaj() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(255, 255, 255));
		
		
	}
	
	public void obrisiSveKomponente() {
		for(int i = 0; i < this.getComponents().length; i++) {
			this.remove(i);
			i--;
			
		}
		DineApp.getInstance().mainWindow.revalidate();
		
	}
	
	public void ucitajRecepte() {
		for (int i = 0; i < DineApp.recepti.size(); i++) {
			this.add(new Stavka(DineApp.recepti.get(i)));
		}
		DineApp.getInstance().mainWindow.revalidate();
	}
	
	public void refresh() {
		
	}
	
}
