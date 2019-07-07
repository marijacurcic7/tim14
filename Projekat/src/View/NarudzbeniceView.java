package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.NarudzbeniceController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.Placena;
import Model.Poslata;
import Model.TipKorisnika;

public class NarudzbeniceView extends JPanel {
	
	private NarudzbeniceController ncon;
	private AplikacijaPreduzece preduzece;
	private JScrollPane scroll;
	private JButton plati;
	private JPanel pnl;
	//public MainFrame frame;
	private JPanel pnlContent;
	ArrayList<Narudzbenica> narudzbenice;
	
	public NarudzbeniceView(List<Narudzbenica> narudzbenice2, AplikacijaPreduzece ap) {
		
		this.preduzece = ap;
		this.pnl = new JPanel();
		this.narudzbenice = (ArrayList<Narudzbenica>) narudzbenice2;
		
		if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.kupac)) {
			constructGUI();
		}
		else if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.menadzer)) {
			constructGUI2();
		}
		
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		pnlContent.setLayout(new GridLayout(narudzbenice.size(), 1));
		int i = 0;
		for(Narudzbenica n : narudzbenice) {
			NarudzbenicaView nv = new NarudzbenicaView(n, preduzece, this);
			pnlContent.add(nv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			i+=10;
		}
		System.out.println(preduzece.korpa);
		if(!preduzece.korpa.stavkeNarudzbenice.isEmpty()) {
			NarudzbenicaView nv = new NarudzbenicaView(preduzece.korpa, preduzece, this);
			pnlContent.add(nv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		}
		
		scroll = new JScrollPane(pnlContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(1000, 600));
		
		pnl.add(scroll);
		add(pnl);
	}
	
	private void constructGUI2() {
		pnlContent = new JPanel();
		pnlContent.setLayout(new GridLayout(narudzbenice.size(), 1));
		int i = 0;
		for(Narudzbenica n : narudzbenice) {
			if(n.getStanje().getClass().equals(Placena.class) || n.getStanje().getClass().equals(Poslata.class)) {
				NarudzbenicaView nv = new NarudzbenicaView(n, preduzece, this);
				pnlContent.add(nv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
				i+=10;
			}
			
		}
		
		scroll = new JScrollPane(pnlContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(1000, 600));
		
		pnl.add(scroll);
		add(pnl);
	}

}
