package command;

import java.awt.Point;

import controler.CVCO;

public class CreateVCO extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		CVCO result = new CVCO();
		result.getPresentation().setOrigine( p );
		/*result.getPresentation().setBounds(p.x,
				  						   p.y,
				  						   result.getPresentation().getWidth(), 
				  						   result.getPresentation().getHeight() );*/
		result.getPresentation().setLocation( p.x, p.y );
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );
	}

}
