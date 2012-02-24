package command;

import java.awt.Point;
import controler.CReplicator;

public class CreateReplicator extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		
		CReplicator result = new CReplicator();
		super.getHorloge().addModuleObserver( result );
		System.out.println("Commande Replicator here");
		result.getPresentation().setLocation( p.x, p.y );
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );

	}

}
