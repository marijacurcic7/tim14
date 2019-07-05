package View;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Controller.ProizvodController;
import Model.Proizvod;

public class ProizvodView extends BaseView {
	
	Proizvod p;
	ProizvodController controller;
	
	// imace dugme stavi u korpus
	
	// sta se desi ako u pola uloguje se novi
	// ostavljamo naarudzbenicu? ili novu
	// dugme da se sve brise iz narudzbenice?
	
	JButton staviUKorpu;
	JLabel slika;
	JLabel naziv;
	// slicica
	JLabel opis;
	JLabel jedinicnaCena;
	BaseView gdjeStoji;
	// set text
	
	public ProizvodView(Proizvod p) {
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
	
	public ProizvodView(Proizvod p, BaseView bw) {
		gdjeStoji = bw;
		this.p = p;
		
		
		slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
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
	    JSpinner spinner = new JSpinner(value);   
	            spinner.setBounds(100,100,50,30);    
	            this.add(spinner);    
	            //f.setSize(300,300);    
	            //f.setLayout(null);    
	            //f.setVisible(true);    
		staviUKorpu = new JButton("Dodaj u korpu");
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

	public BaseView getGdjeStoji() {
		return gdjeStoji;
	}

	public void setGdjeStoji(BaseView gdjeStoji) {
		this.gdjeStoji = gdjeStoji;
	}
	

}
