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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Alat;
import model.DineApp;
import model.Namirnica;

public class IzmenaPodataka extends JFrame {
	
	private int width = 270;
	private int height = 330;
	
	/* GUI KOMPONENTE */
	private JTextField poljeZaIme;
	private JTextField poljeZaPrezime;
	private JTextField poljeZaSifru;
	private JTextField poljeZaNamirnice;
	private JTextField poljeZaAlate;
	
	private JLabel labelaZaIme;
	private JLabel labelaZaPrezime;
	private JLabel labelaZaSifru;
	private JLabel labelaZaNamirnice;
	private JLabel labelaZaAlate;
	
	private JButton potvrdiDugme;
	private JButton odustanakDugme;
	
	public IzmenaPodataka() {
		
		this.setSize(width, height);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255, 255, 255));
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		bottomLayer.setPreferredSize(new Dimension(0, -170));
		
		/* Inicijalizacija GUI komponenti */
		
		//inicijalizacija labeli
		labelaZaIme = new JLabel("Unesite novo ime: ");
		labelaZaPrezime = new JLabel("Unesite novo prezime: ");
		labelaZaSifru = new JLabel("Unesite novu lozinku: ");
		labelaZaNamirnice = new JLabel("Unesite namirnice: ");
		labelaZaAlate = new JLabel("Unesite alate: ");
		
		labelaZaNamirnice.setToolTipText("Odvojite namirnice zarezom: ");
		labelaZaAlate.setToolTipText("Odvojite alate zarezom");
		
		//inicijalizacija text polja
		poljeZaIme = new JTextField(DineApp.getInstance().ulogovaniKorisnik.getIme(), 20);
		poljeZaIme.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		poljeZaPrezime = new JTextField(DineApp.getInstance().ulogovaniKorisnik.getPrezime(), 20);
		poljeZaPrezime.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		poljeZaSifru = new JTextField(DineApp.getInstance().ulogovaniKorisnik.getLozinka(), 20);
		poljeZaSifru.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		poljeZaNamirnice = new JTextField(dobaviSpisakNamirnica(), 20);
		poljeZaNamirnice.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		poljeZaAlate = new JTextField(dobaviSpisakAlata(), 20);
		poljeZaAlate.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		//inicijalizacija dugmica
		potvrdiDugme = new JButton("Potvrdi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(78, 36));
			setOpaque(true);
		}};
		odustanakDugme = new JButton("Odustani"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(78, 36));
			setOpaque(true);
		}};
		
		/* dodavanje komponenti panelu */
		
		//dodavanje labela i text polja
		topLayer.add(labelaZaIme);
		topLayer.add(poljeZaIme);
		
		topLayer.add(labelaZaPrezime);
		topLayer.add(poljeZaPrezime);
		
		topLayer.add(labelaZaSifru);
		topLayer.add(poljeZaSifru);
		
		topLayer.add(labelaZaNamirnice);
		topLayer.add(poljeZaNamirnice);
		
		topLayer.add(labelaZaAlate);
		topLayer.add(poljeZaAlate);
		
		//dodavanje dugmica
		bottomLayer.add(potvrdiDugme);
		bottomLayer.add(odustanakDugme);
		
		container.add(topLayer);
		container.add(bottomLayer);
		
		dodajListenere();
		
		this.add(container);
		this.setVisible(true);
		
	}

	public void dodajListenere() {
		
		odustanakDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IzmenaPodataka.this.dispose();
			}
		});
		
		potvrdiDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//upamtim sve unesene podatke i snimim ih u fajl
				String ime = poljeZaIme.getText();
				String prezime = poljeZaPrezime.getText();
				String lozinka = poljeZaSifru.getText();
				
				DineApp.getInstance().ulogovaniKorisnik.setIme(ime);
				DineApp.getInstance().ulogovaniKorisnik.setPrezime(prezime);
				DineApp.getInstance().ulogovaniKorisnik.setLozinka(lozinka);
				
				//TODO: pamcenje namirnica i alata
				
				//snimanje podataka u fajl
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./korisnici.sims"));
					out.writeObject(DineApp.korisnici);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//zatvaranje prozora
				IzmenaPodataka.this.dispose();
			}
		});
		
	}
	
	//ispraznim listu namirnica, kreiram nove namirnice i dodam ih u listu
	public void ubaciNoveNamirnice(String tekst) {
		
		//TODO
	}
	
	public void ubaciNoveAlate(String tekst) {
		//TODO
	}

	public String dobaviSpisakNamirnica() {
		
		StringBuilder sbn = new StringBuilder();
		int brojac = 0;
		for(Namirnica n: DineApp.getInstance().ulogovaniKorisnik.Namirnica) {
			brojac++;
			sbn.append(n.getNaziv());
			if(!(brojac == DineApp.getInstance().ulogovaniKorisnik.Namirnica.size())) {
				sbn.append(", ");
			}
		}
		return sbn.toString();
	}
	
	public String dobaviSpisakAlata() {
		
		StringBuilder sba= new StringBuilder();
		int brojac = 0;
		for(Alat a: DineApp.getInstance().ulogovaniKorisnik.Alat) {
			brojac++;
			sba.append(a.getNaziv());
			if(!(brojac == DineApp.getInstance().ulogovaniKorisnik.Alat.size())) {
				sba.append(", ");
			}
		}
		System.out.println(brojac);
		return sba.toString();
		
	}
	
}
