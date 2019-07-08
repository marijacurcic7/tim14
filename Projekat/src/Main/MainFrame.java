package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;

import Controller.HeaderController;
import Model.AplikacijaPreduzece;
import Model.Kategorija;
import Model.Korisnik;
import Model.Nalog;
import Model.Narudzbenica;
import Model.Proizvod;
import Model.RegistrovaniKupac;
import Model.StavkaCenovnika;
import Model.StavkaNarudzbenice;
import Model.TipKorisnika;
import View.BaseView;
import View.HeaderView;
import View.ProizvodiView;
import gui.panels.SviProizvodiPanel;
// commit

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1366462111697644313L;
	public static final String APP_TITLE = "Nas WebShop";

	JScrollPane skrol;
	JButton login;
	JButton korpa;
	JLabel broj;
	JLabel labela;
	JLabel naslov;
	JPanel glavni;
	JPanel p;
	SviProizvodiPanel bw;
	public JSplitPane split;
	JPanel ovajStoSeMenja;
	JPanel centralni;

	BaseView view;
	HeaderView header;
	HeaderController headerController;
	
	AplikacijaPreduzece preduzece;
	Korisnik trenUlogovani;
	
	JButton prijava;


	public MainFrame() throws IOException {
		
		preduzece = new AplikacijaPreduzece();
		System.out.println(preduzece.proizvodi.size() + 1);
		//izgenerisiPreduzece();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setLocationRelativeTo(null);
		
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                
            	try {
            		preduzece.pisanjeUFajl();
            		
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
		
		header = new HeaderView(preduzece);
		
		centralni = new JPanel();
		centralni.setPreferredSize(new Dimension(1600, 600));
		
		ovajStoSeMenja = new JPanel();
		
		ProizvodiView bw = new ProizvodiView(ovajStoSeMenja, preduzece, preduzece.proizvodi);  // da on vidi frejm? zbog dimenzija
		view = bw;
		
		centralni.add(new ProizvodiView(centralni, preduzece, preduzece.proizvodi)); 	// izmeniti
		
		bw.setMaximumSize(new Dimension(1000, 400));
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(header);
		
		JLabel slika = new JLabel();
		
		File currentDir = new File("");
		String sep = File.separator;
		String backgr = currentDir.getAbsolutePath() + sep + "slike" + sep +"background5.jpg";
		
		slika.setIcon(new ImageIcon(new ImageIcon(backgr).getImage().getScaledInstance(2000, 200, Image.SCALE_DEFAULT)));
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel drugiPanel = new JPanel();
		JPanel gornjiPanel = new JPanel();
		panel.add(gornjiPanel, BorderLayout.PAGE_START);
		gornjiPanel.setPreferredSize(new Dimension(1100, 30));
		drugiPanel.add(slika);
		drugiPanel.setPreferredSize(new Dimension(0, 200));
		panel.add(bw);
		
		panel.add(centralni, BorderLayout.CENTER);
		panel.add(drugiPanel, BorderLayout.PAGE_END);
		
		ovajStoSeMenja = centralni;
		
		split.setBottomComponent(panel);
		split.setDividerLocation(0.8);
		
		skrol = new JScrollPane(split);	
		add(skrol, BevelBorder.RAISED);		
		
		headerController = new HeaderController(header, view, preduzece, this); 
	    
		//ispis();
	}

	
	public void ispis() {
		System.out.println("\n\n-----------------------------------------------\n");
		for(Korisnik k : preduzece.korisnici) {
			System.out.println(k.nalog.getKorisnickoIme()+" "+k.nalog.getLozinka()+" "+k.nalog.getTipKorisnika());
			if(k.getClass().equals(RegistrovaniKupac.class)) {
				RegistrovaniKupac rk = (RegistrovaniKupac)k;
				for(Narudzbenica n : rk.narudzbenice) {
					System.out.println("Narudzbenica "+n.getId());
					for(StavkaNarudzbenice sn : n.stavkeNarudzbenice) {
						System.out.println(sn.proizvod.getNaziv());
					}
				}
			}
			System.out.println("");
		}
		System.out.println("");
		for(Narudzbenica n : preduzece.narudzbenice) {
			System.out.println("Narudzbenica "+n.getId());
			for(StavkaNarudzbenice sn : n.stavkeNarudzbenice) {
				System.out.println(sn.proizvod.getNaziv());
			}
			System.out.println("");
		}
		System.out.println("Korpa");
		for(StavkaNarudzbenice sn : preduzece.korpa.stavkeNarudzbenice) {
			System.out.println(sn.proizvod.getNaziv());
		}
		System.out.println("");
		for(Kategorija k : preduzece.kategorije) {
			System.out.println(k.getNaziv());
		}
	}
	
	public void izgenerisiPreduzece() {
		
		File currentDir = new File("");
		String sep = File.separator;
		String put = currentDir.getAbsolutePath() + sep + "slike" + sep + "solja.jpg";
		//put = "C:\\Users\\Korisnik\\Desktop\\sims_webshop\\tim14\\Projekat\\slike\\solja.jpg";
		String fld = currentDir.getAbsolutePath() + sep + "slike" + sep;

		
		Kategorija kat = new Kategorija("Kuhinja");
		Kategorija k = new Kategorija("Posudje", kat);
		Kategorija k1 = new Kategorija("Escajg", kat);
		Kategorija kat2 = new Kategorija("Garderoba");
		Kategorija k2 = new Kategorija("Zenska garderoba", kat2);
		Kategorija k22 = new Kategorija("Muska garderoba", kat2);
		
		preduzece.addKategorija(kat);
		preduzece.addKategorija(k);
		preduzece.addKategorija(k1);
		preduzece.addKategorija(kat2);
		preduzece.addKategorija(k2);
		preduzece.addKategorija(k22);
		
		Proizvod p = new Proizvod(1, "Solja", "bela, velika", k, fld + "solja.jpg");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date datum = new Date(System.currentTimeMillis());
		StavkaCenovnika sc = new StavkaCenovnika(100, datum, p);
		p.setAktuelnaCena(sc);
		
		Proizvod p2 = new Proizvod(2, "Viljuska", "metalna", k1, fld + "viljuska.jpg");
		StavkaCenovnika c2 = new StavkaCenovnika(500, datum, p2);
		p2.setAktuelnaCena(c2);
		System.out.println(p2.getPutanja());
		
		
		preduzece.addProizvod(p);
		preduzece.addProizvod(p2);

		
		Proizvod p42 = new Proizvod(3, "Noz", "metalni", k1, fld + "noz.jpg");
		StavkaCenovnika c42 = new StavkaCenovnika(500, datum, p42);
		p42.setAktuelnaCena(c42);
		preduzece.addProizvod(p42);
		

		Proizvod p44 = new Proizvod(4, "Kasicica", "zlatna", k1, fld + "kasika.jpg");
		StavkaCenovnika c44 = new StavkaCenovnika(500, datum, p44);
		p44.setAktuelnaCena(c44);
		preduzece.addProizvod(p44);
		

		Proizvod p45 = new Proizvod(5, "Kravata", "vunena", k22, fld + "kravata.jpg");
		StavkaCenovnika c45 = new StavkaCenovnika(500, datum, p45);
		p45.setAktuelnaCena(c45);
		preduzece.addProizvod(p45);
		
		
		Proizvod p3 = new Proizvod(6, "Case", "staklene", k, fld +  "case.jpg");
		StavkaCenovnika c3 = new StavkaCenovnika(500, datum, p3);
		p3.setAktuelnaCena(c3);
		preduzece.addProizvod(p3);
		
		Proizvod p4 = new Proizvod(7, "Kosulja", "crna, svilena", k2, fld + "default.jpg");
		StavkaCenovnika c4 = new StavkaCenovnika(1500, datum, p4);
		p4.setAktuelnaCena(c4);
		preduzece.addProizvod(p4);
		
		Proizvod p5 = new Proizvod(8, "Kapa", "zenska, roze", k2, fld + "kapa.jpg");
		StavkaCenovnika c5 = new StavkaCenovnika(10000, datum, p5);
		p5.setAktuelnaCena(c5);
		preduzece.addProizvod(p5);
		
		
		Proizvod p6 = new Proizvod(9, "Mikrovalna", "crna", kat, fld + "mikrovalna.jpg");
		StavkaCenovnika c6 = new StavkaCenovnika(100000, datum, p6);
		p6.setAktuelnaCena(c6);
		preduzece.addProizvod(p6);
		preduzece.addStavkaCenovnika(c6);
		
		Proizvod p7 = new Proizvod(10, "Sal", "sareni, zenski", k2, fld + "sal.jpg");
		StavkaCenovnika c7 = new StavkaCenovnika(800, datum, p7);
		p7.setAktuelnaCena(c7);
		preduzece.addProizvod(p7);
		preduzece.addStavkaCenovnika(c7);
		
		
		preduzece.addStavkaCenovnika(sc);
		preduzece.addStavkaCenovnika(c2);
		preduzece.addStavkaCenovnika(c3);
		preduzece.addStavkaCenovnika(c4);
		preduzece.addStavkaCenovnika(c5);
		
		
		Nalog nalog = new Nalog();
		nalog.setKorisnickoIme("menadzer");
		nalog.setLozinka("menadzer");
		nalog.setTipKorisnika(TipKorisnika.menadzer);
		Korisnik kor = new Korisnik("ime", "prezime", null, null, nalog);
		preduzece.addKorisnici(kor);
		
		Nalog nalog1 = new Nalog();
		nalog1.setKorisnickoIme("admin");
		nalog1.setLozinka("admin");
		nalog1.setTipKorisnika(TipKorisnika.administrator);
		Korisnik kor1 = new Korisnik("admin", "admin", null, null, nalog1);
		preduzece.addKorisnici(kor1);
		//System.out.println("asdas");
		//System.out.println(preduzece.korisnici.size());
	}

	public static void main(String[] args) throws IOException {
		new MainFrame().setVisible(true);
		
	}
	
	public JPanel getCentralni() {
		return centralni;
	}


	public void setCentralni(JPanel centralni) {
		this.centralni = centralni;
	}

	public JScrollPane getSkrol() {
		return skrol;
	}

	public void setSkrol(JScrollPane skrol) {
		this.skrol = skrol;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getKorpa() {
		return korpa;
	}
	
	public void setKorpa(JButton korpa) {
		this.korpa = korpa;
	}

	public JLabel getBroj() {
		return broj;
	}

	public void setBroj(JLabel broj) {
		this.broj = broj;
	}

	public JLabel getLabela() {
		return labela;
	}

	public void setLabela(JLabel labela) {
		this.labela = labela;
	}

	public JLabel getNaslov() {
		return naslov;
	}

	public void setNaslov(JLabel naslov) {
		this.naslov = naslov;
	}

	public JPanel getGlavni() {
		return glavni;
	}

	public void setGlavni(JPanel glavni) {
		this.glavni = glavni;
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}

	public SviProizvodiPanel getBw() {
		return bw;
	}

	public void setBw(SviProizvodiPanel bw) {
		this.bw = bw;
	}

	public JSplitPane getSplit() {
		return split;
	}

	public void setSplit(JSplitPane split) {
		this.split = split;
	}

	public BaseView getView() {
		return view;
	}

	public void setView(BaseView view) {
		this.view = view;
	}

	public HeaderView getHeader() {
		return header;
	}

	public void setHeader(HeaderView header) {
		this.header = header;
	}

	public HeaderController getHeaderController() {
		return headerController;
	}

	public void setHeaderController(HeaderController headerController) {
		this.headerController = headerController;
	}

	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Korisnik getTrenUlogovani() {
		return trenUlogovani;
	}

	public void setTrenUlogovani(Korisnik trenUlogovani) {
		this.trenUlogovani = trenUlogovani;
	}

	public JButton getPrijava() {
		return prijava;
	}

	public void setPrijava(JButton prijava) {
		this.prijava = prijava;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getAppTitle() {
		return APP_TITLE;
	}
	
	public JPanel getOvajStoSeMenja() {
		return ovajStoSeMenja;
	}

	public void setOvajStoSeMenja(JPanel ovajStoSeMenja) {
		this.ovajStoSeMenja = ovajStoSeMenja;
	}

}
