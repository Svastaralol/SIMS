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
import javax.swing.JTextField;

import model.DineApp;
import model.Korisnik;


@SuppressWarnings("serial")
public class Logovanje extends JFrame {
	
	private int width = 400;
	private int height = 200;
	
	private JTextField korisnickoIme;
	private JTextField lozinka;
	
	public Logovanje() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255,255,255));
		
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
		
		JButton logovanjeDugme = new JButton("Uloguj se");
		logovanjeDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Korisnik k: DineApp.korisnici) {
					if (k.getKorIme().equals(korisnickoIme.getText()) && k.getLozinka().equals(lozinka.getText())) {
						DineApp.getInstance().mainWindow.setVisible(true);
						MainWindow.changeFont(DineApp.getInstance().mainWindow);
						Logovanje.this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Neispravni podaci.", "Logovanje", NORMAL);
			}
		});
		
		JButton registracijaDugme = new JButton("Registruj se");
		registracijaDugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Registracija();
			}
			
		});
		JButton odustanakDugme = new JButton("Odustani");
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
		
		Logovanje logovanje = this;
		
		getContentPane().add(container);
		
		MainWindow.changeFont(container);
		this.setVisible(true);
	}
	
}
