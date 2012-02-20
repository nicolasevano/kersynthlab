package controler;

import kernel.impl.vco.VCO;
import gui.impl.PresentationVCO;

public class CVCO extends VCO {
	
	/**
	 * Public constructor.
	 */
	public CVCO(){
		presentation = new PresentationVCO();
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public PresentationVCO getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationVCO presentation ) {
		this.presentation = presentation;
	}
	
	/** Current VCO presentation. */
	private PresentationVCO presentation;
	
}
