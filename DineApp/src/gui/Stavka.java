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
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Administrator;
import model.DineApp;
import model.Korisnik;
import model.Namirnica;
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
	
	public Stavka (Namirnica namirnica) {
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
		
		
		this.setUpUIKorisnik(namirnica);
		
	}
	
	
	public void setUpUIKorisnik(Namirnica namirnica) {
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
		
		
		JLabel sifra = new JLabel("Sifra namirnice: " + namirnica.getSifra());
		JLabel naziv = new JLabel("Naziv namirnice: " + namirnica.getNaziv());
		JLabel cena = new JLabel("Cena namirnice: " + namirnica.getCena());
		
		middleLayer.add(sifra);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(naziv);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(cena);
		middleLayer.add(MainWindow.getNewLine());
		
		middleLayer.add(new JButton("Odobri"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(96, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					namirnica.setValidna(true);
					
					MainWindow.upisNamirnicaUFajl();
					DineApp.getInstance().mainWindow.sadrzaj.refresNamirnice();
					
				}
				
			});
		}});
		
		middleLayer.add(new JButton("Obrisi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(96, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					for (int i = 0; i < DineApp.namirnice.size(); i++) {
						if (DineApp.namirnice.get(i).getSifra() == namirnica.getSifra()) {
							DineApp.namirnice.remove(i);
							break;
						}
					}
					
					MainWindow.upisNamirnicaUFajl();
					DineApp.getInstance().mainWindow.sadrzaj.refresNamirnice();
					
				}
				
			});
		}});
		
		
		this.add(leftLayer);
		this.add(middleLayer);
		this.add(rightLayer);
		
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
		
		
		if (DineApp.getInstance().ulogovaniKorisnik instanceof Administrator){
			rightLayer.add(new JButton("Validacija"){{
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
						new ValidacijaRecepata(recepat);
						
						
					}
					
				});
			}});
		}
		
		
		else {
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
						if (recepat.getSifra().equals(DineApp.getInstance().ulogovaniKorisnik.omiljeni.get(i).getSifra())) {
							flag = true;
						}
					}
					
					if (!flag) {
						recepat.setOcena(recepat.getOcena() + 1);
						DineApp.getInstance().ulogovaniKorisnik.omiljeni.add(recepat);
						MainWindow.upisRecepataUFajl();
						MainWindow.upisKorisnikaUFajl();
						DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteKorisnik();
						Timer timer = new Timer();
						timer.schedule(new TimerTask(){
							int lastValue = MainWindow.scrollFrame.getVerticalScrollBar().getValue();
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteKorisnik();
								MainWindow.scrollFrame.getVerticalScrollBar().setValue(lastValue);
								System.out.println(lastValue);
							}
							
						}, 500);
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
						if (recepat.getSifra().equals(DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.get(i).getSifra())) {
							flag = true;
						}
					}
					
					if (!flag) {
						recepat.setOcena(recepat.getOcena() - 1);
						DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.add(recepat);
						MainWindow.upisRecepataUFajl();
						MainWindow.upisKorisnikaUFajl();
						Timer timer = new Timer();
						timer.schedule(new TimerTask(){
							int lastValue = MainWindow.scrollFrame.getVerticalScrollBar().getValue();
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteKorisnik();
								MainWindow.scrollFrame.getVerticalScrollBar().setValue(lastValue);
								System.out.println(lastValue);
							}
							
						}, 10);
						
					}
					System.out.println(DineApp.getInstance().ulogovaniKorisnik.neOmiljeni.size());
					
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
					new PrikazKomentara(recepat);
				}
				
			});
		}});
		}
		
		
		
		
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
		
		
		JLabel imePrezime = new JLabel("Ime i Prezime: " + korisnik.getIme() + " " + korisnik.getPrezime());
		JLabel korisnickoIme = new JLabel("Korisnicko ime: " + korisnik.getKorIme());
		JLabel email = new JLabel("E-Mail: " + korisnik.geteMail());
		JLabel lozinka = new JLabel("Lozinka: " + korisnik.getLozinka());
		
		
		middleLayer.add(imePrezime);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(korisnickoIme);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(email);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(lozinka);
		middleLayer.add(MainWindow.getNewLine());
		middleLayer.add(new JButton("Obrisi korisnika"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(96, 26));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					for (int i = 0; i < DineApp.korisnici.size(); i++) {
						if (DineApp.korisnici.get(i) == korisnik) {
							DineApp.korisnici.remove(i);
						}
					}
					
					MainWindow.upisKorisnikaUFajl();
					DineApp.getInstance().mainWindow.sadrzaj.refreshKorisnike();
					
				}
				
			});
		}});
		
		
		this.add(leftLayer);
		this.add(middleLayer);
		this.add(rightLayer);
	}
	
	
}
