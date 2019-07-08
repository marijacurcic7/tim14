package View;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Controller.ProizvodController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.TipKorisnika;

public class ProizvodView extends BaseView {
	
	Proizvod p;
	ProizvodController controller;
	AplikacijaPreduzece preduzece;
	JSpinner spinner;
	public MainFrame frame;
	
	JButton staviUKorpu;
	JButton obrisi;
	JButton izmeni;
	JLabel slika;
	JPanel pnlpodaci;
	JLabel kategorija;
	JLabel naziv;
	JLabel opis;
	JLabel jedinicnaCena;
	JPanel gdjeStoji;
	
	public ProizvodView(Proizvod p, MainFrame frame, String g) {
		this.frame = frame;
		this.p = p;
		slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		add(slika);
		naziv = new JLabel(p.getNaziv());
		this.add(naziv);
		
		jedinicnaCena = new JLabel(p.getAktuelnaCena().getRedovnaCena() + "");
		this.add(jedinicnaCena);
	}
	
	public ProizvodView(Proizvod p, JPanel bw, AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
		gdjeStoji = bw;
		this.p = p;
		
		constructGUI();
		
	}
	
	private void constructGUI() {
		pnlpodaci = new JPanel();
		pnlpodaci.setLayout(new GridBagLayout());
		pnlpodaci.setPreferredSize(new Dimension(300, 400));
		
		slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon(p.getPutanja()).getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		add(slika);
		naziv = new JLabel("Naziv proizvoda: "+p.getNaziv());
		jedinicnaCena = new JLabel("Cena: "+p.getAktuelnaCena().getRedovnaCena());
		opis = new JLabel("Opis: "+p.getOpis());
		kategorija = new JLabel("Kategorija: "+p.getKategorija().getNaziv());
		
		pnlpodaci.add(new JLabel("Id: " + p.getId() + ""), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlpodaci.add(naziv, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlpodaci.add(jedinicnaCena, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlpodaci.add(kategorija, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlpodaci.add(opis, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		add(pnlpodaci);
		
		obrisi = new JButton("Obrisi");
		izmeni = new JButton("Izmeni");
		
		SpinnerModel value =  
	             new SpinnerNumberModel(1, //initial value  
	                1, //minimum value  
	                100, //maximum value  
	                1); //step  
	    spinner = new JSpinner(value);   
        spinner.setBounds(100,100,50,30);    
        add(spinner);
        staviUKorpu = new JButton("Dodaj u korpu");
        if (preduzece.trenutnoUlogovani != null) {
			if (preduzece.trenutnoUlogovani.getNalog().getTipKorisnika() == TipKorisnika.menadzer) {
				staviUKorpu.setVisible(false);
				add(obrisi);
				add(izmeni);
				spinner.setVisible(false);
			}
		}
		
		add(staviUKorpu);
	}

	public Proizvod getP() {
		return p;
	}

	public void setP(Proizvod p) {
		this.p = p;
	}

	public ProizvodController getController() {
		return controller;
	}

	public void setController(ProizvodController controller) {
		this.controller = controller;
	}

	public JButton getStaviUKorpu() {
		return staviUKorpu;
	}

	public void setStaviUKorpu(JButton staviUKorpu) {
		this.staviUKorpu = staviUKorpu;
	}

	public JLabel getSlika() {
		return slika;
	}

	public void setSlika(JLabel slika) {
		this.slika = slika;
	}

	public JLabel getOpis() {
		return opis;
	}

	public void setOpis(JLabel opis) {
		this.opis = opis;
	}

	public JLabel getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(JLabel jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public JPanel getGdjeStoji() {
		return gdjeStoji;
	}

	public void setGdjeStoji(JPanel gdjeStoji) {
		this.gdjeStoji = gdjeStoji;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JLabel getNaziv() {
		return naziv;
	}

	public void setNaziv(JLabel naziv) {
		this.naziv = naziv;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public JButton getObrisi() {
		return obrisi;
	}

	public void setObrisi(JButton obrisi) {
		this.obrisi = obrisi;
	}

	public JButton getIzmeni() {
		return izmeni;
	}

	public void setIzmeni(JButton izmeni) {
		this.izmeni = izmeni;
	}
	
	
	

}
