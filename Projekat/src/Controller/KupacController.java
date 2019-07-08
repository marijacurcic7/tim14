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
		// TODO Auto-generated method stub
		view.getIzmenaPodataka().addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	//JOptionPane.showMessageDialog(null, "Izmena podataka");
		    	PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, view.getFrame());
				
				view.remove(1);
				view.add(ppv);
				view.updateUI();
		    }});
		
		view.getPrikazNarudzbenica().addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	//Window w =SwingUtilities.getWindowAncestor(prikazNarudzbenica);
		    	//JOptionPane.showMessageDialog(null, "Prikaz narudzbenica");
		    	NarudzbeniceView nv = new NarudzbeniceView(view.getKupac().narudzbenice, preduzece);
		    	//nv.setPreferredSize(new Dimension(1000, 600));  // skrolbar preferred size,
		    	view.getProizvodi().getGdeStoji().remove(1);
		    	view.getProizvodi().getGdeStoji().add(nv);
		    	view.getProizvodi().getGdeStoji().updateUI();
		    	//proizvodi.add(nv);
		    	//proizvodi.remove(0);
		    	//proizvodi.updateUI();
		    	/*frame.getView().add(nv);
				frame.getView().remove(0);
				frame.getView().updateUI();*/
		    }});
	}

	private void izmenaPodataka() {}
	
	private void prikazNarudzbenica() {}
	
	
}
