package controler;

import java.awt.Point;

import kernel.InPort;
import kernel.Module;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.PresentationWire;

public class CWire {
	
	public CWire(PresentationOutPortImpl outPort, Point pDest){
		presentation = new PresentationWire( outPort, pDest );
		presentation.setControl( this );
	}
	
	public CWire( String savedOne ){
		presentation = new PresentationWire( savedOne );
		presentation.setControl( this );
	}
	
	public PresentationWire getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationWire presentation) {
		this.presentation = presentation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	public InPort getInport() {
		return inport;
	}

	public void setInport(InPort inport) {
		this.inport = inport;
	}
	
	public void attachPorts(){
		module.addObserver( inport );
	}
	
	public void detachPorts(){
		module.removeObserver( inport );
	}
	
	private Module module;

	private InPort inport;
	
	private PresentationWire presentation;

}
