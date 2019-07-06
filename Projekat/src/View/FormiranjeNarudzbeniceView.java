package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Controller.FormiranjeNarudzbeniceController;
import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Narudzbenica;

public class FormiranjeNarudzbeniceView extends JPanel {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik trenutnoUlogovani;
	private FormiranjeNarudzbeniceController fncon;
	private Narudzbenica korpa;
	
	private JButton btnOK;
	private JButton btnCancell;
	
	private JPanel pnlContent;
	private JLabel lblime;
	private JLabel lblprezime;
	private JLabel lbltelefon;
	private JLabel lblemail;
	private JLabel lblgrad;
	private JLabel lbldrzava;
	private JLabel lbladresa;
	
	private JTextField tfemail;
	private JTextField tftelefon;
	private JTextField tfime;
	private JTextField tfprezime;
	private JTextField tfgrad;
	private JTextField tfdrzava;
	private JTextField tfadresa;
	
	public FormiranjeNarudzbeniceView(AplikacijaPreduzece ap) {
		
		this.preduzece = ap;
		this.trenutnoUlogovani = ap.trenutnoUlogovani;
		this.korpa = ap.korpa;
		
		lblime = new JLabel("Ime:");
		tfime = new JTextField(20);
		tfime.setText(trenutnoUlogovani.getIme());

		lblprezime = new JLabel("Prezime:");
		tfprezime = new JTextField(20);
		tfprezime.setText(trenutnoUlogovani.getPrezime());
		
		lblemail = new JLabel("e-mail adresa:");
		tfemail = new JTextField(20);
		tfemail.setText(trenutnoUlogovani.getNalog().geteMail());

		lbltelefon = new JLabel("Telefon:");
		tftelefon = new JTextField(20);
		tftelefon.setText(trenutnoUlogovani.getTelefon());
		
		lblgrad = new JLabel("Grad:");
		tfgrad = new JTextField(20);
		//
		
		lbldrzava = new JLabel("Drzava:");
		tfdrzava = new JTextField(20);
		//
		
		lbladresa = new JLabel("Adresa:");
		tfadresa = new JTextField(20);
		
		if(trenutnoUlogovani.getMesto() != null) {
			tfgrad.setText(trenutnoUlogovani.getMesto().getGrad());
			tfdrzava.setText(trenutnoUlogovani.getMesto().getDrzava());
			tfadresa.setText(trenutnoUlogovani.getMesto().getAdresa());
		}
		//

		btnOK = new JButton("OK");
		btnCancell = new JButton("Cancell");
		
		pnlContent = new JPanel(new GridBagLayout());
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent.add(lblime, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfime, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblprezime, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfprezime, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblemail, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfemail, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbltelefon, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tftelefon, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbldrzava, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfdrzava, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblgrad, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfgrad, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbladresa, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfadresa, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		/*pnlContent.add(btnOK, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));*/
		//pnlOK.add(btnOK);
		
		pnlContent.setVisible(true);

		add(pnlContent, BorderLayout.CENTER);
		
		//add(pnlOK, BorderLayout.SOUTH);
		
		add(btnOK);
		add(btnCancell);
		
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					ok();
					
				}
		});
	
	}
	
	private void ok() {
		if(fncon == null) {
			fncon = new FormiranjeNarudzbeniceController(this, preduzece);
		}
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		String ime = tfime.getText();
		String prezime = tfprezime.getText();
		//String email = tfemail.getText();
		String telefon = tftelefon.getText();
		
		double cena = korpa.getUkupanIznos();
		
		String message = fncon.formirajNarudzbenicu(ime, prezime, telefon, cena, tfgrad.getText(), tfdrzava.getText(), tfadresa.getText());
		
		//String message = regcon.registrujSe(kime, lozinka, ime, prezime, email, telefon);
		//String title = "Greska";
		
		if(message.equals("")) {
			JOptionPane.showMessageDialog(parent, "Narudzbenica formirana");
		}
		else {
			JOptionPane.showMessageDialog(parent, message);

			//ok();
		}
	}
	
	private void ulogovan() {
		if(preduzece.trenutnoUlogovani == null) {
			//n
		}
	}

}
