package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	
	MainFrame frame;
	
	// jscrollpane ce primiti pnlContent, a u pnlContent redamo stavke narudzbenice
	private JPanel pnlContent;
	
	public KorpaView(AplikacijaPreduzece ap, MainFrame mf) {
		this.preduzece = ap;
		this.korpa = ap.getKorpa();
		this.kupi = new JButton("Kupi");
		this.isprazni = new JButton("Isprazni korpu");
		this.pnl = new JPanel();
		constructGUI();
	}
	
	private void constructGUI() {
		pnlContent = new JPanel();
		
		pnlContent.setLayout(new GridLayout(preduzece.korpa.stavkeNarudzbenice.size(), 1));
		//pnlContent.setPreferredSize(new Dimension(500, 700));
		//pnlContent.setLayout(new GridLayout(0, 1));
		
		int i = 0;
		for(StavkaNarudzbenice sn : korpa.getStavkaNarudzbenice()) {
			
			StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, this);
			pnlContent.add(snv, new GridBagConstraints(0, i, 1, 1, 0, 0, GridBagConstraints.WEST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			//add(new JLabel(sn.proizvod.getNaziv()));
			i+=10;
		}
		JPanel linija = new JPanel(new GridLayout(3, 0));
		linija.add(kupi);
		linija.add(isprazni);
		//linija.add(new JButton("asdasd"));
		//pnlContent.add(linija);
		scroll = new JScrollPane(pnlContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(1000, 600));
		
		pnl.add(scroll);
		pnl.add(linija);
		add(pnl);
		//add(pnlContent);
		
		isprazni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preduzece.korpa = new Narudzbenica();
				//korpa = new Narudzbenica();
				KorpaView kv = new KorpaView(preduzece, frame);
				add(kv);
				remove(0);
				updateUI();
			}
		});
		
		kupi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					//loginv.setVisible(false);
					//System.out.println("");
					//removeAll();
					//NarudzbenicaDialog nd = new NarudzbenicaDialog();
					
					//JOptionPane.showOptionDialog(this, nd, "Narudzbenica", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
					//add(nd);
					
					//nd.show();
					//nd.setVisible(true);
					if (korpa.stavkeNarudzbenice.size()==0) {
						Window w = SwingUtilities.getWindowAncestor(kupi);
						JOptionPane.showMessageDialog(w, "Korpa je prazna");
					}
					else if(preduzece.trenutnoUlogovani == null) {
						//RegistracijaView rv = new RegistracijaView(preduzece, frame);
						
						//login -> nullpointerexception
						/*LogInView rv = new LogInView(preduzece, frame);
						add(rv);
						remove(0);
						updateUI();*/
						
						//samo poruka
						
						Window w = SwingUtilities.getWindowAncestor(kupi);
						JOptionPane.showMessageDialog(w, "Ulogujte se");
						
					}
					else {
						FormiranjeNarudzbeniceView fnv = new FormiranjeNarudzbeniceView(preduzece, frame);
						add(fnv);
						remove(0);
						updateUI();
					}
				
					
					
					//rv.setVisible(true);
					//setVisible(false);
					
				}
		});
	}

}
