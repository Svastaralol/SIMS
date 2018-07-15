package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.DineApp;
import model.Korisnik;
import model.Recepat;
import model.Sastojak;

@SuppressWarnings("serial")
public class Stavka extends JPanel {
	
	private Recepat recepat;
	JPanel leftLayer;
	JPanel middleLayer;
	JPanel rightLayer;
	
	public Stavka (Recepat recepat) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(0,200));
		leftLayer = new JPanel();
		leftLayer.setBackground(new Color(255, 255, 255));
		leftLayer.setPreferredSize(new Dimension(-150,0));
		
		middleLayer = new JPanel();
		middleLayer.setLayout(new FlowLayout(FlowLayout.LEFT));
		middleLayer.setBackground(new Color(255, 255, 255));
		middleLayer.setPreferredSize(new Dimension(0,0));
		
		rightLayer = new JPanel();
		rightLayer.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightLayer.setBackground(new Color(255, 255, 255));
		rightLayer.setPreferredSize(new Dimension(0,0));
		
		
		this.setUpUIKorisnik(recepat);
		
	}
	
	public Stavka (Korisnik korisnik) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(0,200));
		leftLayer = new JPanel();
		leftLayer.setBackground(new Color(255, 255, 255));
		leftLayer.setPreferredSize(new Dimension(-150,0));
		
		middleLayer = new JPanel();
		middleLayer.setLayout(new FlowLayout(FlowLayout.LEFT));
		middleLayer.setBackground(new Color(255, 255, 255));
		middleLayer.setPreferredSize(new Dimension(0,0));
		
		rightLayer = new JPanel();
		rightLayer.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightLayer.setBackground(new Color(255, 255, 255));
		rightLayer.setPreferredSize(new Dimension(0,0));
		
		
		this.setUpUIKorisnik(korisnik);
		
	}
	
	
	public void setUpUIKorisnik(Recepat recepat) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("./data/images/utility/food_image.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image newImage = image.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		
		JLabel picLabel = new JLabel(new ImageIcon(newImage));
		picLabel.setBorder(BorderFactory.createEmptyBorder(10, 35, 35, 35));
		
		leftLayer.add(MainWindow.getNewLine());
		leftLayer.add(picLabel);
		
		
		JLabel naziv = new JLabel(recepat.getNaziv());
		naziv.setFont(naziv.getFont().deriveFont(16f));
		JTextArea uputstvo = new JTextArea(4, 23);
		uputstvo.setEditable(false);
		uputstvo.setLineWrap( true );
		uputstvo.setText(recepat.getUputstvo());
		uputstvo.setFont(uputstvo.getFont().deriveFont(11f));
		JLabel kolikoOsoba = new JLabel("Broj osoba:  " + recepat.getKolikoOsoba());
		
		JLabel ocena = new JLabel("Svidjanja: " + recepat.getOcena());
		
		String glavneNamirniceText = "";
		String opcioneNamirniceText = "";
		
		for (int i = 0; i < recepat.getSastojci().size(); i++) {
			if (i == 0) {
				if (!recepat.getSastojci().get(i).isOpciona()) {
					glavneNamirniceText += recepat.getSastojci().get(i).getNamirnica().getNaziv();
				}
				else {
					opcioneNamirniceText += recepat.getSastojci().get(i).getNamirnica().getNaziv();
				}
			}
			else {
				if (!recepat.getSastojci().get(i).isOpciona()) {
					glavneNamirniceText += ", " + recepat.getSastojci().get(i).getNamirnica().getNaziv();
				}
				else {
					opcioneNamirniceText += ", " + recepat.getSastojci().get(i).getNamirnica().getNaziv();
				}
			}
			 
		}
		
		JLabel glavneNamirnice = new JLabel("Glavne namirnice: " + glavneNamirniceText);
		JLabel opcioneNamirnice = new JLabel("Opcione namirnice: " + opcioneNamirniceText);
		JLabel korisnickoIme = new JLabel("Korisnik: " + recepat.getKorisnik().getKorIme());
		
		
		middleLayer.add(naziv);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(uputstvo);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(kolikoOsoba);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(ocena);
		
		rightLayer.add(glavneNamirnice);
		rightLayer.add(MainWindow.getNewLine());
		rightLayer.add(opcioneNamirnice);
		rightLayer.add(MainWindow.getNewLine());
		rightLayer.add(korisnickoIme);
		rightLayer.add(MainWindow.getNewLine());
		
		rightLayer.add(new JButton("Svidja ti se"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(155, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					boolean flag = false;
					
					for (int i = 0; i < DineApp.getInstance().ulogovaniKorisnik.omiljeni.size(); i++) {
						if (recepat == DineApp.getInstance().ulogovaniKorisnik.omiljeni.get(i)) {
							flag = true;
						}
					}
					
					if (!flag) {
						recepat.setOcena(recepat.getOcena() + 1);
						DineApp.getInstance().ulogovaniKorisnik.omiljeni.add(recepat);
						MainWindow.upisRecepataUFajl();
						MainWindow.upisKorisnikaUFajl();
					}
					
					
				}
				
			});
		}});
		
		rightLayer.add(new JButton("Ne svidja ti se"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(155, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					boolean flag = false;
					
					for (int i = 0; i < DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.size(); i++) {
						if (recepat == DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.get(i)) {
							flag = true;
						}
					}
					
					if (!flag) {
						recepat.setOcena(recepat.getOcena() - 1);
						DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.add(recepat);
						MainWindow.upisRecepataUFajl();
						MainWindow.upisKorisnikaUFajl();
					}
					
				}
				
			});
		}});
		
		rightLayer.add(new JButton("Komentarisi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(155, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Komentarisi(recepat);
				}
				
			});
		}});
		
		rightLayer.add(new JButton("Prikazi sve komentare"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(155, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Komentarisi(recepat);
				}
				
			});
		}});
		
		
		
		
		
		this.add(leftLayer);
		this.add(middleLayer);
		this.add(rightLayer);
	}
	
	public void setUpUIKorisnik(Korisnik korisnik) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("./data/images/utility/food_image.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image newImage = image.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		
		JLabel picLabel = new JLabel(new ImageIcon(newImage));
		picLabel.setBorder(BorderFactory.createEmptyBorder(10, 35, 35, 35));
		
		leftLayer.add(MainWindow.getNewLine());
		leftLayer.add(picLabel);
		
		
		
		
		
		this.add(leftLayer);
		this.add(middleLayer);
		this.add(rightLayer);
	}
	
	
}
