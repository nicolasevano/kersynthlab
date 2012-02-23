package command;

import java.awt.Point;

import controler.CVCA;

public class CreateVCA extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		CVCA result = new CVCA();
		super.getHorloge().addModuleObserver( result );
//		result.getPresentation().setOrigine( p );
		System.out.println("Commande VCA here");
		result.getPresentation().setLocation( p.x, p.y );
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );

	}

}
