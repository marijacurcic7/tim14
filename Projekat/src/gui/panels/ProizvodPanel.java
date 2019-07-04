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
		
		
		Image myPicture = ImageIO.read(new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg"));
		
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
		
	}
	

			
			

}
