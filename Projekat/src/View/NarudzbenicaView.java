package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.NarudzbenicaController;
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
		setPreferredSize(new Dimension(500, 200));
		
		//add(new JLabel("Narudzbenica"));
		
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
		
		//pnlContent.setLayout(new GridBagLayout());
		
		pnlContent.setLayout(new FlowLayout());
		
		JPanel podaci = new JPanel(new GridLayout(0, 1)); 	// fiksiramo, vamo dva dugmeta
		//podaci.add(comp)
		podaci.setPreferredSize(new Dimension(300, 180));
		pnlContent.add(podaci);
		
		JPanel dugmici = new JPanel(new GridLayout(2, 0));
		//pnlContent.add(dugmici);
		
		//this.setPreferredSize(new Dimension(1000, 600));
		
		//pnlContent.add(new Label("ID: "+narudzbenica.getId()), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
		//		GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		podaci.add(new Label("Datum: "+narudzbenica.getDatum()));
		podaci.add(new Label("Cena: "+narudzbenica.getUkupanIznos()));
		podaci.add(new Label("Stanje: "+narudzbenica.getStanje()));
		
		//podaci.add(new Label("asdlkasjd"));
		//podaci.add(new Label("asdlkasjd"));
		//pnlContent.add(new Label("Datum: "+narudzbenica.getDatum()), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
		//		GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		//pnlContent.add(new Label("Cena: "+narudzbenica.getUkupanIznos()), new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
		//		GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		//pnlContent.add(new Label("Stanje: "+narudzbenica.getStanje()), new GridBagConstraints(0, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
		//		GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnl.add(pnlContent);
		if(narudzbenica.getStanje().getClass().equals(Zavrsena.class)) {
			//pnl.add(plati);
			dugmici.add(plati);
		}
		
		// za menadzera srediti
		if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.menadzer) && (narudzbenica.getStanje().getClass().equals(Placena.class) || narudzbenica.getStanje().getClass().equals(Poslata.class))) {
			podaci.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()));
			podaci.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()));
			//pnlContent.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()), new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
			//		GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			//pnlContent.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()), new GridBagConstraints(0, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
			//		GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			//pnl.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()));
			//pnl.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()));
			if(narudzbenica.getStanje().getClass().equals(Placena.class)) {
				dugmici.add(isporuci);
			}
		}
		
		//pnl.add(pregled);
		dugmici.add(pregled);
		pnlContent.add(dugmici);
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
				//pnl2.setPreferredSize(new Dimension(1000, 600));
				
				JScrollPane scroll = new JScrollPane(pnl2);
				scroll.setPreferredSize(new Dimension(1100, 600));
				//pnl2.setLayout(new GridLayout(preduzece.korpa.stavkeNarudzbenice.size(), 1));
				pnl2.setLayout(new GridLayout(0, 1));
				int i = 0;
				for(StavkaNarudzbenice sn : narudzbenica.stavkeNarudzbenice) {
					StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, naview);
					//pnl2.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					//		GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
					pnl2.add(snv);
					//add(new JLabel(sn.proizvod.getNaziv()));
					i+=10;
				}
				nev.add(scroll);
				nev.remove(0);
				nev.updateUI();
			}
		});
		
	}

}
