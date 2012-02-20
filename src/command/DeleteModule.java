package command;

import gui.APresentationModule;
import gui.impl.PresentationPoubelle;
import gui.impl.PresentationModuleZone;

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
			//System.out.println("dxRemoveZone = " + dxRemoveZone);
			//System.out.println("dyRemoveZone = " + dyRemoveZone);
			//System.out.println("xSelectedZone = " + xSelectedZone);
			//System.out.println("ySelectedZone = " + ySelectedZone);
			//System.out.println("first condition = " + ( ( pSelectedOrigine.x < poubelle.getWidth() ) && 
			//		  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) ));
			//System.out.println("second condition = " + ( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
			//		  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ));
			//System.out.println("thrid condition = " + ( ( pSelectedOrigine.x < poubelle.getWidth() ) &&
			//		  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ));
			//System.out.println("fourth condition = " + ( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
			//		  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) ));
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
		System.out.println( "Remove a module!" );
		( ( PresentationModuleZone ) getPlan() ).remove( ( ( PresentationModuleZone ) getPlan() ).getSelected() );
		Module toRemove = ( ( APresentationModule )( ( PresentationModuleZone ) getPlan() ).getSelected()).getControl();
		super.getHorloge().removeModuleObserver( toRemove );
		//TODO remove each wire at this moment
		( ( PresentationModuleZone ) getPlan() ).repaint();
	}
	
	private PresentationPoubelle poubelle;
	
}
