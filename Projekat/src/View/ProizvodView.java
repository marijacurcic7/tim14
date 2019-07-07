package View;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	
	// imace dugme stavi u korpus
	
	// sta se desi ako u pola uloguje se novi
	// ostavljamo naarudzbenicu? ili novu
	// dugme da se sve brise iz narudzbenice?
	
	JButton staviUKorpu;
	JButton obrisi;
	JButton izmeni;
	JLabel slika;
	JLabel naziv;
	// slicica
	JLabel opis;
	JLabel jedinicnaCena;
	BaseView gdjeStoji;
	// set text
	
	public ProizvodView(Proizvod p, MainFrame frame, String g) {
		this.frame = frame;
		this.p = p;
		slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		add(slika);
		naziv = new JLabel(p.getNaziv());
		this.add(naziv);
		//int cena = 1;
		System.out.println("asdadas");
		jedinicnaCena = new JLabel(p.getAktuelnaCena().getRedovnaCena() + "");
		this.add(jedinicnaCena);
	}
	
	public ProizvodView(Proizvod p, BaseView bw, AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
		gdjeStoji = bw;
		this.p = p;
		
		obrisi = new JButton("Obrisi");
		izmeni = new JButton("Izmeni");
		
		slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon(p.getPutanja()).getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		//C:\Windows\Web\Wallpaper\Theme1
		add(slika);
		
		naziv = new JLabel(p.getNaziv());
		
		this.add(naziv);
		
		int cena = 1;
		
		jedinicnaCena = new JLabel(p.getAktuelnaCena().getRedovnaCena() + "");
		this.add(jedinicnaCena);
		
		//JSpinner spinner = new JSpinner();
		//SpinnerModel spinner = new SpinnerModel(100, 100, 100);
		
		// na klik na dugme u kontroleru na osnovu modeela
		// provjeriti koliko ima tog proizvoda
	
		SpinnerModel value =  
	             new SpinnerNumberModel(1, //initial value  
	                1, //minimum value  
	                100, //maximum value  
	                1); //step  
	    spinner = new JSpinner(value);   
        spinner.setBounds(100,100,50,30);    
        this.add(spinner);    
        //f.setSize(300,300);    
        //f.setLayout(null);    
        //f.setVisible(true);    
		staviUKorpu = new JButton("Dodaj u korpu");
		
		if (preduzece.trenutnoUlogovani != null) {
			if (preduzece.trenutnoUlogovani.getNalog().getTipKorisnika() == TipKorisnika.menadzer) {
				//staviUKorpu.setText("Izmeni");
				staviUKorpu.setVisible(false);
				add(obrisi);
				add(izmeni);
				spinner.setVisible(false);
			}
		}
		
		add(staviUKorpu);
		//String value1 = spinner.change
		//System.out.println(value1+"");
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

	public BaseView getGdjeStoji() {
		return gdjeStoji;
	}

	public void setGdjeStoji(BaseView gdjeStoji) {
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
