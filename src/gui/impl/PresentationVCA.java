package gui.impl;

import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import stringloader.IConfigurationLoader;

import kernel.Module;
import kernel.impl.VCA;
import controler.CInPort;
import controler.COutPort;
import controler.CVCA;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCA;

/**
 * Class PresentationVCA extends class APresentationModule
 * set information for displaying module VCA
 */

public class PresentationVCA extends APresentationModule {

	/**
	 * Two constructors of PresentationVCA
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	public PresentationVCA( IConfigurationLoader configuration ) 
	throws UnsupportedEncodingException {
		this.configuration = configuration;
		initComponentVCA(configuration);
	}
	
	public PresentationVCA( IConfigurationLoader configuration, String savedOne ) 
	throws UnsupportedEncodingException {
		this.configuration = configuration;
		initComponentVCA( configuration, savedOne );
	}

	/**
	 * Initiate components of VCA
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	private void initComponentVCA(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		this.configuration = configuration;
		String language  = this.configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		
		labelVCA = new JLabel();
		if(language == "Chinese")
			labelVCA.setText(new String(configuration.getProperties().getProperty("module.VCA.title").getBytes("iso8859-1"), "utf-8"));
        else
        	labelVCA.setText(configuration.getProperties().getProperty("module.VCA.title"));
		
		labelVCA.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCA.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );	
		paramVCA = new ReglageVCA(configuration);
		CInPort cAmPort = new CInPort( super.getCurrentPortId() );
        super.setCurrentPortId( super.getCurrentPortId() + 1 );
		am = cAmPort.getPresentation();
		CInPort cInport = new CInPort( super.getCurrentPortId() );
        super.setCurrentPortId( super.getCurrentPortId() + 1 );
		inPort = cInport.getPresentation();
		COutPort cOutPort = new COutPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		outPort = cOutPort.getPresentation();
		
		add( labelVCA );
		
		JLabel jLabelAm = new JLabel();
        if(language == "Chinese")
        	jLabelAm.setText(new String(configuration.getProperties().getProperty("module.VCA.am").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelAm.setText(configuration.getProperties().getProperty("module.VCA.am"));
        jLabelAm.setSize(50,50);
        jLabelAm.setLocation(0, ( ( getHeight()/3 ) - ( am.getHeight()/2 ) ) - 35);
        jLabelAm.setForeground(Color.white);
        add(jLabelAm);
        
		add( am );
		am.setLocation(0, ( ( getHeight()/3 ) - ( am.getHeight()/2 ) ) );
		add( inPort );
		inPort.setLocation(0, ( (getHeight()/3) * 2 ) - ( inPort.getHeight()/2 ) );
		System.out.println( ( getHeight() ) - ( inPort.getHeight() ) );
		
		JLabel jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.VCA.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.VCA.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, ( ( getHeight() / 3 ) * 2 ) - ( inPort.getHeight()/2 ) + 40);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
        
        JLabel jLabelOut = new JLabel();
        if(language == "Chinese")
        	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCA.out").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelOut.setText(configuration.getProperties().getProperty("module.VCA.out"));
        jLabelOut.setSize(50,50);
        jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35);
        jLabelOut.setForeground(Color.white);
        add(jLabelOut);
        
		add( outPort );
		outPort.setLocation( getWidth() - outPort.getWidth(), 
				( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
		add(paramVCA);
		setParameterPosition();
		setTitlePosition();

	}

	private void initComponentVCA(IConfigurationLoader configuration, String savedOne) throws UnsupportedEncodingException {
		this.configuration = configuration;
		String [] savedVCO = savedOne.split( "\\|" );
        String inPortInfo = savedVCO[ this.inPortIndex ];
        int inPortID = 
        	Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
        int amPortID = 
        	Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ].split( "," )[ 1 ] );
        String outPortInfo = savedVCO[ this.outPortIndex ];
        int outPortID = Integer.valueOf( ( ( outPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
        String locationInfo = savedVCO[ this.locationIndex ];
        String locationInfoX = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[0] );
        String locationInfoY = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[1] );
        int xPosition = Integer.valueOf( locationInfoX.split( "," )[ 1 ] );
        int yPosition = Integer.valueOf( locationInfoY.split( "," )[ 1 ] );
		String language  = this.configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		
		labelVCA = new JLabel();
		if(language == "Chinese")
			labelVCA.setText(new String(configuration.getProperties().getProperty("module.VCA.title").getBytes("iso8859-1"), "utf-8"));
        else
        	labelVCA.setText(configuration.getProperties().getProperty("module.VCA.title"));
		
		labelVCA.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCA.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );	
		paramVCA = new ReglageVCA(configuration);
		CInPort cAmPort = new CInPort( amPortID );
		am = cAmPort.getPresentation();
		CInPort cInport = new CInPort( inPortID );
		inPort = cInport.getPresentation();
		COutPort cOutPort = new COutPort( outPortID );
		outPort = cOutPort.getPresentation();
		
		add( labelVCA );
		
		JLabel jLabelAm = new JLabel();
        if(language == "Chinese")
        	jLabelAm.setText(new String(configuration.getProperties().getProperty("module.VCA.am").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelAm.setText(configuration.getProperties().getProperty("module.VCA.am"));
        jLabelAm.setSize(50,50);
        jLabelAm.setLocation(0, ( ( getHeight()/3 ) - ( am.getHeight()/2 ) ) - 35);
        jLabelAm.setForeground(Color.white);
        add(jLabelAm);
        
		add( am );
		am.setLocation(0, ( ( getHeight()/3 ) - ( am.getHeight()/2 ) ) );
		add( inPort );
		inPort.setLocation(0, ( (getHeight()/3) * 2 ) - ( inPort.getHeight()/2 ) );
		System.out.println( ( getHeight() ) - ( inPort.getHeight() ) );
		
		JLabel jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.VCA.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.VCA.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, ( ( getHeight() / 3 ) * 2 ) - ( inPort.getHeight()/2 ) + 40);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
        
        JLabel jLabelOut = new JLabel();
        if(language == "Chinese")
        	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCA.out").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelOut.setText(configuration.getProperties().getProperty("module.VCA.out"));
        jLabelOut.setSize(50,50);
        jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35);
        jLabelOut.setForeground(Color.white);
        add(jLabelOut);
        
		add( outPort );
		outPort.setLocation( getWidth() - outPort.getWidth(), 
				( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
		add(paramVCA);
		setParameterPosition();
		setTitlePosition();
		setLocation( xPosition, yPosition );
	}
	private void setTitlePosition() {
		labelVCA.setSize( 400, 30 );
        labelVCA.setLocation( ( getWidth() / 2 ) - ( labelVCA.getWidth() / 2 ), 0 );
        labelVCA.setForeground(Color.white);

	}

	private void setParameterPosition() {
		paramVCA.setSize(/*360*/240, 120);
		paramVCA.setLocation( ( getWidth() / 2 ) - ( paramVCA.getWidth() / 2 ),
				30 );
		paramVCA.setLocation();

	}
	
	public void initListener() {
		
		setParameterListener();
		setDefaultValue();
		
	}
	
	/**
	 * set default values for VCA components
	 */
	
	private void setDefaultValue(){
		( ( CVCA ) getControl() ).setAttVCA(
        		paramVCA.getAtt().choisirAffichageValeur( paramVCA.getAtt().getSigneAff(), 
        												   paramVCA.getAtt().getTs() )
        );
		
		( ( CVCA ) getControl() ).setBase(
				paramVCA.getBase().choisirAffichageValeur( paramVCA.getBase().getSigneAff(), 
														    paramVCA.getBase().getTs() )
						);
	}
	

	private void setParameterListener() {
		paramVCA.getAtt().getTs().addChangeListener(new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				((CVCA) getControl()).setAttVCA(
						paramVCA.getAtt().choisirAffichageValeur(paramVCA.getAtt().getSigneAff(), 
																 paramVCA.getAtt().getTs()
						)
						);
				
			}
		});
		
		//il n'existe pas de Base sur la partie VCA
		
		paramVCA.getBase().getTs().addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CVCA ) getControl() ).setBase(
						paramVCA.getBase().choisirAffichageValeur(paramVCA.getBase().getSigneAff(), 
																   paramVCA.getBase().getTs()
																  )
																  );
				
			}
			
		});
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public JLabel getNameVCA() {
		return labelVCA;
	}

	public void setNameVCA(JLabel nameVCA) {
		this.labelVCA = nameVCA;
	}

	
	@Override
	public PresentationInPortImpl getInPort() {
		// TODO Auto-generated method stub
		return inPort;
	}

	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return outPort;
	}

	@Override
	public void setControl(Module module) {
		super.control = module;
		this.inPort.getControl().setInport( module.getInPorts().get( "in" ) );
		/**find a wait to add am inport*/
		this.am.getControl().setInport( module.getInPorts().get( "am" ) );
		this.outPort.getControl().setModule( module );
	}
	
	public PresentationInPortImpl getAm() {
		return am;
	}

	public void setAm(PresentationInPortImpl am) {
		this.am = am;
	}
	
	@Override
	public void setInPort( PresentationInPortImpl inPort ) {
		this.inPort = inPort;
		
	}

	@Override
	public void setOutPort( PresentationOutPortImpl outPort ) {
		this.outPort = outPort;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append( "VCA:|" );
		result.append( "Inport:" );
		result.append( "in," ).append( inPort.getControl().getId() ).append( ";" );
		result.append( "am," ).append( am.getControl().getId() ).append( "|" );
		result.append( "Outport:" );
		result.append( "out," ).append( outPort.getControl().getId() ).append( "|" );
		result.append( "Parameter:" );
		result.append( "att," ).append( ( ( VCA )control ).getAttVCA() ).append( ";" );
		result.append( "base," ).append( ( ( VCA )control ).getBase() ).append( "|" );
		result.append( "Position:" );
		result.append( "x," ).append( this.getLocation().x ).append( ";" );
		result.append( "y," ).append( this.getLocation().y ).append( "|" );
		return result.toString();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ReglageVCA paramVCA;
	private PresentationInPortImpl am;
	private PresentationInPortImpl inPort;
	private PresentationOutPortImpl outPort;
	private JLabel labelVCA;
	private IConfigurationLoader configuration;

}
