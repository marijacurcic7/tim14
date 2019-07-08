package gui.panels;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Proizvod;

public class SviProizvodiPanel extends AbstractPanelCM {

	public JPanel panelSaProizvodima;
	JScrollPane skrol;
	
	public SviProizvodiPanel() throws IOException {
		initProductPanel();
		
		add(panelSaProizvodima);
			
	}

	private void initProductPanel() throws IOException {
		
		panelSaProizvodima = new JPanel();
		GridLayout grid = new GridLayout(0, 4, 50, 50);
		panelSaProizvodima.setLayout(grid);
		
		for (int i = 0; i < 18; i++) {
			Proizvod p  = new Proizvod("proizvod" + i);
			
					
		}
	}
	
}
