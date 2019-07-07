package Controller;

import Model.AplikacijaPreduzece;
import Model.Narudzbenica;
import Model.StavkaNarudzbenice;
import View.KorpaView;

public class KorpaController {
	
	private KorpaView kv;
	private AplikacijaPreduzece preduzece;
	private Narudzbenica korpa;
	
	public KorpaController(KorpaView kv, AplikacijaPreduzece ap) {
		
		this.kv = kv;
		this.preduzece = ap;
		
	}
	
	public void dodajUKorpu(StavkaNarudzbenice sn) {
		
	}

}
