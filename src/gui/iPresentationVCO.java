package gui;

import kernel.impl.VCO.WaveForm;


public interface iPresentationVCO {

	//bouton radio
	void setFormeOnde(WaveForm wf);
	
	WaveForm getFormeOnde();


}
