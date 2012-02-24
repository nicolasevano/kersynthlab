package gui.impl;

import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import stringloader.IConfigurationLoader;

import kernel.Module;
import controler.CVCF;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCF;

public class PresentationVCF extends APresentationModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReglageVCF paramVCF;
	private CVCF control;
	private PresentationInPortImpl inPort;
	private PresentationOutPortImpl outPort;
	private JLabel labelVCF;
	//private String nameModule = "MODULE VCF";

	public PresentationVCF(IConfigurationLoader configuration) throws UnsupportedEncodingException {
//		control = new CVCF();
//		control.setPresentation(this);
		String language = configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		
		//labelVCF = new JLabel(nameModule);
		labelVCF = new JLabel();
		if(language == "Chinese")
			labelVCF.setText(new String(configuration.getProperties().getProperty("module.VCF.title").getBytes("iso8859-1"), "utf-8"));
		else
			labelVCF.setText(configuration.getProperties().getProperty("module.VCF.title"));
		labelVCF.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCF.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );
		
		paramVCF = new ReglageVCF(configuration);
		inPort = new PresentationInPortImpl();
		outPort = new PresentationOutPortImpl();
		
		add(labelVCF);
		add(inPort);
		inPort.setLocation(0,(getHeight()/2) - (inPort.getHeight()/2));
		
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
		add(paramVCF);
		setParameterPosition();
		setTitlePosition();
	}
	
	
	
	private void setTitlePosition() {
		labelVCF.setSize( 400, 30 );
        labelVCF.setLocation( ( getWidth() / 2 ) - ( labelVCF.getWidth() / 2 ), 0 );
        labelVCF.setForeground(Color.white);
		
	}


	public void initListener(){
		setParameterListener();
//		setDefaultValue();
	}

	private void setParameterPosition() {
		paramVCF.setSize(/*360*/240, 120);
		paramVCF.setLocation( ( getWidth() / 2 ) - ( paramVCF.getWidth() / 2 ),
				30 );
		paramVCF.setLocation();
		
	}
	
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



	public CVCF getControl() {
		return control;
	}

	public void setControl(CVCF control) {
		this.control = control;
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
		
	}



	@Override
	public PresentationInPortImpl getInPort() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setInPort(PresentationInPortImpl inPort) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		// TODO Auto-generated method stub
		
	}
	
	
	private IConfigurationLoader configuration;

}
