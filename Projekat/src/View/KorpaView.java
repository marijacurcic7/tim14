package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Controller.KorpaController;
import Main.MainFrame;
import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;

public class KorpaView extends JPanel {
	
	private KorpaController korpacon;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	private JScrollPane scroll;
	private JButton kupi;
	private JButton isprazni;
	private JPanel pnl;
	private JLabel ukupnaCena;
	
	MainFrame frame;
	
	private JPanel pnlContent;
	
	public KorpaView(AplikacijaPreduzece ap, MainFrame mf) {
		this.preduzece = ap;
		this.korpa = ap.getKorpa();
		this.kupi = new JButton("Kupi");
		this.isprazni = new JButton("Isprazni korpu");
		this.pnl = new JPanel();
		constructGUI();
		this.korpacon = new KorpaController(this, preduzece);
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		
		pnlContent.setLayout(new GridLayout(preduzece.korpa.stavkeNarudzbenice.size(), 1));
		
		int i = 0;
		for(StavkaNarudzbenice sn : korpa.getStavkaNarudzbenice()) {
			
			StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, this);
			pnlContent.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			i+=10;
		}
		ukupnaCena = new JLabel("Ukupan iznos: "+korpa.getUkupanIznos());
		JPanel linija = new JPanel(new GridLayout(3, 0));
		linija.add(ukupnaCena);
		linija.add(kupi);
		linija.add(isprazni);
		
		scroll = new JScrollPane(pnlContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(1000, 600));
		
		pnl.add(scroll);
		pnl.add(linija);
		add(pnl);
		
	}

	public KorpaController getKorpacon() {
		return korpacon;
	}

	public void setKorpacon(KorpaController korpacon) {
		this.korpacon = korpacon;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Narudzbenica getKorpa() {
		return korpa;
	}

	public void setKorpa(Narudzbenica korpa) {
		this.korpa = korpa;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JButton getKupi() {
		return kupi;
	}

	public void setKupi(JButton kupi) {
		this.kupi = kupi;
	}

	public JButton getIsprazni() {
		return isprazni;
	}

	public void setIsprazni(JButton isprazni) {
		this.isprazni = isprazni;
	}

	public JPanel getPnl() {
		return pnl;
	}

	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}

	public JLabel getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(JLabel ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
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

}
