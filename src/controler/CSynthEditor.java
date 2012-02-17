package controler;

import java.io.IOException;

import gui.SynthEditor;

public class CSynthEditor {

	public CSynthEditor() throws IOException{
		presentation = new SynthEditor();
		presentation.setControl( this );
		
		cUserOption = new CUserOption();
		presentation.setUserOption( cUserOption.getPresentation() );
		cToolBoxes = new CToolBoxes();
		presentation.setToolBoxes( cToolBoxes.getPresentation() );
		cModuleZone = new CModuleZone();
		presentation.setModuleZone( cModuleZone.getPresentation() );
		cToolBoxes.setcModuleZone( cModuleZone );
		presentation.pack();
	}
	
	public static final void main( String...args ) throws IOException{
		new CSynthEditor();
	}
	
	public SynthEditor getPresentation() {
		return presentation;
	}

	public void setPresentation( SynthEditor presentation ) {
		this.presentation = presentation;
	}
	
	private SynthEditor presentation;
	private CModuleZone cModuleZone;
	private CToolBoxes cToolBoxes;
	private CUserOption cUserOption;

}