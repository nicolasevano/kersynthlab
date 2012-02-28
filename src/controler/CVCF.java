package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import gui.impl.PresentationVCF;
import kernel.impl.vcf.VCF;

public class CVCF extends VCF{
	private PresentationVCF presentation;

	public CVCF(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		presentation = new PresentationVCF( configuration );
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public CVCF(IConfigurationLoader configuration, String savedOne) throws UnsupportedEncodingException{
		presentation = new PresentationVCF( configuration, savedOne );
		presentation.setControl( this );
		presentation.initListener();
	}
	
	public PresentationVCF getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationVCF presentation) {
		this.presentation = presentation;
	}

}
