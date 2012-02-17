package controler;

import gui.impl.Poubelle;


public class CPoubelle {
	public CPoubelle(){
		presentation = new Poubelle();
		presentation.setControl( this );
	}
	
	public Poubelle getPresentation() {
		return presentation;
	}

	public void setPresentation( Poubelle presentation ) {
		this.presentation = presentation;
	}
	
	
	private Poubelle presentation;
	
}
