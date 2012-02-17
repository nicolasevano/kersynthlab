package controler;

import kernel.impl.Out;
import gui.presentationOUTImpl;


public class COUT extends Out{
	
	public COUT(){
		presentation = new presentationOUTImpl();
		presentation.setControle( this );
	}
	
	public presentationOUTImpl getPresentation() {
		return presentation;
	}

	public void setPresentation( presentationOUTImpl presentation ) {
		this.presentation = presentation;
	}
	
	private presentationOUTImpl presentation;
}
