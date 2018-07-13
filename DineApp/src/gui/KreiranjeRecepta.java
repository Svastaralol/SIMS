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
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class KreiranjeRecepta extends JFrame {
	private int width = 400;
	private int height = 410;
	
	private JPanel container;
	private JPanel topLayer;
	private JPanel bottomLayer;
	private JTextField nazivRecepta;
	private JTextArea opis;
	private JTextField kolikoOsoba;
	private JTextField glavneNamirnice;
	private JTextField opcioneNamirnice;
	
	
	public KreiranjeRecepta() {
		//super(new FlowLayout(FlowLayout.LEFT));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(MainWindow.screenWidth/2 - width/2, MainWindow.screenHeight/2 - height/2, width, height);
		this.setVisible(true);
		
		
		JLabel nazivReceptaLabela = new JLabel("Naziv recepta: ");
		
		int textFieldSize = 31;
		
		nazivRecepta = new JTextField(textFieldSize);
		
		JLabel opisLabela = new JLabel("Uputstvo recepta: ");
		
		opis = new JTextArea(5, textFieldSize);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		
		nazivRecepta.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
	    opis.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		opis.setFont(nazivRecepta.getFont());
		opis.setLineWrap(true);
		opis.setWrapStyleWord(true);
		
		
		JLabel kolikoOsobaLabela = new JLabel("Za koliko osoba: ");
		
		kolikoOsoba = new JTextField(2);
		kolikoOsoba.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		glavneNamirnice = new JTextField(textFieldSize);
		glavneNamirnice.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		opcioneNamirnice = new JTextField(textFieldSize);
		opcioneNamirnice.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel namirniceLabela1 = new JLabel("Unesite glavne namirnice koje koristite u receptu:                          ");
		JLabel namirniceLabela2 = new JLabel("Unesite opcione namirnice koje koristite u receptu:                          ");
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setPreferredSize(new Dimension(0, 380));
		topLayer.setBackground(new Color(255, 255, 255));
		topLayer.add(nazivReceptaLabela);
		topLayer.add(this.nazivRecepta);
		topLayer.add(new JLabel("                                                                "
				+ "                    "
				+ "                    "
				+ "                    "));
		topLayer.add(opisLabela);
		topLayer.add(this.opis);
		topLayer.add(kolikoOsobaLabela);
		topLayer.add(kolikoOsoba);
		topLayer.add(new JLabel("                                                                "
				+ "                    "
				+ "                    "
				+ "                    "));
		topLayer.add(namirniceLabela1);
		topLayer.add(glavneNamirnice);
		topLayer.add(namirniceLabela2);
		topLayer.add(opcioneNamirnice);
		
		bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		
		JButton confirmButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Odustani");
		
		KreiranjeRecepta r = this;
		
		
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				r.dispose();
				
			}
			
		});
		
		
		bottomLayer.add(confirmButton);
		bottomLayer.add(cancelButton);
		
		
		container.add(this.topLayer);
		container.add(this.bottomLayer);
		this.add(container);
		
		
	}
}
