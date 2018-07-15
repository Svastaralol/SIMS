package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Administrator;
import model.DineApp;
import model.Korisnik;


@SuppressWarnings("serial")
public class Logovanje extends JFrame {
	
	private int width = 388;
	private int height = 185;
	
	private JTextField korisnickoIme;
	private JTextField lozinka;
	
	public Logovanje() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255,255,255));
		topLayer.setPreferredSize(new Dimension(0, 0));
		
		this.korisnickoIme = new JTextField(30);
		this.korisnickoIme.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		this.lozinka = new JTextField(30);
		this.lozinka.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		topLayer.add(new JLabel("Unesite korisnicko ime: "));
		topLayer.add(this.korisnickoIme);
		topLayer.add(new JLabel("Unesite lozinku: "));
		topLayer.add(this.lozinka);
		container.add(topLayer);
		
		FlowLayout fl_bottomLayer = new FlowLayout(FlowLayout.RIGHT);
		JPanel bottomLayer = new JPanel(fl_bottomLayer);
		topLayer.add(bottomLayer);
		bottomLayer.setBackground(new Color(255,255,255));
		
		JButton logovanjeDugme = new JButton("Uloguj se"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(66, 36));
			setOpaque(true);
		}};
		logovanjeDugme.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Korisnik k: DineApp.korisnici) {
					if (k.getKorIme().equals(korisnickoIme.getText()) && k.getLozinka().equals(lozinka.getText())) {
						MainWindow w = DineApp.getInstance().mainWindow;
						
						if (k instanceof Administrator) {
							w.container.add(new AlatkeAdministratora());
							
						}
						else {
							w.container.add(new AlatkeKorisnika());
							
						}
						DineApp.getInstance().ulogovaniKorisnik = k;
						w.sadrzaj = new Sadrzaj();
						JScrollPane scrollFrame = new JScrollPane(w.sadrzaj);
						scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
						scrollFrame.setVisible(true);
						scrollFrame.setBorder(BorderFactory.createEmptyBorder());
						w.sadrzaj.setAutoscrolls(true);
						w.container.add(scrollFrame);
						w.add(w.container);
						w.revalidate();
						
						w.setVisible(true);
						
						
						
						if (k instanceof Korisnik) {
							DineApp.getInstance().mainWindow.sadrzaj.ucitajRecepte();
						}
						MainWindow.changeFont(DineApp.getInstance().mainWindow);
						Logovanje.this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Neispravni podaci.", "Logovanje", NORMAL);
			}
		});
		
		JButton registracijaDugme = new JButton("Registruj se"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(78, 36));
			setOpaque(true);
		}};
		registracijaDugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Registracija();
			}
			
		});
		JButton odustanakDugme = new JButton("Odustani"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(65, 36));
			setOpaque(true);
		}};
		odustanakDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		bottomLayer.add(logovanjeDugme);
		bottomLayer.add(registracijaDugme);
		bottomLayer.add(odustanakDugme);
		
		bottomLayer.setPreferredSize(new Dimension(0, -50));
		container.add(bottomLayer);
		
		getContentPane().add(container);
		
		MainWindow.changeFont(container);
		this.setVisible(true);
	}
	
}
