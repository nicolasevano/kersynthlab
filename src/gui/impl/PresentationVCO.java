package gui.impl;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.Module;
import gui.impl.PresentationInPortImpl;


import controler.CVCO;



public class PresentationVCO extends Module {
	
	
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration                     
    private javax.swing.JLabel jLabel4;
    private Reglage parametre;
    private Onde forme;
	
	PresentationOutPortImpl outPort;
	PresentationInPortImpl inPort;
	
	
	
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
	
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setTitle("MODULE VCO");    

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODULE VCO");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        
        //Panel p = new Panel();
        //p.setLayout(new BorderLayout());
        setLayout( null );
        setSize( 800, 400 );//On donne une taille à notre fenêtre
        /*p.add(forme, BorderLayout.SOUTH);
        p.add(inPort, BorderLayout.WEST);
        p.add(outPort, BorderLayout.EAST);       
        p.add(parametre, BorderLayout.CENTER);
        p.add(jLabel4, BorderLayout.NORTH);*/
        add( forme );
        forme.setSize( 600, 400 );
        forme.setLocation( (getWidth() / 2) - (forme.getWidth() / 2), 
        				  ( getHeight() / 2 ) - ( parametre.getHeight() / 2 ) + parametre.getHeight() + 60  );
        forme.setLocation();
        add( inPort );
        inPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
        add( outPort );
        outPort.setLocation( getWidth() - outPort.getWidth(), 
        					 ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) );
        add( parametre );
        parametre.setSize( 360, 250 );
        parametre.setLocation( ( getWidth() / 2 ) - ( parametre.getWidth() / 2 ),
        					   ( getHeight() / 2 ) - ( parametre.getHeight() / 2 ) );
        parametre.setLocation();
        add( jLabel4 );
        jLabel4.setSize( 400, 30 );
        jLabel4.setLocation( ( getWidth() / 2 ) - ( jLabel4.getWidth() / 2 ), 0 );
        //setSize( 800, 400 ); 
		//setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        //add( p );
        parametre.getAtt().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setAtt(
							parametre.getAtt().choisirAffichageValeur(
																	  parametre.getAtt().signeAff, 
																	  parametre.getAtt().getTs()
																	  )
																	  );
			}
        });
        
        parametre.getPitch().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setPitch(
							parametre.getAtt().choisirAffichageValeur(parametre.getPitch().signeAff, 
																	  parametre.getPitch().getTs()
																	  )
																	  );
			}
        });
        
        parametre.getBase().getTs().addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
					control.setBase(
							parametre.getAtt().choisirAffichageValeur(parametre.getBase().signeAff, 
																	  parametre.getBase().getTs()
																	  )
																	  );
			}
        });
	}
	
	public CVCO getControl() {
		return control;
	}

	public void setControl(CVCO control) {
		this.control = control;
	}
	
	private CVCO control;
	
	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresentationVCO().setVisible(true);
            }
        });
		
	}
}
