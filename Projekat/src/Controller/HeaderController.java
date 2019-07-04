package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.BaseView;
import View.HeaderView;
import View.LogInView;


public class HeaderController {

	HeaderView panel;
	BaseView view;

			
		
		/*x.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      //your code here
				    	System.out.println("Nesto se desilo");
				    }
				  }
				);*/
	

	public HeaderController(HeaderView panel, BaseView base) {
		super();
		this.panel = panel;
		this.view = base;
		this.panel.getKorpa().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      //your code here
			    	System.out.println("Nesto se desilo");
			    }
			
		});
		
		
		panel.getPrijava().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//bw.setVisible(false);
				LogInView lv = new LogInView();
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
