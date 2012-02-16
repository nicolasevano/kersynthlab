package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;
//import command.Command;

public class ModuleListener extends MouseAdapter{
	
	public void mousePressed(MouseEvent e){
		
//		System.out.println( "Mouse pressed!" );
//		if( currentCommand != null ){
//			currentCommand.execute( e.getPoint() );
//			if(currentCommand.getDessin() != null){
//				( (JPanel) currentCommand.getPlan() ).add( currentCommand.getDessin(),0 );
//				//currentCommand.getDessin().setFocusable(true);
//			}
//			currentCommand.nextState();
//		}
		
	}
	
	public void mouseReleased(MouseEvent e){
		
//		System.out.println( "Mouse released!" );
//		if( currentCommand != null ){
//			currentCommand.nextState();
//			currentCommand.execute( e.getPoint() );
//			currentCommand.nextState();
//		}
		
	}
	
	public void mouseWheelMoved (MouseWheelEvent e) {
//		if(currentCommand != null && currentCommand.isWheelMouse()){
//			currentCommand.execute(e);
//		}
	
	}
//	public Command getCurrentCommand() {
//		return currentCommand;
//	}

//	public void setCurrentCommand(Command currentCommand) {
//		this.currentCommand = currentCommand;
//	}
	
//	private Command currentCommand;

	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
