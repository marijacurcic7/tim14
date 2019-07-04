package View;

import Controller.AplikacijaController;
import Model.AplikacijaPreduzece;

public class AplikacijaView {
	
	private AplikacijaPreduzece ap;
	private AplikacijaController apcontroller;
	
	public AplikacijaView(AplikacijaPreduzece ap, AplikacijaController apc) {
		this.ap = ap;
		this.apcontroller = apc;
	}

}
