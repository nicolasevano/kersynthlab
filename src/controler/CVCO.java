package controler;

import kernel.impl.VCO;
import gui.impl.PresentationVCO;

public class CVCO extends VCO {
	
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
	
	private PresentationVCO presentation;
	
}
