package controler;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import listener.ConfigurationListener;
import listener.IFileChangeListener;
import stringloader.ConfigurationLoader;
import stringloader.IConfigurationLoader;
import kernel.HorlogeSubject;
import gui.impl.PresentationUserOption;
import kernel.impl.HorlogeImpl;

public class CUserOption {

	/** Public constructor 
	 * @throws UnsupportedEncodingException */
	public CUserOption(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		presentation = new PresentationUserOption(configuration);
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
	/** current menu presentation */
	private PresentationUserOption presentation;
	/** current horloge presentation */
	private HorlogeSubject horloge;
	
	
	//private IConfigurationLoader configuration;
	private ConfigurationLoader configuration;
}
