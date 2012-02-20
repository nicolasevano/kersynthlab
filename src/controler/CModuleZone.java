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
	public CModuleZone( CUserOption cmenu ){
		this.cmenu = cmenu;
		presentation = new PresentationModuleZone();
		presentation.setControl( this );
		cPoubelle = new CPoubelle();
		presentation.setPoubelle( cPoubelle.getPresentation() );
		
	}
	
	public PresentationModuleZone getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationModuleZone presentation) {
		this.presentation = presentation;
	}
	
	public CUserOption getCmenu() {
		return cmenu;
	}

	public void setCmenu(CUserOption cmenu) {
		this.cmenu = cmenu;
	}
	
	private PresentationModuleZone presentation;
	private CPoubelle cPoubelle;
	
	private CUserOption cmenu;
	//private COUT cOUT;

}
