package gui.impl;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kernel.impl.vco.VCO.WaveForm;

import gui.APresentationModule;
import gui.impl.subpresentation.Onde;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.Reglage;


import controler.CVCO;



public class PresentationVCO extends APresentationModule {
	
	
    // End of variables declaration  
	
	public PresentationVCO(){
		initComponents();
	}

	private void initComponents() {
        jLabel4 = new javax.swing.JLabel();
        //instanciation des composants
        parametre = new Reglage();
        forme = new Onde();
		inPort = new PresentationInPortImpl();
		outPort = new PresentationOutPortImpl();
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODULE VCO");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        setLayout( null );
        setBackground( Color.gray );
        setSize( 500, 250 );//On donne une taille à notre fenêtre
        add( inPort );
        inPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
        add( outPort );
        outPort.setLocation( getWidth() - outPort.getWidth(), 
        					 ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
        add( parametre );
        setParameterPosition();
        add( forme );
        setFormePosition();
        forme.setBackground(Color.gray);
        add( jLabel4 );
        setTittlePosition();
	}
	
	public void initListener(){
		 setParameterListener();
	     setFormeListener();
	     setDefaultValue();
	}
	
	public CVCO getControl() {
		return control;
	}

	public void setControl(CVCO control) {
		this.control = control;
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
	
	private void setParameterPosition(){
		parametre.setSize( 360, 120 );
        parametre.setLocation( ( getWidth() / 2 ) - ( parametre.getWidth() / 2 ),
        					   30 );
        parametre.setLocation();
	}
	
	private void setParameterListener(){
		parametre.getAtt().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setAtt(
							parametre.getAtt().choisirAffichageValeur(
																	  parametre.getAtt().getSigneAff(), 
																	  parametre.getAtt().getTs()
																	  )
																	  );
			}
        });
        parametre.getPitch().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setPitch(
							parametre.getPitch().choisirAffichageValeur(parametre.getPitch().getSigneAff(), 
																	    parametre.getPitch().getTs()
																	   )
																	   );
			}
        });
        parametre.getBase().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setBase(
							parametre.getBase().choisirAffichageValeur(parametre.getBase().getSigneAff(), 
																	   parametre.getBase().getTs()
																	  )
																	  );
			}
        });
	}
	
	private void setDefaultValue(){
        control.setAtt(
        		parametre.getAtt().choisirAffichageValeur( parametre.getAtt().getSigneAff(), 
        												   parametre.getAtt().getTs() )
        );
        control.setPitch(
        		parametre.getPitch().choisirAffichageValeur( parametre.getPitch().getSigneAff(), 
        													 parametre.getPitch().getTs() )
				        );
        control.setBase(
				parametre.getBase().choisirAffichageValeur( parametre.getBase().getSigneAff(), 
														    parametre.getBase().getTs() )
						);
        control.setWaveForm(WaveForm.SQUARE);
	}
	
	private void setFormePosition(){
		forme.setSize( 360, 100 );
        forme.setLocation( (getWidth() / 2) - (forme.getWidth() / 2), 
        				  30 + parametre.getHeight()  );
        forme.setLocation();
	}
	
	private void setFormeListener(){
		forme.getCarre().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if( forme.getCarre().isSelected() ){
					control.setWaveForm( WaveForm.SQUARE );
				}
			}
		});
		forme.getScie().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if( forme.getScie().isSelected() ){
					control.setWaveForm( WaveForm.SAW );
				}
			}
		});
		forme.getTriangle().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if( forme.getTriangle().isSelected() ){
					control.setWaveForm( WaveForm.TRIANGLE );
				}
			}
		});
		forme.getCarre().setSelected( true );
	}
	
	private void setTittlePosition(){
		jLabel4.setSize( 400, 30 );
        jLabel4.setLocation( ( getWidth() / 2 ) - ( jLabel4.getWidth() / 2 ), 0 );
        jLabel4.setForeground(Color.white);
	}
	
	private CVCO control;
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration                     
    private javax.swing.JLabel jLabel4;
    private Reglage parametre;
    private Onde forme;
	
	private PresentationOutPortImpl outPort;

	private PresentationInPortImpl inPort;
	
	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresentationVCO().setVisible(true);
            }
        });	
	}
}
