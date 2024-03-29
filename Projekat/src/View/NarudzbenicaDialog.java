package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NarudzbenicaDialog extends JDialog {
	
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
	
	static JFrame parent = new JFrame();
	
	
	public NarudzbenicaDialog() {
		
		super(parent," title ",true);
		
		lblime = new JLabel("Ime:");
		tfime = new JTextField(20);

		lblprezime = new JLabel("Prezime:");
		tfprezime = new JTextField(20);
		
		lblemail = new JLabel("e-mail adresa:");
		tfemail = new JTextField(20);

		lbltelefon = new JLabel("Telefon:");
		tftelefon = new JTextField(20);
		
		lblgrad = new JLabel("Grad:");
		tfgrad = new JTextField(20);
		
		lbldrzava = new JLabel("Drzava:");
		tfdrzava = new JTextField(20);
		
		lbladresa = new JLabel("Adresa:");
		tfadresa = new JTextField(20);

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

		
		pnlContent.setVisible(true);

		add(pnlContent, BorderLayout.CENTER);
		
		
		add(btnOK);
		add(btnCancell);
		
		
	}
}
