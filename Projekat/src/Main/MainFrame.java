package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import gui.panels.SviProizvodiPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1366462111697644313L;

	public static final String APP_TITLE = "Nas WebShop";

	JScrollPane skrol;
	SviProizvodiPanel view; // on ce se mijenjati, a view cce imati svog kontrolera
	JButton login;
	JButton korpa;
	JLabel broj;
	JLabel labela;
	JLabel naslov;
	JPanel glavni;
	JPanel p;

	public MainFrame() throws IOException {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(APP_TITLE);
		setSize(1000, 800);
		setLocationRelativeTo(null);


		glavni = new JPanel();
		
		
		
		
		
		SviProizvodiPanel bw = new SviProizvodiPanel();  // da on vidi frejm? zbog dimenzija
		
		
		initHeader();

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(p);
		split.setBottomComponent(bw);
		split.setDividerLocation(0.8);
		
		skrol = new JScrollPane(split);
		
		add(skrol, BorderLayout.CENTER);
		
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
	    p.add(new JButton("Prijava"), c);
	    
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
