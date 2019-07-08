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

import Controller.StavkaNarudzbeniceController;
import Model.AplikacijaPreduzece;
import Model.Formiranje;
import Model.Narudzbenica;
import Model.Proizvod;
import Model.StavkaNarudzbenice;

public class StavkaNarudzbeniceView extends JPanel {
	
	private StavkaNarudzbenice stavkan;
	private Proizvod proizvod;
	private AplikacijaPreduzece preduzece;
	private JButton btnObrisi;
	private JButton btnPromeniKolicinu;
	private JPanel pnlContent;
	private KorpaView kv;
	private NarudzbenicaView narudzbenicav;
	private StavkaNarudzbeniceController sncon;
	
	public StavkaNarudzbeniceView(StavkaNarudzbenice sn, AplikacijaPreduzece ap, KorpaView kv) {
		this.kv = kv;
		this.stavkan = sn;
		this.preduzece = ap;
		this.proizvod = sn.getProizvod();
		this.btnObrisi = new JButton("Obrisi");
		this.btnPromeniKolicinu = new JButton("Promeni kolicinu");
		if(this.sncon == null) {
			this.sncon = new StavkaNarudzbeniceController(preduzece, this);
		}
		constructGUI();
	}
	
	public StavkaNarudzbeniceView(StavkaNarudzbenice sn, AplikacijaPreduzece ap, NarudzbenicaView n) {
		this.stavkan = sn;
		this.preduzece = ap;
		this.proizvod = sn.getProizvod();
		this.btnObrisi = new JButton("Obrisi");
		this.btnPromeniKolicinu = new JButton("Promeni kolicinu");
		this.narudzbenicav = n;
		
		
		constructGUI2();
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
						preduzece.korpa.update();
						break;
					}
				}
				
				
				KorpaView kv1 = new KorpaView(preduzece, kv.frame);
				kv.add(kv1);
				kv.remove(0);
				kv.updateUI();
			}
		});
		
	
	}
	
	private void constructGUI2() {
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
		
		if(narudzbenicav.narudzbenica.getStanje().getClass().equals(Formiranje.class)) {
			add(btnObrisi);
			add(btnPromeniKolicinu);
		}
		
		btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(StavkaNarudzbenice s : narudzbenicav.narudzbenica.stavkeNarudzbenice) {
					if(s.equals(stavkan)) {
						narudzbenicav.narudzbenica.stavkeNarudzbenice.remove(s);
						narudzbenicav.narudzbenica.update();
						preduzece.korpa.stavkeNarudzbenice.remove(s);
						preduzece.korpa.update();
						break;
					}
				}
				
				NarudzbeniceView nev = narudzbenicav.nev;
				
				JPanel pnl2 = new JPanel();
				
				pnl2.setLayout(new GridLayout(preduzece.korpa.stavkeNarudzbenice.size(), 1));
				int i = 0;
				for(StavkaNarudzbenice sn : narudzbenicav.narudzbenica.stavkeNarudzbenice) {
					StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, narudzbenicav);
					pnl2.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
					i+=10;
				}
				nev.add(pnl2);
				nev.remove(0);
				nev.updateUI();
				
			}
		});

	}

	public StavkaNarudzbenice getStavkan() {
		return stavkan;
	}

	public void setStavkan(StavkaNarudzbenice stavkan) {
		this.stavkan = stavkan;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public JButton getBtnObrisi() {
		return btnObrisi;
	}

	public void setBtnObrisi(JButton btnObrisi) {
		this.btnObrisi = btnObrisi;
	}

	public JButton getBtnPromeniKolicinu() {
		return btnPromeniKolicinu;
	}

	public void setBtnPromeniKolicinu(JButton btnPromeniKolicinu) {
		this.btnPromeniKolicinu = btnPromeniKolicinu;
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}

	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
	}

	public KorpaView getKv() {
		return kv;
	}

	public void setKv(KorpaView kv) {
		this.kv = kv;
	}

	public NarudzbenicaView getNarudzbenicav() {
		return narudzbenicav;
	}

	public void setNarudzbenicav(NarudzbenicaView narudzbenicav) {
		this.narudzbenicav = narudzbenicav;
	}

	public StavkaNarudzbeniceController getSncon() {
		return sncon;
	}

	public void setSncon(StavkaNarudzbeniceController sncon) {
		this.sncon = sncon;
	}

}
