package gui.impl;

import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;

import stringloader.IConfigurationLoader;

import kernel.Module;
import kernel.impl.adsr.ADSR;

import controler.CInPort;
import controler.COutPort;
import controler.CReplicator;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;

public class PresentationReplicator extends APresentationModule {

	//private String nameRepliactor = "MODULE Replicator";

	public PresentationReplicator(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		// TODO Auto-generated constructor stub
		String language = configuration.getLanguage();
		setLayout( null );
		setBackground( Color.gray );
		setSize( 140, 200 );
		
		labelReplicator = new JLabel();
		if(language == "Chinese")
			labelReplicator.setText(new String(configuration.getProperties().getProperty("module.Replicator.title").getBytes("iso8859-1"), "utf-8"));
        else
        	labelReplicator.setText(configuration.getProperties().getProperty("module.Replicator.title"));
		labelReplicator.setBorder(new javax.swing.border.MatteBorder(null));
		labelReplicator.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		CInPort cInport = new CInPort( super.getCurrentPortId() );
        super.setCurrentPortId( super.getCurrentPortId() + 1 );
        inPort = cInport.getPresentation();
        COutPort cOutPort1 = new COutPort( super.getCurrentPortId() );
        outPort1 = cOutPort1.getPresentation();
        COutPort cOutPort2 = new COutPort( super.getCurrentPortId() );
		outPort2 = cOutPort2.getPresentation();
		COutPort cOutPort3 = new COutPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		outPort3 = cOutPort3.getPresentation();
		
		jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.Replicator.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.Replicator.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, (getHeight()/2) - (inPort.getHeight()/2) - 35);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
		
		add(labelReplicator);
		add( inPort );
		inPort.setLocation(0,(getHeight()/2) - (inPort.getHeight()/2));
		add( outPort1 );
		outPort1.setLocation( getWidth() - outPort1.getWidth(), 
				(getHeight()/6) - (outPort1.getHeight()/6));
		
//		System.out.println("Position outPort1: "+ ((getHeight()/6) - (outPort1.getHeight()/6)));
		add( outPort2 );
		outPort2.setLocation( getWidth() - outPort2.getWidth(), 
				( getHeight() / 2) - ( outPort2.getHeight() / 2 ) );
		
//		System.out.println("Position outPort2: "+(( getHeight() / 2) - ( outPort2.getHeight() / 2 )));
		add( outPort3 );
		outPort3.setLocation( getWidth() - outPort3.getWidth(), 
				 ((getHeight()/2) -  (outPort3.getHeight()/2))+51 );
//		System.out.println("position outPort3: "+((((getHeight()))) -  (((outPort3.getHeight())))));
		
		setTitlePosition();
		
	}
	
	public PresentationReplicator( IConfigurationLoader configuration,String savedOne ) 
	throws UnsupportedEncodingException {
		// TODO Auto-generated constructor stub
		String language = configuration.getLanguage();
		setLayout( null );
		setBackground( Color.gray );
		setSize( 140, 200 );
		String [] savedReplicator = savedOne.split( "\\|" );
		String inPortInfo = savedReplicator[ this.inPortIndex ];
		int inPortID = 
        	Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
        String outPortInfo = savedReplicator[ this.outPortIndex ];
        int outPortID = Integer.valueOf( ( ( outPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
        String locationInfo = savedReplicator[ this.locationIndex ];
        String locationInfoX = ( ( ( locationInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ] );
        String locationInfoY = ( ( ( locationInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ] );
        int xPosition = Integer.valueOf( locationInfoX.split( "," )[ 1 ] );
        int yPosition = Integer.valueOf( locationInfoY.split( "," )[ 1 ] );
		labelReplicator = new JLabel();
		if(language == "Chinese")
			labelReplicator.setText(new String(configuration.getProperties().getProperty("module.Replicator.title").getBytes("iso8859-1"), "utf-8"));
        else
        	labelReplicator.setText(configuration.getProperties().getProperty("module.Replicator.title"));
		labelReplicator.setBorder(new javax.swing.border.MatteBorder(null));
		labelReplicator.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		CInPort cInport = new CInPort( inPortID );
        inPort = cInport.getPresentation();
        COutPort cOutPort1 = new COutPort( outPortID );
        outPort1 = cOutPort1.getPresentation();
        COutPort cOutPort2 = new COutPort( outPortID );
		outPort2 = cOutPort2.getPresentation();
		COutPort cOutPort3 = new COutPort( outPortID );
		outPort3 = cOutPort3.getPresentation();
		
		jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.Replicator.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.Replicator.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, (getHeight()/2) - (inPort.getHeight()/2) - 35);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
		
		add(labelReplicator);
		add( inPort );
		inPort.setLocation(0,(getHeight()/2) - (inPort.getHeight()/2));
		add( outPort1 );
		outPort1.setLocation( getWidth() - outPort1.getWidth(), 
				(getHeight()/6) - (outPort1.getHeight()/6));
		
//		System.out.println("Position outPort1: "+ ((getHeight()/6) - (outPort1.getHeight()/6)));
		add( outPort2 );
		outPort2.setLocation( getWidth() - outPort2.getWidth(), 
				( getHeight() / 2) - ( outPort2.getHeight() / 2 ) );
		
//		System.out.println("Position outPort2: "+(( getHeight() / 2) - ( outPort2.getHeight() / 2 )));
		add( outPort3 );
		outPort3.setLocation( getWidth() - outPort3.getWidth(), 
				 ((getHeight()/2) -  (outPort3.getHeight()/2))+51 );
//		System.out.println("position outPort3: "+((((getHeight()))) -  (((outPort3.getHeight())))));
		
		setTitlePosition();
		setLocation( xPosition, yPosition );
	}
	
	private void setTitlePosition() {
		labelReplicator.setSize( 400, 30 );
        labelReplicator.setLocation( ( getWidth() / 2 ) - ( labelReplicator.getWidth() / 2 ), 0 );
        labelReplicator.setForeground(Color.white);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Module getControl() {
		return super.control;
	}

	public PresentationInPortImpl getInPort() {
		return this.inPort;
	}

	public void setInPort( PresentationInPortImpl inPort ) {
		this.inPort = inPort;
	}

	public PresentationOutPortImpl getOutPort1() {
		return outPort1;
	}

	public void setOutPort1(PresentationOutPortImpl outPort1) {
		this.outPort1 = outPort1;
	}

	public PresentationOutPortImpl getOutPort2() {
		return outPort2;
	}

	public void setOutPort2(PresentationOutPortImpl outPort2) {
		this.outPort2 = outPort2;
	}

	public PresentationOutPortImpl getOutPort3() {
		return outPort3;
	}
	
	public void setOutPort3(PresentationOutPortImpl outPort3) {
		this.outPort3 = outPort3;
	}

	@Override
	public void setControl( Module module ) {
		System.out.println( "setControl" );
        super.control = module;
        this.inPort.getControl().setInport( super.control.getInPorts().get( "in" ) );
        this.outPort1.getControl().setModule( super.control );
        this.outPort2.getControl().setModule( super.control );
        this.outPort3.getControl().setModule( super.control );
		
	}

	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return this.outPort1;
	}

	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		this.outPort1 = outPort;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append( "Replicator:|" );
		result.append( "Inport:" );
		result.append( "in," ).append( inPort.getControl().getId() ).append( "|" );
		result.append( "Outport:" );
		result.append( "out," ).append( outPort1.getControl().getId() ).append( "|" );
		result.append( "Parameter:" );
		result.append( "|" );
		result.append( "Position:" );
		result.append( "x," ).append( this.getLocation().x ).append( ";" );
		result.append( "y," ).append( this.getLocation().y ).append( "|" );
		return result.toString();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PresentationInPortImpl inPort;
	private PresentationOutPortImpl outPort1;
	private PresentationOutPortImpl outPort2;
	private PresentationOutPortImpl outPort3;
	private JLabel labelReplicator;
	private JLabel jLabelIn;
	private IConfigurationLoader configuration;

}
