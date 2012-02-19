package listener;

import gui.Module;
import gui.impl.ModuleZone;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class ModuleMotionListener extends MouseMotionAdapter {
	
	public void mouseDragged(MouseEvent e){
		Point p = e.getPoint();
		if( currentPlan.getComponentAt( p ) instanceof Module && 
				((ModuleZone) currentPlan).getSelected() == null){
			Module toMove = (Module)currentPlan.getComponentAt( p );
			((ModuleZone) currentPlan).setSelected( toMove );
			setTranslationRatioX( p.x - toMove.getLocation().x );
			setTranslationRatioY( p.y - toMove.getLocation().y );
		}else if ( ( ( ModuleZone ) currentPlan).getSelected() != null){
			( ( ModuleZone ) currentPlan).getSelected().setLocation( 
					p.x - getTranslationRatioX(),
					p.y - getTranslationRatioY());
		}
	}
	
	public int getTranslationRatioX() {
		return translationRatioX;
	}

	public void setTranslationRatioX(int translationRatioX) {
		this.translationRatioX = translationRatioX;
	}

	public int getTranslationRatioY() {
		return translationRatioY;
	}

	public void setTranslationRatioY(int translationRationY) {
		this.translationRatioY = translationRationY;
	}
	
	public JPanel getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(JPanel currentPlan) {
		this.currentPlan = currentPlan;
	}
	
	private JPanel currentPlan;
	
	private int translationRatioX;
	
	private int translationRatioY;
}
