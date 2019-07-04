package gui.panels;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Proizvod;

//proslediti u proizvod parametar ko je ulogovan i na osnovu toga formirati dugmad?
//npr. ako je kupac onda ima korpa i pregled, a ako je menadzer ima pregled i izmeni

public class ProizvodPanel extends JPanel {
	Proizvod proizvod;
	JLabel labelaCena;
	JLabel labelaIme;
	JButton dugmeKorpa;
	JButton dugmePregled;
	JLabel slika;
	
	public ProizvodPanel(Proizvod p) throws IOException {
		
		proizvod = p;
		
		GridLayout grid  = new GridLayout(4, 0);
		setLayout(grid);
		
		
		labelaIme = new JLabel(p.getNaziv());
		labelaCena = new JLabel("1000");  // pokupiti cenu iz stavke cenovnika koja stoji u proizvodu	
		dugmeKorpa = new JButton("Korpa");
		dugmePregled = new JButton("Pregled");
		//BufferedImage myPicture = ImageIO.read(new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg"));
		
		//Image image = ImageIO.read(new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg"));
		//Image scaledImage = image.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		//JLabel picLabel = new JLabel(new ImageIcon(image));
		
		
		Image myPicture = ImageIO.read(new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg"));
		//Image scaledImage = myPicture.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
		//slika = new JLabel(new ImageIcon(scaledImage));
		slika = new JLabel(new ImageIcon(myPicture));
		//add(slika);
		add(labelaIme);
		add(labelaCena);
		
		GridLayout gridHorizontal = new GridLayout(0,2);
		JPanel holder = new JPanel();
		holder.setLayout(gridHorizontal);
		holder.add(dugmeKorpa);
		holder.add(dugmePregled);
		add(holder);
		
		//add(dugmeKorpa);
		//add(dugmePregled);
		
	}
	

			
			

}
