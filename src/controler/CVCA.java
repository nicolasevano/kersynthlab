package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import gui.impl.PresentationVCA;
import kernel.impl.VCA;

/**
 * Controller of VCA
 * Control presentation of VCA
 */

public class CVCA extends VCA {
	
	private PresentationVCA presentation;

	/**
	 * Constructor of CVCA
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	public CVCA(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		presentation = new PresentationVCA(configuration);
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public CVCA(IConfigurationLoader configuration, String savedOne) throws UnsupportedEncodingException {
		presentation = new PresentationVCA( configuration, savedOne );
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public PresentationVCA getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationVCA presentation) {
		this.presentation = presentation;
	}
	
	/**
	 * set value of attenuator for VCA
	 */
	
	public void setAttVCA(int att){
		
		super.setAttVCA((att == 0)? 1 : att );
	}
	

}
