package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Border border = BorderFactory.createLineBorder(Color.GRAY);
	
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
	
	private AlatkeKorisnika alatke;
	private Sadrzaj sadrzaj;
	
	public MainWindow() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	// podesava da se prozor ne moze razvlaciti
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.container = new JPanel();
		this.container.setLayout(new BoxLayout(this.container, BoxLayout.X_AXIS));
		
		this.alatke = new AlatkeKorisnika();
		this.sadrzaj = new Sadrzaj();
		
		this.container.add(this.alatke);
		JScrollPane scrollFrame = new JScrollPane(this.sadrzaj);
		scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
		scrollFrame.setVisible(true);
		scrollFrame.setBorder(BorderFactory.createEmptyBorder());
		this.sadrzaj.setAutoscrolls(true);
		this.container.add(scrollFrame);
		
		this.add(this.container);
		
		//this.setVisible(true);
		new Logovanje();
	}
}
