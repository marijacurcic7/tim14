package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.AplikacijaPreduzece;
import View.KupacView;
import View.NarudzbeniceView;
import View.PromenaPodatakaView;

public class KupacController {

	private KupacView view;
	private AplikacijaPreduzece preduzece;
	
	public KupacController(KupacView view, AplikacijaPreduzece preduzece) {
		//super();
		this.view = view;
		this.preduzece = preduzece;
		
		addListeners();
	}
	
	private void addListeners() {
		view.getIzmenaPodataka().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        
		    	PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, view.getFrame());
				
				view.remove(1);
				view.add(ppv);
				view.updateUI();
		    }});
		
		view.getPrikazNarudzbenica().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        
		    	NarudzbeniceView nv = new NarudzbeniceView(view.getKupac().narudzbenice, preduzece);
		    	view.getProizvodi().getGdeStoji().remove(1);
		    	view.getProizvodi().getGdeStoji().add(nv);
		    	view.getProizvodi().getGdeStoji().updateUI();
		    	
		    }});
	}

	
	
	
}
