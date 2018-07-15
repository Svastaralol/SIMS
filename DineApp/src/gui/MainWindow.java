package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import model.DineApp;
import model.Recepat;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Border border = BorderFactory.createLineBorder(Color.GRAY);
	public static JScrollPane scrollFrame;
	
	public static Font font;
	public static JLabel getNewLine() { 
		return new JLabel("                         "
			+ "                          "
			+ "                          "
			+ "                          "
			+ "                          "
			+ "                          "
			+ "                          ");
	}
	public static void changeFont (Component component) {	//rekurzivno podesava font svih komponenti
	    component.setFont(new Font("Montserrat", component.getFont().getStyle(), component.getFont().getSize()));
	    if (component instanceof Container) {
	        for ( Component child : ( ( Container ) component ).getComponents () ) {
	            changeFont (child);
	        }
	    }
	}
	
	public static int screenWidth;
	public static int screenHeight;
	
	public int width = 1280;
	public int height = 720;
	public JPanel container;
	
	public Sadrzaj sadrzaj;
	
	public MainWindow() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	// podesava da se prozor ne moze razvlaciti
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.container = new JPanel();
		this.container.setLayout(new BoxLayout(this.container, BoxLayout.X_AXIS));
		
		//this.alatke = new AlatkeAdministratora();
		//this.sadrzaj = new Sadrzaj();
		
		//this.container.add(this.alatke);
		//JScrollPane scrollFrame = new JScrollPane(this.sadrzaj);
		//scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		//scrollFrame.setVisible(true);
		//scrollFrame.setBorder(BorderFactory.createEmptyBorder());
		//this.sadrzaj.setAutoscrolls(true);
		//this.container.add(scrollFrame);
		
		//this.add(this.container);
		
		//this.setVisible(true);
		new Logovanje();

	}
	
	public static void upisRecepataUFajl() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/recepti.sims"));
			out.writeObject(DineApp.recepti);
			//JOptionPane.showMessageDialog(null, "Uspesno dodavanje recepta.", "Unos recepta", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void upisKorisnikaUFajl() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/korisnici.sims"));
			out.writeObject(DineApp.korisnici);
			//JOptionPane.showMessageDialog(null, "Uspesno dodavanje recepta.", "Unos recepta", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
