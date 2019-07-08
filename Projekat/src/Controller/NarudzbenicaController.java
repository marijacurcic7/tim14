package Controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.AplikacijaPreduzece;
import Model.Placena;
import Model.Poslata;
import Model.StavkaNarudzbenice;
import View.NarudzbenicaView;
import View.StavkaNarudzbeniceView;

public class NarudzbenicaController {
	
	NarudzbenicaView view;
	AplikacijaPreduzece preduzece;
	public NarudzbenicaController(NarudzbenicaView view, AplikacijaPreduzece preduzece) {
		super();
		this.view = view;
		this.preduzece = preduzece;
		
		addListeners();
	}
	
	private void addListeners() {
		
		view.getPlati().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getNarudzbenica().setStanje(new Placena());
				NarudzbenicaView nv = new NarudzbenicaView(view.getNarudzbenica(), preduzece, view.getNev());
				view.add(nv);
				view.remove(0);
				view.updateUI();
			}
		});
		
		view.getIsporuci().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getNarudzbenica().setStanje(new Poslata());
				NarudzbenicaView nv = new NarudzbenicaView(view.getNarudzbenica(), preduzece, view.getNev());
				view.add(nv);
				view.remove(0);
				view.updateUI();
			}
		});
		
		NarudzbenicaView naview = view;
		
		view.getPregled().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JPanel pnl2 = new JPanel();
				
				JScrollPane scroll = new JScrollPane(pnl2);
				scroll.setPreferredSize(new Dimension(1100, 600));
				pnl2.setLayout(new GridLayout(0, 1));
				int i = 0;
				for(StavkaNarudzbenice sn : view.getNarudzbenica().stavkeNarudzbenice) {
					StavkaNarudzbeniceView snv = new StavkaNarudzbeniceView(sn, preduzece, naview);
					
					pnl2.add(snv);
					i+=10;
				}
				view.getNev().add(scroll);
				view.getNev().remove(0);
				view.getNev().updateUI();
			}
		});
		
	}
	
	
	
	

}
