package listener;

import gui.APresentationModule;
import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 * Wire listener
 * Monitor wire changes 
 */

public class WireListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int result = JOptionPane.showConfirmDialog( ( Component ) null, title,
				message, JOptionPane.OK_CANCEL_OPTION );
		if( result == JOptionPane.OK_OPTION ){
			wire.getControl().detachPorts();
			( ( APresentationModule ) wire.getOutPort().getParent() ).getWires().remove( wire );
			( ( APresentationModule ) wire.getInPort().getParent() ).getWires().remove( wire );
			currentPlan.remove( wire );
			currentPlan.validate();
			currentPlan.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased( MouseEvent arg0 ) {
	}
	
	public PresentationModuleZone getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(PresentationModuleZone currentPlan) {
		this.currentPlan = currentPlan;
	}
	
	public PresentationWire getWire() {
		return wire;
	}

	public void setWire(PresentationWire wire) {
		this.wire = wire;
	}
	
	private PresentationModuleZone currentPlan;
	
	private PresentationWire wire;
	
	private String message = "câble dialogue:";
	
	private String title = " Voulez vous supprimer ce câble? ";
	
}
