package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.AplikacijaPreduzece;
import View.DodavanjeProizvodaView;
import View.MenadzerView;
import View.NarudzbeniceView;
import View.PromenaPodatakaView;

public class MenadzerController {

	MenadzerView view;
	AplikacijaPreduzece preduzece;
	
	public MenadzerController(MenadzerView view, AplikacijaPreduzece preduzece) {
		super();
		this.view = view;
		this.preduzece = preduzece;
		addListeners();
	}
	
	private void addListeners() {
		
		view.getDodajNoviProizvod().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	dodajNoviProizvod();
		    }
		    });
		
		
		view.getPrikazNarudzbenica().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		       
		    	
		    	prikazNarudzbenica();
		    	
		    }});
		
		view.getIzmenaPodataka().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	izmenaPodataka();
		    }
		});
	}
	private void prikazNarudzbenica() {
		NarudzbeniceView nv = new NarudzbeniceView(view.getNarudzbenice(), preduzece);
    	view.remove(1);
    	view.add(nv);
    	view.updateUI();
	}
	
	private void dodajNoviProizvod() {
		DodavanjeProizvodaView rw = new DodavanjeProizvodaView(preduzece, view.getFrame());
		
		view.remove(1);
		view.add(rw);
		view.updateUI();
	}
	
	private void izmenaPodataka() {
		PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, view.getFrame());
		
		view.remove(1);
		view.add(ppv);
		view.updateUI();
	}
}
