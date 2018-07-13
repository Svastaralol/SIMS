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
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DineApp;

@SuppressWarnings("serial")
public class Logovanje extends JFrame {
	
	private int width = 400;
	private int height = 180;
	
	private JTextField korisnickoIme;
	private JTextField lozinka;
	
	public Logovanje() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(MainWindow.screenWidth/2 - this.width/2, MainWindow.screenHeight/2 - this.height/2, width, height);
		
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255,255,255));
		
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255,255,255));
		
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
		
		Logovanje logovanje = this;
		
		JButton logovanjeDugme = new JButton("Uloguj se");
		logovanjeDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				logovanje.dispose();
				DineApp.getInstance().mainWindow.setVisible(true);
				MainWindow.changeFont(DineApp.getInstance().mainWindow);
			}
			
		});
		
		
		
		JButton registracijaDugme = new JButton("Registruj se");
		JButton odustanakDugme = new JButton("Odustani");
		odustanakDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		bottomLayer.setPreferredSize(new Dimension(0,-30));
		
		
		bottomLayer.add(logovanjeDugme);
		bottomLayer.add(registracijaDugme);
		bottomLayer.add(odustanakDugme);
		
		
		container.add(bottomLayer);
		
		this.add(container);
		
		MainWindow.changeFont(container);
		this.setVisible(true);
	}
	
}
