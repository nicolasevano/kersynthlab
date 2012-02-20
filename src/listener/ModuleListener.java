package listener;

import gui.impl.PresentationModuleZone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

import command.Command;

public class ModuleListener extends MouseAdapter{
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		deleteCommand.execute( e.getPoint() );
		( ( PresentationModuleZone ) currentPlan ).setSelected( null );
	}
	
	public void mouseWheelMoved (MouseWheelEvent e) {
	
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
	
	private Command command;
	
	private Command deleteCommand;
	
	private JPanel currentPlan;

}
