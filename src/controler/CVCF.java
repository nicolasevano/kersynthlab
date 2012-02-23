package controler;

import gui.impl.PresentationVCF;
import kernel.impl.vcf.VCF;

public class CVCF extends VCF{
	private PresentationVCF presentation;

	public CVCF(){
	presentation = new PresentationVCF();
	presentation.setControl(this);
	presentation.initListener();
	}
	
	public PresentationVCF getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationVCF presentation) {
		this.presentation = presentation;
	}

}
