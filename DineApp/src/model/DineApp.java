package model;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.MainWindow;

public class DineApp {
	
	private static DineApp instance = null;
	
	public MainWindow mainWindow;
	
	
	public DineApp() {
		this.mainWindow = new MainWindow();
		//MainWindow.changeFont(this.mainWindow);
		this.mainWindow.revalidate();
	}
	
	
	public static DineApp getInstance() { //singleton
		
		if (instance == null) {
			instance = new DineApp();
			return instance;
		}
		
		return instance;
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			MainWindow.font = Font.createFont(Font.TRUETYPE_FONT, new File("./data/fonts/Montserrat-Regular.ttf")).deriveFont(12f); 
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(MainWindow.font);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // stavlja windows okruzenje
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		DineApp.getInstance();

	}

}
