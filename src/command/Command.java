package command;

import java.awt.Point;

import javax.swing.JPanel;

import kernel.HorlogeSubject;

import gui.APresentationModule;

public abstract class Command {
	
	public abstract void execute(Point p);
	
	public void setPlan(JPanel currentPlan){
		this.currentPlan  = currentPlan;
	}
	
	public JPanel getPlan(){
		return currentPlan;
	}
	
	public void setModule(APresentationModule module) {
		this.module = module;
	}

	public APresentationModule getModule() {
		return this.module;
	}
	
	public HorlogeSubject getHorloge() {
		return horloge;
	}

	public void setHorloge( HorlogeSubject horloge ) {
		this.horloge = horloge;
	}
	
	private APresentationModule module;
	
	private JPanel currentPlan;
	
	private HorlogeSubject horloge;
}
