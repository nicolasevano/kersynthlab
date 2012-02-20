package controler;

import java.io.IOException;

import gui.impl.PresentationToolBoxes;

/**
 * 
 * @author nicolas
 *
 */
public class CToolBoxes {
	
	/**
	 * Public contructor
	 * @throws IOException
	 */
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
	
	/** current tool box presentation */
	private PresentationToolBoxes presentation;
	/** current module zone control */
	private CModuleZone cModuleZone;

}
