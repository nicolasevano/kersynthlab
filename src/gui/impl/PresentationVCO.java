package gui.impl;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import stringloader.IConfigurationLoader;

import kernel.impl.vco.VCO.WaveForm;

import gui.APresentationModule;
import gui.impl.subpresentation.Onde;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCO;


import controler.CVCO;



public class PresentationVCO extends APresentationModule {
	
	
    // End of variables declaration  
	
	public PresentationVCO(IConfigurationLoader configuration){
		this.configuration = configuration;
		initComponents(this.configuration);
	}

	private void initComponents(IConfigurationLoader configuration) {
		this.configuration = configuration;
		jLabel4 = new JLabel();
        //instanciation des composants
<<<<<<< HEAD
        parametre = new ReglageVCO();
        forme = new Onde();
=======
        parametre = new Reglage(configuration);
        forme = new Onde(configuration);
>>>>>>> 264e54a7baa4bde5f84abb0d82be7689e7030380
		inPort = new PresentationInPortImpl();
		outPort = new PresentationOutPortImpl();
        jLabel4.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
        //jLabel4.setText( "MODULE VCO" );
        jLabel4.setText(configuration.getProperties().getProperty("module.VCO.title"));
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        setLayout( null );
        setBackground( Color.gray );
<<<<<<< HEAD
        setSize( 500, 250 );//On donne une taille à notre fenêtre
//        JLabel nameInPort = new JLabel("in");
//        add(nameInPort);
//        nameInPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) - 100 );
=======
        setSize( 500, 250 );//On donne une taille ï¿½notre fené˜¾re
>>>>>>> 264e54a7baa4bde5f84abb0d82be7689e7030380
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
					( ( CVCO ) getControl() ).setAtt(
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
				( ( CVCO ) getControl() ).setPitch(
							parametre.getPitch().choisirAffichageValeur(parametre.getPitch().getSigneAff(), 
																	    parametre.getPitch().getTs()
																	   )
																	   );
			}
        });
        parametre.getBase().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				( ( CVCO ) getControl() ).setBase(
							parametre.getBase().choisirAffichageValeur(parametre.getBase().getSigneAff(), 
																	   parametre.getBase().getTs()
																	  )
																	  );
			}
        });
	}
	
	private void setDefaultValue(){
		( ( CVCO ) getControl() ).setAtt(
        		parametre.getAtt().choisirAffichageValeur( parametre.getAtt().getSigneAff(), 
        												   parametre.getAtt().getTs() )
        );
		( ( CVCO ) getControl() ).setPitch(
        		parametre.getPitch().choisirAffichageValeur( parametre.getPitch().getSigneAff(), 
        													 parametre.getPitch().getTs() )
				        );
		( ( CVCO ) getControl() ).setBase(
				parametre.getBase().choisirAffichageValeur( parametre.getBase().getSigneAff(), 
														    parametre.getBase().getTs() )
						);
		( ( CVCO ) getControl() ).setWaveForm(WaveForm.SQUARE);
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
					( ( CVCO ) getControl() ).setWaveForm( WaveForm.SQUARE );
				}
			}
		});
		forme.getScie().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if( forme.getScie().isSelected() ){
					( ( CVCO ) getControl() ).setWaveForm( WaveForm.SAW );
				}
			}
		});
		forme.getTriangle().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if( forme.getTriangle().isSelected() ){
					( ( CVCO ) getControl() ).setWaveForm( WaveForm.TRIANGLE );
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
	
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration                     
    private JLabel jLabel4;
    private ReglageVCO parametre;
    private Onde forme;
	
	private PresentationOutPortImpl outPort;

	private PresentationInPortImpl inPort;
	
	/*public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresentationVCO(IConfigurationLoader configuration).setVisible(true);
            }
        });	
	}*/
	
	private IConfigurationLoader configuration;
}
