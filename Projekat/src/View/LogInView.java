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
		//tLayout(new FlowLayout());
		this.preduzece = preduzece;
		
		this.frame = frame;

		pnlContent = new JPanel(new GridBagLayout());

		lblkorisnickoime = new JLabel("Korisnicko ime:");
		tfkorisnicko = new JTextField(20);

		lbllozinka = new JLabel("Lozinka:");
		tflozinka = new JPasswordField(20);
		//tflozinka = new JTextField(20);

		pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton("OK");
		btnReg = new JButton("Registracija");
		
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

		pnlOK.add(btnOK);
		pnlOK.add(btnReg);
		//add(pnlOK, BorderLayout.SOUTH);
		
		pnlContent.add(pnlOK);

		add(pnlContent, BorderLayout.CENTER);
		
		
		
		btnReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					//loginv.setVisible(false);
					//System.out.println("");
					//removeAll();
					RegistracijaView rv = new RegistracijaView(preduzece, frame);
					add(rv);
					remove(0);
					updateUI();
					//rv.setVisible(true);
					//setVisible(false);
					
				}
		});
		
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
		if (loginc == null) {
			loginc = new LogInController(this);
		}
		
		
		String kime = tfkorisnicko.getText();
		String lozinka = tflozinka.getText();
		loginc.login(kime, lozinka);
		System.out.println(kime);
		System.out.println(lozinka);
		if(!(preduzece.proveriLogin(kime, lozinka))) {
			//JDialog neuspesno = new JDialog();
			String message = "Pogresno uneto korisnicko ime ili lozinka. Pokusajte ponovo.";
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
