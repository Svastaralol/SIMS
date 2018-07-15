package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DineApp;
import model.Objavljen;
import model.Otkazan;
import model.Recepat;

@SuppressWarnings("serial")
public class ValidacijaRecepata extends JFrame {
	
	private int width = 300;
	private int height = 100;
	
	public ValidacijaRecepata(Recepat recepat) {
		this.setResizable(false);	// podesava da se prozor ne moze razvlaciti
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		JPanel container = new JPanel();
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel topLayer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topLayer.setBackground(new Color(255, 255, 255));
		JLabel text = new JLabel("Da li zelite da objavite ili otkazete ovaj recepat: ");
		
		topLayer.add(text);
		
		JButton objavi = new JButton("Objavi");
		objavi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				recepat.setStanje(new Objavljen());
				MainWindow.upisRecepataUFajl();
				
				ValidacijaRecepata.this.dispose();
				DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteAdministrator();
			}
			
		});
		JButton otkazi = new JButton("Otkazi");
		objavi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				recepat.setStanje(new Otkazan());
				MainWindow.upisRecepataUFajl();
				
				ValidacijaRecepata.this.dispose();
				DineApp.getInstance().mainWindow.sadrzaj.refreshRecepteAdministrator();
			}
			
		});
		
		JPanel bottomLayer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomLayer.setBackground(new Color(255, 255, 255));
		bottomLayer.add(objavi);
		bottomLayer.add(otkazi);
		
		container.add(topLayer);
		container.add(bottomLayer);
		
		this.add(container);
		
		this.setVisible(true);
		MainWindow.changeFont(this);
	}

}
