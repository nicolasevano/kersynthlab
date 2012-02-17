package controler;

import kernel.impl.Out;
import gui.impl.PresentationOUTImpl;


public class COUT extends Out{
	
	public COUT(){
		presentation = new PresentationOUTImpl();
		presentation.setControle( this );
	}
	
	public PresentationOUTImpl getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationOUTImpl presentation ) {
		this.presentation = presentation;
	}
	
	private PresentationOUTImpl presentation;
}
