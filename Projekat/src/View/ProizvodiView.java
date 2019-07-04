package View;


import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.ControllerProizvoda;
import Model.Proizvod;
import gui.panels.ProizvodPanel;



public class ProizvodiView extends BaseView{
//public class BasicView extends JScrollPane{
	
	public JPanel panelSaProizvodima;
	JScrollPane skrol;
	
	public ProizvodiView() throws IOException {
		
		initProductPanel();
		//skrol = new JScrollPane(panelSaProizvodima,
		//		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		//	        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//skrol.setPreferredSize(new Dimension(500, 300));
		//
		//add(skrol);
		//add(panelSaProizvodima);
		//skrol.set;
		//add(panelSaProizvodima);
		//add(panelSaProizvodima);
			
	}

	private void initProductPanel() throws IOException {
		// TODO Auto-generated method stub
		panelSaProizvodima = new JPanel();
		GridLayout grid = new GridLayout(0, 3, 50, 50);
		panelSaProizvodima.setLayout(grid);
		//this.setLayout(grid);
		
		for (int i = 0; i < 18; i++) {
			System.out.println("U basic view sta se dsava");
			System.out.println(this);
			Proizvod p  = new Proizvod("proizvod" + i);
			ProizvodPanel pp = new ProizvodPanel(p, this);
			ControllerProizvoda cp = new ControllerProizvoda(pp);
			pp.setController(cp);
			//pp.updateUI();
			// ovde dodam kontroler?
			
			panelSaProizvodima.add(pp);
			this.add(panelSaProizvodima);
					
		}
	}
	
	
}