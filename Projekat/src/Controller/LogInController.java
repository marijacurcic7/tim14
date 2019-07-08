package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.TipKorisnika;
import View.AdminView;
import View.KupacView;
import View.LogInView;
import View.MenadzerView;
import View.ProizvodiView;
import View.RegistracijaView;

public class LogInController {
	
	private LogInView loginv;
	private String korisnickoIme;
	private String lozinka;
	private AplikacijaPreduzece preduzece;
	
	public LogInController(LogInView lv, AplikacijaPreduzece preduzece) {
		this.loginv = lv;
		this.preduzece = preduzece;
		//this.loginv.btnReg.addActionListener(new ActionListener() {

		/*@Override
		public void actionPerformed(ActionEvent e) {
				//loginv.setVisible(false);
				RegistracijaView rv = new RegistracijaView();
				lv.add(rv);
				rv.setVisible(true);
				
			}
		});*/
		
		/*
		loginv.btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					//loginv.setVisible(false);
					//System.out.println("");
					//removeAll();
					RegistracijaView rv = new RegistracijaView(preduzece, loginv.getFrame());
					loginv.add(rv);
					loginv.remove(0);
					loginv.updateUI();
					//rv.setVisible(true);
					//setVisible(false);
					
				}
		});
		
		loginv.btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});*/
		addListeners();
	}
	
	
	private void addListeners() {
		// TODO Auto-generated method stub
		
		loginv.btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					//loginv.setVisible(false);
					//System.out.println("");
					//removeAll();
					RegistracijaView rv = new RegistracijaView(preduzece, loginv.getFrame());
					loginv.add(rv);
					loginv.remove(0);
					loginv.updateUI();
					//rv.setVisible(true);
					//setVisible(false);
					
				}
		});
		
		loginv.btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok1();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});
	}

	
	private void ok1()  throws IOException {
		
		String kime = loginv.getTfkorisnicko().getText();
		String lozinka = loginv.getTflozinka().getText();
		login(kime, lozinka);
		System.out.println(kime);
		System.out.println(lozinka);
		//Korisnik k = preduzece.proveriLogin(kime,  lozinka);
		boolean ulogovan = preduzece.login(kime, lozinka);
		System.out.println("*******************");
		System.out.println(ulogovan);
		if(ulogovan == false) {
			//JDialog neuspesno = new JDialog();
			String message = "Pogresno uneto korisnicko ime ili lozinka. Pokusajte ponovo.";
			JOptionPane.showMessageDialog(loginv, message);
		}
		else {
			//preduzece.trenutnoUlogovani = k;
			System.out.println("----------------------------------");
			//System.out.println(k.getNalog().getTipKorisnika());
			if (loginv.getPreduzece().trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.kupac) {
			//if(k.nalog.getTipKorisnika() == TipKorisnika.kupac) {
				
				//JPanel holder = frame.getOvajStoSeMenja();
				
				//preduzece.trenutnoUlogovani = k;
				KupacView kv = new KupacView(preduzece, loginv.getFrame());
				//
				//?
				//kv.frame.setOvajStoSeMenja(kv);
				//?    
				
				//frame.setOvajStoSeMenja(holder);
			
				// 
				loginv.getFrame().getHeader().getPrijava().setText("Odjava");
				loginv.getFrame().getHeader().updateUI();
				// dodala.frame.getovajstosemenja()
				System.out.println(loginv.getFrame().getOvajStoSeMenja());
				loginv.getFrame().getCentralni().add(kv);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
				//frame.getOvajStoSeMenja().add(kv);
				//frame.getOvajStoSeMenja().remove(0);
				//frame.getOvajStoSeMenja().updateUI();
				//return;
			}
			
			else if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.menadzer) {
			//else if(k.nalog.getTipKorisnika() == TipKorisnika.menadzer) {
				//preduzece.trenutnoUlogovani = k;
				System.out.println("Menadzer");
				MenadzerView mv = new MenadzerView(preduzece, loginv.getFrame());
				//
				loginv.getFrame().getHeader().getPrijava().setText("Odjava");
				loginv.getFrame().getHeader().getKorpa().setVisible(false);
				loginv.getFrame().getHeader().updateUI();
				loginv.getFrame().getCentralni().add(mv);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
				//frame.getOvajStoSeMenja().add(mv);
				//frame.getOvajStoSeMenja().remove(0);
				//frame.getOvajStoSeMenja().updateUI();
				//return;		
			}
			else  {
				AdminView av = new AdminView(preduzece, loginv.getFrame());
				//
				
				loginv.getFrame().getHeader().getPrijava().setText("Odjava");
				loginv.getFrame().getHeader().getKorpa().setVisible(false);
				loginv.getFrame().getHeader().updateUI();
				loginv.getFrame().getCentralni().add(av);
				loginv.getFrame().getCentralni().remove(0);
				loginv.getFrame().getCentralni().updateUI();
				
				//frame.getOvajStoSeMenja().add(av);
				//frame.getOvajStoSeMenja().remove(0);
				//frame.getOvajStoSeMenja().updateUI();
			//ProizvodiView bw = new ProizvodiView(preduzece);
			//add(bw);
			//remove(0);
			//updateUI();
			}
		}

	}
	

	private void ok() throws IOException {
		//if (loginc == null) {
		//	loginc = new LogInController(this, preduzece);
		//}
		
		System.out.println("yup im here");
		System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String kime = loginv.getTfkorisnicko().getText();
		String lozinka = loginv.getTflozinka().getText();
		login(kime, lozinka);
		System.out.println(kime);
		System.out.println(lozinka);
		//Korisnik k = preduzece.proveriLogin(kime,  lozinka);
		System.out.println("*******************");
		System.out.println();
		System.out.println("888888888888888888888");
	}
		/*if(k == null) {
			//JDialog neuspesno = new JDialog();
			String message = "Pogresno uneto korisnicko ime ili lozinka. Pokusajte ponovo.";
			JOptionPane.showMessageDialog(null, message);
		}
		else {
			preduzece.trenutnoUlogovani = k;
			System.out.println("----------------------------------");
			//System.out.println(k.getNalog().getTipKorisnika());
			
			
			System.out.println("222222222222222222");
			if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.kupac) {
				KupacView kv = new KupacView(preduzece);
				//
				loginv.getFrame().getHeader().getPrijava().setText("Odjava");
				loginv.getFrame().getHeader().updateUI();
				loginv.add(kv);
				loginv.remove(0);
				loginv.updateUI();
				return;
			}
			
			else if (preduzece.trenutnoUlogovani.nalog.getTipKorisnika() == TipKorisnika.menadzer) {
				System.out.println("Menadzer");
				MenadzerView mv = new MenadzerView(preduzece);
				//
				loginv.getFrame().getHeader().getPrijava().setText("Odjava");
				loginv.getFrame().getHeader().updateUI();
				loginv.add(mv);
				loginv.remove(0);
				System.out.println("OOOOOOOOYYYYYYYYYYYYYYYYY");
				loginv.updateUI();
				
				return;
				
			}
			
			else  {
			ProizvodiView bw = new ProizvodiView(preduzece);
			loginv.add(bw);
			loginv.remove(0);
			loginv.updateUI();
			}}
		}
	*/
	
	public void login(String kime, String lozinka) {
		this.korisnickoIme = kime;
		this.lozinka = lozinka;
	}

	public LogInView getLoginv() {
		return loginv;
	}

	public void setLoginv(LogInView loginv) {
		this.loginv = loginv;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	

}
