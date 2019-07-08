package View;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Controller.MenadzerController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.Placena;
import Model.Poslata;

public class MenadzerView extends BaseView {
	
	MenadzerController kontroler;
	ProizvodiView proizvodi;
	
	JPanel onoSaStrane;
	JLabel dodajNoviProizvod;
	JLabel prodavnice;
	MainFrame frame;
	JLabel prikazNarudzbenica;
	JLabel izmenaPodataka;
	JSplitPane split;
	private ArrayList<Narudzbenica> narudzbenice;
	
	AplikacijaPreduzece preduzece;
	
	public MenadzerView(AplikacijaPreduzece preduzece, MainFrame frame) {
		
		this.frame = frame;
		this.preduzece = preduzece;
		
		try {
			proizvodi = new ProizvodiView(this, preduzece, preduzece.proizvodi);   // aplikacija mu treba
		} catch (IOException e) {
			e.printStackTrace();
		}
		initOnoSaStrane();
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.setLayout(new BorderLayout());
		
		JPanel left = new JPanel(new BorderLayout());
		left.add(onoSaStrane, BorderLayout.LINE_END);
		JPanel panel = new JPanel();
		
		this.add(left, BorderLayout.LINE_START);
		panel.add(proizvodi);
		this.add(panel);
		this.show();
		
		kontroler = new MenadzerController(this, preduzece);
		
		this.frame.setOvajStoSeMenja(this);
				
		this.narudzbenice = new ArrayList<Narudzbenica>();
		for(Narudzbenica n : preduzece.narudzbenice) {
			if(n.getStanje().getClass().equals(Placena.class) || n.getStanje().getClass().equals(Poslata.class)) {
				narudzbenice.add(n);
			}
		}
		
	}
	
	private void initOnoSaStrane() {
		onoSaStrane = new JPanel();
		
		onoSaStrane.setPreferredSize(new Dimension(300, 600));
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);

		prikazNarudzbenica = new JLabel("  Prikaz narudzbenica  ");
		prikazNarudzbenica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		onoSaStrane.setLayout(new GridLayout(18, 0));
		
		dodajNoviProizvod = new JLabel("  Dodaj novi proizvod  ");
		dodajNoviProizvod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		onoSaStrane.add(dodajNoviProizvod);		
		onoSaStrane.add(prikazNarudzbenica);		
		
		izmenaPodataka = new JLabel("  Izmena mojih podataka  ");
		izmenaPodataka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		onoSaStrane.add(izmenaPodataka);
		onoSaStrane.add(new JLabel("  Rad sa kategorijama  "));
		onoSaStrane.add(new JLabel("  Rad sa prodavnicama  "));
		
	}


	public ProizvodiView getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(ProizvodiView proizvodi) {
		this.proizvodi = proizvodi;
	}

	public JPanel getOnoSaStrane() {
		return onoSaStrane;
	}

	public void setOnoSaStrane(JPanel onoSaStrane) {
		this.onoSaStrane = onoSaStrane;
	}

	public JLabel getDodajNoviProizvod() {
		return dodajNoviProizvod;
	}

	public void setDodajNoviProizvod(JLabel dodajNoviProizvod) {
		this.dodajNoviProizvod = dodajNoviProizvod;
	}

	public JLabel getProdavnice() {
		return prodavnice;
	}

	public void setProdavnice(JLabel prodavnice) {
		this.prodavnice = prodavnice;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public JLabel getPrikazNarudzbenica() {
		return prikazNarudzbenica;
	}

	public void setPrikazNarudzbenica(JLabel prikazNarudzbenica) {
		this.prikazNarudzbenica = prikazNarudzbenica;
	}

	public JLabel getIzmenaPodataka() {
		return izmenaPodataka;
	}

	public void setIzmenaPodataka(JLabel izmenaPodataka) {
		this.izmenaPodataka = izmenaPodataka;
	}

	public JSplitPane getSplit() {
		return split;
	}

	public void setSplit(JSplitPane split) {
		this.split = split;
	}

	public ArrayList<Narudzbenica> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(ArrayList<Narudzbenica> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}
	
}
