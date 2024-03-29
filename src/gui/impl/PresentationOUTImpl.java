package gui.impl;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import controler.CInPort;

import kernel.Module;
import gui.IPresentationOUT;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;

public class PresentationOUTImpl extends APresentationModule implements IPresentationOUT{

	@Override
	public PresentationInPortImpl getInPort() {
		// TODO Auto-generated method stub
		return portIn;
	}
	
	/**
	 * Constructor of PresentationOUTImpl
	 * define components and their locations for OUT
	 */

	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInPort(PresentationInPortImpl inPort) {
		// TODO Auto-generated method stub
		this.portIn = inPort;
	}

	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		// TODO Auto-generated method stub
		
	}
	
	public PresentationOUTImpl(){
		CInPort cInPort = new CInPort( super.getCurrentPortId() );
		super.setCurrentPortId( super.getCurrentPortId() + 1 );
		portIn = cInPort.getPresentation();
		icone = new ImageIcon ( this.getClass().getResource( "/images/baffle.png" ) ) ;
		face = new JLabel(icone);
		this.setBackground( Color.gray );
		this.setLayout( null );
		
		setPreferredSize(this.getSize());
		largeur = icone.getIconWidth ()/*120*/ + 2;
		hauteur = icone.getIconHeight ()/*120*/ + 2;
		
		face.setVisible ( true ) ;
		face.setSize( icone.getIconWidth()/*120*/, icone.getIconHeight()/*120*/ );
		add( face );
		face.setLocation( portIn.getWidth() + 3,1 );
		add( portIn );
		portIn.setLocation(0, (hauteur / 2) - (portIn.getHeight() / 2) );
		setSize( largeur + portIn.getWidth() + 2 , hauteur );
	}
	
	public PresentationOUTImpl( String savedOne ){
		System.out.println( savedOne );
		String [] savedADSR = savedOne.split( "\\|" );
        String inPortInfo = savedADSR[ this.inPortIndex ];
        System.out.println( inPortInfo );
        int inPortID = Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
        String locationInfo = savedADSR[ this.locationIndex ];
        String locationInfoX = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[0] );
        String locationInfoY = ( ( ( locationInfo.split( ":" ) )[ 1 ].split(";") )[1] );
        int xPosition = Integer.valueOf( locationInfoX.split( "," )[ 1 ] );
        int yPosition = Integer.valueOf( locationInfoY.split( "," )[ 1 ] );
		CInPort cInPort = new CInPort( inPortID );
		portIn = cInPort.getPresentation();
		icone = new ImageIcon ( this.getClass().getResource( "/images/baffle.png" ) ) ;
		face = new JLabel(icone);
		this.setBackground( Color.gray );
		this.setLayout( null );
		
		setPreferredSize(this.getSize());
		largeur = icone.getIconWidth ()/*120 + 2*/;
		hauteur = icone.getIconHeight ()/*120 + 2*/;
		
		face.setVisible ( true ) ;
		face.setSize( largeur/*120*/,hauteur /*120*/ );
		add( face );
		face.setLocation( portIn.getWidth() + 3,1 );
		add( portIn );
		portIn.setLocation(0, (hauteur / 2) - (portIn.getHeight() / 2) );
		setSize( largeur + portIn.getWidth() + 2 , hauteur );
		setLocation( xPosition, yPosition );
	}
	
	@Override
	public boolean isConnectedCable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setControl( Module module ){
		System.out.println("Out set control");
		super.control = module;
		if(module.getInPorts().get( "in" ) != null){
			this.portIn.getControl().setInport( module.getInPorts().get( "in" ) );
		} else {
			System.out.println("port d'entr�e null");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append( "Out:|" );
		result.append( "Inport:" );
		result.append( "in," ).append( portIn.getControl().getId() ).append( "|" );
		result.append( "Outport:" );
		result.append( "|" );
		result.append( "Parameter:" );
		result.append( "|" );
		result.append( "Position:" );
		result.append( "x," ).append( this.getLocation().x ).append( ";" );
		result.append( "y," ).append( this.getLocation().y ).append( "|" );
		return result.toString();
	}
	
	public static void main (String args []) {
		JFrame f = new JFrame ("Test Affichage OUT");
		f.getContentPane ().add (new PresentationOUTImpl()) ;
		f.setBackground(Color.black);
		f.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent e) {
				System.exit (0) ;
			}
		}) ;
		f.pack () ;
		f.setVisible ( true ) ;
	}
	
	protected ImageIcon icone ;
	protected JLabel face ;
	protected PresentationInPortImpl portIn;
	protected GridLayout myGridLay;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	
}
