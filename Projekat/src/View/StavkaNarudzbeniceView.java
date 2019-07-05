package View;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.StavkaNarudzbenice;

public class StavkaNarudzbeniceView extends JPanel {
	
	StavkaNarudzbenice stavkan;
	Proizvod proizvod;
	AplikacijaPreduzece preduzece;
	ProizvodView proizvodv;
	JButton btnObrisi;
	JButton btnPromeniKolicinu;
	
	public StavkaNarudzbeniceView(StavkaNarudzbenice sn, AplikacijaPreduzece ap) {
		this.stavkan = sn;
		this.preduzece = ap;
		this.proizvod = sn.getProizvod();
		this.btnObrisi = new JButton("Obrisi");
		this.btnPromeniKolicinu = new JButton("Promeni kolicinu");
		
		//setPreferredSize(new Dimension(700, 200));
		
		//this.proizvodv = new ProizvodView(proizvod);
		JLabel slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
		add(slika);
		slika.setVisible(true);
		JLabel naziv = new JLabel(proizvod.getNaziv());
		this.add(naziv);
		JLabel kolicina = new JLabel(stavkan.getKolicina()+"");
		double ukupno = stavkan.getUkupnaCena();
		JLabel ukupnaCena = new JLabel(ukupno + "");
		this.add(ukupnaCena);
		this.add(btnObrisi);
		this.add(btnPromeniKolicinu);
		
	}
	
	private void constructGUI() {
		
	}

}
