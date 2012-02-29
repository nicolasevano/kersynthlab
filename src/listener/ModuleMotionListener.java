package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import command.Command;

/**
 * Mouse motion listeners
 */

public class ModuleMotionListener extends MouseMotionAdapter {
	
	public void mouseDragged(MouseEvent e){
		System.out.println("motion listener call!");
		currentCommand.execute( e.getPoint() );
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
	
	public Command getCurrentCommand() {
		return currentCommand;
	}

	public void setCurrentCommand(Command currentCommand) {
		this.currentCommand = currentCommand;
	}
	
	private Command currentCommand;
	
	private JPanel currentPlan;
	
	private int translationRatioX;
	
	private int translationRatioY;
}
