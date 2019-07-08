package gui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControllerProizvoda;
import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.TipKorisnika;
import View.BaseView;
import View.ProizvodiView;


public class ProizvodPanel extends JPanel {
	
	AplikacijaPreduzece preduzece;
	ControllerProizvoda controller;
	Proizvod proizvod;
	JLabel labelaCena;
	JLabel labelaIme;
	JButton dugmeKorpa;
	JButton dugmePregled;
	JLabel slika;
	ProizvodiView gdjeStoji; // wtf?
	
	public ControllerProizvoda getController() {
		return controller;
	}

	public void setController(ControllerProizvoda controller) {
		this.controller = controller;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public JLabel getLabelaCena() {
		return labelaCena;
	}

	public void setLabelaCena(JLabel labelaCena) {
		this.labelaCena = labelaCena;
	}

	public JLabel getLabelaIme() {
		return labelaIme;
	}

	public void setLabelaIme(JLabel labelaIme) {
		this.labelaIme = labelaIme;
	}

	public JButton getDugmeKorpa() {
		return dugmeKorpa;
	}

	public void setDugmeKorpa(JButton dugmeKorpa) {
		this.dugmeKorpa = dugmeKorpa;
	}

	public JButton getDugmePregled() {
		return dugmePregled;
	}

	public void setDugmePregled(JButton dugmePregled) {
		this.dugmePregled = dugmePregled;
	}

	public JLabel getSlika() {
		return slika;
	}

	public void setSlika(JLabel slika) {
		this.slika = slika;
	}

	public ProizvodiView getGdjeStoji() {
		return gdjeStoji;
	}

	public void setGdjeStoji(ProizvodiView gdjeStoji) {
		this.gdjeStoji = gdjeStoji;
	}

	public ProizvodPanel(Proizvod p, ProizvodiView bw, AplikacijaPreduzece preduzece) throws IOException {
		this.preduzece = preduzece;
		gdjeStoji = bw;
		proizvod = p;
		
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		
		
		labelaIme = new JLabel(p.getNaziv());
		labelaCena = new JLabel(p.getAktuelnaCena().getRedovnaCena() + "");  // pokupiti cenu iz stavke cenovnika koja stoji u proizvodu	
		dugmeKorpa = new JButton("Korpa");
		
		dugmePregled = new JButton("Pregled - korpa");
		
		if (preduzece.getTrenutnoUlogovani() == null) {
			
		}
		
		else if (preduzece.getTrenutnoUlogovani().getNalog().getTipKorisnika() == TipKorisnika.menadzer) {
			dugmePregled.setText("Izmeni");
		}
		
		slika = new JLabel();
		System.out.println(proizvod.getPutanja());
		slika.setIcon(new ImageIcon(new ImageIcon(proizvod.getPutanja()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
		
		
		add(slika);

		c.gridx = 0;
		c.gridy = 1;
		
		JPanel holder1 = new JPanel(new GridLayout(0, 3));
		holder1.add(labelaIme);
		holder1.add(new JLabel());
		holder1.add(new JLabel("Id: " + p.getId() + ""));
		add(holder1, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(labelaCena, c);
		
		c.gridy = 3;
		GridLayout gridHorizontal = new GridLayout(0,1);
		JPanel holder = new JPanel();
		holder.setLayout(gridHorizontal);
		
		holder.add(dugmePregled);
		add(holder, c);

	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public ProizvodPanel() {
		// TODO Auto-generated constructor stub
	}
	

			
			

}
