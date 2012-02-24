package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import gui.impl.PresentationReplicator;
import kernel.impl.replicator.Replicator;

public class CReplicator extends Replicator{

	private PresentationReplicator presentation;

	public CReplicator(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		presentation = new PresentationReplicator(configuration);
		presentation.setControl(this);
	}
	
	public PresentationReplicator getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationReplicator presentation) {
		this.presentation = presentation;
	}

}
