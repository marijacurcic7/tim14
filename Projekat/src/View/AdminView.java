package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.AdminController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;

public class AdminView extends BaseView {

	JButton dodajMenadzera;

	AdminController admincon;
	AplikacijaPreduzece preduzece;
	MainFrame frame;
	
	public AdminView(AplikacijaPreduzece preduzece, MainFrame frame) {
		
		this.frame = frame;
		this.preduzece = preduzece;
		this.dodajMenadzera = new JButton("Dodaj menadzera");
		
		this.dodajMenadzera.setPreferredSize(new Dimension(150, 100));
		
		this.add(dodajMenadzera);
		
		admincon = new AdminController(this, preduzece);
		
	}

	public JButton getDodajMenadzera() {
		return dodajMenadzera;
	}

	public void setDodajMenadzera(JButton dodajMenadzera) {
		this.dodajMenadzera = dodajMenadzera;
	}

	public AdminController getAdmincon() {
		return admincon;
	}

	public void setAdmincon(AdminController admincon) {
		this.admincon = admincon;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}
