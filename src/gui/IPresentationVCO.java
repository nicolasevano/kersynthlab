package gui;

import kernel.impl.vco.VCO.WaveForm;

/**
 * Interface of PresentationVCO
 */

public interface IPresentationVCO {

	/**button radio*/
	void setFormeOnde(WaveForm wf);
	
	WaveForm getFormeOnde();


}
