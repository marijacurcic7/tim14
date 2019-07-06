package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import Controller.Controller;
import Model.AplikacijaPreduzece;

public class AdminView extends BaseView {

	JButton dodajMenadzera;
	Controller controller;  // ovo dodati, zasad akciju na dugme ostaviti ovdje
	AplikacijaPreduzece preduzece;
	
	public AdminView(AplikacijaPreduzece preduzece) {
		
		this.preduzece = preduzece;
		this.dodajMenadzera = new JButton("Dodaj menadzera");
		
		this.dodajMenadzera.setPreferredSize(new Dimension(200, 150));
		
		this.add(dodajMenadzera);
		
		
		
	}
}
