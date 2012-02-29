package gui.impl.subpresentation;


import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

import stringloader.IConfigurationLoader;

/**
 * Define reglages of VCO:
 * 	att, pitch and base
 */

public class ReglageVCO extends JPanel{

	public ReglageVCO(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		
		this.configuration = configuration;
		String language = configuration.getLanguage();
		
		if(language == "Chinese")
		{
			nameAtt = new String(configuration.getProperties().getProperty("module.VCO.att").getBytes("iso8859-1"), "utf-8");
			namePitch = new String(configuration.getProperties().getProperty("module.VCO.pitch").getBytes("iso8859-1"), "utf-8");
			nameBase = new String(configuration.getProperties().getProperty("module.VCO.base").getBytes("iso8859-1"), "utf-8");
		}
		else
		{
			nameAtt = configuration.getProperties().getProperty("module.VCO.att");
			namePitch = configuration.getProperties().getProperty("module.VCO.pitch");
			nameBase = configuration.getProperties().getProperty("module.VCO.base");
		}
		att = new PresentationMolette( SigneAffichage.negatif, 7, nameAtt,4);
		att.getTs().setValue(att.getTs().getValeurAiguille());
		pitch = new PresentationMolette( SigneAffichage.positif, 100, namePitch,20);
		pitch.getTs().setValue(pitch.getTs().getValeurAiguille());
		base = new PresentationMolette( SigneAffichage.puissance, 7, nameBase,3);
		base.getTs().setValue(base.getTs().getValeurAiguille());
	
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
	private String nameAtt;
	private String nameBase;
	private String namePitch;
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	
	private IConfigurationLoader configuration;
	
}
