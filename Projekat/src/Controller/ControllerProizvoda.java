package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.AplikacijaPreduzece;
import View.ProizvodView;
import gui.panels.ProizvodPanel;

public class ControllerProizvoda {

	ProizvodPanel pp;
	AplikacijaPreduzece preduzece;

	public ControllerProizvoda(ProizvodPanel pp, AplikacijaPreduzece preduzece) {
		super();
		this.pp = pp;
		this.preduzece = preduzece;
		
		
		this.pp.getDugmePregled().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	pregledKliknuto();
			    }
			
		});
	}

	
	protected void pregledKliknuto() {
		
		pp.getGdjeStoji().show();
		
		ProizvodPanel ppp = new ProizvodPanel();
		
		
		ProizvodView novi = new ProizvodView(pp.getProizvod(), pp.getGdjeStoji().getGdeStoji(), preduzece); //, preduzece);
		ProizvodController noviController = new ProizvodController(novi, preduzece);
		novi.setController(noviController);
		
		
		if (preduzece.trenutnoUlogovani != null) {
		pp.getGdjeStoji().getGdeStoji().remove(1);
		}
		else {
			pp.getGdjeStoji().getGdeStoji().remove(0);
		}
		pp.getGdjeStoji().getGdeStoji().add(novi);
		pp.getGdjeStoji().getGdeStoji().updateUI();
		
		
		
	}
	
	
}
