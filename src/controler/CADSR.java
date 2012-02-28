package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import kernel.impl.adsr.ADSR;
import gui.impl.PresentationADSR;

public class CADSR extends ADSR{
	
	public CADSR(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		
		this.configuration = configuration;
		
		presentation = new PresentationADSR(configuration);
		presentation.setControl( this );
		presentation.initListener();
		
	}
	
	public CADSR(IConfigurationLoader configuration,String savedOne) throws UnsupportedEncodingException{
		
		this.configuration = configuration;
		
		presentation = new PresentationADSR( configuration,savedOne );
		presentation.setControl( this );
		presentation.initListener();
		
	}

	public PresentationADSR getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationADSR presentation) {
		this.presentation = presentation;
	}
	
	private PresentationADSR presentation;
	
	private IConfigurationLoader configuration;

}
