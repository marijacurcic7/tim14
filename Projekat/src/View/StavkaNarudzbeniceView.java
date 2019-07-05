package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
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
		
		this.setLayout(new BorderLayout());
		
		//setPreferredSize(new Dimension(700, 200));
		
		//this.proizvodv = new ProizvodView(proizvod);
		JLabel slika = new JLabel();
		
		slika.setIcon(new ImageIcon(new ImageIcon("C:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
		//add(slika);
		add(slika, BorderLayout.LINE_START);
		
		
		JPanel labele = new JPanel(new BorderLayout());
		
		
		slika.setVisible(true);
		JLabel naziv = new JLabel(proizvod.getNaziv());
		//this.add(naziv);
		labele.add(naziv, BorderLayout.NORTH);
		JLabel kolicina = new JLabel(stavkan.getKolicina()+"");
		double ukupno = stavkan.getUkupnaCena();
		JLabel ukupnaCena = new JLabel(ukupno + "");
		
		
		labele.add(new JLabel(proizvod.getOpis()), BorderLayout.CENTER);
	
		//this.add(ukupnaCena);
		labele.add(ukupnaCena, BorderLayout.SOUTH);
		
		this.add(labele, BorderLayout.CENTER);
		
		
		JPanel dugmad = new JPanel(new BorderLayout());
		//btnObrisi.setSize(new Dimension(2,2));
		//btnPromeniKolicinu.setSize(5, 2);
		//dugmad.add(btnObrisi, GroupLayout.PREFERRED_SIZE);
		//dugmad.add(btnPromeniKolicinu, GroupLayout.PREFERRED_SIZE);
		
		btnObrisi.setPreferredSize(new Dimension(5, 2));
		btnObrisi.setPreferredSize(new Dimension(5, 2));
		dugmad.add(btnObrisi);
		dugmad.add(btnPromeniKolicinu);
		
		this.add(dugmad, BorderLayout.LINE_END);
	}
	
	private void constructGUI() {
		
	}

}
