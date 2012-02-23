package command;

import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Point;

public class CreateWire extends Command {

	@Override
	public void execute(Point p) {
		System.out.println( "Create wire call" );
		if ( ( ( PresentationModuleZone ) getPlan() ).getCurrentWire() != null ){
			System.out.println( "Create wire call" );
			outPort = ( ( PresentationModuleZone ) getPlan() ).getCurrentWire().getOutPort();
			init = new Point ( outPort.getLocation().x,	outPort.getLocation().y );
			System.out.println( "init = " + init );
			computeRatio( p );
			end = new Point( getTranslationRatioX(), getTranslationRatioY() );
			System.out.println( "end = " + end );
			setInit( p );
			computeLocation( p );
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().validate();
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().repaint();
			getPlan().validate();
			getPlan().repaint();
		}

	}
	
	private void computeRatio( Point p ){
		if( ( init.x ) <= p.x && 
			( init.y ) <= p.y ) {
			setTranslationRatioX( 
					p.x - ( ( ( PresentationModuleZone ) getPlan() ).getCurrentWire().getX() ) 
			);
			setTranslationRatioY( 
					p.y - ( ( ( PresentationModuleZone ) getPlan() ).getCurrentWire().getY() ) 
			);
		} else if ( ( init.x ) < p.x && 
				( init.y  ) > p.y ){
			setTranslationRatioX( 
				p.x - ( ( ( PresentationModuleZone ) getPlan() ).getCurrentWire().getX() ) );
			setTranslationRatioY( 5 );
		} else if ( ( init.x > p.x ) && ( init.y < p.y ) ) {
			setTranslationRatioX( 5 );
			setTranslationRatioY( 
					p.y - ( ( ( PresentationModuleZone ) getPlan() ).getCurrentWire().getY() )
					);
		} else {
			setTranslationRatioX( 5 );
			setTranslationRatioY( 5 );
		}
		( ( PresentationModuleZone ) getPlan() ).getCurrentWire().setpDest( 
				new Point( getTranslationRatioX(), getTranslationRatioY() ) );
	}

	private void computeLocation(Point p){
		if( ( outPort.getLocation().x <= p.x ) && ( outPort.getLocation().y <= p.y ) ) {
			System.out.println( "On first quad" );
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().setLocation( init );
		} else if( ( outPort.getLocation().x < p.x ) && ( outPort.getLocation().y > p.y ) ) {
			System.out.println( "On second quad" );
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().setLocation( init.x, p.y );
		} else if( ( outPort.getLocation().x > p.x ) && ( outPort.getLocation().y < p.y ) ) {
			System.out.println( "On thrid quad" );
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().setLocation( p.x, init.y );
		} else {
			System.out.println("on Fourth quad");
			( ( PresentationModuleZone ) getPlan() ).getCurrentWire().setLocation( p );
		}
	}
	
	private void setInit(Point p){
		PresentationWire currentWire = ( ( PresentationModuleZone ) getPlan() ).getCurrentWire();
		Point location = null;
		if( ( outPort.getLocation().x <= p.x ) && ( outPort.getLocation().y <= p.y ) ) {
			location = new Point( 0 +
					outPort.getWidth() / 2
					,0 + outPort.getHeight() / 2 );
		} else if ( ( outPort.getLocation().x < p.x ) && ( outPort.getLocation().y > p.y ) ) {
			location = new Point( outPort.getWidth() / 2,
								  outPort.getHeight() / 2 + outPort.getLocation().y - p.y);
		} else if ( ( outPort.getLocation().x > p.x ) && ( outPort.getLocation().y < p.y ) ) {
			location = new Point( outPort.getLocation().x - p.x + outPort.getWidth() / 2,
								  outPort.getHeight() / 2 );
		} else {
			location = new Point( outPort.getLocation().x - p.x + outPort.getWidth() / 2,
					  			  outPort.getLocation().y - p.y + outPort.getHeight() / 2 );
		}
		System.out.println( "x origine = " + 
				location.x );
		System.out.println( "y origine = " + 
				location.y );
		currentWire.setpInit( location );
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
	
	private Point init;
	private Point end; 
	private PresentationOutPortImpl outPort;
	
	private int translationRatioX;
	
	private int translationRatioY;
}
