package controler;

import stringloader.IConfigurationLoader;
import kernel.impl.adsr.ADSR;
import gui.impl.PresentationADSR;

public class CADSR extends ADSR{
	
	public CADSR(IConfigurationLoader configuration){
		this.configuration = configuration;		
		presentation = new PresentationADSR(configuration);
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
