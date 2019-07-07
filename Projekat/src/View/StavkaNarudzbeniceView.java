package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.Proizvod;
import Model.StavkaNarudzbenice;

public class StavkaNarudzbeniceView extends JPanel {
	
	private StavkaNarudzbenice stavkan;
	private Proizvod proizvod;
	private AplikacijaPreduzece preduzece;
	private ProizvodView proizvodv;
	private JButton btnObrisi;
	private JButton btnPromeniKolicinu;
	private JPanel pnlContent;
	private KorpaView kv;
	
	public StavkaNarudzbeniceView(StavkaNarudzbenice sn, AplikacijaPreduzece ap, KorpaView kv) {
		this.kv = kv;
		this.stavkan = sn;
		this.preduzece = ap;
		this.proizvod = sn.getProizvod();
		this.btnObrisi = new JButton("Obrisi");
		this.btnPromeniKolicinu = new JButton("Promeni kolicinu");
		
		/*this.setLayout(new BorderLayout());
		
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
		
		this.add(dugmad, BorderLayout.LINE_END);*/
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		pnlContent.setLayout(new GridBagLayout());
		
		JLabel slika = new JLabel();
		slika.setIcon(new ImageIcon(new ImageIcon(proizvod.getPutanja()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
		add(slika);
		add(slika, BorderLayout.LINE_START);
		
		
		JPanel labele = new JPanel(new GridBagLayout());

		
		JLabel naziv = new JLabel(proizvod.getNaziv());

		JLabel kolicina = new JLabel(stavkan.getKolicina()+"");
		double ukupno = stavkan.getUkupnaCena();
		JLabel ukupnaCena = new JLabel(ukupno + "");

		labele.add(naziv, new GridBagConstraints(0, 0, 5, 5, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(15, 15, 15, 15), 0, 0));
		labele.add(kolicina, new GridBagConstraints(0, 5, 5, 5, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(15, 15, 15, 15), 0, 0));
		labele.add(ukupnaCena, new GridBagConstraints(0, 10, 5, 5, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(15, 15, 15, 15), 0, 0));
		
		
		add(labele);
		
		add(btnObrisi);
		add(btnPromeniKolicinu);
		
		btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(StavkaNarudzbenice s : preduzece.korpa.stavkeNarudzbenice) {
					if(s.equals(stavkan)) {
						preduzece.korpa.stavkeNarudzbenice.remove(s);
						break;
					}
				}
				
				//StavkaNarudzbeniceView sv = new StavkaNarudzbeniceView(null, preduzece);
				
				//add(sv);
				KorpaView kv1 = new KorpaView(preduzece, kv.frame);
				kv.add(kv1);
				kv.remove(0);
				kv.updateUI();
			}
		});
		
	
	}

}
