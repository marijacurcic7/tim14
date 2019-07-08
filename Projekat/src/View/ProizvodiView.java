package View;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import Controller.ControllerProizvoda;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Kategorija;
import Model.Proizvod;
import gui.panels.ProizvodPanel;



public class ProizvodiView extends BaseView{
//public class BasicView extends JScrollPane{
	
	public JPanel panelSaProizvodima;
	JScrollPane skrol;
	AplikacijaPreduzece preduzece;
	ArrayList<Proizvod> proizvodi;
	MainFrame frame;
	JPanel gdeStoji;
	
	JMenuBar meni;
	JPanel desniDugmici;
	JButton sortiraj;
	JButton sortirajCOpadajuce;
	JButton pretrazi;
	JButton sortNazRast;
	JButton sortNazOp;
	JTextField pretragaTxt;
	JMenu kategorije;
	
	public ProizvodiView(JPanel gdeStoji, AplikacijaPreduzece preduzece, List<Proizvod> proizvodi) throws IOException {
		this.gdeStoji = gdeStoji;
		this.preduzece = preduzece;
		//this.proizvodi = (ArrayList) preduzece.proizvodi;
		this.proizvodi = (ArrayList<Proizvod>) proizvodi;
		initProductPanel();
		skrol = new JScrollPane(panelSaProizvodima);
		//		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		//	        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//skrol.setPreferredSize(new Dimension(500, 300));
		//
		//add(skrol);
		//add(panelSaProizvodima);
		//skrol.set;
		//add(panelSaProizvodima);
		//add(panelSaProizvodima);
		skrol.setPreferredSize(new Dimension(1100, 630));
		add(skrol);
		//skrol.setMaximumSize(new Dimension(1000, 400));
			
		initDesno();
		add(desniDugmici);
		
		sortiraj.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	// skloniti i desno i panel, pa dodati i desno i panel
				 sortirajCenaRastuce();
				 	remove(0);
				 	remove(0);
				 	//add(Proiz)
				 	updateUI();
			    }
			
		});
		
		
		
	}

	
	protected void sortirajCenaRastuce() {
		// TODO Auto-generated method stub
		 Collections.sort(proizvodi, new Comparator() 
         {

          public int compare(Object o1, Object o2) 
          {
          Proizvod sa = (Proizvod)o1;
          Proizvod sb = (Proizvod)o2;

          //int v = sa.getAktuelnaCena().getRedovnaCena().compareTo(sb.getAktuelnaCena().getRedovnaCena());

          return Double.compare(sa.getAktuelnaCena().getRedovnaCena(), sb.getAktuelnaCena().getRedovnaCena());           

              // it can also return 0, and 1
          } }   );
		 ProizvodiView pv;
			try {
				pv = new ProizvodiView(gdeStoji, preduzece, proizvodi);
				gdeStoji.add(pv);
				if(preduzece.trenutnoUlogovani == null) {
					gdeStoji.remove(0);
				}
				else {
					gdeStoji.remove(1);
				}
				gdeStoji.updateUI();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}


	private void initDesno() {
		desniDugmici = new JPanel(new GridLayout(15, 0));
		desniDugmici.setPreferredSize(new Dimension(300, 600));
		sortiraj = new JButton("Sortiraj po ceni rastuce");
		//sortiraj.setPreferredSize(new Dimension(10, 0));
		sortNazRast = new JButton("Sortiraj po nazivu rastuce");
		sortNazOp = new JButton("Sortiraj po nazivu opadajuce");
		pretrazi = new JButton("Pretrazi");
		sortirajCOpadajuce = new JButton("Sortiraj po ceni opadajuce");
		// nek pretrazuje uvijek sve
		
		
		JPanel holder = new JPanel(new FlowLayout());
		pretragaTxt = new JTextField(15);
		holder.add(pretragaTxt);
		holder.add(pretrazi);
 		desniDugmici.add(holder);
		
 		JPanel p1 = new JPanel();
 		p1.add(sortiraj);
 		desniDugmici.add(p1);
 		JPanel p2 = new JPanel();
 		p2.add(sortirajCOpadajuce);
		desniDugmici.add(p2);
 		
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		p4.add(sortNazRast);
		p5.add(sortNazOp);
		desniDugmici.add(p4);
		desniDugmici.add(p5);
		Dimension d = sortNazOp.getSize();
		//sortiraj.setPreferredSize(d);
		//sortirajCOpadajuce.setPreferredSize(d);
		//sortNazRast.setPreferredSize(d);
		
		JPanel p3 = new JPanel();
 		meni = new JMenuBar();
		kategorije = new JMenu("Kategorije");
		kategorije.setMnemonic(KeyEvent.VK_A);
		meni.add(kategorije);
		p3.add(meni);
		desniDugmici.add(p3);
		kreirajKategorije();

	}
	
	private void kreirajKategorije() {
		for(Kategorija k : preduzece.kategorije) {
			if(k.getNadkategorija()==null) {
				if(k.getPodkategorije().size()!=0) {
					JMenu kat = new JMenu(k.getNaziv());
					//JMenuItem kat = new JMenuItem(k.getNaziv());
					kat.setMnemonic(KeyEvent.VK_A);
					JMenuItem katitem1 = new JMenuItem(k.getNaziv());
					katitem1.setAccelerator(KeyStroke.getKeyStroke(
					        KeyEvent.VK_K, ActionEvent.CTRL_MASK));
					katitem1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println(">>>>>>>>>>> Kategorija: "+k.getNaziv());
							prikazKategorije(k);
							
						}
					});
					kat.add(katitem1);
					for(Kategorija kk : k.getPodkategorije()) {
						JMenuItem katitem = new JMenuItem(kk.getNaziv());
						katitem.setAccelerator(KeyStroke.getKeyStroke(
						        KeyEvent.VK_K, ActionEvent.CTRL_MASK));
						katitem.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								System.out.println(">>>>>>>>>>> Kategorija: "+kk.getNaziv());
								prikazKategorije(kk);
								
							}
						});
						kat.add(katitem);
					}
					kat.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println(">>>>>>>>>>> Kategorija: "+k.getNaziv());
							prikazKategorije(k);
							
						}
					});
					
					kategorije.add(kat);
				}
				else {
					JMenuItem katitem = new JMenuItem(k.getNaziv());
					katitem.setAccelerator(KeyStroke.getKeyStroke(
					        KeyEvent.VK_K, ActionEvent.CTRL_MASK));
					katitem.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println(">>>>>> Kategorija: "+k.getNaziv());
							
						}
					});
					kategorije.add(katitem);
				}
				
				
				//kategorije.addSeparator();
				//System.out.println("Kategorija: "+k.getNaziv());
			}
		}
	}
	
	private void prikazKategorije(Kategorija k) {
		ArrayList<Proizvod> novaLista = new ArrayList<Proizvod>();
		for(Proizvod p : preduzece.proizvodi) {
			if(p.getKategorija().equals(k)) {
				novaLista.add(p);
			}
			if(p.getKategorija().getNadkategorija()!=null) {
				 if(p.getKategorija().getNadkategorija().equals(k)) {
					 novaLista.add(p);
				 }
			}
		}
		ProizvodiView pv;
		try {
			pv = new ProizvodiView(gdeStoji, preduzece, novaLista);
			gdeStoji.add(pv);
			if(preduzece.trenutnoUlogovani == null) {
				gdeStoji.remove(0);
			}
			else {
				gdeStoji.remove(1);
			}
			gdeStoji.updateUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initProductPanel() throws IOException {
		// TODO Auto-generated method stub
		panelSaProizvodima = new JPanel();
		GridLayout grid = new GridLayout(0, 3, 50, 50);
		panelSaProizvodima.setLayout(grid);
		//this.setLayout(grid);
		
		for (Proizvod p: this.proizvodi) {
			ProizvodPanel pp = new ProizvodPanel(p, this, preduzece);
			ControllerProizvoda cp = new ControllerProizvoda(pp, preduzece);		// da ovde dobije preduzece, ili mozemo
			pp.setController(cp);										// ostaviti ovako jer svakako pristupa preduzecu iz view?
			//pp.updateUI();
			// ovde dodam kontroler?
			
			panelSaProizvodima.add(pp);
			//this.add(panelSaProizvodima);
		
		}
		
		/*
		for (int i = 0; i < 18; i++) {
			//System.out.println("U basic view sta se dsava");
			//System.out.println(this);
			Proizvod p  = new Proizvod("proizvod" + i);
			ProizvodPanel pp = new ProizvodPanel(p, this, preduzece);
			ControllerProizvoda cp = new ControllerProizvoda(pp);
			pp.setController(cp);
			//pp.updateUI();
			// ovde dodam kontroler?
			
			panelSaProizvodima.add(pp);
			this.add(panelSaProizvodima);
					
		}*/
	}


	public JPanel getPanelSaProizvodima() {
		return panelSaProizvodima;
	}


	public void setPanelSaProizvodima(JPanel panelSaProizvodima) {
		this.panelSaProizvodima = panelSaProizvodima;
	}


	public JScrollPane getSkrol() {
		return skrol;
	}


	public void setSkrol(JScrollPane skrol) {
		this.skrol = skrol;
	}


	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}


	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}


	public ArrayList<Proizvod> getProizvodi() {
		return proizvodi;
	}


	public void setProizvodi(ArrayList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}


	public MainFrame getFrame() {
		return frame;
	}


	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}


	public JPanel getGdeStoji() {
		return gdeStoji;
	}


	public void setGdeStoji(JPanel gdeStoji) {
		this.gdeStoji = gdeStoji;
	}


	public JPanel getDesniDugmici() {
		return desniDugmici;
	}


	public void setDesniDugmici(JPanel desniDugmici) {
		this.desniDugmici = desniDugmici;
	}


	public JButton getSortiraj() {
		return sortiraj;
	}


	public void setSortiraj(JButton sortiraj) {
		this.sortiraj = sortiraj;
	}


	public JButton getPretrazi() {
		return pretrazi;
	}


	public void setPretrazi(JButton pretrazi) {
		this.pretrazi = pretrazi;
	}
	
	
}
