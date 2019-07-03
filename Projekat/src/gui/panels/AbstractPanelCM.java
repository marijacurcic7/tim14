package gui.panels;

import javax.swing.JPanel;

import Model.AplikacijaPreduzece;
import controler.AbstractController;


// klasa koju nasledjuju paneli koji imaju kontroler i model
public abstract class AbstractPanelCM extends JPanel {

	AbstractController controller;
	AplikacijaPreduzece preduzece;
	public AbstractController getController() {
		return controller;
	}
	public void setController(AbstractController controller) {
		this.controller = controller;
	}
	public AplikacijaPreduzece getPreduzece() {
		return preduzece;
	}
	public void setPreduzece(AplikacijaPreduzece preduzece) {
		this.preduzece = preduzece;
	}
	public AbstractPanelCM(AbstractController controller, AplikacijaPreduzece preduzece) {
		super();
		this.controller = controller;
		this.preduzece = preduzece;
	}
	public AbstractPanelCM() {
		super();
	}
	
	
	
}
