package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.KorpaController;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;

public class KorpaView extends JPanel {
	
	private KorpaController korpacon;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	
	// jscrollpane ce primiti pnlContent, a u pnlContent redamo stavke narudzbenice
	private JPanel pnlContent;
	
	public KorpaView(AplikacijaPreduzece ap) {
		this.preduzece = ap;
		this.korpa = ap.getKorpa();
		constructGUI();
	}
	
	private void constructGUI() {
		for(StavkaNarudzbenice sn : korpa.getStavkaNarudzbenice()) {
			StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece);
			add(new JLabel(sn.proizvod.getNaziv()));
		}
	}

}
