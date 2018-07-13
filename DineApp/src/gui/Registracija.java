package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Registracija extends JFrame{
	
	private int width = 400;
	private int height = 500;
	
	private JTextField ime;
	private JTextField prezime;
	private JTextField eMail;
	private JTextField korisnickoIme;
	private JPasswordField  lozinka;
	private JPasswordField  potvrdaLozinke;
	
	public Registracija() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(MainWindow.screenWidth/2 - width/2, MainWindow.screenHeight/2 - height/2, width, height);;
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255, 255, 255));
		
		this.ime = new JTextField(30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		}};
		
		this.prezime = new JTextField(30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		}};
		
		this.eMail = new JTextField(30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		}};
		
		this.korisnickoIme = new JTextField(30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		}};
		
		this.lozinka = new JPasswordField (30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			setEchoChar('*');
		}};
		
		this.potvrdaLozinke = new JPasswordField (30) {{
			setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			setEchoChar('*');
		}};
		
		
		topLayer.add(new JLabel("Unesite ime: "));
		topLayer.add(this.ime);
		topLayer.add(new JLabel("Unesite prezime: "));
		topLayer.add(this.prezime);
		topLayer.add(this.eMail);
		topLayer.add(this.korisnickoIme);
		topLayer.add(this.lozinka);
		topLayer.add(this.potvrdaLozinke);
		
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		
		container.add(topLayer);
		container.add(bottomLayer);
		
		this.add(container);
		
		
		
		this.setVisible(true);
		MainWindow.changeFont(this);
	}

}
