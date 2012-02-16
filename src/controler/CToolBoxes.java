package controler;

import java.io.IOException;

import gui.ToolBoxes;

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
	
	private ToolBoxes presentation;

}
