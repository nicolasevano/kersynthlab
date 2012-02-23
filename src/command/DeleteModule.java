package command;

import gui.APresentationModule;
import gui.impl.PresentationPoubelle;
import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Point;

import kernel.Module;

public class DeleteModule extends Command{

	@Override
	public void execute( Point p ) {
		// TODO Auto-generated method stub
		if( ( ( PresentationModuleZone ) getPlan() ).getSelected() != null ) {
			Point poubelleOrigine = poubelle.getLocation();
			Point pSelectedOrigine = ( ( PresentationModuleZone ) getPlan() ).getSelected().getLocation();
			int dxRemoveZone = poubelleOrigine.x + poubelle.getWidth();
			int dyRemoveZone = poubelleOrigine.y + poubelle.getHeight();
			int xSelectedZone = pSelectedOrigine.x + ( ( PresentationModuleZone ) getPlan() ).getSelected().getWidth();
			int ySelectedZone = pSelectedOrigine.y + ( ( PresentationModuleZone ) getPlan() ).getSelected().getHeight();
			if( ( ( pSelectedOrigine.x < poubelle.getWidth() ) && 
				  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) ) ||
				( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
				  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ) ||
				( ( pSelectedOrigine.x < poubelle.getWidth() ) &&
				  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ) ||
				( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
				  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) )
				){
					deleteModule();
			}
				
		}
	}
	
	public void setPoubelle( PresentationPoubelle poubelle ){
		this.poubelle = poubelle;
	}
	
	public PresentationPoubelle getPoubelle(){
		return this.poubelle;
	}
	
	private void deleteModule(){
		PresentationWire wire = null;
		int wiresSize;
		System.out.println( "Remove a module!" );
		( ( PresentationModuleZone ) getPlan() ).remove( ( ( PresentationModuleZone ) getPlan() ).getSelected() );
		Module toRemove = 
			( ( APresentationModule )( ( PresentationModuleZone ) getPlan() ).getSelected() ).getControl();
		APresentationModule presentationToRemove = 
			( ( APresentationModule )( ( PresentationModuleZone ) getPlan() ).getSelected() );
		super.getHorloge().removeModuleObserver( toRemove );
		//TODO remove each wire at this moment
		wiresSize = presentationToRemove.getWires().size();
		for( int i = 0; i < wiresSize; i++ ){
			wire = presentationToRemove.getWires().get( 0 );
			wire.getControl().detachPorts();
			( ( APresentationModule ) wire.getOutPort().getParent() ).getWires().remove( wire );
			( ( APresentationModule ) wire.getInPort().getParent() ).getWires().remove( wire );
			( ( PresentationModuleZone ) getPlan() ).remove( wire );
			( ( PresentationModuleZone ) getPlan() ).repaint();
		}
	}
	
	private PresentationPoubelle poubelle;
	
}
