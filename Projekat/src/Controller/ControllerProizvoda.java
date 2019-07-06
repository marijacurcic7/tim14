package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.AplikacijaPreduzece;
import View.ProizvodView;
import gui.panels.ProizvodPanel;

public class ControllerProizvoda extends Controller {

	ProizvodPanel pp;
	AplikacijaPreduzece preduzece;

	public ControllerProizvoda(ProizvodPanel pp, AplikacijaPreduzece preduzece) {
		super();
		this.pp = pp;
		this.preduzece = preduzece;
		
		
		this.pp.getDugmePregled().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	System.out.println("Nesto se desiloooo");
			    	pregledKliknuto();
			    }
			
		});
	}

	// dovoljno je da ima view, a view ima svoj kontroler
	//@SuppressWarnings("deprecation")
	protected void pregledKliknuto() {
		//System.out.println("asdasda");
		//ProizvodPanel prop = new ProizvodPanel();
		//ControllerProizvoda cp = new ControllerProizvoda(pp);
		//prop.setController(cp);
		
		//System.out.println(pp.getGdjeStoji());
		//pp.setGdjeStoji();
		pp.getGdjeStoji().show();
		//pp.getGdjeStoji().hide();
		//System.out.println("gdje stoji..........");
		//System.out.println(pp.getGdjeStoji());
		ProizvodPanel ppp = new ProizvodPanel();
		//ppp.add(new JButton("button"));
		//pp.setGdjeStoji(ppp);
		//pp.getGdjeStoji().show();
		//pp.getGdjeStoji().add(new JButton("Dugme"));
		
		
		ProizvodView novi = new ProizvodView(pp.getProizvod(), pp.getGdjeStoji(), preduzece); //, preduzece);
		ProizvodController noviController = new ProizvodController(novi, preduzece);
		novi.setController(noviController);
		
		
		pp.getGdjeStoji().remove(0);
		pp.getGdjeStoji().add(novi);
		pp.getGdjeStoji().updateUI();
		//pp.setGdjeStoji(ppp);
		//pp.getGdjeStoji().updateUI();
		//pp.getGdjeStoji().updateUI();
		//pp.getGdjeStoji().show();
		
	}
	
	
}
