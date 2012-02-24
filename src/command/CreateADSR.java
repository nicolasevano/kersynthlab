package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import controler.CADSR;

public class CreateADSR extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		CADSR result;
		try {
			result = new CADSR(super.getConfiguration());
			super.getHorloge().addModuleObserver( result );
			result.getPresentation().setOrigine( p );
			result.getPresentation().setLocation( p.x, p.y );
			result.getPresentation().repaint();
			super.setModule( result.getPresentation() );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
