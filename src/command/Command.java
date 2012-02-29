package command;

import java.awt.Point;

import javax.swing.JPanel;

import stringloader.IConfigurationLoader;

import kernel.HorlogeSubject;

import gui.APresentationModule;

/**
 * create getters and setters for :
 * 		plan  (JPanel)
 * 		module (APresentationModule)
 * 		horloge (HorlogeSubject)
 * 		configuration (IConfigurationLoader)
 */

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
	
	public IConfigurationLoader getConfiguration() {
		return configuration;
	}

	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	private APresentationModule module;
	
	private JPanel currentPlan;
	
	private HorlogeSubject horloge;
	
	private IConfigurationLoader configuration;

	
}
