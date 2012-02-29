package gui.impl.subpresentation;

import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

import stringloader.IConfigurationLoader;

/**
 * Define the ajustements of VCA:
 * 	Att and Base
 */

public class ReglageVCA extends JPanel {

	private static final long serialVersionUID = 1L;
	private PresentationMolette att;
	private PresentationMolette base;
	private String nameAtt;
	private String nameBase;

	/**
	 * Constructor of ReglageVCA
	 * set presentation properties of VCA molettes
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	public ReglageVCA(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		String language = configuration.getLanguage();
		setLayout(null);
		if(language == "Chinese")
		{
			nameAtt = new String(configuration.getProperties().getProperty("module.VCA.att").getBytes("iso8859-1"), "utf-8");
			nameBase = new String(configuration.getProperties().getProperty("module.VCA.base").getBytes("iso8859-1"), "utf-8");
	    }
		else
		{
			nameAtt = configuration.getProperties().getProperty("module.VCA.att");
			nameBase = configuration.getProperties().getProperty("module.VCA.base");
		}
        	
		
		att = new PresentationMolette (SigneAffichage.negatif, 8, nameAtt,4);
		att.getTs().setValue(att.getTs().getValeurAiguille());
		base = new PresentationMolette (SigneAffichage.puissance , 7 , nameBase,3);
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
	
	public String getNameAtt() {
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
	}

//	public ReglageVCA(LayoutManager arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ReglageVCA(boolean arg0) {
//		super(arg0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ReglageVCA(LayoutManager arg0, boolean arg1) {
//		super(arg0, arg1);
//		// TODO Auto-generated constructor stub
//	}

}
