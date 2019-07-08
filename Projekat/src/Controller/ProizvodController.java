package Controller;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.StavkaCenovnika;
import Model.StavkaNarudzbenice;
import View.KupacView;
import View.ProizvodView;
import View.ProizvodiView;


public class ProizvodController {

	private ProizvodView proizvodView;
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;
	private int kolicina;
	
	
	public ProizvodController(ProizvodView proizvodView, AplikacijaPreduzece preduzece) {
		this.proizvodView = proizvodView;
		this.preduzece = preduzece;
		this.proizvod = proizvodView.getP();
		
		
		addListeners();
	}
	
	private void addListeners() {
		Window w = SwingUtilities.getWindowAncestor(proizvodView);
		
		proizvodView.getStaviUKorpu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					kolicina = Integer.parseInt(proizvodView.getSpinner().getValue().toString());
					boolean added = false;
					for (StavkaNarudzbenice sn: preduzece.korpa.getStavkaNarudzbenice()) {
						if (sn.getProizvod().getId() == proizvod.getId()) {
							sn.setKolicina(sn.getKolicina() + kolicina);
							double cenaUkorpi = preduzece.korpa.getUkupanIznos();
							preduzece.korpa.update();
							
							added = true;
						}
					}
					if (added == false) {
						preduzece.korpa.addStavkaNarudzbenice(new StavkaNarudzbenice(kolicina, proizvod));
					}
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date datum = new Date(System.currentTimeMillis());
					preduzece.korpa.setDatum(datum);
					
					JOptionPane.showMessageDialog(w, "Dodato");
					
					ProizvodiView bw = null;
					try {
						bw = new ProizvodiView(proizvodView.getGdjeStoji(), preduzece, preduzece.proizvodi);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if (preduzece.trenutnoUlogovani == null) {
					proizvodView.getGdjeStoji().add(bw);
					proizvodView.getGdjeStoji().remove(0);
					proizvodView.getGdjeStoji().updateUI();
					}
					else {
						//KupacView stoji = (KupacView) proizvodView.getGdjeStoji();
						
						return;
						
					}
			}
		});
		
		proizvodView.getObrisi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(Proizvod p : preduzece.proizvodi) {
					if(p.equals(proizvod)) {
						preduzece.proizvodi.remove(proizvod);
						for(StavkaNarudzbenice sn : preduzece.korpa.stavkeNarudzbenice) {
							if(sn.proizvod.equals(p)) {
								preduzece.korpa.removeStavkaNarudzbenice(sn);
							}
						}
						JOptionPane.showMessageDialog(w, "Proizvod je izbrisan");
						break;
					}
				}
				ProizvodiView bw = null;
				try {
					bw = new ProizvodiView(proizvodView.getGdjeStoji(), preduzece, preduzece.proizvodi);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				proizvodView.getGdjeStoji().remove(1);
				proizvodView.getGdjeStoji().add(bw);
				
				proizvodView.getGdjeStoji().updateUI();
			
			}
						
		});
		
		proizvodView.getIzmeni().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cenastr = JOptionPane.showInputDialog("Nova cena: ");
				
				double cena = Double.parseDouble(cenastr);
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date datum = new Date(System.currentTimeMillis());
				StavkaCenovnika sc = new StavkaCenovnika(cena, datum, proizvod);
				proizvod.setAktuelnaCena(sc);
				ProizvodiView bw = null;
				try {
					bw = new ProizvodiView(proizvodView.getGdjeStoji(), preduzece, preduzece.proizvodi);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				proizvodView.getGdjeStoji().remove(1);
				proizvodView.getGdjeStoji().add(bw);
				
				proizvodView.getGdjeStoji().updateUI();
			}
		});
	}
	
}
