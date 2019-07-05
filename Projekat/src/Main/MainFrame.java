package Main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;

import Controller.HeaderController;
import Model.AplikacijaPreduzece;
import Model.Kategorija;
import Model.Korisnik;
import Model.Proizvod;
import Model.StavkaCenovnika;
import Model.StavkaNarudzbenice;
import View.BaseView;
import View.HeaderView;
import View.ProizvodiView;
import gui.panels.SviProizvodiPanel;
// commit

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1366462111697644313L;
	public static final String APP_TITLE = "Nas WebShop";

	JScrollPane skrol;
	//SviProizvodiPanel view; // on ce se mijenjati, a view cce imati svog kontrolera
	JButton login;
	JButton korpa;
	JLabel broj;
	JLabel labela;
	JLabel naslov;
	JPanel glavni;
	JPanel p;
	SviProizvodiPanel bw;
	public JSplitPane split;
	
	BaseView view;
	HeaderView header;
	HeaderController headerController;
	
	AplikacijaPreduzece preduzece;
	Korisnik trenUlogovani;
	
	JButton prijava;

	public MainFrame() throws IOException {
		
		preduzece = new AplikacijaPreduzece();
		izgenerisiPreduzece();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);
		//glavni = new JPanel();	
		
		//trenUlogovani.getNalog().getTipKorisnika()
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                
            	try {
					preduzece.pisanjeUFajl();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		header = new HeaderView(preduzece);
		ProizvodiView bw = new ProizvodiView(preduzece);  // da on vidi frejm? zbog dimenzija
		view = bw;
		
		//bw = new SviProizvodiPanel();  // da on vidi frejm? zbog dimenzija
		
		//setContentPane(glavni);
		//add(glavni);
		
		//initHeader();

		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(header);
		split.setBottomComponent(bw);
		split.setDividerLocation(0.8);
		
		skrol = new JScrollPane(split);
		
		//add(skrol, BorderLayout.CENTER); probala sam da stavim slicno sa swing
		
		add(skrol, BevelBorder.RAISED);
		
		/*
		prijava.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//bw.setVisible(false);
				LogInView lv = new LogInView();
				//split.setBottomComponent(lv);
				bw.add(lv);
				bw.remove(0);
				bw.updateUI();
			}
		});*/
		
		
		headerController = new HeaderController(header, view, preduzece); 
		
	}

	
	
	private void initHeader() {
		p = new JPanel(new GridBagLayout());

	    p.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(4, 4, 4, 4);
	    c.weighty = 1.0;
	    c.weightx = 0.0;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 3;
	    //c.fill = GridBagConstraints.BOTH;
	    c.anchor = GridBagConstraints.CENTER; // place component on the North
	    System.out.println("java dugme");
	    System.out.println(c.gridx + ", a y " + c.gridy);
	    //p.add(new JButton("Java"), c);
	    //p.add(new JPanel(), c);
	    c.gridx = 0;
	    c.gridy = 1;
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    System.out.println("izvor dugme");
	    System.out.println(c.gridx + ", a y " + c.gridy);
	    p.add(new JLabel("Labela1"), c);
	    //p.add(new JPanel(), c);
	    c.gridy = 2;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
	    System.out.println("I");
	    System.out.println(c.gridx + ", a y " + c.gridy);
	    p.add(new JPanel(), c);
	    
	    c.gridx = 1;
	    c.gridy = 0;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
	    p.add(new JPanel(), c);
	    
	    c.gridy = 1;
	    p.add(new JLabel("Labela2"), c);
	    
	    c.gridy = 2;
	    p.add(new JPanel(),c);
	    
	    c.gridx = 2;
	    
	    c.gridy = 0;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
	    p.add(new JPanel(), c);
	    
	    c.gridy = 1;

	    //p.add(new JButton("Dugme2"), c);
	    
	    p.add(new JPanel(), c);
	    
	    c.gridy = 2;
	    p.add(new JPanel(),c);
	    
	    
	    c.gridx = 3;
	    c.gridy = 0;
	    c.gridheight = 3;
	    c.fill = GridBagConstraints.BOTH;
	    c.weightx = 1.0;
	    JLabel lab= new JLabel("TITLE");
	    JPanel pn = new JPanel();
	    pn.add(lab);
	    pn.setBackground(new Color(100, 200, 200));
	    p.add(pn, c);
	    
	    c.fill = GridBagConstraints.NONE;
	    
	    c.gridx = 4;
	    
	    //c.gridy = 0;
	    //c.gridwidth = 1;
	   
	    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
	    //p.add(new JPanel(), c);
	    
	    c.weightx = 0.0;
	    c.gridy = 0;
	    //p.add(new JButton("Prijava"), c);
	    prijava = new JButton("Prijava");
	    p.add(prijava, c);
	    
	    c.gridy = 2;
	    p.add(new JPanel(),c);
	    
	    c.gridx = 5;
	    c.gridy = 0;
	    p.add(new JButton("Korpa"), c);
	    
	    
	
	}
	
	public void izgenerisiPreduzece() {
		// prvo napraviti kategorije, pa proizvode, pa stavke cenovnika i dodati kome sta treba
		
		Kategorija kat = new Kategorija("Kuhinja");
		Kategorija k = new Kategorija("Posudje", kat);
		Kategorija k1 = new Kategorija("Escajg", kat);
		Kategorija kat2 = new Kategorija("Garderoba");
		Kategorija k2 = new Kategorija("Zenska garderoba", kat2);
		Kategorija k22 = new Kategorija("Muska garderoba", kat2);
		
		preduzece.addKategorija(kat);
		preduzece.addKategorija(k);
		preduzece.addKategorija(k1);
		preduzece.addKategorija(kat2);
		preduzece.addKategorija(k2);
		preduzece.addKategorija(k22);
		
		Proizvod p = new Proizvod(1, "Solja", "zelena, velika", k);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date datum = new Date(System.currentTimeMillis());
		//String datstr = f.format(datum);
		StavkaCenovnika sc = new StavkaCenovnika(100, datum, p);
		p.setAktuelnaCena(sc);
		
		Proizvod p2 = new Proizvod(2, "Viljuska", "plasticna", k1);
		StavkaCenovnika c2 = new StavkaCenovnika(500, datum, p2);
		p2.setAktuelnaCena(c2);
		
		
		preduzece.addProizvod(p2);
		preduzece.addProizvod(p);
		// 
		Proizvod p3 = new Proizvod(3, "Majica", "plava, pamucna", kat2);
		StavkaCenovnika c3 = new StavkaCenovnika(500, datum, p3);
		p3.setAktuelnaCena(c3);
		preduzece.addProizvod(p3);
		
		Proizvod p4 = new Proizvod(4, "Kosulja", "crna, svilena", kat2);
		StavkaCenovnika c4 = new StavkaCenovnika(1500, datum, p4);
		p4.setAktuelnaCena(c4);
		preduzece.addProizvod(p4);
		
		Proizvod p5 = new Proizvod(5, "Farmerke", "teksas, plave", kat2);
		StavkaCenovnika c5 = new StavkaCenovnika(10000, datum, p5);
		p5.setAktuelnaCena(c5);
		
		preduzece.addProizvod(p5);
		
		
		preduzece.addStavkaCenovnika(sc);
		preduzece.addStavkaCenovnika(c2);
		preduzece.addStavkaCenovnika(c3);
		preduzece.addStavkaCenovnika(c4);
		preduzece.addStavkaCenovnika(c5);
		
		StavkaNarudzbenice sn1 = new StavkaNarudzbenice(2, p4);
		StavkaNarudzbenice sn2 = new StavkaNarudzbenice(1, p2);
		StavkaNarudzbenice sn3 = new StavkaNarudzbenice(3, p5);
		
		preduzece.korpa.addStavkaNarudzbenice(sn1);
		preduzece.korpa.addStavkaNarudzbenice(sn2);
		preduzece.korpa.addStavkaNarudzbenice(sn3);
		
		
		
	}

	public static void main(String[] args) throws IOException {
		new MainFrame().setVisible(true);
	}
}
