package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.NarudzbenicaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.Zavrsena;

public class NarudzbenicaView extends JPanel {
	
	private NarudzbenicaController ncon;
	private AplikacijaPreduzece preduzece;
	//private JScrollPane scroll;
	private JButton plati;
	private JPanel pnl;
	//public MainFrame frame;
	private JPanel pnlContent;
	private Narudzbenica narudzbenica;
	
	public NarudzbenicaView(Narudzbenica n, AplikacijaPreduzece ap) {

		this.preduzece = ap;
		this.plati = new JButton("Plati");
		this.pnl = new JPanel();
		this.narudzbenica = n;
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		pnlContent.setLayout(new GridBagLayout());
		
		pnlContent.add(new Label("ID: "+narudzbenica.getId()), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(new Label("Datum: "+narudzbenica.getDatum()), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(new Label("Cena: "+narudzbenica.getUkupanIznos()), new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnl.add(pnlContent);
		if(narudzbenica.getStanje().getClass().equals(Zavrsena.class)) {
			pnl.add(plati);
		}
		
		add(pnl);
		
	}

}
