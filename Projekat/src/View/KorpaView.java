package View;

import javax.swing.JPanel;

import Controller.KorpaController;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;

public class KorpaView extends JPanel {
	
	private KorpaController korpacon;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	
	private JPanel pnlContent;
	
	public KorpaView(AplikacijaPreduzece ap) {
		this.preduzece = ap;
		this.korpa = ap.getKorpa();
	}
	
	private void constructGUI() {
		for(StavkaNarudzbenice sn : korpa.getStavkaNarudzbenice()) {
			StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece);
		}
	}

}
