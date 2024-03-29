package controler;


import java.io.File;
import java.io.UnsupportedEncodingException;

import command.LoadInstallation;
import command.WriteInstallation;
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
		HorlogeImpl.setSampleRate( 44100 );
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
	
	public void saveMontage( File useForSave ){
		
		WriteInstallation writeCmd = new WriteInstallation();
		writeCmd.setPlan( this.ceditor.getPresentation().getModuleZone() );
		writeCmd.setToUseForWrite( useForSave );
		writeCmd.execute( null );
		
	}
	
	public void loadMontage(File toLoad){
		
		LoadInstallation loadCmd = new LoadInstallation();
		loadCmd.setPlan( this.ceditor.getPresentation().getModuleZone() );
		loadCmd.setHorloge( this.getHorloge() );
		loadCmd.setToUseToLoad(toLoad);
		loadCmd.setConfiguration(this.getPresentation().getConfiguration());
		loadCmd.execute( null );
		
	}
	
	public void changeSampleRate(){
		presentation.getSampleRateChose().setVisible( true );
	}
	
	public void changeBufferSize(){
		
	}
	
	public CSynthEditor getCeditor() {
		return ceditor;
	}

	public void setCeditor(CSynthEditor ceditor) {
		this.ceditor = ceditor;
	}
	
	/** current menu presentation */
	private PresentationUserOption presentation;
	/** current horloge presentation */
	private HorlogeSubject horloge;
	
	private CSynthEditor ceditor;
	
}
