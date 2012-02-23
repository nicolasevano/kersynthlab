package gui.impl;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kernel.Module;
import kernel.impl.vco.VCO.WaveForm;

import controler.CVCA;
import controler.CVCO;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCA;

public class PresentationVCA extends APresentationModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ReglageVCA paramVCA;
	private PresentationInPortImpl am;
	private PresentationInPortImpl inPort;
	private PresentationOutPortImpl outPort;
	private CVCA control;
	private JLabel labelVCA;
	private String nameModule = "MODULE VCA";

	public PresentationVCA() {
		initComponentVCA();
	}

	private void initComponentVCA() {
		setLayout(null);
		setBackground(Color.gray);
		
		labelVCA = new JLabel(nameModule);
		labelVCA.setBorder(new javax.swing.border.MatteBorder(null));
		labelVCA.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		setSize( 380, 200 );
		
		paramVCA = new ReglageVCA();
		am = new PresentationInPortImpl();
		inPort = new PresentationInPortImpl();
		outPort = new PresentationOutPortImpl();
		
		add(labelVCA);
		add(am);
		am.setLocation(0, ((getHeight()/3) - (am.getHeight()/2)));
		add(inPort);
		inPort.setLocation(0,/*110*/((getHeight()/3)*2) - (inPort.getHeight()/2));
		System.out.println((getHeight()) - (inPort.getHeight()));
		add( outPort );
		outPort.setLocation( getWidth() - outPort.getWidth(), 
				( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
		add(paramVCA);
		setParameterPosition();
		setTitlePosition();

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
		//setDefaultValue();
		
	}
	
	
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

	public CVCA getControl() {
		return control;
	}

	public void setControl(CVCA controle) {
		this.control = controle;
	}

	public JLabel getNameVCA() {
		return labelVCA;
	}

	public void setNameVCA(JLabel nameVCA) {
		this.labelVCA = nameVCA;
	}

	public String getNameModule() {
		return nameModule;
	}

	public void setNameModule(String nameModule) {
		this.nameModule = nameModule;
	}

	@Override
	public PresentationInPortImpl getInPort() {
		// TODO Auto-generated method stub
		return null;
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
		//TODO find a wait to add am inport
		this.outPort.getControl().setModule( module );
		
	}

	@Override
	public void setInPort(PresentationInPortImpl inPort) {
		this.inPort = inPort;
		
	}

	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		this.outPort = outPort;
		
	}

}
