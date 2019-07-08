package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.AplikacijaPreduzece;
import Model.StavkaNarudzbenice;
import View.KorpaView;
import View.StavkaNarudzbeniceView;

public class StavkaNarudzbeniceController {
	
	private AplikacijaPreduzece preduzece;
	private StavkaNarudzbeniceView snview;
	
	public StavkaNarudzbeniceController(AplikacijaPreduzece preduzece, StavkaNarudzbeniceView snview) {
		this.preduzece = preduzece;
		this.snview = snview;
		
		//addListeners();
	}
	
	private void addListeners() {
		snview.getBtnObrisi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(StavkaNarudzbenice s : preduzece.korpa.stavkeNarudzbenice) {
					if(s.equals(snview.getStavkan())) {
						preduzece.korpa.stavkeNarudzbenice.remove(s);
						preduzece.korpa.update();
						break;
					}
				}
				
				
				KorpaView kv1 = new KorpaView(preduzece, snview.getKv().getFrame());
				snview.getKv().add(kv1);
				snview.getKv().remove(0);
				snview.getKv().updateUI();
			}
		});
		
		/*btnObrisi.addActionListener(new ActionListener() {
			
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
		});*/
		
	}

}
