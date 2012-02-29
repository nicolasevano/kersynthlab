package listener;

import gui.APresentationModule;
import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

import command.Command;
import command.CreateWire;
import controler.CWire;

/**
 * Mouse listeners in module
 */

public class ModuleListener extends MouseAdapter{
	
	public void mousePressed(MouseEvent e){
		if( currentPlan.getComponentAt(e.getPoint()) instanceof APresentationModule ){
			APresentationModule module = (APresentationModule) currentPlan.getComponentAt( e.getPoint() );
			Component tmp = module.getComponentAt(e.getPoint().x - module.getX(), e.getPoint().y - module.getY());
			if(tmp instanceof PresentationOutPortImpl){
				CreateWire cmdCWire = new CreateWire();
				cmdCWire.setPlan( currentPlan );
				motionPreviousCmd = ( ( ModuleMotionListener ) ( ( PresentationModuleZone ) currentPlan ).getaDML() ).getCurrentCommand();
				( ( ModuleMotionListener ) ( ( PresentationModuleZone ) currentPlan ).getaDML() ).setCurrentCommand( cmdCWire );
				PresentationOutPortImpl outPort = ( PresentationOutPortImpl ) tmp;
				CWire currentWire = new CWire( outPort, 
						  					   new Point(e.getPoint().x + outPort.getWidth() / 2,
						  							     e.getPoint().y + outPort.getHeight() / 2
						  					   ) );
				currentWire.setModule( module.getControl() );
				module.getWires().add( currentWire.getPresentation() );
				( ( PresentationModuleZone ) currentPlan ).setCurrentWire( currentWire.getPresentation() ); 
				Point location = new Point( 
						outPort.getLocation().x - outPort.getWidth() / 2,
						outPort.getLocation().y - outPort.getHeight() / 2 
						);
				( ( PresentationModuleZone ) currentPlan ).getCurrentWire().setLocation( location );
				( ( PresentationModuleZone ) currentPlan ).getCurrentWire().setVisible( true );
				currentPlan.add( ( ( PresentationModuleZone ) currentPlan ).getCurrentWire() , 0 );
				currentPlan.validate();
				currentPlan.repaint();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		deleteCommand.execute( e.getPoint() );
		( ( PresentationModuleZone ) currentPlan ).setSelected( null );
		if( motionPreviousCmd != null ){
			( ( ModuleMotionListener ) 
					( ( PresentationModuleZone ) currentPlan ).getaDML() 
					).setCurrentCommand(motionPreviousCmd);
			motionPreviousCmd = null;
			if( currentPlan.getComponentAt( e.getPoint().x + 10, e.getPoint().y + 10  ) instanceof APresentationModule ){
				APresentationModule module = (APresentationModule) currentPlan.getComponentAt( e.getPoint().x + 10, e.getPoint().y + 10 );
				Component tmp = module.getComponentAt(e.getPoint().x - module.getX(), e.getPoint().y - module.getY());
				attachWireToInport( tmp );
			} else if(currentPlan.getComponentAt( e.getPoint().x - 10, e.getPoint().y + 10  ) instanceof APresentationModule){
				APresentationModule module = (APresentationModule) currentPlan.getComponentAt( e.getPoint().x - 10, e.getPoint().y + 10 );
				Component tmp = module.getComponentAt(e.getPoint().x - module.getX(), e.getPoint().y - module.getY());
				attachWireToInport( tmp );
			} else if(currentPlan.getComponentAt( e.getPoint().x + 10, e.getPoint().y - 10  ) instanceof APresentationModule){
				APresentationModule module = (APresentationModule) currentPlan.getComponentAt( e.getPoint().x + 10, e.getPoint().y - 10 );
				Component tmp = module.getComponentAt(e.getPoint().x - module.getX(), e.getPoint().y - module.getY());
				attachWireToInport( tmp );
			} else if(currentPlan.getComponentAt( e.getPoint().x - 10, e.getPoint().y - 10  ) instanceof APresentationModule){
				APresentationModule module = (APresentationModule) currentPlan.getComponentAt( e.getPoint().x - 10, e.getPoint().y - 10 );
				Component tmp = module.getComponentAt(e.getPoint().x - module.getX(), e.getPoint().y - module.getY());
				attachWireToInport( tmp );
			} else {
				( ( APresentationModule )( ( PresentationModuleZone ) currentPlan ).getCurrentWire().getOutPort().getParent()).getWires().remove(
						( ( PresentationModuleZone ) currentPlan ).getCurrentWire() );
				( ( PresentationModuleZone ) currentPlan ).remove( ( ( PresentationModuleZone ) currentPlan ).getCurrentWire() );
			}
			( ( PresentationModuleZone ) currentPlan ).setCurrentWire( null );
		}
		( ( PresentationModuleZone ) currentPlan ).validate();
		( ( PresentationModuleZone ) currentPlan ).repaint();
	}
	
	public void mouseWheelMoved (MouseWheelEvent e) {
	
	}

	private void attachWireToInport( Component comp ){
		
		if( comp instanceof PresentationInPortImpl ){
			
			PresentationInPortImpl inPort = ( PresentationInPortImpl ) comp;
			( ( PresentationModuleZone ) currentPlan ).getCurrentWire().setInPort( inPort );
			( ( PresentationModuleZone ) currentPlan ).getCurrentWire().getControl().attachPorts();
			( ( APresentationModule ) comp.getParent() ).getWires().add( ( ( PresentationModuleZone ) currentPlan ).getCurrentWire() );
			WireListener wireListener = new WireListener();
			wireListener.setCurrentPlan( ( PresentationModuleZone ) currentPlan );
			wireListener.setWire( ( ( PresentationModuleZone ) currentPlan ).getCurrentWire() );
			( ( PresentationModuleZone ) currentPlan ).getCurrentWire().setWireListener( wireListener );
			
		}
		
	}
	
	public void mouseClicked( MouseEvent arg0 ) {
		
		if( command != null ){
			command.execute( arg0.getPoint() );
			currentPlan.add( command.getModule(), 0 );
			command.getModule().repaint();
			currentPlan.repaint();
		}
		
	}

	public void mouseEntered( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}
	
	public void setCommand( Command command ){
		this.command = command;
	}
	
	public Command getCommand(){
		return this.command;
	}
	
	public JPanel getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan( JPanel currentPlan ) {
		this.currentPlan = currentPlan;
	}
	
	public Command getDeleteCommand() {
		return deleteCommand;
	}

	public void setDeleteCommand(Command deleteCommand) {
		this.deleteCommand = deleteCommand;
	}
	
	/**
	 * 
	 */
	private Command command;
	
	/**
	 * 
	 */
	private Command motionPreviousCmd;
	
	/**
	 * 
	 */
	private Command deleteCommand;
	
	/**
	 * 
	 */
	private JPanel currentPlan;

}
