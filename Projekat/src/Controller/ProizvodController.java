package Controller;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.StavkaNarudzbenice;
import View.ProizvodView;
import View.ProizvodiView;


public class ProizvodController extends Controller {

	private ProizvodView proizvodView;
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;
	private int kolicina;
	
	
	public ProizvodController(ProizvodView proizvodView, AplikacijaPreduzece preduzece) {
		this.proizvodView = proizvodView;
		this.preduzece = preduzece;
		this.proizvod = proizvodView.getP();
		
		
		/*this.proizvodView.getStaviUKorpu().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	//System.out.println("Nesto se desilo");
			    String message = "Na osnovu modela pogledati\n"
			    		+ " da li ima dovoljno proizvoda, \n"
			    		+ "dodati ih u narudzbenicu, skinuti sa nekog"
			    		+ "stanja\ni jos nesto probs, ugl azurirati model!";	
				 
				 JOptionPane.showMessageDialog(proizvodView, message);
			    }
			 	
			
		});*/
		addListeners();
	}
	
	private void addListeners() {
		proizvodView.getStaviUKorpu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					kolicina = Integer.parseInt(proizvodView.getSpinner().getValue().toString());
					preduzece.korpa.addStavkaNarudzbenice(new StavkaNarudzbenice(kolicina, proizvod));
					System.out.println(kolicina+" "+proizvod);
					Window w = SwingUtilities.getWindowAncestor(proizvodView);
					JOptionPane.showMessageDialog(w, "Dodato");
					/*try {
						ProizvodiView pv = new ProizvodiView(preduzece);
						add(pv);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					ProizvodiView bw = null;
					try {
						bw = new ProizvodiView(preduzece);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//frame.getView().remove(0);
					
					proizvodView.getGdjeStoji().add(bw);
					proizvodView.getGdjeStoji().remove(0);
					proizvodView.getGdjeStoji().updateUI();
			}
		});
	}
	
}
