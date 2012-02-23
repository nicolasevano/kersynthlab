package gui.impl;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kernel.Module;
import stringloader.IConfigurationLoader;

import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationMolette;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.SigneAffichage;
import controler.CADSR;
import controler.CInPort;
import controler.COutPort;

/**
 * 
 * @author nicolas
 *
 */
public class PresentationADSR extends APresentationModule{

	/**
	 * Public constructor
	 */
	public PresentationADSR(IConfigurationLoader configuration){
		
		this.configuration = configuration;
		
		setBackground( Color.gray );
		attackTime = new PresentationMolette( SigneAffichage.positif, 1000, configuration.getProperties().getProperty("module.ADSR.attackTime") );
		initialDelay = new PresentationMolette( SigneAffichage.positif, 1000,configuration.getProperties().getProperty("module.ADSR.initialDelay"));
		sustainAmp = new PresentationMolette( SigneAffichage.positif, 32768, configuration.getProperties().getProperty("module.ADSR.sustainAmp") );
		finalDelay = new PresentationMolette( SigneAffichage.positif, 1000, configuration.getProperties().getProperty("module.ADSR.finalDelay"));
		CInPort cInport = new CInPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		inPort = cInport.getPresentation();
		COutPort cOutport = new COutPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		outPort = cOutport.getPresentation();
		tittle = new JLabel();
		tittle.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		tittle.setText(configuration.getProperties().getProperty("module.ADSR.title"));
		//tittle.setText( "MODULE ADSR" );
		tittle.setBorder( new javax.swing.border.MatteBorder( null ) );
		tittle.setForeground( Color.white );
		//tittle.setVisible( true );
		setLayout( null );
		add( tittle );
		add( inPort );
		add( attackTime );
		add( initialDelay );
        add( sustainAmp );
        add( finalDelay );
        add( outPort );
        setVisible( true );
        setPosition();
	}
	
	/**
	 * set position of each component on ADSR presentation JPanel
	 */
	private void setPosition(){
		setSize( 360,300 );
		tittle.setSize( 250, 30 );
        tittle.setLocation( ( getWidth() / 2 ) - ( tittle.getWidth() / 2 ), 0 );
        attackTime.setSize( 120,120 );
        attackTime.setLocation( ( getWidth() / 2 ) - attackTime.getWidth() , 30);
        initialDelay.setSize( 120,120 );
        initialDelay.setLocation( ( getWidth() / 2 ) , 30);
        sustainAmp.setSize( 120,120 );
        sustainAmp.setLocation( ( getWidth() / 2 ) - sustainAmp.getWidth(), 
        						30 + sustainAmp.getHeight() );
        finalDelay.setSize( 120,120 );
        finalDelay.setLocation( ( getWidth() / 2 ), 
        						30 + finalDelay.getHeight() );
        inPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
        outPort.setLocation( getWidth() - outPort.getWidth(), 
				 			 ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
	}
	
	/**
	 * initiate scrolled listener
	 */
	public void initListener(){
		attackTime.getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					( ( CADSR ) getControl() ).setAttackTime(
							attackTime.choisirAffichageValeur( attackTime.getSigneAff(), attackTime.getTs() )
				                  		 );
			}
        });
		initialDelay.getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CADSR ) getControl() ).setDelayTime(
					 initialDelay.choisirAffichageValeur( initialDelay.getSigneAff(), initialDelay.getTs() )
									    );
			}
        });
		sustainAmp.getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CADSR ) getControl() ).setSustainVoltage(
							sustainAmp.choisirAffichageValeur( sustainAmp.getSigneAff(), sustainAmp.getTs() )
								             );
			}
        });
		finalDelay.getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CADSR ) getControl() ).setFinalDelayTime(
							finalDelay.choisirAffichageValeur( finalDelay.getSigneAff(), finalDelay.getTs() )
								             );
			}
        });
	}
	
	/**
	 * initiate default value coming from presentation to control.
	 */
	public void setDefaultValue(){
		( ( CADSR ) getControl() ).setAttackTime(
				attackTime.choisirAffichageValeur( attackTime.getSigneAff(), attackTime.getTs() )
        );
		( ( CADSR ) getControl() ).setDelayTime(
        		initialDelay.choisirAffichageValeur( initialDelay.getSigneAff(), initialDelay.getTs() )
				        );
		( ( CADSR ) getControl() ).setSustainVoltage(
        		sustainAmp.choisirAffichageValeur( sustainAmp.getSigneAff(), sustainAmp.getTs() )
						);
		( ( CADSR ) getControl() ).setFinalDelayTime(
        		finalDelay.choisirAffichageValeur( finalDelay.getSigneAff(), finalDelay.getTs() )
						);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		validate();
	}
	
	public void setControl(Module module){
		super.control = module;
		this.inPort.getControl().setInport(module.getInPorts().get( "gate" ) );
		this.outPort.getControl().setModule( module );
	}
	
	public PresentationInPortImpl getInPort() {
		return inPort;
	}

	public void setInPort(PresentationInPortImpl inPort) {
		this.inPort = inPort;
	}
	
	public PresentationOutPortImpl getOutPort() {
		return outPort;
	}

	public void setOutPort(PresentationOutPortImpl outPort) {
		this.outPort = outPort;
	}
	
	/**
	 * attack time configuration slider
	 */
	private PresentationMolette attackTime;
	
	/**
	 * initial delay configuration slider
	 */
	private PresentationMolette initialDelay;
	
	/**
	 * sustain amplification slider
	 */
	private PresentationMolette sustainAmp;
	
	/**
	 * final delay configuration slider
	 */
	private PresentationMolette finalDelay;
	
	/**
	 * outPort ADSR module instance
	 */
	private PresentationOutPortImpl outPort;

	/**
	 * inPort (gate) ADSR module instance
	 */
	private PresentationInPortImpl inPort;
	
	/**
	 * ADSR module tittle
	 */
	private JLabel tittle;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IConfigurationLoader configuration;
}
