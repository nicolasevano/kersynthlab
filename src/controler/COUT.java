package controler;

import gui.presentationOUTImpl;


public class COUT {
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
