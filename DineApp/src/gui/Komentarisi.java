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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DineApp;
import model.Komentar;
import model.Recepat;

public class Komentarisi extends JFrame {
	
	private int width = 389;
	private int height = 270;
	
	private JTextField naslov;
	private JTextArea tekst;
	
	public Komentarisi(Recepat recepat) {
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		
		this.naslov = new JTextField(27);
		this.naslov.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.naslov.setFont(this.naslov.getFont().deriveFont(12f));
		this.tekst = new JTextArea(5, 27);
		this.tekst.setFont(this.tekst.getFont().deriveFont(12f));
		this.tekst.setLineWrap(true);
		this.tekst.setBorder(BorderFactory.createCompoundBorder(MainWindow.border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255, 255, 255));
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		
		topLayer.add(new JLabel("Unesite naslov komentara: "));
		topLayer.add(naslov);
		topLayer.add(new JLabel("Unesite sadrzaj komentara: "));
		topLayer.add(tekst);
		
		bottomLayer.setPreferredSize(new Dimension(0, -30));
		bottomLayer.add(new JButton("Potvrdi"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(55, 36));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					recepat.komentari.add(new Komentar(Komentarisi.this.naslov.getText(), Komentarisi.this.tekst.getText(), DineApp.getInstance().ulogovaniKorisnik));
					MainWindow.upisRecepataUFajl();
					Komentarisi.this.dispose();
				}
				
			});
			
		}});
		
		bottomLayer.add(new JButton("Odustani"){{
			setContentAreaFilled(false);
			setBackground(new Color(0, 179, 143));
			setForeground(new Color(255, 255, 255));
			setBorder(BorderFactory.createLineBorder(new Color(0, 179, 143)));
			setPreferredSize(new Dimension(55, 36));
			setOpaque(true);
			addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Komentarisi.this.dispose();
				}
				
			});
		}});
		
		container.add(topLayer);
		container.add(bottomLayer);
		
		this.add(container);
		
		this.setVisible(true);
		MainWindow.changeFont(this);
	}

}
