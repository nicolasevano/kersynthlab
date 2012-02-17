package gui;

import kernel.impl.VCO.WaveForm;


public interface IPresentationVCO {

	//bouton radio
	void setFormeOnde(WaveForm wf);
	
	WaveForm getFormeOnde();


}
