package controler;

import gui.impl.PresentationModuleZone;
/**
 * 
 * @author nicolas
 *
 */
public class CModuleZone {
	
	/**
	 * Public constructor create presentation layer on module zone.
	 * create an instance of cPoubelle.
	 */
	public CModuleZone(){
		presentation = new PresentationModuleZone();
		presentation.setControl( this );
		
		cPoubelle = new CPoubelle();
		presentation.setPoubelle( cPoubelle.getPresentation() );
		
		//cOUT = new COUT();
		//presentation.setOUT( cOUT.getPresentation() );
	}
	
	public PresentationModuleZone getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationModuleZone presentation) {
		this.presentation = presentation;
	}
	
	private PresentationModuleZone presentation;
	private CPoubelle cPoubelle;
	//private COUT cOUT;
}
