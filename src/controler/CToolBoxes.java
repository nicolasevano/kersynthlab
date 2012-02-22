package controler;

import java.io.IOException;

import stringloader.IConfigurationLoader;

import gui.impl.PresentationToolBoxes;

/**
 * 
 * @author nicolas
 *
 */
public class CToolBoxes {
	
	/**
	 * Public contructor
	 * @throws IOException
	 */
	public CToolBoxes( CUserOption cmenu, IConfigurationLoader configuration ) throws IOException{
		this.cmenu = cmenu;
		this.configuration = configuration;
		presentation = new PresentationToolBoxes(configuration);
		presentation.setControl( this );
	}
	
	public PresentationToolBoxes getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationToolBoxes presentation ) {
		this.presentation = presentation;
	}
	
	public CModuleZone getcModuleZone() {
		return cModuleZone;
	}

	public void setcModuleZone(CModuleZone cModuleZone) {
		this.cModuleZone = cModuleZone;
	}
	
	public CUserOption getCmenu() {
		return cmenu;
	}

	public void setCmenu(CUserOption cmenu) {
		this.cmenu = cmenu;
	}
	
	/** current tool box presentation */
	private PresentationToolBoxes presentation;
	/** current module zone control */
	private CModuleZone cModuleZone;
	
	private CUserOption cmenu;
	
	private IConfigurationLoader configuration;

}
