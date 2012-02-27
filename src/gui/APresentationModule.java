package gui;

import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import kernel.Module;



public abstract class APresentationModule extends JPanel{
	
	public Point getOrigine() {
		return origine;
	}

	public void setOrigine(Point origine) {
		this.origine = origine;
	}
	
	public Module getControl(){
		return this.control;
	}
	
	abstract public void setControl(Module module);
	
	abstract public String toString();
	
	public List<PresentationWire> getWires() {
		return wires;
	}

	public void setWires(List<PresentationWire> wires) {
		this.wires = wires;
	}
	
	public synchronized static int getCurrentPortId(){
		return currentPortId;
	}
	
	public synchronized static void setCurrentPortId( int currentPortId ){
		APresentationModule.currentPortId = currentPortId;
	}
	
	protected Module control;
	
	public abstract PresentationInPortImpl getInPort();

	public abstract void setInPort( PresentationInPortImpl inPort );
	
	public abstract PresentationOutPortImpl getOutPort();

	public abstract void setOutPort( PresentationOutPortImpl outPort );
	
	private Point origine;
	
	private static final long serialVersionUID = 1L;
	
	private static int currentPortId;
	
	private List<PresentationWire> wires = new ArrayList<PresentationWire>();

}
