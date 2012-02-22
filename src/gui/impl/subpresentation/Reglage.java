package gui.impl.subpresentation;


import javax.swing.JPanel;

import stringloader.IConfigurationLoader;


public class Reglage extends JPanel{

	public Reglage(IConfigurationLoader configuration){
		
		this.configuration = configuration;
		
		att = new PresentationMolette( SigneAffichage.negatif, 7, configuration.getProperties().getProperty("module.VCO.att") );
		pitch = new PresentationMolette( SigneAffichage.positif, 100, configuration.getProperties().getProperty("module.VCO.pitch"));
		base = new PresentationMolette( SigneAffichage.puissance, 7, configuration.getProperties().getProperty("module.VCO.base"));
		//att = new PresentationMolette( SigneAffichage.negatif, 7, "Att" );
		//pitch = new PresentationMolette( SigneAffichage.positif, 100, "Pitch" );
		//base = new PresentationMolette( SigneAffichage.puissance, 7, "Base" );
		setLayout( null );
		add( att );
		add( pitch );
        add( base );
        setVisible( true );
        
	}
	
	public void setLocation(){
		att.setLocation( ( getWidth() / 6 ) - ( att.getWidth() / 2 ),
				         ( getHeight() / 2 ) - ( att.getHeight() / 2 ) );
		pitch.setLocation( ( getWidth() / 2 ) - ( pitch.getWidth() / 2 ),
		                   ( getHeight() / 2 ) - ( pitch.getHeight() / 2 ) );
		base.setLocation( getWidth() - base.getWidth(),
				          ( getHeight() / 2 ) - ( base.getHeight() / 2 ) );
	}
	
	public PresentationMolette getAtt() {
		return att;
	}

	public void setAtt(PresentationMolette att) {
		this.att = att;
	}

	public PresentationMolette getPitch() {
		return pitch;
	}

	public void setPitch(PresentationMolette pitch) {
		this.pitch = pitch;
	}

	public PresentationMolette getBase() {
		return base;
	}

	public void setBase(PresentationMolette base) {
		this.base = base;
	}
	
	private PresentationMolette att;
	private PresentationMolette base;
	private PresentationMolette pitch;
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	
	private IConfigurationLoader configuration;
	
}
