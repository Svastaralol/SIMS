package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AlatkeKorisnika extends JPanel{

	private JTextField unosNaziva;
	private JTextField unosNamirnica;
	private JTextField unosAlata;
	private JTextField unosBrojPorcija;
	private JButton pretragaDugme;
	private JButton kreirajReceptDugme;
	private JButton unesiPodatkeDugme;
	private JButton slanjeZahtevaZaNamirnicu;
	
	private JRadioButton sortirajRastuceDugme;
	private JRadioButton sortirajOpadajuceDugme;
	
	private JRadioButton prikaziOmiljenoDugme;
	private JRadioButton prikaziSveDugme;
	
	
	public AlatkeKorisnika() {
		super(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color(255, 255, 255));
		this.setPreferredSize(new Dimension(-550, 0));
		
		int textFieldSize = 26;
		
		this.unosNaziva = new JTextField(textFieldSize);
		this.unosNaziva.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		this.unosNamirnica = new JTextField(textFieldSize);
		this.unosNamirnica.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		this.unosAlata = new JTextField(textFieldSize);
		this.unosAlata.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		this.unosBrojPorcija = new JTextField(2);
		this.unosBrojPorcija.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		this.pretragaDugme = new JButton("Pretrazi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(100, 26));
			setOpaque(true);
		}};
		
		this.kreirajReceptDugme = new JButton("Kreiraj Recepat"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		kreirajReceptDugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KreiranjeRecepta kreiranje = new KreiranjeRecepta();
				MainWindow.changeFont(kreiranje);
				
			}
			
		});
		
		this.slanjeZahtevaZaNamirnicu = new JButton("Posalji zahtev za novu namirnicu"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		slanjeZahtevaZaNamirnicu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SlanjeZahteva sz = new SlanjeZahteva();
				MainWindow.changeFont(sz);
				
			}
			
		});
		
		this.unesiPodatkeDugme = new JButton("Izmena Podataka"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		
		this.unesiPodatkeDugme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IzmenaPodataka izmena = new IzmenaPodataka();
				MainWindow.changeFont(izmena);
		}
		});
		
		this.prikaziOmiljenoDugme = new JRadioButton("Omiljeno"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		this.prikaziSveDugme = new JRadioButton("Sve"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		this.sortirajOpadajuceDugme = new JRadioButton("Opadajuce"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		this.sortirajRastuceDugme = new JRadioButton("Rastuce"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		ButtonGroup gp1 = new ButtonGroup();
		gp1.add(this.sortirajOpadajuceDugme);
		gp1.add(this.sortirajRastuceDugme);
		
		
		ButtonGroup gp2 = new ButtonGroup();
		gp2.add(prikaziOmiljenoDugme);
		gp2.add(prikaziSveDugme);
		
		this.prikaziSveDugme.setSelected(true);
		this.sortirajOpadajuceDugme.setSelected(true);
		
		//this.pretragaDugme.setOpaque(true);
		
		JLabel naslov = new JLabel("DineApp");
		naslov.setFont(naslov.getFont().deriveFont(74f));
		naslov.setForeground(new Color(0, 179, 143));
		
		JLabel unosNazivaLabela = new JLabel("Unesite naziv recepta: ");
		
		JLabel unosNamirnicaLabela = new JLabel("Unesite namirnice recepta: ");
		
		JLabel unosAlataLabela = new JLabel("Unesite alat koji se koristi: ");
		
		JLabel unosBrojPorcijaLabela = new JLabel("Unesite broj porcija: ");
		
		JLabel vrstaSortiranja = new JLabel("Sortiraj po oceni: ");
		
		JLabel omiljenoIliSveLabela = new JLabel("Odaberite vrstu prikaza: ");
		
		this.add(naslov);
		this.add(MainWindow.getNewLine());
		this.add(unosNazivaLabela);
		this.add(this.unosNaziva);
		this.add(unosNamirnica);
		this.add(unosNamirnicaLabela);
		this.add(this.unosNamirnica);
		this.add(unosAlataLabela);
		this.add(this.unosAlata);
		this.add(unosBrojPorcijaLabela);
		this.add(this.unosBrojPorcija);
		this.add(new JLabel("                     "));
		this.add(this.pretragaDugme);
		
		this.add(vrstaSortiranja);
		this.add(sortirajOpadajuceDugme);
		this.add(sortirajRastuceDugme);
		
		this.add(MainWindow.getNewLine());
		this.add(this.kreirajReceptDugme);
		this.add(this.slanjeZahtevaZaNamirnicu);
		this.add(this.unesiPodatkeDugme);
		this.add(omiljenoIliSveLabela);
		this.add(this.prikaziOmiljenoDugme);
		this.add(this.prikaziSveDugme);
		
	
	}

}
