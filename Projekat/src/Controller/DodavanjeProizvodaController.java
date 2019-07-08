package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.AplikacijaPreduzece;
import Model.Kategorija;
import Model.Proizvod;
import Model.StavkaCenovnika;
import View.DodavanjeProizvodaView;
import View.MenadzerView;



public class DodavanjeProizvodaController {
	
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;

	private DodavanjeProizvodaView dpview;
	
	public DodavanjeProizvodaController(DodavanjeProizvodaView dpview, AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
		this.dpview = dpview;
		
		addListeners();
	}

	public String dodaj(String idstr, String naziv, String opis, String nazivKategorije, String cenastr, String putanja) {
		int id = 0;
		double cena = 0;
		
		if (idstr == null) {
			return "Unesite id";
		}
		idstr = idstr.trim();
		if (idstr.isEmpty()) {
			return "Unesite id";
		}
		
		 try { 
		        id = Integer.parseInt(idstr); 
		        if (preduzece.validanId(id) == false) {
		        	return "Vec postoji proizvod sa unetim ID-om!";
		        }
		    } catch(NumberFormatException e) { 
		        return "ID proizvoda mora da bude broj!"; 
		    }
		
		if (naziv == null) {
			return "Unesite naziv";
		}
		naziv = naziv.trim();
		if (naziv.isEmpty()) {
			return "Unesite naziv";
		}
		
		if (opis == null) {
			return "Unesite opis";
		}
		opis = opis.trim();
		if (opis.isEmpty()) {
			return "Unesite opis";
		}
		
		if (nazivKategorije == null) {
			return "Unesite kategoriju";
		}
		
		nazivKategorije = nazivKategorije.trim();
		if (nazivKategorije.isEmpty()) {
			return "Unesite kategoriju";
		}
		
		if (cenastr == null) {
			return "Unesite cenu";
		}
		cenastr = cenastr.trim();
		if (cenastr.isEmpty()) {
			return "Unesite cenu";
		}
		
		 try { 
		        cena = Double.parseDouble(cenastr); 
		 } catch(NumberFormatException e) { 
		        return "Niste lepo uneli cenu..."; 
		 }
		
		Kategorija kategorija = new Kategorija();
		
		int i = 0;
		for(Kategorija k : preduzece.kategorije) {
			if(k.getNaziv().equals(nazivKategorije)) {
				kategorija = k;
				i=1;
				break;
			}
		}
		
		if(i == 0) {
			kategorija = new Kategorija(nazivKategorije);
			preduzece.kategorije.add(kategorija);
		}
		
		File file = new File(putanja);
		if(!(file.exists() && !file.isDirectory())) { 
		    return "Nevalidna putanja";
		}
		if (!(putanja.endsWith("jpg") || putanja.endsWith("jpeg") || putanja.endsWith("png"))) {
			return "Fajl nevalidnog formata";
		}
 				
		Date datum = new Date(System.currentTimeMillis());
		
		Proizvod p = new Proizvod(id, naziv, opis, kategorija, putanja);
		StavkaCenovnika sc = new StavkaCenovnika(cena, datum, p);
		p.setAktuelnaCena(sc);
		
		dpview.setProizvod(p);
		preduzece.addProizvod(p);
		
		return "Proizvod je uspesno kreiran";
	}
	
	private void addListeners() {
		dpview.getBtnOK().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
		});
		
		dpview.getDugmeSlika().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slika();
			}
			
		});
	}
	
	public void ok() throws IOException {
		
		Window parent = SwingUtilities.getWindowAncestor(dpview);

		String id = dpview.getTfid().getText();
		String naziv = dpview.getTfnaziv().getText();
		String opis = dpview.getTfopis().getText();
		String kategorija = dpview.getTfkategorija().getText();
		String cena = dpview.getTfcena().getText();
		String putanja = dpview.getTfslika().getText();
		
		String message = dodaj(id, naziv, opis, kategorija, cena, putanja);
		
		if (dpview.getProizvod() == null){
			
			JOptionPane.showMessageDialog(parent, message);
		}
		else {
			
			JOptionPane.showMessageDialog(parent, message);
			
			dpview.setPreduzece(this.preduzece);//dpcon.getPreduzece();
			MenadzerView mv = new MenadzerView(preduzece, dpview.getFrame());
			
			dpview.getFrame().getCentralni().add(mv);
			dpview.getFrame().getCentralni().remove(0);
			dpview.getFrame().getCentralni().updateUI(); 
			
		}
	}
	
	public void slika() {
		dpview.setOdabirSlike(new JFileChooser()); //= new JFileChooser();
		
		int result = dpview.getOdabirSlike().showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			dpview.getTfslika().setText(dpview.getOdabirSlike().getSelectedFile().getAbsolutePath());
		} else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		}
	}

	
	

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public DodavanjeProizvodaView getDpview() {
		return dpview;
	}

	public void setDpview(DodavanjeProizvodaView dpview) {
		this.dpview = dpview;
	}
	
	
}
