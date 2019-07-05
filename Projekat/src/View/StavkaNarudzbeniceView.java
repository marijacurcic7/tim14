package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControllerProizvoda;
import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.StavkaNarudzbenice;
import gui.panels.ProizvodPanel;

public class StavkaNarudzbeniceView extends JPanel {
	
	StavkaNarudzbenice stavkan;
	Proizvod proizvod;
	AplikacijaPreduzece preduzece;
	ProizvodView proizvodv;
	
	public StavkaNarudzbeniceView(StavkaNarudzbenice sn, AplikacijaPreduzece ap) {
		this.stavkan = sn;
		this.preduzece = ap;
		this.proizvod = sn.getProizvod();
		
		//this.proizvodv = new ProizvodView(proizvod);
		JLabel slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		add(slika);
		JLabel naziv = new JLabel(proizvod.getNaziv());
		this.add(naziv);
		JLabel kolicina = new JLabel(stavkan.getKolicina()+"");
		double ukupno = stavkan.getUkupnaCena();
		JLabel ukupnaCena = new JLabel(ukupno + "");
		this.add(ukupnaCena);
	}
	
	private void constructGUI() {
		
	}

}
