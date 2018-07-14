package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
	
	int width = 480;
	int height = 300;
	
	/* GUI KOMPONENTE */
	JTextField poljeZaIme;
	JTextField poljeZaPrezime;
	JTextField poljeZaSifru;
	JTextField poljeZaNamirnice;
	JTextField poljeZaAlate;
	
	JLabel labelaZaIme;
	JLabel labelaZaPrezime;
	JLabel labelaZaSifru;
	JLabel labelaZaNamirnice;
	JLabel labelaZaAlate;
	
	JButton potvrdiDugme;
	JButton odustanakDugme;
	
	public IzmenaPodataka() {
		
		this.setBounds(200, 200, width, height);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
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
		poljeZaPrezime = new JTextField(DineApp.getInstance().ulogovaniKorisnik.getPrezime(), 20);
		poljeZaSifru = new JTextField(DineApp.getInstance().ulogovaniKorisnik.getLozinka(), 20);
		poljeZaNamirnice = new JTextField(dobaviSpisakNamirnica(), 25);
		poljeZaAlate = new JTextField(dobaviSpisakAlata(), 25);
		
		//inicijalizacija dugmica
		potvrdiDugme = new JButton("Potvrdi");
		odustanakDugme = new JButton("Odustani");
		
		/* dodavanje komponenti panelu */
		
		//dodavanje labela i text polja
		panel.add(labelaZaIme);
		panel.add(poljeZaIme);
		
		panel.add(labelaZaPrezime);
		panel.add(poljeZaPrezime);
		
		panel.add(labelaZaSifru);
		panel.add(poljeZaSifru);
		
		panel.add(labelaZaNamirnice);
		panel.add(poljeZaNamirnice);
		
		panel.add(labelaZaAlate);
		panel.add(poljeZaAlate);
		
		//dodavanje dugmica
		panel.add(potvrdiDugme);
		panel.add(odustanakDugme);
		
		dodajListenere();
		
		this.add(panel);
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
