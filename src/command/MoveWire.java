package command;

import gui.APresentationModule;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Point;

/**
 * move wires
 *
 */

public class MoveWire extends Command{

	/**
	 * move wires and repaint current wires
	 */
	
	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		if( getPlan().getComponentAt( p ) instanceof APresentationModule ){
			APresentationModule inMove = ( APresentationModule ) getPlan().getComponentAt( p );

			for( PresentationWire wire : inMove.getWires() ){
				currentWire = wire;
				outPortX = ( currentWire.getOutPort().getX() + currentWire.getOutPort().getParent().getX() + currentWire.getOutPort().getWidth()/2 );
				outPortY = currentWire.getOutPort().getY() + currentWire.getOutPort().getParent().getY() + currentWire.getOutPort().getHeight()/2;
				inPortX = ( currentWire.getInPort().getLocation().x + currentWire.getInPort().getParent().getX() + currentWire.getInPort().getWidth()/2 );
				inPortY = currentWire.getInPort().getY() + currentWire.getInPort().getParent().getY() + currentWire.getInPort().getHeight()/2;
				init = new Point ( currentWire.getOutPort().getLocation().x,
						currentWire.getOutPort().getLocation().y );
				System.out.println( "init = " + init );
				computeRatio( p );
				end = new Point( getTranslationRatioX(), getTranslationRatioY() );
				System.out.println( "end = " + end );
				setInit( p );
				computeLocation( p );
				currentWire.validate();
				currentWire.repaint();
				getPlan().validate();
				getPlan().repaint();
			}
		}
	}
	
	private void computeRatio2( Point p ){
		setTranslationRatioX( currentWire.getOutPort().getParent().getX() + 
				  			  currentWire.getOutPort().getX() +
				  			  currentWire.getOutPort().getWidth() +
				  			  ( currentWire.getInPort().getWidth() / 2 ) -
				  			  currentWire.getInPort().getParent().getX() -
				  			  currentWire.getInPort().getWidth()
	  			  			);
		setTranslationRatioY(
	              			  currentWire.getOutPort().getY() +
	              			  currentWire.getOutPort().getHeight() / 2 +
	              			  currentWire.getOutPort().getLocation().y - 
	              			  currentWire.getInPort().getY() -
	              			  currentWire.getInPort().getParent().getY() - 
	              			  currentWire.getInPort().getHeight() -
	              			  10 );
		currentWire.setpDest( 
				new Point( getTranslationRatioX(), getTranslationRatioY() ) );
	}
	
	private void computeLocation2( Point p ){		
		currentWire.setLocation( 
				 currentWire.getInPort().getLocation().x + currentWire.getInPort().getParent().getLocation().x, 
				 currentWire.getInPort().getLocation().y + + currentWire.getInPort().getParent().getLocation().y 
		);
	}
	
	private void setInit2( Point p ){
		Point location = null;
		location = new Point(  currentWire.getInPort().getWidth() / 2,
	   			   			   currentWire.getInPort().getHeight() / 2 );
		currentWire.setpInit( location );
		
	}
	
	/**
	 * calculate the size of JPnale which contains wire
	 * @param p
	 */
	
	private void computeRatio( Point p ){
		if( ( outPortX <= inPortX ) && ( outPortY <= inPortY ) ){
			setTranslationRatioX( currentWire.getInPort().getParent().getX() +
							  	  currentWire.getInPort().getWidth() +
							  	  (currentWire.getOutPort().getWidth() / 2 ) -
							  	  currentWire.getOutPort().getParent().getX() - 
							  	  currentWire.getOutPort().getParent().getWidth() );
			setTranslationRatioY( currentWire.getInPort().getParent().getY() - 
							  	  currentWire.getOutPort().getParent().getY() - 
							  	  10 );
		} else if( ( outPortX < inPortX ) && ( outPortY > inPortY ) ){
			setTranslationRatioX( currentWire.getInPort().getParent().getX() +
		  			  currentWire.getInPort().getWidth() +
		  			  ( currentWire.getOutPort().getWidth() / 2 ) -
		  			  currentWire.getOutPort().getParent().getX() - 
		  			  currentWire.getOutPort().getParent().getWidth() );
			setTranslationRatioY( 0 );
		} else if( ( outPortX > inPortX ) && ( outPortY > inPortY ) ){
			setTranslationRatioX( currentWire.getOutPort().getParent().getX() + 
					  currentWire.getOutPort().getX() +
	  	  			  currentWire.getOutPort().getWidth() +
	  	  			  (currentWire.getInPort().getWidth() / 2 ) -
	  	  			  currentWire.getInPort().getParent().getX() -
	  	  			  currentWire.getInPort().getWidth()
	  	  			  );
			setTranslationRatioY(
        			  currentWire.getOutPort().getY() +
        			  currentWire.getOutPort().getHeight() / 2 +
        			  currentWire.getOutPort().getLocation().y - 
        			  currentWire.getInPort().getY() -
        			  currentWire.getInPort().getParent().getY() - 
        			  currentWire.getInPort().getHeight() -
        			  10 );
		} else {
			setTranslationRatioX( currentWire.getOutPort().getParent().getX() + 
					  currentWire.getOutPort().getX() +
	  	  			  currentWire.getOutPort().getWidth() +
	  	  			  (currentWire.getInPort().getWidth() / 2 ) -
	  	  			  currentWire.getInPort().getParent().getX() -
	  	  			  currentWire.getInPort().getWidth()
	  	  			  );
			setTranslationRatioY( currentWire.getOutPort().getHeight()/2 );
		}
		currentWire.setpDest( 
				new Point( getTranslationRatioX(), getTranslationRatioY() ) );
	}
	
	/**
	 * calculate the location of wire
	 * @param p
	 */
	
	private void computeLocation( Point p ){
		if( ( outPortX <= inPortX ) && ( outPortY <= inPortY ) ){
			currentWire.setLocation( 
								 currentWire.getOutPort().getLocation().x, 
								 currentWire.getOutPort().getLocation().y
								);
		} else if( ( outPortX < inPortX ) && ( outPortY > inPortY ) ){
			currentWire.setLocation( 
					 currentWire.getOutPort().getLocation().x, 
					 currentWire.getInPort().getLocation().y +
					 currentWire.getInPort().getParent().getLocation().y +
					 currentWire.getInPort().getHeight() / 2 
					);
		} else if( ( outPortX > inPortX ) && ( outPortY > inPortY ) ){
			currentWire.setLocation( 
					 currentWire.getInPort().getLocation().x + currentWire.getInPort().getParent().getLocation().x, 
					 currentWire.getInPort().getLocation().y + + currentWire.getInPort().getParent().getLocation().y 
			);
		} else {
			currentWire.setLocation( 
					 currentWire.getInPort().getLocation().x + 
					 currentWire.getInPort().getParent().getLocation().x, 
					 currentWire.getOutPort().getLocation().y 
					);
		}
	}
	
	/**
	 * Initiate wire
	 * @param p
	 */
	
	private void setInit( Point p ){
		Point location = null;
		if( ( outPortX <= inPortX ) && ( outPortY <= inPortY ) ){
			location = new Point(  currentWire.getOutPort().getWidth() / 2,
							   currentWire.getOutPort().getHeight() / 2 );
		} else if( ( outPortX < inPortX ) && ( outPortY > inPortY ) ){
			location = new Point(  currentWire.getOutPort().getWidth() / 2,
					   currentWire.getOutPort().getParent().getY() +
					   currentWire.getOutPort().getHeight() - 
					   currentWire.getInPort().getParent().getY() - 
					   10 );
		} else if( ( outPortX > inPortX ) && ( outPortY > inPortY ) ){
			location = new Point(  currentWire.getInPort().getWidth() / 2,
		   			   			   currentWire.getInPort().getHeight() / 2 );
		} else {
			location = new Point(  currentWire.getInPort().getWidth() / 2,
					   currentWire.getInPort().getParent().getY() -
					   currentWire.getOutPort().getParent().getY() -
					   10 );
		}
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
	
	private int outPortX;
	private int outPortY;
	private int inPortX;
	private int inPortY;
	private Point init;
	private Point end; 
	private PresentationOutPortImpl outPort;
	
	private int translationRatioX;
	
	private int translationRatioY;
	
	private PresentationWire currentWire;
	APresentationModule inMove;
	
}
