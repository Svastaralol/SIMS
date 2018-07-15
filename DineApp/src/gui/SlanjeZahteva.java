package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DineApp;
import model.Namirnica;

@SuppressWarnings("serial")
public class SlanjeZahteva extends JFrame {
	
	private int width = 270;
	private int height = 180;
	
	/* GUI KOMPONENTE */
	private JTextField poljeZaNamirnicu;
	private JTextField poljeZaCenu;
	
	private JLabel labelaZaPolje;
	private JLabel labelaZaCenu;
	
	private JButton dugmePosalji;
	private JButton dugmeOtkazi;
	
	
	public SlanjeZahteva() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255, 255, 255));
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		bottomLayer.setPreferredSize(new Dimension(0, -25));
		
		/* Inicijalizacija GUI komponenti */
		poljeZaNamirnicu = new JTextField(20);
		poljeZaNamirnicu.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		labelaZaPolje = new JLabel("Unesite naziv namirnice: ");
		labelaZaPolje.setToolTipText("Unesite naziv namirnice koju hocete da posaljete na validaciju admin-u");
		
		poljeZaCenu = new JTextField(20);
		poljeZaCenu.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		labelaZaCenu = new JLabel("Unesite cenu u din: ");
		labelaZaCenu.setToolTipText("Unesite predlozenu cenu namirnice koja ide na validaciju");
		
		dugmePosalji = new JButton("Posalji"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(66, 36));
			setOpaque(true);
		}};
		dugmeOtkazi = new JButton("Otkazi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(66, 36));
			setOpaque(true);
		}};
		
		/* Dodavanje komponenti panelu */
		topLayer.add(labelaZaPolje);
		topLayer.add(poljeZaNamirnicu);
		topLayer.add(labelaZaCenu);
		topLayer.add(poljeZaCenu);
		bottomLayer.add(dugmePosalji);
		bottomLayer.add(dugmeOtkazi);
		
		container.add(topLayer);
		container.add(bottomLayer);
		
		//dodavanje action listener-a na komponente
		dodajListenere();
		
		this.add(container);
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
				
				int sifra = 0;
				
				for (int i = 0; i < DineApp.namirnice.size(); i++) {
					if (DineApp.namirnice.get(i).getSifra() >= sifra) {
						sifra = DineApp.namirnice.get(i).getSifra() + 1;
					}
				}
				
				
				Namirnica n = new Namirnica(sifra, naziv, Integer.parseInt(cena));
				System.out.println(n.isValidna());
				DineApp.getInstance().namirnice.add(n);
				
				//upis dodate namirnice u fajl(zapravo  se upisu sve namirnice)
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/namirnice.sims"));
					out.writeObject(DineApp.namirnice);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				SlanjeZahteva.this.dispose();
			}
		});
	}
	
}
