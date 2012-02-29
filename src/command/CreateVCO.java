package command;

import java.awt.Point;
import java.io.UnsupportedEncodingException;

import controler.CVCO;

/**
 * Module VCO for dealing with sound
 * get horloge
 * set location for VCO
 */

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
