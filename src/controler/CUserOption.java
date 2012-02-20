package controler;

import kernel.HorlogeSubject;
import gui.impl.PresentationUserOption;
import kernel.impl.HorlogeImpl;

public class CUserOption {

	public CUserOption(){
		presentation = new PresentationUserOption();
		presentation.setControl( this );
		horloge = new HorlogeImpl();
	}
	
	public PresentationUserOption getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationUserOption presentation ) {
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
	
	private PresentationUserOption presentation;
	private HorlogeSubject horloge;
	
	
}
