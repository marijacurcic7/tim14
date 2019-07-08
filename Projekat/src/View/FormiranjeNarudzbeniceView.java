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
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Mesto;
import Model.Narudzbenica;
import Model.Placena;

public class FormiranjeNarudzbeniceView extends JPanel {
	
	private AplikacijaPreduzece preduzece;
	private Korisnik trenutnoUlogovani;
	private FormiranjeNarudzbeniceController fncon;
	private Narudzbenica korpa;
	private Narudzbenica narudzbenica;
	public MainFrame frame;
	
	private JButton btnOK;
	private JButton btnCancell;
	
	private JPanel pnlContent;
	private JPanel pnl;
	private JLabel lblime;
	private JLabel lblprezime;
	private JLabel lbltelefon;
	private JLabel lblemail;
	private JLabel lblgrad;
	private JLabel lbldrzava;
	private JLabel lbladresa;
	private JLabel lblkartica;
	
	private JTextField tfemail;
	private JTextField tftelefon;
	private JTextField tfime;
	private JTextField tfprezime;
	private JTextField tfgrad;
	private JTextField tfdrzava;
	private JTextField tfadresa;
	private JTextField tfkartica;
	
	public FormiranjeNarudzbeniceView(AplikacijaPreduzece ap, MainFrame frame) {
		
		this.frame = frame;
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
		
		lblkartica = new JLabel("Broj kartice:");
		tfkartica = new JTextField(20);
		
		lblgrad = new JLabel("Grad:");
		tfgrad = new JTextField(20);
		
		lbldrzava = new JLabel("Drzava:");
		tfdrzava = new JTextField(20);
		
		lbladresa = new JLabel("Adresa:");
		tfadresa = new JTextField(20);
		
		if(trenutnoUlogovani.getMesto() != null) {
			tfgrad.setText(trenutnoUlogovani.getMesto().getGrad());
			tfdrzava.setText(trenutnoUlogovani.getMesto().getDrzava());
			tfadresa.setText(trenutnoUlogovani.getMesto().getAdresa());
		}
		
		btnOK = new JButton("OK");
		btnCancell = new JButton("Cancell");
		
		pnlContent = new JPanel(new GridBagLayout());
		pnl = new JPanel();
		
		constructGUI();
		
		if(fncon == null) {
			fncon = new FormiranjeNarudzbeniceController(this, preduzece);
		}
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
		
		pnlContent.add(lblkartica, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfkartica, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbldrzava, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfdrzava, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblgrad, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfgrad, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lbladresa, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfadresa, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		
		
		pnlContent.setVisible(true);

		pnl.add(pnlContent, BorderLayout.CENTER);
		
		
		pnl.add(btnOK);
		pnl.add(btnCancell);
		
		/*btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					ok();
					
				}
		});
		*/
		
		add(pnl);
	
	}
	
	public void ok() {
		if(fncon == null) {
			fncon = new FormiranjeNarudzbeniceController(this, preduzece);
		}
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		String ime = tfime.getText();
		String prezime = tfprezime.getText();
		//String email = tfemail.getText();
		String telefon = tftelefon.getText();
		String karticastr = tfkartica.getText();
		
		
		double cena = korpa.getUkupanIznos();
		
		String message = fncon.formirajNarudzbenicu(ime, prezime, telefon, karticastr, cena, tfgrad.getText(), tfdrzava.getText(), tfadresa.getText());
		
		//String message = regcon.registrujSe(kime, lozinka, ime, prezime, email, telefon);
		//String title = "Greska";
		
		if(message.equals("")) {
			//JOptionPane.showMessageDialog(parent, "Narudzbenica formirana");
			//JOptionPane.showConfirmDialog(this, "Plati");
			
			int dialogbtn = JOptionPane.YES_NO_OPTION;
			int dialogrez = JOptionPane.showConfirmDialog(this, "Plati", "Narudzbenica je formirana", dialogbtn);
			if(dialogrez == JOptionPane.YES_OPTION) {
				narudzbenica.setStanje(new Placena());
			}
			
			preduzece.narudzbenice.add(narudzbenica);

			/*ProizvodiView bw = null;
			try {
				bw = new ProizvodiView(frame.getView(), preduzece, preduzece.proizvodi);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.getView().remove(1);
			frame.getView().add(bw);
			
			frame.getView().updateUI();*/
			//doSth();
			//KupacView kv = new KupacView(preduzece, frame);
			//remove(0);
			//add(kv);
			
			updateUI();
		}
		else {
			JOptionPane.showMessageDialog(parent, message);

		}
	}
	
	


	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Korisnik getTrenutnoUlogovani() {
		return trenutnoUlogovani;
	}

	public void setTrenutnoUlogovani(Korisnik trenutnoUlogovani) {
		this.trenutnoUlogovani = trenutnoUlogovani;
	}

	public FormiranjeNarudzbeniceController getFncon() {
		return fncon;
	}

	public void setFncon(FormiranjeNarudzbeniceController fncon) {
		this.fncon = fncon;
	}

	public Narudzbenica getKorpa() {
		return korpa;
	}

	public void setKorpa(Narudzbenica korpa) {
		this.korpa = korpa;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JButton getBtnCancell() {
		return btnCancell;
	}

	public void setBtnCancell(JButton btnCancell) {
		this.btnCancell = btnCancell;
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}

	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
	}

	public JPanel getPnl() {
		return pnl;
	}

	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}

	public JLabel getLblime() {
		return lblime;
	}

	public void setLblime(JLabel lblime) {
		this.lblime = lblime;
	}

	public JLabel getLblprezime() {
		return lblprezime;
	}

	public void setLblprezime(JLabel lblprezime) {
		this.lblprezime = lblprezime;
	}

	public JLabel getLbltelefon() {
		return lbltelefon;
	}

	public void setLbltelefon(JLabel lbltelefon) {
		this.lbltelefon = lbltelefon;
	}

	public JLabel getLblemail() {
		return lblemail;
	}

	public void setLblemail(JLabel lblemail) {
		this.lblemail = lblemail;
	}

	public JLabel getLblgrad() {
		return lblgrad;
	}

	public void setLblgrad(JLabel lblgrad) {
		this.lblgrad = lblgrad;
	}

	public JLabel getLbldrzava() {
		return lbldrzava;
	}

	public void setLbldrzava(JLabel lbldrzava) {
		this.lbldrzava = lbldrzava;
	}

	public JLabel getLbladresa() {
		return lbladresa;
	}

	public void setLbladresa(JLabel lbladresa) {
		this.lbladresa = lbladresa;
	}

	public JLabel getLblkartica() {
		return lblkartica;
	}

	public void setLblkartica(JLabel lblkartica) {
		this.lblkartica = lblkartica;
	}

	public JTextField getTfemail() {
		return tfemail;
	}

	public void setTfemail(JTextField tfemail) {
		this.tfemail = tfemail;
	}

	public JTextField getTftelefon() {
		return tftelefon;
	}

	public void setTftelefon(JTextField tftelefon) {
		this.tftelefon = tftelefon;
	}

	public JTextField getTfime() {
		return tfime;
	}

	public void setTfime(JTextField tfime) {
		this.tfime = tfime;
	}

	public JTextField getTfprezime() {
		return tfprezime;
	}

	public void setTfprezime(JTextField tfprezime) {
		this.tfprezime = tfprezime;
	}

	public JTextField getTfgrad() {
		return tfgrad;
	}

	public void setTfgrad(JTextField tfgrad) {
		this.tfgrad = tfgrad;
	}

	public JTextField getTfdrzava() {
		return tfdrzava;
	}

	public void setTfdrzava(JTextField tfdrzava) {
		this.tfdrzava = tfdrzava;
	}

	public JTextField getTfadresa() {
		return tfadresa;
	}

	public void setTfadresa(JTextField tfadresa) {
		this.tfadresa = tfadresa;
	}

	public JTextField getTfkartica() {
		return tfkartica;
	}

	public void setTfkartica(JTextField tfkartica) {
		this.tfkartica = tfkartica;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

}
