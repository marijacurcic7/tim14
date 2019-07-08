package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Narudzbenica;
import Model.Placena;
import Model.RegistrovaniKupac;
import Model.Zavrsena;
import View.FormiranjeNarudzbeniceView;


public class FormiranjeNarudzbeniceController {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik trenutnoUlogovani;
	private FormiranjeNarudzbeniceView fnview;
	private Narudzbenica korpa;
	private RegistrovaniKupac kupac;
	
	public FormiranjeNarudzbeniceController(FormiranjeNarudzbeniceView fnv, AplikacijaPreduzece ap) {
		
		this.fnview = fnv;
		this.preduzece = ap;
		this.trenutnoUlogovani = ap.trenutnoUlogovani;
		this.korpa = ap.korpa;
		kupac = (RegistrovaniKupac)trenutnoUlogovani;
		addListeners();
	}
	
	public String formirajNarudzbenicu(String ime, String prezime, String telefon, String karticastr, double cena, String drzava, String grad, String adresa) {
		
		if (ime == null) {
			return "Unesite ime";
		}
		ime = ime.trim();
		if (ime.isEmpty()) {
			return "Unesite ime";
		}
		
		if (prezime == null) {
			return "Unesite prezime";
		}
		prezime = prezime.trim();
		if (prezime.isEmpty()) {
			return "Unesite prezime";
		}
		
		int brKartice;
		karticastr = karticastr.trim();
		if (karticastr.isEmpty()) {
			return "Unesite karticu";
		}
		
		 try { 
			brKartice = Integer.parseInt(karticastr); 
		    } catch(NumberFormatException e) { 
		        return "Niste lepo uneli karticu..."; 
		    }
		
		
		if (drzava == null) {
			return "Unesite drzavu";
		}
		drzava = drzava.trim();
		if (drzava.isEmpty()) {
			return "Unesite drzavu";
		}
		
		if (grad == null) {
			return "Unesite grad";
		}
		grad = grad.trim();
		if (grad.isEmpty()) {
			return "Unesite grad";
		}
		
		if (adresa == null) {
			return "Unesite adresu";
		}
		adresa = adresa.trim();
		if (adresa.isEmpty()) {
			return "Unesite adresu";
		}
		
		Mesto mesto = new Mesto(grad, drzava, adresa);
		korpa.setIme(ime);
		korpa.setPrezime(prezime);
		korpa.setTelefon(telefon);
		korpa.setUkupanIznos(cena);
		korpa.setMesto(mesto);
		korpa.setStanje(new Zavrsena());
		korpa.setKartica(brKartice);
		
		kupac.getNarudzbenice().add(korpa);
		//
		//preduzece.getNarudzbenice().add(korpa);
		
		
		/*Integer id;
		
		Collections.sort(preduzece.sekvencer, new Comparator<Integer>() 
		{
			public int compare(Integer i1, Integer i2) {
				return Integer.valueOf(i1).compareTo(Integer.valueOf(i2));
			}
		});
		
		//preduzece.sekvencer.sort();
		id = preduzece.sekvencer.get(preduzece.sekvencer.size()-1)+1;
		
		while(preduzece.sekvencer.contains(id)) {
			id++;
		}
		
		korpa.setId(id);
		preduzece.sekvencer.add(id);
		*/
		
		//preduzece.narudzbenice.add(korpa);
		fnview.setNarudzbenica(korpa);
		
		preduzece.korpa = new Narudzbenica();
		korpa.setId(0);
		
		return "";
	}
	
	private void addListeners() {
		
		fnview.getBtnOK().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					ok();
					//fnview.ok();
				}
		});
		
	}
	
	
	public void ok() {
		//if(fncon == null) {
		//	fncon = new FormiranjeNarudzbeniceController(this, preduzece);
		//}
		
		Window parent = SwingUtilities.getWindowAncestor(fnview);
		
		String ime = fnview.getTfime().getText();
		String prezime = fnview.getTfprezime().getText();
		//String email = tfemail.getText();
		String telefon = fnview.getTftelefon().getText();
		String karticastr = fnview.getTfkartica().getText();
		
		
		double cena = korpa.getUkupanIznos();
		
		String message = formirajNarudzbenicu(ime, prezime, telefon, karticastr, cena, fnview.getTfgrad().getText(), fnview.getTfdrzava().getText(), fnview.getTfadresa().getText());
		
		//String message = regcon.registrujSe(kime, lozinka, ime, prezime, email, telefon);
		//String title = "Greska";
		
		if(message.equals("")) {
			//JOptionPane.showMessageDialog(parent, "Narudzbenica formirana");
			//JOptionPane.showConfirmDialog(this, "Plati");
			
			int dialogbtn = JOptionPane.YES_NO_OPTION;
			int dialogrez = JOptionPane.showConfirmDialog(fnview, "Plati", "Narudzbenica je formirana", dialogbtn);
			if(dialogrez == JOptionPane.YES_OPTION) {
				fnview.getNarudzbenica().setStanje(new Placena());
			}
			
			preduzece.narudzbenice.add(fnview.getNarudzbenica());

			/*ProizvodiView bw = null;
			try {
				bw = new ProizvodiView(frame.getView(), preduzece, preduzece.proizvodi);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.getView().remove(1);
			frame.getView().add(bw);
			
			frame.getView().updateUI();*/
			//doSth();
			//KupacView kv = new KupacView(preduzece, frame);
			//remove(0);
			//add(kv);
			
			fnview.updateUI();
		}
		else {
			JOptionPane.showMessageDialog(parent, message);

		}
	}

	
	

}
