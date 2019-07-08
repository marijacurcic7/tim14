package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;
import View.FormiranjeNarudzbeniceView;
import View.KorpaView;

public class KorpaController {
	
	private KorpaView kv;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	
	public KorpaController(KorpaView kv, AplikacijaPreduzece ap) {
		
		this.kv = kv;
		this.preduzece = ap;
		
		addListeners();
		
	}
	
	private void addListeners() {
		// TODO Auto-generated method stub
		
		kv.getKupi().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					kupi();
					//fnview.ok();
				}
		});
		
		kv.getIsprazni().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					isprazni();
					//fnview.ok();
				}
			
		});
		
	}

	protected void kupi() {
		if (preduzece.korpa.stavkeNarudzbenice.size()==0) {
			Window w = SwingUtilities.getWindowAncestor(kv.getKupi());
			JOptionPane.showMessageDialog(w, "Korpa je prazna");
		}
		else if(preduzece.trenutnoUlogovani == null) {
			//RegistracijaView rv = new RegistracijaView(preduzece, frame);
			
			//login -> nullpointerexception
			/*LogInView rv = new LogInView(preduzece, frame);
			add(rv);
			remove(0);
			updateUI();*/
			
			//samo poruka
			
			Window w = SwingUtilities.getWindowAncestor(kv.getKupi());
			JOptionPane.showMessageDialog(w, "Ulogujte se");
			
		}
		else {
			FormiranjeNarudzbeniceView fnv = new FormiranjeNarudzbeniceView(preduzece, kv.getFrame());
			kv.add(fnv);
			kv.remove(0);
			kv.updateUI();
		}

	}

	protected void isprazni() {
		preduzece.korpa = new Narudzbenica();
		//korpa = new Narudzbenica();
		KorpaView kv1 = new KorpaView(preduzece, kv.getFrame());
		kv.add(kv1);
		kv.remove(0);
		kv.updateUI();
		
	}

	public void dodajUKorpu(StavkaNarudzbenice sn) {
		if (preduzece.korpa.stavkeNarudzbenice.size()==0) {
			Window w = SwingUtilities.getWindowAncestor(kv.getKupi());
			JOptionPane.showMessageDialog(w, "Korpa je prazna");
		}
		else if(preduzece.trenutnoUlogovani == null) {
			//RegistracijaView rv = new RegistracijaView(preduzece, frame);
			
			//login -> nullpointerexception
			/*LogInView rv = new LogInView(preduzece, frame);
			add(rv);
			remove(0);
			updateUI();*/
			
			//samo poruka
			
			Window w = SwingUtilities.getWindowAncestor(kv.getKupi());
			JOptionPane.showMessageDialog(w, "Ulogujte se");
			
		}
		else {
			FormiranjeNarudzbeniceView fnv = new FormiranjeNarudzbeniceView(preduzece, kv.getFrame());
			kv.add(fnv);
			kv.remove(0);
			kv.updateUI();
		}

	}

}
