package gui.impl.subpresentation;

import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

import stringloader.IConfigurationLoader;

public class ReglageVCF extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PresentationMolette att;
	private PresentationMolette base;
	//private String nameAtt= "Att";
	//private String nameBase = "Base";
	
	public ReglageVCF(IConfigurationLoader configuration) throws UnsupportedEncodingException{
		String language = configuration.getLanguage();
		setLayout(null);
		if(language == "Chinese")
		{
			nameAtt = new String(configuration.getProperties().getProperty("module.VCF.att").getBytes("iso8859-1"), "utf-8");
			nameBase = new String(configuration.getProperties().getProperty("module.VCF.base").getBytes("iso8859-1"), "utf-8");
		}
		else
		{
			nameAtt = configuration.getProperties().getProperty("module.VCF.att");
			nameBase = configuration.getProperties().getProperty("module.VCF.base");
		}
		att = new PresentationMolette (SigneAffichage.negatif, 8, nameAtt,4);
		att.getTs().setValue(att.getTs().getValeurAiguille());
		base = new PresentationMolette (SigneAffichage.positif , 15 , nameBase,7);
		base.getTs().setValue(base.getTs().getValeurAiguille());
	
		
		add(att);
		add(base);
		setVisible(true);
		
	}
	
	public void setLocation(){
		att.setLocation( (getWidth()/2) - (att.getWidth() ), 
						 (getHeight() / 2)-(att.getHeight() / 2 ) );
		base.setLocation( getWidth()/2,
		          		  ( getHeight() / 2 ) - ( base.getHeight() / 2 ) );
		System.out.println("SetLocation of VCA");
	}


	public PresentationMolette getAtt() {
		return att;
	}


	public void setAtt(PresentationMolette att) {
		this.att = att;
	}


	public PresentationMolette getBase() {
		return base;
	}


	public void setBase(PresentationMolette base) {
		this.base = base;
	}
	
	
	private String nameAtt;
	private String nameBase;
	
	
	/*public String getNameAtt() {
		return nameAtt;
	}


	public void setNameAtt(String nameAtt) {
		this.nameAtt = nameAtt;
	}


	public String getNameBase() {
		return nameBase;
	}


	public void setNameBase(String nameBase) {
		this.nameBase = nameBase;
	}*/

}
