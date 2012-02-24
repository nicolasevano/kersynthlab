package command;

import gui.APresentationModule;
import gui.impl.PresentationModuleZone;

import java.awt.Point;

public class MoveModule extends Command {
	
	public MoveModule(){
		moveWire = new MoveWire();
	}
	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		if( moveWire.getPlan() == null ) moveWire.setPlan( getPlan() ); 
		if( getPlan().getComponentAt( p ) instanceof APresentationModule && 
				((PresentationModuleZone) getPlan()).getSelected() == null){
			APresentationModule toMove = (APresentationModule)getPlan().getComponentAt( p );
			((PresentationModuleZone) getPlan()).setSelected( toMove );
			setTranslationRatioX( p.x - toMove.getLocation().x );
			setTranslationRatioY( p.y - toMove.getLocation().y );
		} else if ( ( ( PresentationModuleZone ) getPlan()).getSelected() != null){
			( ( PresentationModuleZone ) getPlan()).getSelected().setLocation( 
					p.x - getTranslationRatioX(),
					p.y - getTranslationRatioY());
		}
		moveWire.execute( p );
	}
	
	public int getTranslationRatioX() {
		return translationRatioX;
	}

	public void setTranslationRatioX(int translationRatioX) {
		this.translationRatioX = translationRatioX;
	}

	public int getTranslationRatioY() {
		return translationRatioY;
	}

	public void setTranslationRatioY(int translationRationY) {
		this.translationRatioY = translationRationY;
	}
	
	private int translationRatioX;
	
	private int translationRatioY;
	
	private Command moveWire;
}
