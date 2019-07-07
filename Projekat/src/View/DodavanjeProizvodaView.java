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

import Controller.DodavanjeProizvodaController;
import Controller.RegistracijaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Korisnik;
import Model.Proizvod;

public class DodavanjeProizvodaView extends JPanel {
	
	private AplikacijaPreduzece preduzece;
	private Proizvod proizvod;

	private DodavanjeProizvodaController dpcon;
	
	private JPanel pnlContent;
	private JLabel lblid;
	private JTextField tfid;
	private JLabel lblnaziv;
	private JTextField tfnaziv;
	private JLabel lblopis;
	private JTextField tfopis;
	private JLabel lblkategorija;
	private JTextField tfkategorija;
	private JLabel lblcena;
	private JTextField tfcena;

	public MainFrame frame;
	
	private JPanel pnlOK;
	private JButton btnOK;
	
	public DodavanjeProizvodaView(AplikacijaPreduzece preduzece, MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.preduzece = preduzece;
		this.frame = frame;
		
		pnlContent = new JPanel(new GridBagLayout());

		lblid = new JLabel("ID proizvoda:");
		tfid = new JTextField(20);

		lblnaziv = new JLabel("Naziv:");
		tfnaziv = new JTextField(20);
		
		lblopis = new JLabel("Opis:");
		tfopis = new JTextField(50);

		lblkategorija = new JLabel("Kategorija:");
		tfkategorija = new JTextField(20);
		
		lblcena = new JLabel("Cena:");
		tfcena = new JTextField(20);

		btnOK = new JButton("OK");
		
		
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent.add(lblid, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfid, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblnaziv, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfnaziv, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblopis, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfopis, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblkategorija, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfkategorija, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblcena, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfcena, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
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
		if (dpcon == null) {
			dpcon = new DodavanjeProizvodaController(this, preduzece);
		}
		
		Window parent = SwingUtilities.getWindowAncestor(this);

		String id = tfid.getText();
		String naziv = tfnaziv.getText();
		String opis = tfopis.getText();
		String kategorija = tfkategorija.getText();
		String cena = tfcena.getText();
		
		String message = dpcon.dodaj(id, naziv, opis, kategorija, cena);
		String title = "Greska";
		
		if (proizvod == null){
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//JOptionPane.
			    	Window w = SwingUtilities.getWindowAncestor(btnOk);

			        if (w != null) {
			          w.setVisible(false);
			        }
			    	DodavanjeProizvodaView rw = new DodavanjeProizvodaView(preduzece, frame);
					add(rw);
					remove(0);
					updateUI();
			        //System.out.println("code excuted");
			    }
			}); 
			JOptionPane.showOptionDialog(parent, message, title, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{btnOk}, btnOk);
			
		}
		else {
			// gledam koji je tip
			// promijeniti zaglavlje, na odjavi
			JOptionPane.showMessageDialog(parent, message);
			//KupacView kv = new KupacView(preduzece);
			//
			preduzece = dpcon.getPreduzece();
			//ProizvodiView bw = new ProizvodiView(preduzece);
			MenadzerView mv = new MenadzerView(preduzece, frame);
			//frame.getHeader().getPrijava().setText("Odjava");
			//frame.getHeader().updateUI();
			//Window w = SwingUtilities.getWindowAncestor(this);
			//add(w);
			//remove(0);
			//updateUI();
			frame.getView().add(mv);
			frame.getView().remove(0);
			frame.getView().updateUI();
			//System.out.println(preduzece.trenutnoUlogovani.getIme());
		}
		
		
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public DodavanjeProizvodaController getDpcon() {
		return dpcon;
	}

	public void setDpcon(DodavanjeProizvodaController dpcon) {
		this.dpcon = dpcon;
	}

	public JPanel getPnlContent() {
		return pnlContent;
	}

	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
	}

	public JLabel getLblid() {
		return lblid;
	}

	public void setLblid(JLabel lblid) {
		this.lblid = lblid;
	}

	public JTextField getTfid() {
		return tfid;
	}

	public void setTfid(JTextField tfid) {
		this.tfid = tfid;
	}

	public JLabel getLblnaziv() {
		return lblnaziv;
	}

	public void setLblnaziv(JLabel lblnaziv) {
		this.lblnaziv = lblnaziv;
	}

	public JTextField getTfnaziv() {
		return tfnaziv;
	}

	public void setTfnaziv(JTextField tfnaziv) {
		this.tfnaziv = tfnaziv;
	}

	public JLabel getLblopis() {
		return lblopis;
	}

	public void setLblopis(JLabel lblopis) {
		this.lblopis = lblopis;
	}

	public JTextField getTfopis() {
		return tfopis;
	}

	public void setTfopis(JTextField tfopis) {
		this.tfopis = tfopis;
	}

	public JLabel getLblkategorija() {
		return lblkategorija;
	}

	public void setLblkategorija(JLabel lblkategorija) {
		this.lblkategorija = lblkategorija;
	}

	public JTextField getTfkategorija() {
		return tfkategorija;
	}

	public void setTfkategorija(JTextField tfkategorija) {
		this.tfkategorija = tfkategorija;
	}

	public JLabel getLblcena() {
		return lblcena;
	}

	public void setLblcena(JLabel lblcena) {
		this.lblcena = lblcena;
	}

	public JTextField getTfcena() {
		return tfcena;
	}

	public void setTfcena(JTextField tfcena) {
		this.tfcena = tfcena;
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
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
	
	

}
