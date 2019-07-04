package View;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.AplikacijaPreduzece;

public class HeaderView extends BaseView {

	//JPanel p;
	JButton korpa;
	JButton prijava;
	JLabel labela1;
	JLabel labela2;
	JLabel naslov;
	AplikacijaPreduzece preduzece;
	
	public HeaderView(AplikacijaPreduzece preduzece){
		this.preduzece = preduzece;
	//p = new JPanel(new GridBagLayout());
    this.setLayout(new GridBagLayout());
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
    labela1 = new JLabel("Labela1");
    this.add(labela1, c);
    //p.add(new JPanel(), c);
    c.gridy = 2;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
    System.out.println("I");
    System.out.println(c.gridx + ", a y " + c.gridy);
    this.add(new JPanel(), c);
    
    c.gridx = 1;
    c.gridy = 0;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
    this.add(new JPanel(), c);
    
    c.gridy = 1;
    labela2 = new JLabel("Labela2");
    this.add(labela2, c);
    
    c.gridy = 2;
    this.add(new JPanel(),c);
    
    c.gridx = 2;
    
    c.gridy = 0;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
    this.add(new JPanel(), c);
    
    c.gridy = 1;

    //p.add(new JButton("Dugme2"), c);
    
    this.add(new JPanel(), c);
    
    c.gridy = 2;
    this.add(new JPanel(),c);
    
    
    c.gridx = 3;
    c.gridy = 0;
    c.gridheight = 3;
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    naslov = new JLabel("TITLE");
    JPanel pn = new JPanel();
    pn.add(naslov);
    pn.setBackground(new Color(100, 200, 200));
    this.add(pn, c);
    
    c.fill = GridBagConstraints.NONE;
    
    c.gridx = 4;
    
    //c.gridy = 0;
    //c.gridwidth = 1;
   
    c.anchor = GridBagConstraints.CENTER; // remember to rest to center
    //p.add(new JPanel(), c);
    
    c.weightx = 0.0;
    c.gridy = 0;
    
    prijava = new JButton("Prijava");
    this.add(prijava, c);
    
    c.gridy = 2;
    this.add(new JPanel(),c);
    
    c.gridx = 5;
    c.gridy = 0;
    korpa = new JButton("Korpa");
    this.add(korpa, c);
	}

	public JButton getKorpa() {
		return korpa;
	}

	public void setKorpa(JButton korpa) {
		this.korpa = korpa;
	}

	public JButton getPrijava() {
		return prijava;
	}

	public void setPrijava(JButton prijava) {
		this.prijava = prijava;
	}

	public JLabel getLabela1() {
		return labela1;
	}

	public void setLabela1(JLabel labela1) {
		this.labela1 = labela1;
	}

	public JLabel getLabela2() {
		return labela2;
	}

	public void setLabela2(JLabel labela2) {
		this.labela2 = labela2;
	}

	public JLabel getNaslov() {
		return naslov;
	}

	public void setNaslov(JLabel naslov) {
		this.naslov = naslov;
	}
	
	
	
}
