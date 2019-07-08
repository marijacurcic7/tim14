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
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	dodajNoviProizvod();
		    }
		    });
		
		
		view.getPrikazNarudzbenica().addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	//JOptionPane.showMessageDialog(null, "Prikaz liste narudzbenica sa mogucnoscu odabira"
		    	//		+ " posiljke narudzbenica koje nisu poslate");
		    	
		    	prikazNarudzbenica();
		    	
		    }});
		
		view.getIzmenaPodataka().addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
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
		//proizvodi.add(rw);
		//proizvodi.remove(0);
		//proizvodi.updateUI();
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
