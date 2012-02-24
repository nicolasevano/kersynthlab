package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import controler.CVCF;

public class CreateVCF extends Command {

	@Override
	public void execute(Point p) {
		CVCF result;
		try {
			result = new CVCF(super.getConfiguration());
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
