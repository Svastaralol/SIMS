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

import model.DineApp;


@SuppressWarnings("serial")
public class AlatkeAdministratora extends JPanel{

	private JTextField unosKorImena;
	
	private JButton pretragaDugme;
	private JButton prikaziRecepte;
	private JButton prikaziKorisnike;
	private JButton prikaziNamirnice;
	
	private JRadioButton sortirajRastuceDugme;
	private JRadioButton sortirajOpadajuceDugme;
	
	
	
	public AlatkeAdministratora() {
		super(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color(255, 255, 255));
		this.setPreferredSize(new Dimension(-550, 0));
		
		int textFieldSize = 26;
		
		this.unosKorImena = new JTextField(textFieldSize);
		this.unosKorImena.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		
		this.pretragaDugme = new JButton("Pretrazi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(100, 26));
			setOpaque(true);
		}};
		
		this.prikaziRecepte = new JButton("Prikazi recepte"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		prikaziRecepte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteAdministrator();
				
			}
			
		});
		
		this.prikaziKorisnike = new JButton("Prikazi korisnike"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		
		prikaziKorisnike.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DineApp.getInstance().mainWindow.sadrzaj.refreshKorisnike();
				
			}
			
		});
		
		this.prikaziNamirnice = new JButton("Prikazi namirnice za obradu"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(325, 36));
			setOpaque(true);
			
		}};
		
		prikaziNamirnice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KreiranjeRecepta kreiranje = new KreiranjeRecepta();
				MainWindow.changeFont(kreiranje);
				
			}
			
		});
		
		
		this.sortirajOpadajuceDugme = new JRadioButton("Opadajuce"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		this.sortirajRastuceDugme = new JRadioButton("Rastuce"){{
			setBackground(new Color(255, 255, 255));
		}};
		
		ButtonGroup gp1 = new ButtonGroup();
		gp1.add(this.sortirajOpadajuceDugme);
		gp1.add(this.sortirajRastuceDugme);
		
		
		this.sortirajOpadajuceDugme.setSelected(true);
		
		//this.pretragaDugme.setOpaque(true);
		
		JLabel naslov = new JLabel("DineApp");
		naslov.setFont(naslov.getFont().deriveFont(74f));
		naslov.setForeground(new Color(0, 179, 143));
		
		JLabel unosKorImenaLabela = new JLabel("Unesite korisnicko ime: ");
		
		JLabel vrstaSortiranja = new JLabel("Sortiraj: ");
		
		this.add(naslov);
		this.add(MainWindow.getNewLine());
		this.add(unosKorImenaLabela);
		this.add(new JLabel("                            "));
		this.add(this.pretragaDugme);
		this.add(this.unosKorImena);
		
		this.add(vrstaSortiranja);
		this.add(sortirajOpadajuceDugme);
		this.add(sortirajRastuceDugme);
		
		this.add(MainWindow.getNewLine());
		this.add(this.prikaziRecepte);
		this.add(this.prikaziKorisnike);
		this.add(this.prikaziNamirnice);
		
	
	}

}
