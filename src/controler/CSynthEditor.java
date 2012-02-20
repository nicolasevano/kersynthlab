package controler;

import java.io.IOException;

import gui.impl.PresentationSynthEditor;

/**
 * 
 * @author nicolas
 *
 */
public class CSynthEditor {

	/**
	 * Public constructor create each controler and presentation layer to launch  KerSynthSound application.
	 * @throws IOException
	 */
	public CSynthEditor() throws IOException{
		presentation = new PresentationSynthEditor();
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
	
	public PresentationSynthEditor getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationSynthEditor presentation ) {
		this.presentation = presentation;
	}
	
	/** Current SynthEditor presentation */
	private PresentationSynthEditor presentation;
	/** Current controler on moduleZone */
	private CModuleZone cModuleZone;
	/** Current controler on ToolsBoxes */
	private CToolBoxes cToolBoxes;
	/** Current controler on menu */
	private CUserOption cUserOption;

}