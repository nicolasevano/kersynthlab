package controler;

import gui.impl.PresentationVCA;
import kernel.impl.VCA;

public class CVCA extends VCA {
	
	private PresentationVCA presentation;

	public CVCA() {
		presentation = new PresentationVCA();
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public PresentationVCA getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationVCA presentation) {
		this.presentation = presentation;
	}
	
	public void setAttVCA(int att){
		
		super.setAttVCA((att == 0)? 1 : att );
	}

}
