package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import Controller.LogInController;
import Controller.RegistracijaController;
import Model.AplikacijaPreduzece;

public class RegistracijaView extends JPanel {
	
	private AplikacijaPreduzece preduzece;
	private RegistracijaController regcon;
	
	private JPanel pnlContent;
	private JLabel lblkorisnickoime;
	private JTextField tfkorisnicko;
	private JLabel lbllozinka;
	private JTextField tflozinka;
	private JLabel lblime;
	private JTextField tfime;
	private JLabel lblprezime;
	private JTextField tfprezime;
	private JLabel lblemail;
	private JTextField tfemail;
	private JLabel lbltelefon;
	private JTextField tftelefon;

	private JPanel pnlOK;
	private JButton btnOK;
	
	public RegistracijaView(AplikacijaPreduzece preduzece) {
		//setLayout(new FlowLayout());
		this.preduzece = preduzece;
		pnlContent = new JPanel(new GridBagLayout());

		lblkorisnickoime = new JLabel("Korisnicko ime:");
		tfkorisnicko = new JTextField(20);

		lbllozinka = new JLabel("Lozinka:");
		tflozinka = new JTextField(20);
		
		lblime = new JLabel("Ime:");
		tfime = new JTextField(20);

		lblprezime = new JLabel("Prezime:");
		tfprezime = new JTextField(20);
		
		lblemail = new JLabel("e-mail adresa:");
		tfemail = new JTextField(20);

		lbltelefon = new JLabel("Telefon:");
		tftelefon = new JTextField(20);

		pnlOK = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnOK = new JButton("OK");
		
		
		constructGUI();
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
		pnlContent.add(lblime, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfime, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblprezime, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfprezime, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblemail, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfemail, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lbltelefon, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tftelefon, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		pnlOK.add(btnOK);

		add(pnlContent, BorderLayout.CENTER);
		
		add(pnlOK, BorderLayout.SOUTH);
		
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					try {
						ok();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});

	}
	
	private void ok() throws IOException {
		if (regcon == null) {
			regcon = new RegistracijaController(this);
		}
		
		String kime = tfkorisnicko.getText();
		String lozinka = tflozinka.getText();
		String ime = tfime.getText();
		String prezime = tfprezime.getText();
		String email = tfemail.getText();
		String telefon = tftelefon.getText();
		regcon.registrujSe();
		
		if(!(preduzece.registracijaKupca(kime, lozinka, email, ime, prezime, telefon, null, null, null, 0))) {
			//JDialog neuspesno = new JDialog();
			String message = "Korisnicko ime vec postoji.";
			JOptionPane.showMessageDialog(this, message);
		}
		else {
			ProizvodiView bw = new ProizvodiView(preduzece);
			add(bw);
			remove(0);
			updateUI();
		}
	}

}
