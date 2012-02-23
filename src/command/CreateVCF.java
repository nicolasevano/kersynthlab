package command;

import java.awt.Point;
import controler.CVCF;

public class CreateVCF extends Command {

	@Override
	public void execute(Point p) {
		CVCF result = new CVCF();
		super.getHorloge().addModuleObserver( result );
//		result.getPresentation().setOrigine( p );
		System.out.println("Commande VCA here");
		result.getPresentation().setLocation( p.x, p.y );
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );
		
	}

}
