package gui.impl;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controler.COUT;
import gui.IPresentationOUT;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;

public class PresentationOUTImpl extends APresentationModule implements IPresentationOUT{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	protected ImageIcon icone ;
	protected JLabel face ;
	protected JPanel portIn;
	protected GridLayout myGridLay;

	
	private COUT controle; 


	public PresentationOUTImpl(){	
		portIn = new PresentationInPortImpl();
		icone = new ImageIcon ( "images/baffle.png" ) ;
		face = new JLabel(icone);
		//face.setLocation (0, 0) ;
		this.setBackground( Color.gray );
		this.setLayout( null );
		
		setPreferredSize(this.getSize());
		largeur = icone.getIconWidth () + 2;
		hauteur = icone.getIconHeight () + 2;
		
		//face.setSize (largeur, hauteur) ;
		face.setVisible ( true ) ;
		face.setSize( icone.getIconWidth(), icone.getIconHeight() );
		//JPanel faceContainer = new JPanel();
		//faceContainer.setLayout( new BorderLayout() );
		//faceContainer.add( BorderLayout.CENTER, face );
		//faceContainer.setBackground( Color.red );
		//faceContainer.setSize( icone.getIconWidth(), icone.getIconHeight() );
		//faceContainer.setPreferredSize( faceContainer.getSize() );
		//faceContainer.setOpaque( false );
		//setOpaque(false);
		//setLayout(new BorderLayout());
		add( face );
		face.setLocation( portIn.getWidth() + 3,1 );
		add( portIn );
		portIn.setLocation(0, (hauteur / 2) - (portIn.getHeight() / 2) );
		setSize( largeur + portIn.getWidth() + 2 , hauteur );
		//controle.setPresentation(this);
	}
	
	public COUT getControle() {
		return controle;
	}

	public void setControle(COUT controle) {
		this.controle = controle;
	}
	
	
	@Override
	public boolean isConnectedCable() {
		// TODO Auto-generated method stub
		return false;
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
		f.setVisible (true) ;
	}

}
