package listener;

import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import command.Command;
import command.CreateWire;

public class WireListener implements MouseListener {

	private PresentationModuleZone currentPlan;
		
	private PresentationOutPortImpl outPort;
		

	@Override
	public void mouseClicked(MouseEvent arg0) {
		

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
		
		System.out.println( "outport listener call" );
		CreateWire cmdCWire = new CreateWire();
		cmdCWire.setPlan( currentPlan );
		previousCommand = ( ( ModuleMotionListener ) currentPlan.getaDML() ).getCurrentCommand();
		( ( ModuleMotionListener ) currentPlan.getaDML() ).setCurrentCommand( cmdCWire );
		currentPlan.setCurrentWire( new PresentationWire( outPort, 
														  new Point(arg0.getPoint().x + 
																    outPort.getWidth() / 2,
																    arg0.getPoint().y + 
																    outPort.getHeight() / 2
																    ) ) );
		//currentPlan.getCurrentWire().setSize( Math.abs( outPort.getCenter().x - arg0.getPoint().x),
		//		Math.abs( outPort.getCenter().y - arg0.getPoint().y) );
		Point location = new Point( 
				/*( ( PresentationOutPortImpl ) arg0.getComponent() ).getLocation().x + 
				( ( PresentationOutPortImpl ) arg0.getComponent() ).getWidth() / 2*/
				outPort.getLocation().x - outPort.getWidth() / 2,
				/*( ( PresentationOutPortImpl ) arg0.getComponent() ).getLocation().y + 
				( ( PresentationOutPortImpl ) arg0.getComponent() ).getHeight() / 2 )*/
				outPort.getLocation().y - outPort.getHeight() / 2 );
		System.out.println( "x origine = " + 
				/*( ( PresentationOutPortImpl ) arg0.getComponent() ).getLocation().x + 
				( ( PresentationOutPortImpl ) arg0.getComponent() ).getWidth() / 2*/
				( outPort.getLocation().x + outPort.getWidth() / 2 ) );
		System.out.println( "y origine = " + 
				/*( ( PresentationOutPortImpl ) arg0.getComponent() ).getLocation().y + 
				( ( PresentationOutPortImpl ) arg0.getComponent() ).getHeight() / 2*/
				( outPort.getLocation().y + outPort.getHeight() / 2 ) );
		System.out.println( "x terminal = " + ( arg0.getPoint().x + outPort.getWidth() / 2 ) );
		System.out.println( "y treminal = " + ( arg0.getPoint().y + outPort.getHeight() / 2 ) );
		currentPlan.getCurrentWire().setLocation( location );
		currentPlan.getCurrentWire().setVisible( true );
		currentPlan.add( currentPlan.getCurrentWire() , 0 );
		currentPlan.validate();
		currentPlan.repaint();
	}

	@Override
	public void mouseReleased( MouseEvent arg0 ) {
		System.out.println( "outport listener end" );
		( ( ModuleMotionListener ) currentPlan.getaDML() ).setCurrentCommand( previousCommand );
		currentPlan.setCurrentWire( null );
	}
	
	public PresentationModuleZone getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(PresentationModuleZone currentPlan) {
		this.currentPlan = currentPlan;
	}
	
	public PresentationOutPortImpl getOutPort() {
		return outPort;
	}

	public void setOutPort(PresentationOutPortImpl outPort) {
		this.outPort = outPort;
	}
	
	private Command previousCommand;

}
