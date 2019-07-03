package gui.panels;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Proizvod;

public class SviProizvodiPanel extends JPanel {

	public JPanel panelSaProizvodima;
	JScrollPane skrol;
	
	public SviProizvodiPanel() throws IOException {
		// lose the panelSaProizvodima?
		initProductPanel();
		
		add(panelSaProizvodima);
			
	}

	private void initProductPanel() throws IOException {
		// ovaj treba da kupi iz aplikacije listu proizvoda
		
		panelSaProizvodima = new JPanel();
		GridLayout grid = new GridLayout(0, 4, 50, 50);
		panelSaProizvodima.setLayout(grid);
		
		// ova petlja isto za potrebe gui-ja u ranoj fazi radi vizuelizacije panela/prozora
		for (int i = 0; i < 18; i++) {
			Proizvod p  = new Proizvod("proizvod" + i);
			ProizvodPanel pp = new ProizvodPanel(p);
			panelSaProizvodima.add(pp);
					
		}
	}
	
}
