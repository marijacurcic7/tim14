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
		
		
		// ako je kupac, ovaj stoji u kupacview, ako nije, onda stoji solo
		
		ProizvodView novi = new ProizvodView(pp.getProizvod(), pp.getGdjeStoji().getGdeStoji(), preduzece); //, preduzece);
		ProizvodController noviController = new ProizvodController(novi, preduzece);
		novi.setController(noviController);
		
		// sa 1 radi??nel, kupac ima ono lijevo i panel obviously
		//System.out.println(pp.getGdjeStoji().getGdeStoji().getComponent(1));
		System.out.println("ASDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		//pp.getGdjeStoji().getGdeStoji().remove(1);
		
		System.out.println(pp.getGdjeStoji());
		
		System.out.println(pp.getGdjeStoji().getGdeStoji());
		
		System.out.println();
		
		//System.out.println(pp.getGdjeStoji());
		
		// drugacije mi ije gdje stoji u odnosu na ulogovanog kupca? ne?
		// vamo stoji solo, vamo stoji u kupac view
		if (preduzece.trenutnoUlogovani != null) {
		//pp.getComponents()
		pp.getGdjeStoji().getGdeStoji().remove(1);
		}
		else {
			pp.getGdjeStoji().getGdeStoji().remove(0);
		}
		//pp.getGdjeStoji().getGdeStoji().remove(0);
		pp.getGdjeStoji().getGdeStoji().add(novi);
		pp.getGdjeStoji().getGdeStoji().updateUI();
		//pp.setGdjeStoji(ppp);
		//pp.getGdjeStoji().updateUI();
		//pp.getGdjeStoji().updateUI();
		//pp.getGdjeStoji().show();
		
		
	}
	
	
}
