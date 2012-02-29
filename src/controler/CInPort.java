package controler;

import kernel.InPort;
import gui.impl.subpresentation.PresentationInPortImpl;

/**
 * controller of InPort
 */

public class CInPort {
	
	/**
	 * Constructor of CInPort
	 * @param id
	 */
	
	public CInPort( int id ){
		presentation = new PresentationInPortImpl();
		presentation.setControl( this );
		this.id = id;
	}
	
	/**
	 * getters and setters of inport and its presentation
	 * @return
	 */
	
	public PresentationInPortImpl getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationInPortImpl presentation) {
		this.presentation = presentation;
	}

	/**
	 * getter and setter of InPort ID
	 * @return
	 */
	
	public InPort getInport() {
		return inport;
	}

	public void setInport( InPort inport ) {
		this.inport = inport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private PresentationInPortImpl presentation;
	
	private InPort inport;
	
	private int id;
}
