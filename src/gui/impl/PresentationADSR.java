package gui.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kernel.Module;
import kernel.impl.adsr.ADSR;
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
         * @throws UnsupportedEncodingException 
         */
        public PresentationADSR(IConfigurationLoader configuration) throws UnsupportedEncodingException{
               
                this.configuration = configuration;
                String language = configuration.getLanguage();
               
                setBackground( Color.gray );
                
                if(language == "Chinese")
                {
                	attackTime = new PresentationMolette( SigneAffichage.positif, 1000, new String(configuration.getProperties().getProperty("module.ADSR.attackTime").getBytes("iso8859-1"), "utf-8"),100);
                    initialDelay = new PresentationMolette( SigneAffichage.positif, 1000,new String(configuration.getProperties().getProperty("module.ADSR.initialDelay").getBytes("iso8859-1"), "utf-8"),100);
                    sustainAmp = new PresentationMolette( SigneAffichage.positif, 32768, new String(configuration.getProperties().getProperty("module.ADSR.sustainAmp").getBytes("iso8859-1"), "utf-8"),100 );
                    finalDelay = new PresentationMolette( SigneAffichage.positif, 1000, new String(configuration.getProperties().getProperty("module.ADSR.finalDelay").getBytes("iso8859-1"), "utf-8"),100);
                }
                else
                {
                	attackTime = new PresentationMolette( SigneAffichage.positif, 1000, configuration.getProperties().getProperty("module.ADSR.attackTime"),100 );
                    initialDelay = new PresentationMolette( SigneAffichage.positif, 1000,configuration.getProperties().getProperty("module.ADSR.initialDelay"),100);
                    sustainAmp = new PresentationMolette( SigneAffichage.positif, 32768, configuration.getProperties().getProperty("module.ADSR.sustainAmp"),100 );
                    finalDelay = new PresentationMolette( SigneAffichage.positif, 1000, configuration.getProperties().getProperty("module.ADSR.finalDelay"),100);
                }
                
                attackTime.getTs().setValue(attackTime.getTs().getValeurAiguille());
                initialDelay.getTs().setValue(initialDelay.getTs().getValeurAiguille());
                sustainAmp.getTs().setValue(sustainAmp.getTs().getValeurAiguille());
                finalDelay.getTs().setValue(finalDelay.getTs().getValeurAiguille());
                
                jLabelIn = new JLabel();
                if(language == "Chinese")
                	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.ADSR.in").getBytes("iso8859-1"), "utf-8"));
                else
                	jLabelIn.setText(configuration.getProperties().getProperty("module.ADSR.in"));
                	
                CInPort cInport = new CInPort( super.getCurrentPortId() );
                super.setCurrentPortId( super.getCurrentPortId() + 1 );
                inPort = cInport.getPresentation();
                
                jLabelOut = new JLabel();
                if(language == "Chinese")
                	jLabelOut.setText(new String(configuration.getProperties().getProperty("module.ADSR.out").getBytes("iso8859-1"), "utf-8"));
                else
                	jLabelOut.setText(configuration.getProperties().getProperty("module.ADSR.out"));
                
                COutPort cOutport = new COutPort( super.getCurrentPortId() );
                super.setCurrentPortId( super.getCurrentPortId() + 1 );
                outPort = cOutport.getPresentation();
                tittle = new JLabel();
                tittle.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
                if(language == "Chinese")
                	tittle.setText(new String(configuration.getProperties().getProperty("module.ADSR.title").getBytes("iso8859-1"), "utf-8"));
                else
                	tittle.setText(configuration.getProperties().getProperty("module.ADSR.title"));
                //tittle.setText( "MODULE ADSR" );
                tittle.setBorder( new javax.swing.border.MatteBorder( null ) );
                tittle.setForeground( Color.white );
                //tittle.setVisible( true );
                setLayout( null );
                add( tittle );
                add(jLabelIn);
                add( inPort );
                add( attackTime );
                add( initialDelay );
        add( sustainAmp );
        add( finalDelay );
        add(jLabelOut);
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
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2) - 35);
        jLabelIn.setForeground(Color.white);
        
        inPort.setLocation(0, ( getHeight() / 2 ) - ( inPort.getHeight() / 2 ) );
        
        jLabelOut.setSize(50,50);
        jLabelOut.setLocation(getWidth() - 20, ( getHeight() / 2 ) - ( outPort.getHeight() / 2) - 35);
        jLabelOut.setForeground(Color.white);
        
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
        
        @Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer result = new StringBuffer();
			result.append( "ADSR:|" );
			result.append( "Inport:" );
			result.append( "gate," ).append( inPort.getControl().getId() ).append( "|" );
			result.append( "Outport:" );
			result.append( "out," ).append( outPort.getControl().getId() ).append( "|" );
			result.append( "Parameter:" );
			result.append( "attackTime," ).append( ( ( ADSR )control ).getAttackTime() ).append( ";" );
			result.append( "delayTime," ).append( ( ( ADSR )control ).getDelayTime() ).append( ";" );
			result.append( "sustainVoltage," ).append( ( ( ADSR )control ).getSustainVoltage() ).append( ";" );
			result.append( "finalDelay," ).append( ( ( ADSR )control ).getFinalDelayTime() ).append( "|" );
			result.append( "Position:" );
			result.append( "x," ).append( this.getLocation().x ).append( ";" );
			result.append( "y," ).append( this.getLocation().y ).append( "|" );
			return result.toString();
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
        
        private JLabel jLabelIn;
        private JLabel jLabelOut;
}

