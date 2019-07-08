package Controller;


import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Placena;
import Model.TipKorisnika;
import View.AdminView;
import View.BaseView;
import View.HeaderView;
import View.KorpaView;
import View.KupacView;
import View.LogInView;
import View.MenadzerView;
import View.ProizvodiView;


public class HeaderController {

	AplikacijaPreduzece preduzece;
	HeaderView panel;
	BaseView view;

	MainFrame frame;
		
		/*x.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      //your code here
				    	System.out.println("Nesto se desilo");
				    }
				  }
				);*/
	

	public HeaderController(HeaderView panel, BaseView base, AplikacijaPreduzece preduzece, MainFrame frame) {
		super();
		
		this.frame = frame;
		
		this.preduzece = preduzece;
		this.panel = panel;
		this.view = base;
		
		this.panel.getKorpa().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	System.out.println("Nesto se desilo");
			    	//panel.getPrijava().setText("Odjava");
			    	//panel.updateUI();
			    	KorpaView kv = new KorpaView(preduzece, frame);
			    	
			    	System.out.println(frame.getOvajStoSeMenja());
			    	
			    	if (preduzece.trenutnoUlogovani == null ) {
			    		frame.getCentralni().add(kv);
			    		frame.getCentralni().remove(0);
			    		//frame.getOvajStoSeMenja().add(kv);
				    	//frame.getMenja().removeAll();
				    	//frame.getOvajStoSeMenja().remove(0);
			    	}
			    	else {
			    		frame.getOvajStoSeMenja().remove(1);
			    		frame.getOvajStoSeMenja().add(kv);
				    	//frame.getMenja().removeAll();
				    	
			    		
			    	}
			    	//frame.getOvajStoSeMenja().add(kv);
			    	//frame.getMenja().removeAll();
			    	//frame.getOvajStoSeMenja().remove(0);
			    	//frame.getMenja().add(kv);
			    	
			    	//frame.getOvajStoSeMenja().add(kv);
			    	//frame.getMenja().removeAll();
			    	//frame.getOvajStoSeMenja().remove(0);
			    	//frame.getMenja().updateUI();
			    	
			    	
			    	frame.getOvajStoSeMenja().updateUI();
					frame.split.updateUI();
			    }
			
		});
		
		panel.getNaslov().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.getNaslov().addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        
		    	if (preduzece.getTrenutnoUlogovani() == null) {
		    		ProizvodiView pw = null;
		    		try {
						pw = new ProizvodiView(frame.getOvajStoSeMenja(), preduzece, preduzece.proizvodi);
						
						frame.getCentralni().add(pw);
						frame.getCentralni().remove(0);
						frame.getCentralni().updateUI();
						
						//frame.getOvajStoSeMenja().add(pw);
						//frame.getOvajStoSeMenja().remove(0);
						//frame.getOvajStoSeMenja().updateUI();
						return;
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	else if (preduzece.getTrenutnoUlogovani().getNalog().getTipKorisnika() == TipKorisnika.kupac) {
		    		KupacView kv = new KupacView(preduzece, frame);
		    		frame.getCentralni().add(kv);
					frame.getCentralni().remove(0);
					frame.getCentralni().updateUI();
		    		
		    		//frame.getOvajStoSeMenja().add(kv);
					//frame.getOvajStoSeMenja().remove(0);
					//frame.getOvajStoSeMenja().updateUI();
		    		return;
		    	}
		    	else if (preduzece.getTrenutnoUlogovani().getNalog().getTipKorisnika() == TipKorisnika.menadzer) {
		    		MenadzerView mv = new MenadzerView(preduzece, frame);
		    		// ne radi?
		    		//panel.getKorpa().setVisible(false);
		    		//panel.updateUI();
		    		
		    		frame.getCentralni().add(mv);
					frame.getCentralni().remove(0);
					frame.getCentralni().updateUI();
		    		
		    		//frame.getOvajStoSeMenja().add(mv);
					//frame.getOvajStoSeMenja().remove(0);
					//frame.getOvajStoSeMenja().updateUI();
		    		return;
		    	}
		    	else {
		    		AdminView av = new AdminView(preduzece, frame);
		    		//panel.getKorpa().setVisible(false);
		    		//panel.getKorpa().setText("NOVI");
		    		//panel.updateUI();
		    		frame.getCentralni().add(av);
					frame.getCentralni().remove(0);
					frame.getCentralni().updateUI();
		    		
		    		//frame.getOvajStoSeMenja().add(av);
					//frame.getOvajStoSeMenja().remove(0);
					//frame.getOvajStoSeMenja().updateUI();
		    		return;
		    	}
		    	
		    	
		    }});
		
		panel.getPrijava().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//bw.setVisible(false);
				
				/*if (preduzece.trenutnoUlogovani != null) {
					ProizvodiView bw = null;
					try {
						//bw = new ProizvodiView(frame.getOvajStoSeMenja(), preduzece);
						bw = new ProizvodiView(frame.getCentralni(), preduzece, preduzece.proizvodi);
						
						frame.setOvajStoSeMenja(bw);  ///? ili on gde stoji
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int dialogbtn = JOptionPane.YES_NO_OPTION;
					int dialogrez = JOptionPane.showConfirmDialog(bw, "Da li ste sigurni da zelite da se odjavite?", "Odjava", dialogbtn);
					if(dialogrez == JOptionPane.YES_OPTION) {
						//frame.getHeader().getPrijava().setText("Prijava");
						frame.getHeader().getKorpa().setVisible(true);
						frame.getHeader().updateUI();
						preduzece.trenutnoUlogovani = null;
						String message = "Uspesno ste se izlogovali.";
						//JOptionPane.showMessageDialog(null, message);
						/*ProizvodiView bw = null;
						try {
							//bw = new ProizvodiView(frame.getOvajStoSeMenja(), preduzece);
							bw = new ProizvodiView(frame.getCentralni(), preduzece, preduzece.proizvodi);
							
							frame.setOvajStoSeMenja(bw);  ///? ili on gde stoji
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
				
				/*
						frame.getCentralni().add(bw);
						frame.getCentralni().remove(0);
						frame.getCentralni().updateUI();
						
						return;
					}
					else {
						
					}
					
					/*frame.getHeader().getPrijava().setText("Prijava");
					frame.getHeader().getKorpa().setVisible(true);
					frame.getHeader().updateUI();
					preduzece.trenutnoUlogovani = null;
					String message = "Uspesno ste se izlogovali.";
					JOptionPane.showMessageDialog(null, message);
					ProizvodiView bw = null;
					try {
						//bw = new ProizvodiView(frame.getOvajStoSeMenja(), preduzece);
						bw = new ProizvodiView(frame.getCentralni(), preduzece, preduzece.proizvodi);
						
						frame.setOvajStoSeMenja(bw);  ///? ili on gde stoji
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					
					//frame.getView().remove(0);
					
					//frame.getOvajStoSeMenja().add(bw);
					//frame.getOvajStoSeMenja().remove(0);
					//frame.getOvajStoSeMenja().updateUI();
					/*
					frame.getCentralni().add(bw);
					frame.getCentralni().remove(0);
					frame.getCentralni().updateUI();
					
					return;
				}*/
				
				LogInView lv = new LogInView(preduzece, frame);
				/*if(preduzece.trenutnoUlogovani != null) {
					panel.getPrijava().setVisible(false);
				}*/
				//split.setBottomComponent(lv);
				
				//
				//
				//
				//view.add(lv);
				//view.remove(0);
				//view.updateUI();
				frame.getCentralni().add(lv);
				frame.getCentralni().remove(0);
				frame.getCentralni().updateUI();
				
				//frame.getOvajStoSeMenja().add(lv);
				//frame.getOvajStoSeMenja().remove(0);;
				//frame.getOvajStoSeMenja().updateUI();
				
				
			}
		});
		
		panel.getOdjava().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProizvodiView bw = null;
				try {
					//bw = new ProizvodiView(frame.getOvajStoSeMenja(), preduzece);
					bw = new ProizvodiView(frame.getCentralni(), preduzece, preduzece.proizvodi);
					
					frame.setOvajStoSeMenja(bw);  ///? ili on gde stoji
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int dialogbtn = JOptionPane.YES_NO_OPTION;
				int dialogrez = JOptionPane.showConfirmDialog(bw, "Da li ste sigurni da zelite da se odjavite?", "Odjava", dialogbtn);
				if(dialogrez == JOptionPane.YES_OPTION) {
					//frame.getHeader().getPrijava().setText("Prijava");
					
					//panel.getOdjava().setVisible(false);
					//panel.getPrijava().setVisible(true);
					
					frame.getHeader().getPrijava().setVisible(true);
					frame.getHeader().getOdjava().setVisible(false);
					frame.getHeader().getKorpa().setVisible(true);
					frame.getHeader().updateUI();
					preduzece.trenutnoUlogovani = null;
					frame.getCentralni().add(bw);
					frame.getCentralni().remove(0);
					frame.getCentralni().updateUI();
					
					return;
				}
			
			}
				
		});
		
	}



	public HeaderView getPanel() {
		return panel;
	}



	public void setPanel(HeaderView panel) {
		this.panel = panel;
	}



	public HeaderController() {
		super();
	}
	
	
	
	
}
