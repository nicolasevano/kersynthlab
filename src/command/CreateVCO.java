package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;

import controler.CVCO;

public class CreateVCO extends Command {
	
	@Override
	public void execute( Point p ) {
		// TODO Auto-generated method stub
		
		CVCO result;
		try {
			result = new CVCO(super.getConfiguration());
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
