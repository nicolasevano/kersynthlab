package controler;

import gui.SynthEditor;

public class CSynthEditor {

	public CSynthEditor(){
		presentation = new SynthEditor();
		presentation.setControl( this );
		
		cUserOption = new CUserOption();
		presentation.setUserOption( cUserOption.getPresentation() );
		cToolBoxes = new CToolBoxes();
		presentation.setToolBoxes( cToolBoxes.getPresentation() );
		cModuleZone = new CModuleZone();
		presentation.setModuleZone( cModuleZone.getPresentation() );
		presentation.pack();
	}
	
	public static final void main( String...args ){
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