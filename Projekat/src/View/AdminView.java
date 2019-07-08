package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.AdminController;
import Controller.Controller;
import Main.MainFrame;
import Model.AplikacijaPreduzece;

public class AdminView extends BaseView {

	JButton dodajMenadzera;
	//Controller controller;  // ovo dodati, zasad akciju na dugme ostaviti ovdje
	//AdminController admincon;
	AplikacijaPreduzece preduzece;
	MainFrame frame;
	
	public AdminView(AplikacijaPreduzece preduzece, MainFrame frame) {
		
		this.frame = frame;
		this.preduzece = preduzece;
		this.dodajMenadzera = new JButton("Dodaj menadzera");
		
		this.dodajMenadzera.setPreferredSize(new Dimension(200, 150));
		
		this.add(dodajMenadzera);
		
		dodajMenadzera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					RegistracijaView rv = new RegistracijaView(preduzece, frame);
					add(rv);
					remove(0);
					updateUI();
					
					
				}
		});
	}
}
