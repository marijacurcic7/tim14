package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Controller.NarudzbenicaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.Placena;
import Model.Poslata;
import Model.StavkaNarudzbenice;
import Model.TipKorisnika;
import Model.Zavrsena;

public class NarudzbenicaView extends JPanel {
	
	private NarudzbenicaController ncon;
	NarudzbeniceView nev;
	private AplikacijaPreduzece preduzece;
	//private JScrollPane scroll;
	private JButton plati;
	private JButton pregled;
	private JButton isporuci;
	private JPanel pnl;
	//public MainFrame frame;
	private JPanel pnlContent;
	Narudzbenica narudzbenica;
	
	public NarudzbenicaView(Narudzbenica n, AplikacijaPreduzece ap, NarudzbeniceView nev) {

		this.preduzece = ap;
		this.nev = nev;
		this.plati = new JButton("Plati");
		this.pregled = new JButton("Pregled");
		this.isporuci = new JButton("Isporuci");
		this.pnl = new JPanel();
		this.narudzbenica = n;
		
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		pnlContent.setLayout(new GridBagLayout());
		
		//pnlContent.add(new Label("ID: "+narudzbenica.getId()), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
		//		GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(new Label("Datum: "+narudzbenica.getDatum()), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(new Label("Cena: "+narudzbenica.getUkupanIznos()), new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(new Label("Stanje: "+narudzbenica.getStanje()), new GridBagConstraints(0, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnl.add(pnlContent);
		if(narudzbenica.getStanje().getClass().equals(Zavrsena.class)) {
			pnl.add(plati);
		}
		
		
		if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.menadzer) && (narudzbenica.getStanje().getClass().equals(Placena.class) || narudzbenica.getStanje().getClass().equals(Poslata.class))) {
			pnlContent.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()), new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()), new GridBagConstraints(0, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			//pnl.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()));
			//pnl.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()));
			if(narudzbenica.getStanje().getClass().equals(Placena.class)) {
				pnl.add(isporuci);
			}
		}
		
		pnl.add(pregled);
		add(pnl);
		
		plati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				narudzbenica.setStanje(new Placena());
				NarudzbenicaView nv = new NarudzbenicaView(narudzbenica, preduzece, nev);
				add(nv);
				remove(0);
				updateUI();
			}
		});
		
		isporuci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				narudzbenica.setStanje(new Poslata());
				NarudzbenicaView nv = new NarudzbenicaView(narudzbenica, preduzece, nev);
				add(nv);
				remove(0);
				updateUI();
			}
		});
		
		//Window w = SwingUtilities.getWindowAncestor(this);
		NarudzbenicaView naview = this;
		
		pregled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JPanel pnl2 = new JPanel();
				
				pnl2.setLayout(new GridLayout(preduzece.korpa.stavkeNarudzbenice.size(), 1));
				int i = 0;
				for(StavkaNarudzbenice sn : narudzbenica.stavkeNarudzbenice) {
					StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, naview);
					pnl2.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
					//add(new JLabel(sn.proizvod.getNaziv()));
					i+=10;
				}
				nev.add(pnl2);
				nev.remove(0);
				nev.updateUI();
			}
		});
		
	}

}
