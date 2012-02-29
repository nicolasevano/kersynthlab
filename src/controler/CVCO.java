package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import kernel.impl.vco.VCO;
import gui.impl.PresentationVCO;

public class CVCO extends VCO {
	
	/**
	 * Public constructor.
	 * @throws UnsupportedEncodingException 
	 */
	public CVCO(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		presentation = new PresentationVCO(configuration);
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public CVCO(IConfigurationLoader configuration, String savedOne) throws UnsupportedEncodingException{
		presentation = new PresentationVCO( configuration, savedOne );
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public PresentationVCO getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationVCO presentation ) {
		this.presentation = presentation;
	}
	
	/** Current VCO presentation. */
	private PresentationVCO presentation;
	
}
