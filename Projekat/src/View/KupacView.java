package View;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Controller.Controller;
import Controller.KupacController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.RegistrovaniKupac;

public class KupacView extends BaseView {

	RegistrovaniKupac kupac;
	MainFrame frame;
	
	KupacController kontroler;
	
	ProizvodiView proizvodi;
	
	JPanel onoSaStrane;
	
	JLabel prikazNarudzbenica;
	
	JLabel izmenaPodataka;
	
	JSplitPane split;
	
	AplikacijaPreduzece preduzece;
	
	// trebace mi i frejm da vidim gdje stoji i da mijenjam
	public KupacView(AplikacijaPreduzece preduzece, MainFrame f) {
		// napravim proizvode
		// ono sa strane
		// splitpane
		this.preduzece = preduzece;
		this.frame = f;
		this.kupac = (RegistrovaniKupac)preduzece.trenutnoUlogovani;
		try {			// ili f.onajsto se menja
			proizvodi = new ProizvodiView(this, preduzece, preduzece.proizvodi);   // aplikacija mu treba
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initOnoSaStrane();
		//this.add()
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.setLayout(new BorderLayout());
		//split.setTopComponent(onoSaStrane);  // ili p 
		//split.setResizeWeight(1.0);
		//Dimension minimumSize = new Dimension(0, 0);
		//onoSaStrane.setMinimumSize(minimumSize);
		//onoSaStrane.setMaximumSize(new Dimension(100, 0));
		//proizvodi.setMinimumSize(minimumSize);
		
		//onoSaStrane.setPreferredSize(preferredSize);
		// uzeti y koordinatu ili x i postaviti
		
		JPanel left = new JPanel(new BorderLayout());
		//onoSaStrane.setPreferredSize(new Dimension(120, 100));
		left.add(onoSaStrane, BorderLayout.LINE_END);
		//this.add(onoSaStrane, BorderLayout.LINE_START);
		//this.add(proizvodi);
		//this.setPreferredSize(new Dimension(500, 500));
		//this.add(new JLabel("proziv"));
		//System.out.println(this.proizvodi);
		JPanel panel = new JPanel();
		
		this.add(left, BorderLayout.LINE_START);
		panel.add(proizvodi);
		this.add(panel);
		this.show();
		
		//this.frame.setMenja(proizvodi);
		
		
		this.frame.setOvajStoSeMenja(this);
		
		//add(proizvodi);
		//split.getLeftComponent().CENTER_ALIGNMENT
		//split.setLeftComponent(onoSaStrane);
		//split.setBottomComponent(proizvodi);
		//split.setRightComponent(proizvodi);
		//split.setDividerLocation(0.9);
		
		kontroler = new KupacController(this, preduzece);
		
		//this.add(split);
		
	}
	
	private void initOnoSaStrane() {
		onoSaStrane = new JPanel();
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		onoSaStrane.setPreferredSize(new Dimension(200, 600));
		
		prikazNarudzbenica = new JLabel("  Prikaz mojih narudzbenica  ");
		// prikaz pojedinacne, i opcije za nju, refresh
		
		prikazNarudzbenica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		//prikazNarudzbenica.addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		//    @Override
		 //   public void mouseClicked(MouseEvent e) {
		  //      // the user clicks on the label
		  //  	//Window w =SwingUtilities.getWindowAncestor(prikazNarudzbenica);
		  //  	//JOptionPane.showMessageDialog(null, "Prikaz narudzbenica");
		  // 	NarudzbeniceView nv = new NarudzbeniceView(kupac.narudzbenice, preduzece);
		  //  	//nv.setPreferredSize(new Dimension(1000, 600));  // skrolbar preferred size,
		   // 	proizvodi.getGdeStoji().remove(1);
		  //  	proizvodi.getGdeStoji().add(nv);
		   // 	proizvodi.getGdeStoji().updateUI();
		    	//proizvodi.add(nv);
		    	//proizvodi.remove(0);
		    	//proizvodi.updateUI();
		    	/*frame.getView().add(nv);
				frame.getView().remove(0);
				frame.getView().updateUI();*/
		   // }}); 
		onoSaStrane.setLayout(new GridLayout(18, 0));
		
		onoSaStrane.add(prikazNarudzbenica);
		
		
		izmenaPodataka = new JLabel("  Izmena mojih podataka  ");
		izmenaPodataka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/*
		izmenaPodataka.addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	//JOptionPane.showMessageDialog(null, "Izmena podataka");
		    	PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, frame);
				
				remove(1);
				add(ppv);
				updateUI();
		    }});*/
		
		onoSaStrane.add(izmenaPodataka);
		//onoSaStrane.add(new JLabel("  Labela 3  "));
		//onoSaStrane.add(new JLabel("  Labela 4  "));
		
		
		
	}

	public RegistrovaniKupac getKupac() {
		return kupac;
	}

	public void setKupac(RegistrovaniKupac kupac) {
		this.kupac = kupac;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	

	public ProizvodiView getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(ProizvodiView proizvodi) {
		this.proizvodi = proizvodi;
	}

	public JPanel getOnoSaStrane() {
		return onoSaStrane;
	}

	public void setOnoSaStrane(JPanel onoSaStrane) {
		this.onoSaStrane = onoSaStrane;
	}

	public JLabel getPrikazNarudzbenica() {
		return prikazNarudzbenica;
	}

	public void setPrikazNarudzbenica(JLabel prikazNarudzbenica) {
		this.prikazNarudzbenica = prikazNarudzbenica;
	}

	public JLabel getIzmenaPodataka() {
		return izmenaPodataka;
	}

	public void setIzmenaPodataka(JLabel izmenaPodataka) {
		this.izmenaPodataka = izmenaPodataka;
	}

	public JSplitPane getSplit() {
		return split;
	}

	public void setSplit(JSplitPane split) {
		this.split = split;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}
	
}
