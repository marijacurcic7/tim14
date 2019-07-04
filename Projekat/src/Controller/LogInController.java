package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;

import Model.Nalog;
import View.LogInView;
import View.RegistracijaView;

public class LogInController {
	
	private LogInView loginv;
	private Nalog nalog;
	
	public LogInController(LogInView lv) {
		this.loginv = lv;
		//this.loginv.btnReg.addActionListener(new ActionListener() {

		/*@Override
		public void actionPerformed(ActionEvent e) {
				//loginv.setVisible(false);
				RegistracijaView rv = new RegistracijaView();
				lv.add(rv);
				rv.setVisible(true);
				
			}
		});*/
	}
	
	

}
