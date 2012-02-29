package gui.impl;

import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import stringloader.IConfigurationLoader;

import kernel.Module;
import kernel.impl.vcf.VCF;
import controler.CInPort;
import controler.COutPort;
import controler.CVCF;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCF;

/**
 * Class PresentationVCF extends class APresentationModule
 * Define presentation of VCF components
 */

public class PresentationVCF extends APresentationModule {

	/**
	 * Constructor of PresentationVCF
	 * Set Layout of VCF and components properties in VCF
	 * @param configuration
	 * @throws UnsupportedEncodingException
	 */
	
	public PresentationVCF(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		String language = configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		
		labelVCF = new JLabel();
		if(language == "Chinese")
			labelVCF.setText(new String(configuration.getProperties().getProperty("module.VCF.title").getBytes("iso8859-1"), "utf-8"));
		else
			labelVCF.setText(configuration.getProperties().getProperty("module.VCF.title"));
		labelVCF.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCF.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );
		
		paramVCF = new ReglageVCF( configuration );
		CInPort cFmPort = new CInPort( super.getCurrentPortId() );
        super.setCurrentPortId( super.getCurrentPortId() + 1 );
		fmPort = cFmPort.getPresentation();
		CInPort cInport = new CInPort( super.getCurrentPortId() );
        super.setCurrentPortId( super.getCurrentPortId() + 1 );
		inPort = cInport.getPresentation();
		COutPort cOutPort = new COutPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		outPort = cOutPort.getPresentation();
		
		add(labelVCF);
		
		JLabel jLabelFm = new JLabel();
        if(language == "Chinese")
        	jLabelFm.setText(new String(configuration.getProperties().getProperty("module.VCF.fm").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelFm.setText(configuration.getProperties().getProperty("module.VCF.fm"));
        jLabelFm.setSize(50,50);
        jLabelFm.setLocation(0, ( ( getHeight() / 3 ) - ( fmPort.getHeight() / 2 ) ) - 35);
        jLabelFm.setForeground(Color.white);
        add(jLabelFm);
		
		
		add(fmPort);
		fmPort.setLocation(0, ( ( getHeight() / 3 ) - ( fmPort.getHeight() / 2 ) ) );
		
		
		JLabel jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.VCF.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.VCF.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, ( ( getHeight()/3 ) * 2 ) - ( inPort.getHeight() / 2 ) + 40);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
		add(inPort);
		inPort.setLocation(0,( ( getHeight()/3 ) * 2 ) - ( inPort.getHeight() / 2 ) );
		
		JLabel jLabelOut = new JLabel();
        if(language == "Chinese")
        	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCF.out").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelOut.setText(configuration.getProperties().getProperty("module.VCF.out"));
        jLabelOut.setSize(50,50);
        jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35);
        jLabelOut.setForeground(Color.white);
        add(jLabelOut);
		
		add( outPort );
		outPort.setLocation( getWidth() - outPort.getWidth(), 
				( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
		add( paramVCF );
		setParameterPosition();
		setTitlePosition();
	}
	
	public PresentationVCF(IConfigurationLoader configuration,String savedOne) throws UnsupportedEncodingException {
		String language = configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		String [] savedVCF = savedOne.split( "\\|" );
        String inPortInfo = savedVCF[ this.inPortIndex ];
        int inPortID = 
        	Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
        int fmPortID = 
        	Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ].split( "," )[ 1 ] );
        String outPortInfo = savedVCF[ this.outPortIndex ];
        int outPortID = Integer.valueOf( ( ( outPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
        String locationInfo = savedVCF[ this.locationIndex ];
        String locationInfoX = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[0] );
        String locationInfoY = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[1] );
        int xPosition = Integer.valueOf( locationInfoX.split( "," )[ 1 ] );
        int yPosition = Integer.valueOf( locationInfoY.split( "," )[ 1 ] );
		labelVCF = new JLabel();
		if(language == "Chinese")
			labelVCF.setText(new String(configuration.getProperties().getProperty("module.VCF.title").getBytes("iso8859-1"), "utf-8"));
		else
			labelVCF.setText(configuration.getProperties().getProperty("module.VCF.title"));
		labelVCF.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCF.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );
		
		paramVCF = new ReglageVCF( configuration );
		CInPort cFmPort = new CInPort( inPortID );
		fmPort = cFmPort.getPresentation();
		CInPort cInport = new CInPort( fmPortID );
		inPort = cInport.getPresentation();
		COutPort cOutPort = new COutPort( outPortID );
		outPort = cOutPort.getPresentation();
		
		add( labelVCF );
		add( fmPort );
		fmPort.setLocation(0, ( ( getHeight() / 3 ) - ( fmPort.getHeight() / 2 ) ) );
		add( inPort );
		inPort.setLocation(0,( ( getHeight()/3 ) * 2 ) - ( inPort.getHeight() / 2 ) );
		
		JLabel jLabelOut = new JLabel();
        if(language == "Chinese")
        	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCF.out").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelOut.setText(configuration.getProperties().getProperty("module.VCF.out"));
        jLabelOut.setSize(50,50);
        jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35);
        jLabelOut.setForeground(Color.white);
        add(jLabelOut);
		
		add( outPort );
		outPort.setLocation( getWidth() - outPort.getWidth(), 
				( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
		add( paramVCF );
		setParameterPosition();
		setTitlePosition();
		setLocation( xPosition, yPosition );
	}
	
	/**
	 * Set VCF title location
	 */
	
	private void setTitlePosition() {
		labelVCF.setSize( 400, 30 );
        labelVCF.setLocation( ( getWidth() / 2 ) - ( labelVCF.getWidth() / 2 ), 0 );
        labelVCF.setForeground(Color.white);
		
	}

	/**
	 * Initiate listener for VCF components
	 */
	
	public void initListener(){
		setParameterListener();
		setDefaultValue();
	}
	
	/**
	 * Set locations for parameters of VCF components
	 */

	private void setParameterPosition() {
		paramVCF.setSize(/*360*/240, 120);
		paramVCF.setLocation( ( getWidth() / 2 ) - ( paramVCF.getWidth() / 2 ),
				30 );
		paramVCF.setLocation();
		
	}
	
	/**
	 * Set default values for VCF components
	 */
	
	private void setDefaultValue(){
		( ( CVCF ) getControl() ).setAttVCF(
        		paramVCF.getAtt().choisirAffichageValeur( paramVCF.getAtt().getSigneAff(), 
        												   paramVCF.getAtt().getTs() )
        );
		
		( ( CVCF ) getControl() ).setBaseVCF(
				paramVCF.getBase().choisirAffichageValeur( paramVCF.getBase().getSigneAff(), 
														    paramVCF.getBase().getTs() )
						);
	}
	
	/**
	 * Set listener for VCF parameters
	 */
	
	private void setParameterListener() {
		paramVCF.getAtt().getTs().addChangeListener(new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				((CVCF) getControl()).setAttVCF(
						paramVCF.getAtt().choisirAffichageValeur(paramVCF.getAtt().getSigneAff(), 
																 paramVCF.getAtt().getTs()
						)
						);
				
			}
		});
		
		//il n'existe pas de Base sur la partie VCA
		
		paramVCF.getBase().getTs().addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CVCF ) getControl() ).setBaseVCF(
						paramVCF.getBase().choisirAffichageValeur(paramVCF.getBase().getSigneAff(), 
																   paramVCF.getBase().getTs()
																  )
																  );
				
			}
			
		});
		
	}



	public Module getControl() {
		return super.control;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setControl(Module module) {
		// TODO Auto-generated method stub
		super.control = module;
		this.inPort.getControl().setInport( module.getInPorts().get( "in" ) );
		/**find a wait to add am inport*/
		this.fmPort.getControl().setInport( module.getInPorts().get( "fm" ) );
		this.outPort.getControl().setModule( module );
	}

	public PresentationInPortImpl getFmPort() {
		return fmPort;
	}

	public void setFmPort(PresentationInPortImpl fmPort) {
		this.fmPort = fmPort;
	}

	@Override
	public PresentationInPortImpl getInPort() {
		// TODO Auto-generated method stub
		return inPort;
	}

	@Override
	public void setInPort(PresentationInPortImpl inPort) {
		// TODO Auto-generated method stub
		this.inPort = inPort;
	}

	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return outPort;
	}

	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		// TODO Auto-generated method stub
		this.outPort = outPort;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append( "VCF:|" );
		result.append( "Inport:" );
		result.append( "in," ).append( inPort.getControl().getId() ).append( ";" );
		result.append( "fm," ).append( fmPort.getControl().getId() ).append( "|" );
		result.append( "Outport:" );
		result.append( "out," ).append( outPort.getControl().getId() ).append( "|" );
		result.append( "Parameter:" );
		result.append( "att," ).append( ( ( VCF )control ).getAttVCF() ).append( ";" );
		result.append( "base," ).append( ( ( VCF )control ).getBaseVCF() ).append( "|" );
		result.append( "Position:" );
		result.append( "x," ).append( this.getLocation().x ).append( ";" );
		result.append( "y," ).append( this.getLocation().y ).append( "|" );
		return result.toString();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReglageVCF paramVCF;
	private PresentationInPortImpl inPort;
	private PresentationInPortImpl fmPort;
	private PresentationOutPortImpl outPort;
	private JLabel labelVCF;
}
