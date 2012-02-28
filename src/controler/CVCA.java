package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import gui.impl.PresentationVCA;
import kernel.impl.VCA;

public class CVCA extends VCA {
	
	private PresentationVCA presentation;

	public CVCA(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		this.configuration = configuration;
		presentation = new PresentationVCA(configuration);
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public CVCA(IConfigurationLoader configuration, String savedOne) throws UnsupportedEncodingException {
		this.configuration = configuration;
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
	
	public void setAttVCA(int att){
		
		super.setAttVCA((att == 0)? 1 : att );
	}
	
	private IConfigurationLoader configuration;

}
