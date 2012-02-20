package controler;

import kernel.impl.adsr.ADSR;
import gui.impl.PresentationADSR;

public class CADSR extends ADSR{
	
	public CADSR(){
		
		presentation = new PresentationADSR();
		presentation.setControl( this );
		presentation.initListener();
		
	}

	public PresentationADSR getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationADSR presentation) {
		this.presentation = presentation;
	}
	
	private PresentationADSR presentation;

}
