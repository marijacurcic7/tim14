package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AplikacijaPreduzece;
import View.ProizvodView;


public class ProizvodController extends Controller {

	ProizvodView proizvodView;
	AplikacijaPreduzece preduzece;
	
	
	public ProizvodController(ProizvodView proizvodView, AplikacijaPreduzece preduzece) {
		this.proizvodView = proizvodView;
		this.preduzece = preduzece;
		
		this.proizvodView.getStaviUKorpu().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	//System.out.println("Nesto se desilo");
			    String message = "Na osnovu modela pogledati\n"
			    		+ " da li ima dovoljno proizvoda, \n"
			    		+ "dodati ih u narudzbenicu, skinuti sa nekog"
			    		+ "stanja\ni jos nesto probs, ugl azurirati model!";	
				 
				 JOptionPane.showMessageDialog(proizvodView, message);
			    }
			
		});
	}
	
}
