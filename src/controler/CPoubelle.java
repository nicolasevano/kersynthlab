package controler;

import gui.impl.PresentationPoubelle;

/**
 * 
 * @author nicolas
 *
 */
public class CPoubelle {
	
	/**
	 * Public constructor
	 */
	public CPoubelle(){
		presentation = new PresentationPoubelle();
		presentation.setControl( this );
	}
	
	public PresentationPoubelle getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationPoubelle presentation ) {
		this.presentation = presentation;
	}
	
	/** current garbage presentation */
	private PresentationPoubelle presentation;
	
}
