package controler;

import gui.ModuleZone;

public class CModuleZone {
	
	public CModuleZone(){
		presentation = new ModuleZone();
		presentation.setControl( this );
	}
	
	public ModuleZone getPresentation() {
		return presentation;
	}

	public void setPresentation(ModuleZone presentation) {
		this.presentation = presentation;
	}
	
	private ModuleZone presentation;

}
