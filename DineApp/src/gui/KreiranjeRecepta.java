package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.DineApp;
import model.Namirnica;
import model.Recepat;
import model.Sastojak;
import model.Validacija;


@SuppressWarnings("serial")
public class KreiranjeRecepta extends JFrame {
	private int width = 400;
	private int height = 410;
	
	private JPanel container;
	private JPanel topLayer;
	private JPanel bottomLayer;
	private JTextField nazivRecepta;
	private JTextArea opis;
	private JTextField kolikoOsoba;
	private JTextField glavneNamirnice;
	private JTextField opcioneNamirnice;
	
	
	public KreiranjeRecepta() {
		//super(new FlowLayout(FlowLayout.LEFT));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		JLabel nazivReceptaLabela = new JLabel("Naziv recepta: ");
		
		int textFieldSize = 31;
		
		nazivRecepta = new JTextField(textFieldSize);
		
		JLabel opisLabela = new JLabel("Uputstvo recepta: ");
		
		opis = new JTextArea(5, textFieldSize);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		
		nazivRecepta.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
	    opis.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		opis.setFont(nazivRecepta.getFont());
		opis.setLineWrap(true);
		opis.setWrapStyleWord(true);
		
		
		JLabel kolikoOsobaLabela = new JLabel("Za koliko osoba: ");
		
		kolikoOsoba = new JTextField(2);
		kolikoOsoba.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		glavneNamirnice = new JTextField(textFieldSize);
		glavneNamirnice.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		opcioneNamirnice = new JTextField(textFieldSize);
		opcioneNamirnice.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel namirniceLabela1 = new JLabel("Unesite glavne namirnice koje koristite u receptu:                          ");
		JLabel namirniceLabela2 = new JLabel("Unesite opcione namirnice koje koristite u receptu:                          ");
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setPreferredSize(new Dimension(0, 380));
		topLayer.setBackground(new Color(255, 255, 255));
		topLayer.add(nazivReceptaLabela);
		topLayer.add(this.nazivRecepta);
		topLayer.add(new JLabel("                                                                "
				+ "                    "
				+ "                    "
				+ "                    "));
		topLayer.add(opisLabela);
		topLayer.add(this.opis);
		topLayer.add(kolikoOsobaLabela);
		topLayer.add(kolikoOsoba);
		topLayer.add(new JLabel("                                                                "
				+ "                    "
				+ "                    "
				+ "                    "));
		topLayer.add(namirniceLabela1);
		topLayer.add(glavneNamirnice);
		topLayer.add(namirniceLabela2);
		topLayer.add(opcioneNamirnice);
		
		bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		
		JButton confirmButton = new JButton("Potvrdi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(66, 36));
			setOpaque(true);
		}};
		JButton cancelButton = new JButton("Odustani"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(66, 36));
			setOpaque(true);
		}};
		
		KreiranjeRecepta r = this;
		
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nazivRecepta.getText().isEmpty() || opis.getText().isEmpty() || glavneNamirnice.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena, sem opcionih namirnica", "Unos recepta", NORMAL);
				} else {
					Recepat r = new Recepat();
					List<Sastojak> sastojci = new ArrayList<>();
					String[] split = glavneNamirnice.getText().split(",");
					for(int i = 0; i < split.length; i++) {
						Sastojak s = new Sastojak();
						s.setKolicina(1);
						s.setNamirnica(new Namirnica(split[i]));
						sastojci.add(s);
					}
					r.setSastojci(sastojci);
					r.setDatumObjave(new Date());
					r.setNaziv(nazivRecepta.getText());
					r.setUputstvo(opis.getText());
					r.setKorisnik(DineApp.getInstance().ulogovaniKorisnik);
					r.setStanje(new Validacija());
					int brojOsoba = 0;
					try {
						brojOsoba = Integer.parseInt(kolikoOsoba.getText());
					}
					catch(Exception e) {
						brojOsoba = 2;
					}
					r.setKolikoOsoba(brojOsoba);
					DineApp.recepti.add(r);
					
					try {
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/files/recepti.sims"));
						out.writeObject(DineApp.recepti);
						JOptionPane.showMessageDialog(null, "Uspesno dodavanje recepta.", "Unos recepta", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					KreiranjeRecepta.this.dispose();
				}
			}
			
		});
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				r.dispose();
				
			}
			
		});
		
		
		bottomLayer.add(confirmButton);
		bottomLayer.add(cancelButton);
		
		
		container.add(this.topLayer);
		container.add(this.bottomLayer);
		this.add(container);
		
		
	}
}
