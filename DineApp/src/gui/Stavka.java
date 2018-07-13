package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Korisnik;
import model.Recepat;

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
		
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		middleLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		rightLayer.add(new JLabel("ssssssddddddddddddddddddddddddddddddddddd"));
		
		
		
		
		
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
