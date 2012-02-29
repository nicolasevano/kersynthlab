package controler;

import java.io.UnsupportedEncodingException;

import stringloader.IConfigurationLoader;
import gui.impl.PresentationReplicator;
import kernel.impl.replicator.Replicator;

/**
 * Controller of Replicator
 */

public class CReplicator extends Replicator{

	private PresentationReplicator presentation;

	/**
	 * Constructor of CRepliator
	 * Control the presentation of replicators
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	public CReplicator(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		presentation = new PresentationReplicator(configuration);
		presentation.setControl(this);
	}
	
	public CReplicator(IConfigurationLoader configuration,String savedOne) throws UnsupportedEncodingException {
		presentation = new PresentationReplicator( configuration, savedOne );
		presentation.setControl(this);
	}
	
	public PresentationReplicator getPresentation() {
		return presentation;
	}

	public void setPresentation(PresentationReplicator presentation) {
		this.presentation = presentation;
	}

}
