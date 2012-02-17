package controler;

import gui.impl.ModuleZone;

public class CModuleZone {
	
	public CModuleZone(){
		presentation = new ModuleZone();
		presentation.setControl( this );
		
		cPoubelle = new CPoubelle();
		presentation.setPoubelle( cPoubelle.getPresentation() );
		
		//cOUT = new COUT();
		//presentation.setOUT( cOUT.getPresentation() );
	}
	
	public ModuleZone getPresentation() {
		return presentation;
	}

	public void setPresentation(ModuleZone presentation) {
		this.presentation = presentation;
	}
	
	private ModuleZone presentation;
	private CPoubelle cPoubelle;
	//private COUT cOUT;
}
