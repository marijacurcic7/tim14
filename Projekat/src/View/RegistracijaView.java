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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Controller.RegistracijaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Korisnik;

public class RegistracijaView extends JPanel {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik korisnik = null;

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

	MainFrame frame;
	
	private JPanel pnlOK;
	private JButton btnOK;
	
	public RegistracijaView(AplikacijaPreduzece preduzece, MainFrame frame) {
		//setLayout(new FlowLayout());
		
		this.frame = frame;
		
		this.preduzece = preduzece;
		pnlContent = new JPanel(new GridBagLayout());

		lblkorisnickoime = new JLabel("Korisnicko ime:");
		tfkorisnicko = new JTextField(20);

		lbllozinka = new JLabel("Lozinka:");
		tflozinka = new JPasswordField(20);
		//tflozinka = new JTextField(20);
		
		lblime = new JLabel("Ime:");
		tfime = new JTextField(20);

		lblprezime = new JLabel("Prezime:");
		tfprezime = new JTextField(20);
		
		lblemail = new JLabel("e-mail adresa:");
		tfemail = new JTextField(20);

		lbltelefon = new JLabel("Telefon:");
		tftelefon = new JTextField(20);

		//pnlOK = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
		pnlContent.add(btnOK, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		//pnlOK.add(btnOK);

		add(pnlContent, BorderLayout.CENTER);
		
		//add(pnlOK, BorderLayout.SOUTH);
		
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
			regcon = new RegistracijaController(this, preduzece);
		}
		
		Window parent = SwingUtilities.getWindowAncestor(this);

		String kime = tfkorisnicko.getText();
		String lozinka = tflozinka.getText();
		String ime = tfime.getText();
		String prezime = tfprezime.getText();
		String email = tfemail.getText();
		String telefon = tftelefon.getText();
		String message = regcon.registrujSe(kime, lozinka, ime, prezime, email, telefon);
		String title = "Greska";
		
		if (korisnik == null){
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//JOptionPane.
			    	Window w = SwingUtilities.getWindowAncestor(btnOk);

			        if (w != null) {
			          w.setVisible(false);
			        }
			    	RegistracijaView rw = new RegistracijaView(preduzece, frame);
					add(rw);
					remove(0);
					updateUI();
			        System.out.println("code excuted");
			    }
			}); 
			JOptionPane.showOptionDialog(parent, message, title, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{btnOk}, btnOk);
			
		}
		else {
			// gledam koji je tip
			// promijeniti zaglavlje, na odjavi
			JOptionPane.showMessageDialog(parent, message);
			ProizvodiView bw = new ProizvodiView(preduzece);	// za kupca
			KupacView kv = new KupacView(preduzece);
			//
			frame.getHeader().getPrijava().setText("Odjava");
			frame.getHeader().updateUI();
			add(kv);
			remove(0);
			updateUI();
			System.out.println(preduzece.trenutnoUlogovani.getIme());
		}
		
		
	}
	
	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public RegistracijaController getRegcon() {
		return regcon;
	}

	public void setRegcon(RegistracijaController regcon) {
		this.regcon = regcon;
	}

}
