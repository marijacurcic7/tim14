package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Main.MainFrame;
import Model.AplikacijaPreduzece;
import View.BaseView;
import View.HeaderView;
import View.KorpaView;
import View.LogInView;
import View.ProizvodiView;


public class HeaderController {

	AplikacijaPreduzece preduzece;
	HeaderView panel;
	BaseView view;

	MainFrame frame;
		
		/*x.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      //your code here
				    	System.out.println("Nesto se desilo");
				    }
				  }
				);*/
	

	public HeaderController(HeaderView panel, BaseView base, AplikacijaPreduzece preduzece, MainFrame frame) {
		super();
		
		this.frame = frame;
		
		this.preduzece = preduzece;
		this.panel = panel;
		this.view = base;
		this.panel.getKorpa().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	System.out.println("Nesto se desilo");
			    	//panel.getPrijava().setText("Odjava");
			    	//panel.updateUI();
			    	KorpaView kv = new KorpaView(preduzece);
			    	view.add(kv);
			    	view.remove(0);
					view.updateUI();
			    }
			
		});
		
		
		panel.getPrijava().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//bw.setVisible(false);
				
				if (preduzece.trenutnoUlogovani != null) {
					frame.getHeader().getPrijava().setText("Prijava");
					frame.getHeader().updateUI();
					preduzece.trenutnoUlogovani = null;
					String message = "Uspesno ste se izlogovali.";
					JOptionPane.showMessageDialog(null, message);
					ProizvodiView bw = null;
					try {
						bw = new ProizvodiView(preduzece);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.getView().add(bw);
					frame.getView().remove(0);
					frame.getView().updateUI();
					return;
				}
				
				LogInView lv = new LogInView(preduzece, frame);
				//split.setBottomComponent(lv);
				view.add(lv);
				view.remove(0);
				view.updateUI();
			}
		});
		
	}



	public HeaderView getPanel() {
		return panel;
	}



	public void setPanel(HeaderView panel) {
		this.panel = panel;
	}



	public HeaderController() {
		super();
	}
	
	
	
	
}
