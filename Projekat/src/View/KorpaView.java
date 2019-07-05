package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.KorpaController;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;

public class KorpaView extends JPanel {
	
	private KorpaController korpacon;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	private JScrollPane scroll;
	
	// jscrollpane ce primiti pnlContent, a u pnlContent redamo stavke narudzbenice
	private JPanel pnlContent;
	
	public KorpaView(AplikacijaPreduzece ap) {
		this.preduzece = ap;
		this.korpa = ap.getKorpa();
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		
		pnlContent.setLayout(new GridLayout(preduzece.korpa.stavkaNarudzbenice.size(), 1));
		//pnlContent.setPreferredSize(new Dimension(500, 700));
		//pnlContent.setLayout(new GridLayout(0, 1));
		
		int i = 0;
		for(StavkaNarudzbenice sn : korpa.getStavkaNarudzbenice()) {
			
			StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece);
			pnlContent.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			//add(new JLabel(sn.proizvod.getNaziv()));
			i+=10;
		}
		JPanel linija = new JPanel(new GridLayout(3, 0));
		linija.add(new JButton("Kupi"));
		linija.add(new JButton("Isprazni korpu"));
		//linija.add(new JButton("asdasd"));
		//pnlContent.add(linija);
		scroll = new JScrollPane(pnlContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(1000, 600));
		
		add(scroll);
		add(linija);
		//add(pnlContent);
	}

}
