package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LogInController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.RegistrovaniKupac;
import Model.TipKorisnika;

public class LogInView extends JPanel {
	
	private LogInController loginc;
	private Korisnik korisnik;
	private AplikacijaPreduzece preduzece;
	private boolean uspesno;
	
	private MainFrame frame;
	
	private JPanel pnlContent;
	private JLabel lblkorisnickoime;
	private JTextField tfkorisnicko;
	private JLabel lbllozinka;
	private JTextField tflozinka;

	private JPanel pnlOK;
	public JButton btnOK;
	public JButton btnReg;  
	//
	
	public LogInView(AplikacijaPreduzece preduzece, MainFrame frame) {
		this.preduzece = preduzece;
		
		this.frame = frame;

		pnlContent = new JPanel(new GridBagLayout());

		lblkorisnickoime = new JLabel("Korisnicko ime:");
		tfkorisnicko = new JTextField(20);

		lbllozinka = new JLabel("Lozinka:");
		tflozinka = new JPasswordField(20);

		pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton("OK");
		btnReg = new JButton("Registracija");
		
		constructGUI();
		
		loginc = new LogInController(this, preduzece);
		
	}
	
	private void constructGUI() {
		pnlContent.add(lblkorisnickoime, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfkorisnicko, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lbllozinka, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tflozinka, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		pnlOK.add(btnOK);
		pnlOK.add(btnReg);
		
		pnlContent.add(pnlOK);

		add(pnlContent, BorderLayout.CENTER);
		

	}
	

	public LogInController getLoginc() {
		return loginc;
	}

	public void setLoginc(LogInController loginc) {
		this.loginc = loginc;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public boolean isUspesno() {
		return uspesno;
	}

	public void setUspesno(boolean uspesno) {
		this.uspesno = uspesno;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}

	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
	}

	public JLabel getLblkorisnickoime() {
		return lblkorisnickoime;
	}

	public void setLblkorisnickoime(JLabel lblkorisnickoime) {
		this.lblkorisnickoime = lblkorisnickoime;
	}

	public JTextField getTfkorisnicko() {
		return tfkorisnicko;
	}

	public void setTfkorisnicko(JTextField tfkorisnicko) {
		this.tfkorisnicko = tfkorisnicko;
	}

	public JLabel getLbllozinka() {
		return lbllozinka;
	}

	public void setLbllozinka(JLabel lbllozinka) {
		this.lbllozinka = lbllozinka;
	}

	public JTextField getTflozinka() {
		return tflozinka;
	}

	public void setTflozinka(JTextField tflozinka) {
		this.tflozinka = tflozinka;
	}

	public JPanel getPnlOK() {
		return pnlOK;
	}

	public void setPnlOK(JPanel pnlOK) {
		this.pnlOK = pnlOK;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JButton getBtnReg() {
		return btnReg;
	}

	public void setBtnReg(JButton btnReg) {
		this.btnReg = btnReg;
	}


}
