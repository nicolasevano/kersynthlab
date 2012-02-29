package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import controler.CVCA;

/**
 * Module VCA for dealing with sound
 * get horloge
 * set location for VCA
 */

public class CreateVCA extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		CVCA result;
		try {
			result = new CVCA(super.getConfiguration());
			super.getHorloge().addModuleObserver( result );
//			result.getPresentation().setOrigine( p );
			System.out.println("Commande VCA here");
			result.getPresentation().setLocation( p.x, p.y );
			result.getPresentation().repaint();
			super.setModule( result.getPresentation() );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
