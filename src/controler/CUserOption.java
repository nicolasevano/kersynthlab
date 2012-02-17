package controler;

import kernel.HorlogeSubject;
import gui.impl.UserOption;
import kernel.impl.HorlogeImpl;

public class CUserOption {

	public CUserOption(){
		presentation = new UserOption();
		presentation.setControl( this );
		horloge = new HorlogeImpl();
	}
	
	public UserOption getPresentation() {
		return presentation;
	}

	public void setPresentation( UserOption presentation ) {
		this.presentation = presentation;
	}
	
	public HorlogeSubject getHorloge() {
		return horloge;
	}

	public void setHorloge(HorlogeSubject horloge) {
		this.horloge = horloge;
	}
	
	public void startHorloge(){
		if(horloge != null)
			( ( HorlogeImpl ) this.horloge ).start();
	}
	
	public void stopHorloge(){
		if(horloge != null)
			( ( HorlogeImpl ) this.horloge ).stop();
	}
	
	public void saveMontage(){
		
	}
	
	public void loadMontage(){
		
	}
	
	public void changeSampleRate(){
		
	}
	
	public void changeBufferSize(){
		
	}
	
	private UserOption presentation;
	private HorlogeSubject horloge;
	
	
}
