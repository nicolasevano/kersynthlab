package controler;

import gui.impl.PresentationReplicator;
import kernel.impl.replicator.Replicator;

public class CReplicator extends Replicator{

	private PresentationReplicator presentation;

	public CReplicator() {
		presentation = new PresentationReplicator();
		presentation.setControl(this);
	}
	
	public PresentationReplicator getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationReplicator presentation) {
		this.presentation = presentation;
	}

}
