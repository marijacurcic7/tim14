package Main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

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
import Model.Korisnik;
import View.BaseView;
import View.HeaderView;
import View.ProizvodiView;
import gui.panels.SviProizvodiPanel;


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

	public static void main(String[] args) throws IOException {
		new MainFrame().setVisible(true);
	}
}
