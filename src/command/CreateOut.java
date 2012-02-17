package command;

import java.awt.Point;

import controler.COUT;

public class CreateOut extends Command {

	@Override
	public void execute(Point p) {
		
		// TODO Auto-generated method stub
		COUT result = new COUT();
		result.getPresentation().setOrigine( p );
		/*result.getPresentation().setBounds(p.x,
				  						   p.y,
				  						   result.getPresentation().getWidth(), 
				  						   result.getPresentation().getHeight() );*/
		result.getPresentation().setLocation(p.x, p.y);
		result.getPresentation().repaint();
		super.setModule( result.getPresentation() );
		
	}

}
