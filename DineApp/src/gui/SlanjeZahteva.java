package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DineApp;
import model.Namirnica;

@SuppressWarnings("serial")
public class SlanjeZahteva extends JFrame {
	
	private int width = 300;
	private int height = 200;
	
	/* GUI KOMPONENTE */
	private JTextField poljeZaNamirnicu;
	private JTextField poljeZaCenu;
	
	private JLabel labelaZaPolje;
	private JLabel labelaZaCenu;
	
	private JButton dugmePosalji;
	private JButton dugmeOtkazi;
	
	
	public SlanjeZahteva() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(250, 250, width, height);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		
		/* Inicijalizacija GUI komponenti */
		poljeZaNamirnicu = new JTextField(20);
		labelaZaPolje = new JLabel("Unesite naziv namirnice: ");
		labelaZaPolje.setToolTipText("Unesite naziv namirnice koju hocete da posaljete na validaciju admin-u");
		
		poljeZaCenu = new JTextField(20);
		labelaZaCenu = new JLabel("Unesite cenu u din: ");
		labelaZaCenu.setToolTipText("Unesite predlozenu cenu namirnice koja ide na validaciju");
		
		dugmePosalji = new JButton("Posalji");
		dugmeOtkazi = new JButton("Otkazi");
		
		/* Dodavanje komponenti panelu */
		panel.add(labelaZaPolje);
		panel.add(poljeZaNamirnicu);
		panel.add(labelaZaCenu);
		panel.add(poljeZaCenu);
		panel.add(dugmePosalji);
		panel.add(dugmeOtkazi);
		
		//dodavanje action listener-a na komponente
		dodajListenere();
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void dodajListenere() {
		
		dugmeOtkazi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SlanjeZahteva.this.dispose();
			}
		});
		
		
		dugmePosalji.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String naziv = poljeZaNamirnicu.getText().toLowerCase();
				String cena = poljeZaCenu.getText();
				
				Namirnica n = new Namirnica("", naziv, Integer.parseInt(cena));
				DineApp.getInstance().namirniceZaObradu.add(n);
				System.out.println(DineApp.getInstance().namirniceZaObradu.size());
				
				SlanjeZahteva.this.dispose();
			}
		});
	}
	
}
