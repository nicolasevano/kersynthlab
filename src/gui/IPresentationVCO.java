package gui;

import kernel.impl.vco.VCO.WaveForm;


public interface IPresentationVCO {

	//bouton radio
	void setFormeOnde(WaveForm wf);
	
	WaveForm getFormeOnde();


}
