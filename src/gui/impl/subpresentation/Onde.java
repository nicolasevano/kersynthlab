package gui.impl.subpresentation;
import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import stringloader.IConfigurationLoader;


public class Onde extends JPanel {
	
	public Onde(IConfigurationLoader configuration) throws UnsupportedEncodingException {		
		
		this.configuration = configuration;
		String language= configuration.getLanguage();
		
		setLayout(null);
		waveGroup = new ButtonGroup();
		if(language == "Chinese")
			carre = new JCheckBox(new String(configuration.getProperties().getProperty( "module.VCO.onde.carre").getBytes("iso8859-1"), "utf-8"));
		else
			carre = new JCheckBox(configuration.getProperties().getProperty( "module.VCO.onde.carre"));
		//carre = new JCheckBox("Carre");
		waveGroup.add(carre);
		carre.setSize( 80,20 );
		carre.setBackground( Color.gray );
		carre.setForeground( Color.white );
		if(language == "Chinese")
			triangle = new JCheckBox(new String(configuration.getProperties().getProperty( "module.VCO.onde.triangle").getBytes("iso8859-1"), "utf-8"));
		else
			triangle = new JCheckBox(configuration.getProperties().getProperty( "module.VCO.onde.triangle"));
		//triangle = new JCheckBox("Triangle");
		waveGroup.add(triangle);
		triangle.setSize( 80,20 );
		triangle.setBackground( Color.gray );
		triangle.setForeground( Color.white );
		if(language == "Chinese")
			scie = new JCheckBox(new String(configuration.getProperties().getProperty( "module.VCO.onde.scie").getBytes("iso8859-1"), "utf-8"));
		else
			scie = new JCheckBox(configuration.getProperties().getProperty( "module.VCO.onde.scie"));
		//scie = new JCheckBox("Scie");
		waveGroup.add(scie);
		scie.setSize( 80,20 );
		scie.setBackground( Color.gray );
		scie.setForeground( Color.white );
		
		icone1 = new ImageIcon ( this.getClass().getResource( "/images/signal-carre.jpg" ) ) ;
		signalcarre = new JLabel( icone1 );
		signalcarre.setSize( icone1.getIconWidth(), icone1.getIconHeight() );
		icone2 = new ImageIcon ( this.getClass().getResource( "/images/signal-triangle.jpg" ) );
		signaltriangle = new JLabel( icone2 );
		signaltriangle.setSize( icone2.getIconWidth(), icone2.getIconHeight() );
		
		icone3 = new ImageIcon ( this.getClass().getResource( "/images/signal-scie.jpg" ) );
		signalscie = new JLabel( icone3 );
		signalscie.setSize( icone3.getIconWidth(), icone3.getIconHeight() );
			
		add( carre );
		add( triangle );
        add( scie );
        add( signalcarre );
        add( signaltriangle );
        add( signalscie );
        
        setVisible( true );
	}
	
	public void setLocation(){
		carre.setLocation( 0, 0 );
		triangle.setLocation( ( getWidth() / 2 ) - ( triangle.getWidth() / 2 ), 0 );
		scie.setLocation( getWidth() - scie.getWidth(), 0 );
		signalcarre.setLocation( 0,20 );
		signaltriangle.setLocation( ( getWidth() / 2 ) - ( triangle.getWidth() / 2 ), 20);
		signalscie.setLocation( getWidth() - signalscie.getWidth(), 20 );
	}
	
	public JCheckBox getTriangle() {
		return triangle;
	}

	public void setTriangle(JCheckBox triangle) {
		this.triangle = triangle;
	}
	
	public JCheckBox getCarre() {
		return carre;
	}

	public void setCarre(JCheckBox carre) {
		this.carre = carre;
	}
	
	public JCheckBox getScie() {
		return scie;
	}

	public void setScie(JCheckBox scie) {
		this.scie = scie;
	}
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox triangle;
	private JCheckBox carre;
	private JCheckBox scie;
	private ButtonGroup waveGroup;
	
	private IConfigurationLoader configuration;
	
	
	ImageIcon icone1;
	ImageIcon icone2;
	ImageIcon icone3;
	JLabel signalcarre;
	JLabel signaltriangle;
	JLabel signalscie;
	static int largeur;
	static int hauteur;
	static int largeur2;
	static int hauteur2;
}
