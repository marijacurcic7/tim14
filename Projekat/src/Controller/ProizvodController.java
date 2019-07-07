package Controller;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Proizvod;
import Model.StavkaCenovnika;
import Model.StavkaNarudzbenice;
import View.ProizvodView;
import View.ProizvodiView;


public class ProizvodController extends Controller {

	private ProizvodView proizvodView;
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;
	private int kolicina;
	
	
	public ProizvodController(ProizvodView proizvodView, AplikacijaPreduzece preduzece) {
		this.proizvodView = proizvodView;
		this.preduzece = preduzece;
		this.proizvod = proizvodView.getP();
		
		
		/*this.proizvodView.getStaviUKorpu().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	//System.out.println("Nesto se desilo");
			    String message = "Na osnovu modela pogledati\n"
			    		+ " da li ima dovoljno proizvoda, \n"
			    		+ "dodati ih u narudzbenicu, skinuti sa nekog"
			    		+ "stanja\ni jos nesto probs, ugl azurirati model!";	
				 
				 JOptionPane.showMessageDialog(proizvodView, message);
			    }
			 	
			
		});*/
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
							//double novaCena = 
							//sn.setUkupnaCena(novaCena);
							System.out.println("Ukupna cena: "+sn.getUkupnaCena());
							System.out.println("Cena u korpi: "+preduzece.korpa.getUkupanIznos());
							added = true;
						}
					}
					if (added == false) {
						preduzece.korpa.addStavkaNarudzbenice(new StavkaNarudzbenice(kolicina, proizvod));
					}
					System.out.println(kolicina+" "+proizvod);
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date datum = new Date(System.currentTimeMillis());
					preduzece.korpa.setDatum(datum);
					
					JOptionPane.showMessageDialog(w, "Dodato");
					/*try {
						ProizvodiView pv = new ProizvodiView(preduzece);
						add(pv);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					ProizvodiView bw = null;
					try {
						bw = new ProizvodiView(preduzece);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//frame.getView().remove(0);
					
					proizvodView.getGdjeStoji().add(bw);
					proizvodView.getGdjeStoji().remove(0);
					proizvodView.getGdjeStoji().updateUI();
			}
		});
		
		proizvodView.getObrisi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Obrisi");
				for(Proizvod p : preduzece.proizvodi) {
					if(p.equals(proizvod)) {
						preduzece.proizvodi.remove(proizvod);
						JOptionPane.showMessageDialog(w, "Proizvod je izbrisan");
						break;
					}
				}
				ProizvodiView bw = null;
				try {
					bw = new ProizvodiView(preduzece);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frame.getView().remove(0);
				
				proizvodView.getGdjeStoji().add(bw);
				proizvodView.getGdjeStoji().remove(0);
				proizvodView.getGdjeStoji().updateUI();
			}
						
		});
		
		proizvodView.getIzmeni().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izmeni");
				String cenastr = JOptionPane.showInputDialog("Nova cena: ");
				System.out.println(cenastr);
				double cena = Double.parseDouble(cenastr);
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date datum = new Date(System.currentTimeMillis());
				StavkaCenovnika sc = new StavkaCenovnika(cena, datum, proizvod);
				proizvod.setAktuelnaCena(sc);
				ProizvodiView bw = null;
				try {
					bw = new ProizvodiView(preduzece);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//frame.getView().remove(0);
				
				proizvodView.getGdjeStoji().add(bw);
				proizvodView.getGdjeStoji().remove(0);
				proizvodView.getGdjeStoji().updateUI();
			}
		});
	}
	
}
