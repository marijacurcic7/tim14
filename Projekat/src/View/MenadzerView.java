package View;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Controller.Controller;
import Model.AplikacijaPreduzece;

public class MenadzerView extends BaseView {

	// i aplikacija
	
	Controller controller;
	
	ProizvodiView proizvodi;
	
	JPanel onoSaStrane;
	
	//
	JLabel dodajNoviProizvod;
	
	JLabel prodavnice;
	//
	
	
	JLabel prikazNarudzbenica;
	
	JLabel izmenaPodataka;
	
	JSplitPane split;
	
	AplikacijaPreduzece preduzece;
	
	// trebace mi i frejm da vidim gdje stoji i da mijenjam
	public MenadzerView(AplikacijaPreduzece preduzece) {
		// napravim proizvode
		// ono sa strane
		// splitpane
		try {
			proizvodi = new ProizvodiView(preduzece);   // aplikacija mu treba
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
		
		//add(proizvodi);
		//split.getLeftComponent().CENTER_ALIGNMENT
		//split.setLeftComponent(onoSaStrane);
		//split.setBottomComponent(proizvodi);
		//split.setRightComponent(proizvodi);
		//split.setDividerLocation(0.9);
		
		
		
		//this.add(split);
		
	}
	
	private void initOnoSaStrane() {
		onoSaStrane = new JPanel();
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
	
		
		prikazNarudzbenica = new JLabel("  Prikaz mojih narudzbenica  ");
		// prikaz pojedinacne, i opcije za nju, refresh
		prikazNarudzbenica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prikazNarudzbenica.addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	JOptionPane.showMessageDialog(null, "Prikaz liste narudzbenica sa mogucnoscu odabira"
		    			+ " posiljke narudzbenica koje nisu poslate");
		    }});
		onoSaStrane.setLayout(new GridLayout(18, 0));
		
		dodajNoviProizvod = new JLabel("  Dodaj novi proizvod  ");
		dodajNoviProizvod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dodajNoviProizvod.addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	JOptionPane.showMessageDialog(null, " Unos novog proizvoda ");
		    	DodavanjeProizvodaView rw = new DodavanjeProizvodaView(preduzece);
				add(rw);
				remove(0);
				updateUI();
		    }});
		
		onoSaStrane.add(dodajNoviProizvod);
		
		
		onoSaStrane.add(prikazNarudzbenica);
		
		
		izmenaPodataka = new JLabel("  Izmena mojih podataka  ");
		izmenaPodataka.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		izmenaPodataka.addMouseListener(new MouseAdapter() {
			 
			// ovo svakako u controller
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	JOptionPane.showMessageDialog(null, "Izmena podataka");
		    }});
		
		onoSaStrane.add(izmenaPodataka);
		onoSaStrane.add(new JLabel("  Labela 3  "));
		onoSaStrane.add(new JLabel("  Labela 4  "));
		
		
		
	}
	
}
