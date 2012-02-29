package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import controler.CReplicator;

/**
 * Module Replicator for replicating sound
 * get horloge
 * set location for ADSR
 */

public class CreateReplicator extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		
		CReplicator result;
		try {
			result = new CReplicator(super.getConfiguration());
			super.getHorloge().addModuleObserver( result );
			System.out.println("Commande Replicator here");
			result.getPresentation().setLocation( p.x, p.y );
			result.getPresentation().repaint();
			super.setModule( result.getPresentation() );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
