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

import Controller.PromenaPodatakaController;
import Controller.RegistracijaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.TipKorisnika;

public class PromenaPodatakaView extends JPanel {
	private AplikacijaPreduzece preduzece;
	public Korisnik korisnik;
	private PromenaPodatakaController ppcon;
	
	private JPanel pnlContent;
	private JLabel lblkorisnickoime;
	//private JTextField tfkorisnicko;
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
	
	private JLabel lblgrad;
	private JLabel lbldrzava;
	private JLabel lbladresa;
	private JTextField tfgrad;
	private JTextField tfdrzava;
	private JTextField tfadresa;

	public MainFrame frame;
	
	private JPanel pnlOK;
	private JButton btnOK;
	
	public PromenaPodatakaView(AplikacijaPreduzece preduzece, MainFrame frame) {
		//setLayout(new FlowLayout());
		
		this.frame = frame;
		this.preduzece = preduzece;
		this.korisnik = preduzece.trenutnoUlogovani;
		//this.korisnik = preduzece.trenutnoUlogovani;
		
		pnlContent = new JPanel(new GridBagLayout());
		
		lblkorisnickoime = new JLabel("Korisnicko ime: "+korisnik.getNalog().getKorisnickoIme());

		lbllozinka = new JLabel("Lozinka:");
		//tflozinka = new JPasswordField(20);
		tflozinka = new JTextField(20);
		tflozinka.setText(korisnik.nalog.getLozinka());
		
		lblime = new JLabel("Ime:");
		tfime = new JTextField(20);
		tfime.setText(korisnik.getIme());

		lblprezime = new JLabel("Prezime:");
		tfprezime = new JTextField(20);
		tfprezime.setText(korisnik.getPrezime());
		
		lblemail = new JLabel("e-mail adresa:");
		tfemail = new JTextField(20);
		tfemail.setText(korisnik.getNalog().geteMail());

		lbltelefon = new JLabel("Telefon:");
		tftelefon = new JTextField(20);
		tftelefon.setText(korisnik.getTelefon());

		
		lblgrad = new JLabel("Grad:");
		tfgrad = new JTextField(20);
		//
		
		lbldrzava = new JLabel("Drzava:");
		tfdrzava = new JTextField(20);
		//
		
		lbladresa = new JLabel("Adresa:");
		tfadresa = new JTextField(20);
		
		if(korisnik.getMesto() != null) {
			tfgrad.setText(korisnik.getMesto().getGrad());
			tfdrzava.setText(korisnik.getMesto().getDrzava());
			tfadresa.setText(korisnik.getMesto().getAdresa());
		}
		
		
		//pnlOK = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnOK = new JButton("OK");
		
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent.add(lblkorisnickoime, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
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
		
		pnlContent.add(lbldrzava, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfdrzava, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblgrad, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfgrad, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbladresa, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfadresa, new GridBagConstraints(1, 8, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(btnOK, new GridBagConstraints(1, 9, 1, 1, 100, 0, GridBagConstraints.WEST,
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
		if (ppcon == null) {
			ppcon = new PromenaPodatakaController(this, preduzece);
		}
		
		Window parent = SwingUtilities.getWindowAncestor(this);

		String lozinka = tflozinka.getText();
		String ime = tfime.getText();
		String prezime = tfprezime.getText();
		String email = tfemail.getText();
		String telefon = tftelefon.getText();
		
		String message = ppcon.promeni(lozinka, ime, prezime, email, telefon, tfgrad.getText(), tfdrzava.getText(), tfadresa.getText());
		String title = "Greska";
		
		JOptionPane.showMessageDialog(parent, message);
		if (ppcon.isPromenjen()){
			//JButton btnOk = new JButton("Ok");
			btnOK.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	PromenaPodatakaView ppv = new PromenaPodatakaView(preduzece, frame);
			    	
			    	//JOptionPane.

			        /*if (w != null) {
			          w.setVisible(false);
			        }*/
					add(ppv);
					remove(0);
					updateUI();
			        //System.out.println("code excuted");
			    }
			}); 
			//JOptionPane.showOptionDialog(parent, message, title, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{btnOk}, btnOk);
			
		}
		/*else {
			JOptionPane.showMessageDialog(parent, message);
			
		}*/
		
		
		
	}

}
