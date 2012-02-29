package command;

import java.awt.Point;

import controler.COUT;

/**
 * Module Out for connecting with sound card and produce the result
 * get horloge
 * set location for OUT
 */

public class CreateOut extends Command {

	@Override
	public void execute(Point p) {
		
		// TODO Auto-generated method stub
		COUT result = new COUT();
		super.getHorloge().addModuleObserver( result );
		result.getPresentation().setOrigine( p );
		result.getPresentation().setLocation( p.x, p.y );
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );
		
	}

}
