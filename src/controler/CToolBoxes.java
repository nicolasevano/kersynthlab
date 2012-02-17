package controler;

import java.io.IOException;

import gui.impl.ToolBoxes;

public class CToolBoxes {
	
	public CToolBoxes() throws IOException{
		presentation = new ToolBoxes();
		presentation.setControl( this );
	}
	
	public ToolBoxes getPresentation() {
		return presentation;
	}

	public void setPresentation( ToolBoxes presentation ) {
		this.presentation = presentation;
	}
	
	public CModuleZone getcModuleZone() {
		return cModuleZone;
	}

	public void setcModuleZone(CModuleZone cModuleZone) {
		this.cModuleZone = cModuleZone;
	}
	
	private ToolBoxes presentation;
	
	private CModuleZone cModuleZone;

}
