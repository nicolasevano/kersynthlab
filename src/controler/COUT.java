package controler;

import kernel.impl.Out;
import gui.impl.PresentationOUTImpl;

/**
 * 
 * @author nicolas
 *
 */
public class COUT extends Out{
	
	/**
	 * public constructor
	 */
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
	
	/** current sound card presentation */
	private PresentationOUTImpl presentation;
}
