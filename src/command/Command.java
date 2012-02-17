package command;

import java.awt.Point;

import javax.swing.JPanel;

import gui.Module;

public abstract class Command {
	
	public abstract void execute(Point p);
	
	public void setPlan(JPanel currentPlan){
		this.currentPlan  = currentPlan;
	}
	
	public JPanel getPlan(){
		return currentPlan;
	}
	
	public void setModule(Module module) {
		this.module = module;
	}

	public Module getModule() {
		return this.module;
	}
	
	private Module module;
	
	private JPanel currentPlan;
}
