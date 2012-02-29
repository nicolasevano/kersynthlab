package controler;

import kernel.Module;
import gui.impl.subpresentation.PresentationOutPortImpl;

/**
 * Controller of OutPort
 */

public class COutPort {
	
	/**
	 * Constructor of COutPort
	 * define a ID for every OutPort
	 * @param id
	 */
	
	public COutPort(int id){
		
		presentation = new PresentationOutPortImpl();
		presentation.setControl( this );
		this.id = id;
		
	}

	public PresentationOutPortImpl getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationOutPortImpl presentation) {
		this.presentation = presentation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}
	
	private PresentationOutPortImpl presentation;
	
	private Module module;
	
	private int id;

}
