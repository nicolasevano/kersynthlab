package gui.impl;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kernel.Module;
import stringloader.IConfigurationLoader;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;

import gui.APresentationModule;
import gui.impl.subpresentation.Onde;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
import gui.impl.subpresentation.ReglageVCO;


import controler.CInPort;
import controler.COutPort;
import controler.CVCO;

/**
 * Class PresentationVCO extends class APresentationModule
 * Define the components of VCO
 */

public class PresentationVCO extends APresentationModule {
       
		/**
		 * Two constructors for PresentationVCO
		 * @param configuration
		 * @throws UnsupportedEncodingException
		 */   
	
        public PresentationVCO(IConfigurationLoader configuration) throws UnsupportedEncodingException{
                this.configuration = configuration;
                initComponents(this.configuration);
        }

        public PresentationVCO(IConfigurationLoader configuration,String saveOne) throws UnsupportedEncodingException{
            this.configuration = configuration;
            initComponents(this.configuration,saveOne);
        }
        
        /**
         * Initiate listener for VCO components
         */
        
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
       
        @Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer result = new StringBuffer();
			result.append( "VCO:|" );
			result.append( "Inport:" );
			result.append( "fm," ).append( inPort.getControl().getId() ).append( "|" );
			result.append( "Outport:" );
			result.append( "out," ).append( outPort.getControl().getId() ).append( "|" );
			result.append( "Parameter:" );
			result.append( "att," ).append( ( ( VCO )control ).getAtt() ).append( ";" );
			result.append( "base," ).append( ( ( VCO )control ).getBase() ).append( ";" );
			result.append( "pitch," ).append( ( ( VCO )control ).getPitch() ).append( ";" );
			result.append( "waveForm," ).append( ( ( VCO )control ).getWaveForm() ).append( "|" );
			result.append( "Position:" );
			result.append( "x," ).append( this.getLocation().x ).append( ";" );
			result.append( "y," ).append( this.getLocation().y ).append( "|" );
			return result.toString();
		}
        
        /**
         * Initiate VCO components and set their displaying properties
         * @param configuration
         * @throws UnsupportedEncodingException
         */
        
        private void initComponents(IConfigurationLoader configuration) throws UnsupportedEncodingException {
            this.configuration = configuration;
            String language = configuration.getLanguage();
            jLabel4 = new JLabel();
            /**instanciation des composants*/
            CInPort cInport = new CInPort( super.getCurrentPortId() );
            super.setCurrentPortId( super.getCurrentPortId() + 1 );
            inPort = cInport.getPresentation();
            COutPort cOutPort = new COutPort( super.getCurrentPortId() );
            super.setCurrentPortId( super.getCurrentPortId() + 1 );
            outPort = cOutPort.getPresentation();
            parametre = new ReglageVCO( configuration );
            forme = new Onde( configuration );
            jLabel4.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
            if(language == "Chinese")
            	jLabel4.setText(new String(configuration.getProperties().getProperty("module.VCO.title").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabel4.setText(configuration.getProperties().getProperty("module.VCO.title"));
            jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
            setLayout( null );
            setBackground( Color.gray );
            setSize( 500, 250 );/**On donne une taille à notre fenêtre*/
            JLabel jLabelFm = new JLabel();
            if(language == "Chinese")
            	jLabelFm.setText(new String(configuration.getProperties().getProperty("module.VCO.fm").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabelFm.setText(configuration.getProperties().getProperty("module.VCO.fm"));
            jLabelFm.setSize(50,50);
            jLabelFm.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) - 35);
            jLabelFm.setForeground(Color.white);
            add(jLabelFm);
            add( inPort );
            inPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
            JLabel jLabelOut = new JLabel();
            if(language == "Chinese")
            	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCO.out").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabelOut.setText(configuration.getProperties().getProperty("module.VCO.out") );
            jLabelOut.setSize(50,50);
            jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35);
            jLabelOut.setForeground(Color.white);
            add(jLabelOut);
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
        
        /**parameter setting still in progress*/
        private void initComponents( IConfigurationLoader configuration,String savedOne ) throws UnsupportedEncodingException {
            this.configuration = configuration;
            String language = configuration.getLanguage();
            jLabel4 = new JLabel();
            String [] savedVCO = savedOne.split( "\\|" );
            String inPortInfo = savedVCO[ this.inPortIndex ];
            int inPortID = Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
            String outPortInfo = savedVCO[ this.outPortIndex ];
            int outPortID = Integer.valueOf( ( ( outPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
            String locationInfo = savedVCO[ this.locationIndex ];
            String locationInfoX = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[0] );
            String locationInfoY = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[1] );
            int xPosition = Integer.valueOf( locationInfoX.split( "," )[ 1 ] );
            int yPosition = Integer.valueOf( locationInfoY.split( "," )[ 1 ] );
            /**instanciation des composants*/
            CInPort cInport = new CInPort( inPortID );
            inPort = cInport.getPresentation();
            COutPort cOutPort = new COutPort( outPortID );
            outPort = cOutPort.getPresentation();
            parametre = new ReglageVCO( configuration );
            forme = new Onde( configuration );
            jLabel4.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
            if( language == "Chinese" )
            	jLabel4.setText(new String(configuration.getProperties().getProperty("module.VCO.title").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabel4.setText(configuration.getProperties().getProperty("module.VCO.title"));
            jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
            setLayout( null );
            setBackground( Color.gray );
            setSize( 500, 250 );/**On donne une taille à notre fenêtre*/
            JLabel jLabelFm = new JLabel();
            if( language == "Chinese" )
            	jLabelFm.setText(new String(configuration.getProperties().getProperty("module.VCO.fm").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabelFm.setText(configuration.getProperties().getProperty("module.VCO.fm"));
            jLabelFm.setSize( 50,50 );
            jLabelFm.setLocation( 0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) - 35 );
            jLabelFm.setForeground( Color.white );
            add( jLabelFm );
            add( inPort );
            inPort.setLocation( 0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
            JLabel jLabelOut = new JLabel();
            if( language == "Chinese" )
            	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.VCO.out").getBytes("iso8859-1"), "utf-8"));
            else
            	jLabelOut.setText(configuration.getProperties().getProperty("module.VCO.out") );
            jLabelOut.setSize(50,50);
            jLabelOut.setLocation( getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2 ) - 35 );
            jLabelOut.setForeground(Color.white);
            add( jLabelOut );
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
            setLocation( xPosition, yPosition );
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
        					parametre.getPitch().choisirAffichageValeur(
        							parametre.getPitch().getSigneAff(),
        							parametre.getPitch().getTs()
        					)
        			);
        		}
        	});
        	parametre.getBase().getTs().addChangeListener(new ChangeListener(){
        		@Override
        		public void stateChanged(ChangeEvent e) {
        			( ( CVCO ) getControl() ).setBase(
        					parametre.getBase().choisirAffichageValeur(
        							parametre.getBase().getSigneAff(),
        							parametre.getBase().getTs()
        					)
        			);
        		}
        	});
        }
       
        public void setControl(Module module){
                System.out.println( "setControl" );
                super.control = module;
                this.inPort.getControl().setInport( module.getInPorts().get( "fm" ) );
                this.outPort.getControl().setModule( module );
        }
        
        /**
         * set default values for attenuator and base
         */
       
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
        
        /**
         * Set VCO title location
         */
       
        private void setTittlePosition(){
                jLabel4.setSize( 400, 30 );
                jLabel4.setLocation( ( getWidth() / 2 ) - ( jLabel4.getWidth() / 2 ), 0 );
                jLabel4.setForeground(Color.white);
        }
       
        /**
         * 29007655
         */
        private static final long serialVersionUID = 1L;
        
        /** Variables declaration  */                  
        private JLabel jLabel4;
        private ReglageVCO parametre;
        private Onde forme;
       
        private PresentationOutPortImpl outPort;

        private PresentationInPortImpl inPort;
        private IConfigurationLoader configuration;
}

