package View;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Controller.KupacController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.RegistrovaniKupac;

public class KupacView extends BaseView {

	RegistrovaniKupac kupac;
	MainFrame frame;
	KupacController kontroler;
	ProizvodiView proizvodi;
	JPanel onoSaStrane;	
	JLabel prikazNarudzbenica;	
	JLabel izmenaPodataka;
	JSplitPane split;	
	AplikacijaPreduzece preduzece;
	
	
	public KupacView(AplikacijaPreduzece preduzece, MainFrame f) {
		
		this.preduzece = preduzece;
		this.frame = f;
		this.kupac = (RegistrovaniKupac)preduzece.trenutnoUlogovani;
		try {		
			proizvodi = new ProizvodiView(this, preduzece, preduzece.proizvodi);   
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

		this.frame.setOvajStoSeMenja(this);		
		
		kontroler = new KupacController(this, preduzece);
		
		
	}
	
	private void initOnoSaStrane() {
		onoSaStrane = new JPanel();
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		onoSaStrane.setPreferredSize(new Dimension(200, 600));
		
		prikazNarudzbenica = new JLabel("  Prikaz mojih narudzbenica  ");
		prikazNarudzbenica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		onoSaStrane.setLayout(new GridLayout(18, 0));
		onoSaStrane.add(prikazNarudzbenica);
		
		izmenaPodataka = new JLabel("  Izmena mojih podataka  ");
		izmenaPodataka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		onoSaStrane.add(izmenaPodataka);

	}

	public RegistrovaniKupac getKupac() {
		return kupac;
	}

	public void setKupac(RegistrovaniKupac kupac) {
		this.kupac = kupac;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
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

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}
	
}
