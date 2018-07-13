package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.DineApp;
import model.Recepat;

@SuppressWarnings("serial")
public class Sadrzaj extends JPanel{


	public Sadrzaj() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(new Color(255, 255, 255));
		
		
		for(int i = 0; i < 10; i++) {
			this.add(new Stavka(new Recepat()));
		}
		
	}
	
	public void obrisiSveKomponente() {
		for(int i = 0; i < this.getComponents().length; i++) {
			this.remove(i);
			i--;
			
		}
		DineApp.getInstance().mainWindow.revalidate();
		
	}
	
}
