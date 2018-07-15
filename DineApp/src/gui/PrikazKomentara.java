package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.Komentar;
import model.Recepat;

public class PrikazKomentara extends JFrame {
	
	private int width = 500;
	private int height = 400;
	
	/* GUI KOMPONENTE */
	private JTextArea komentari;
	private JScrollPane scrollBar;
	
	public PrikazKomentara(Recepat r) {
		
		this.setTitle("Komentari");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//inicijalizacija text area
		komentari = new JTextArea(20, 45);
		komentari.setFont(komentari.getFont().deriveFont(13f));
		komentari.setEditable(false);;
		komentari.setLineWrap(true); //ako dodje do kraja, turi u novi red
		komentari.setWrapStyleWord(true); //ako dodje do kraja, turi CELU REC dole, ne preseca je
		komentari.setBorder(BorderFactory.createEmptyBorder());
		//da bi se video text area na prozoru
		//Border border = BorderFactory.createLineBorder(Color.gray);
		//komentari.setBorder(border);
		
		//inicijalizacija scrollbar-a
		scrollBar = new JScrollPane(komentari, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollBar.setSize(100, 200);
		
		//popuni text are komentarima
		komentari.setText(dodavanjeSvihKomentara(r));
		
		//dodavanje komponenti panelu
		panel.add(scrollBar);
		
		this.setResizable(false);
		this.add(panel);
		this.setVisible(true);
		MainWindow.changeFont(this);
	}
	
	//dodajem sve komentare u text area
	public String dodavanjeSvihKomentara(Recepat r) {
		
		StringBuilder sb = new StringBuilder();
		
		for(Komentar k: r.komentari) {
			
			sb.append("NASLOV: " + k.getNaslov() + "\n\n");
			sb.append("OPIS: " + k.getOpis() + "\n\n");
			sb.append("OKACIO: " + k.getKorisnik().getIme() + " " + k.getKorisnik().getPrezime() + "\n");
			sb.append("-----------------------------------------------------\n\n");
			
		}
		
		return sb.toString();
	}

}
