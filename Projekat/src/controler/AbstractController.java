package controler;

import Model.AplikacijaPreduzece;
import gui.panels.AbstractPanelCM;

// apstraktni kontroler, ima view/panel/gui komponentu, i model koje azurira
// u ovoj klasi se preklapaju metode kliktanja na dugmad i sl. i azurira se model/osvezava gui komponenta

// svaki kontroler zna koja je njegova gui komponenta, pristupa njenim komponentama
public abstract class AbstractController {

	private AbstractPanelCM panel;
	private AplikacijaPreduzece aplikacija;
	
	public AbstractPanelCM getPanel() {
		return panel;
	}
	
	public void setPanel(AbstractPanelCM panel) {
		this.panel = panel;
	}
	public AplikacijaPreduzece getAplikacija() {
		return aplikacija;
	}
	public void setAplikacija(AplikacijaPreduzece aplikacija) {
		this.aplikacija = aplikacija;
	}
	public AbstractController(AbstractPanelCM panel, AplikacijaPreduzece aplikacija) {
		super();
		this.panel = panel;
		this.aplikacija = aplikacija;
	}
	public AbstractController() {
		super();
	}
	
	
	
}
