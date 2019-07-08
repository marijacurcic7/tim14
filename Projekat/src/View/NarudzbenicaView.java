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
	private JButton plati;
	private JButton pregled;
	private JButton isporuci;
	private JPanel pnl;
	private JPanel pnlContent;
	Narudzbenica narudzbenica;
	
	public NarudzbenicaView(Narudzbenica n, AplikacijaPreduzece ap, NarudzbeniceView nev) {
		setPreferredSize(new Dimension(500, 200));
				
		this.preduzece = ap;
		this.nev = nev;
		this.plati = new JButton("Plati");
		this.pregled = new JButton("Pregled");
		this.isporuci = new JButton("Isporuci");
		this.pnl = new JPanel();
		this.narudzbenica = n;
		
		constructGUI();
		
		ncon = new NarudzbenicaController(this, preduzece);
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		
		pnlContent.setLayout(new FlowLayout());
		
		JPanel podaci = new JPanel(new GridLayout(0, 1)); 	// fiksiramo, vamo dva dugmeta
		podaci.setPreferredSize(new Dimension(300, 180));
		pnlContent.add(podaci);
		
		JPanel dugmici = new JPanel(new GridLayout(2, 0));
		
		podaci.add(new Label("Datum: "+narudzbenica.getDatum()));
		podaci.add(new Label("Cena: "+narudzbenica.getUkupanIznos()));
		podaci.add(new Label("Stanje: "+narudzbenica.getStanje()));
		
		pnl.add(pnlContent);
		if(narudzbenica.getStanje().getClass().equals(Zavrsena.class)) {
			dugmici.add(plati);
		}
		
		if(preduzece.trenutnoUlogovani.nalog.getTipKorisnika().equals(TipKorisnika.menadzer) && (narudzbenica.getStanje().getClass().equals(Placena.class) || narudzbenica.getStanje().getClass().equals(Poslata.class))) {
			podaci.add(new Label("Narucilac: "+narudzbenica.getIme()+" "+narudzbenica.getPrezime()));
			podaci.add(new Label("Adresa: "+narudzbenica.getMesto().getAdresa()+", "+narudzbenica.getMesto().getGrad()+", "+narudzbenica.getMesto().getDrzava()));
			
			if(narudzbenica.getStanje().getClass().equals(Placena.class)) {
				dugmici.add(isporuci);
			}
		}
		
		dugmici.add(pregled);
		pnlContent.add(dugmici);
		add(pnl);

	}

	public NarudzbenicaController getNcon() {
		return ncon;
	}

	public void setNcon(NarudzbenicaController ncon) {
		this.ncon = ncon;
	}

	public NarudzbeniceView getNev() {
		return nev;
	}

	public void setNev(NarudzbeniceView nev) {
		this.nev = nev;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public JButton getPlati() {
		return plati;
	}

	public void setPlati(JButton plati) {
		this.plati = plati;
	}

	public JButton getPregled() {
		return pregled;
	}

	public void setPregled(JButton pregled) {
		this.pregled = pregled;
	}

	public JButton getIsporuci() {
		return isporuci;
	}

	public void setIsporuci(JButton isporuci) {
		this.isporuci = isporuci;
	}

	public JPanel getPnl() {
		return pnl;
	}

	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}

	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

}
