package command;

import gui.impl.ModuleZone;
import gui.impl.Poubelle;

import java.awt.Point;

public class DeleteModule extends Command{

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		if( ( ( ModuleZone ) getPlan() ).getSelected() != null ) {
			Point poubelleOrigine = poubelle.getLocation();
			Point pSelectedOrigine = ( ( ModuleZone ) getPlan() ).getSelected().getLocation();
			int dxRemoveZone = poubelleOrigine.x + poubelle.getWidth();
			int dyRemoveZone = poubelleOrigine.y + poubelle.getHeight();
			int xSelectedZone = pSelectedOrigine.x + ( ( ModuleZone ) getPlan() ).getSelected().getWidth();
			int ySelectedZone = pSelectedOrigine.y + ( ( ModuleZone ) getPlan() ).getSelected().getHeight();
			System.out.println("dxRemoveZone = " + dxRemoveZone);
			System.out.println("dyRemoveZone = " + dyRemoveZone);
			System.out.println("xSelectedZone = " + xSelectedZone);
			System.out.println("ySelectedZone = " + ySelectedZone);
			if( ( ( ( dxRemoveZone - pSelectedOrigine.x ) < poubelle.getWidth() ) && 
				  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) ) ||
				( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
				  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ) ||
				( ( ( dxRemoveZone - pSelectedOrigine.x ) < poubelle.getWidth() ) &&
				  ( ( Math.abs( dyRemoveZone - ySelectedZone ) ) < poubelle.getHeight() ) ) ||
				( ( ( Math.abs( dxRemoveZone - xSelectedZone ) ) < poubelle.getWidth() ) &&
				  ( ( dyRemoveZone - pSelectedOrigine.y ) < poubelle.getHeight() ) )
				){
					deleteModule();
			}
				
		}
	}
	
	public void setPoubelle(Poubelle poubelle){
		this.poubelle = poubelle;
	}
	
	public Poubelle getPoubelle(){
		return this.poubelle;
	}
	
	private void deleteModule(){
		System.out.println( "Remove a module!" );
		( ( ModuleZone ) getPlan() ).remove( ( ( ModuleZone ) getPlan() ).getSelected() );
		//TODO remove each wire at this moment
		( ( ModuleZone ) getPlan() ).repaint();
	}
	
	private Poubelle poubelle;
}
