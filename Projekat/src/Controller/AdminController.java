package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.AplikacijaPreduzece;
import View.AdminView;
import View.RegistracijaView;

public class AdminController extends Controller {
	
	AplikacijaPreduzece preduzece;
	AdminView view;

	public AdminController(AdminView adminView, AplikacijaPreduzece preduzece) {
		// TODO Auto-generated constructor stub
		this.preduzece = preduzece;
		this.view = adminView;
		
		view.getDodajMenadzera().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
					RegistracijaView rv = new RegistracijaView(preduzece, view.getFrame());
					view.add(rv);
					view.remove(0);
					view.updateUI();
					
					
				}
		});

	}
	


}
