package controler;

import java.io.IOException;

import gui.impl.PresentationToolBoxes;

public class CToolBoxes {
	
	public CToolBoxes() throws IOException{
		presentation = new PresentationToolBoxes();
		presentation.setControl( this );
	}
	
	public PresentationToolBoxes getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationToolBoxes presentation ) {
		this.presentation = presentation;
	}
	
	public CModuleZone getcModuleZone() {
		return cModuleZone;
	}

	public void setcModuleZone(CModuleZone cModuleZone) {
		this.cModuleZone = cModuleZone;
	}
	
	private PresentationToolBoxes presentation;
	
	private CModuleZone cModuleZone;

}
