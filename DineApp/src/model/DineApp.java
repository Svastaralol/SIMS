package model;

import java.awt.Font;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.MainWindow;
import gui.ValidacijaRecepata;

public class DineApp {
	
	private static DineApp instance = null;
	public static ArrayList<Korisnik> korisnici = new ArrayList<>();
	public static ArrayList<Recepat> recepti = new ArrayList<>();
	
	public List<Namirnica> namirnice = new ArrayList<Namirnica>();
	public List<Alat> alati = new ArrayList<Alat>();
	
	public Korisnik ulogovaniKorisnik;
	public MainWindow mainWindow;
	
	public DineApp() {
		this.mainWindow = new MainWindow();
		//MainWindow.changeFont(this.mainWindow);
		this.mainWindow.revalidate();
	}
	
	public static DineApp getInstance() { //singleton
		
		if (instance == null) {
			instance = new DineApp();
			return instance;
		}
		
		return instance;
		
	}
	
	public static void main(String[] args) {
		try {
			MainWindow.font = Font.createFont(Font.TRUETYPE_FONT, new File("./data/fonts/Montserrat-Regular.ttf")).deriveFont(12f); 
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(MainWindow.font);
			
			// Ucitavanje korisnika ili kreiranje fajla ako ne postji jos uvek
			File f = new File("./data/files/korisnici.sims");
			if (!f.exists()) {
				f.createNewFile();
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/korisnici.sims"));
				out.writeObject(DineApp.korisnici);
			}
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("./data/files/korisnici.sims"));
			korisnici = (ArrayList<Korisnik>) in.readObject();
			in.close();
			
			// Ucitavanje recepata ili kreiranje fajla ako ne postji jos uvek
			f = new File("./data/files/recepti.sims");
			if (!f.exists()) {
				f.createNewFile();
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/recepti.sims"));
				out.writeObject(DineApp.recepti);
			}
			in = new ObjectInputStream(new FileInputStream("./data/files/recepti.sims"));
			recepti = (ArrayList<Recepat>) in.readObject();
			in.close();
			System.out.println(recepti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // stavlja windows okruzenje
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		
		DineApp.getInstance();
		
	}

}
