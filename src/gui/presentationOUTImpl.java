package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controler.COUT;
import gui.presentationInPortImpl;

public class presentationOUTImpl extends Module implements iPresentationOUT{

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


	public presentationOUTImpl(){	
		portIn = new presentationInPortImpl();
		icone = new ImageIcon ( "images/port.png" ) ;
		face = new JLabel(icone);
		//face.setLocation (0, 0) ;
		this.setBackground(Color.gray);
		setSize( 240,200 );
		setPreferredSize(this.getSize());
		largeur = icone.getIconWidth ();
		hauteur = icone.getIconHeight ();
		//face.setSize (largeur, hauteur) ;
		face.setVisible ( true ) ;
		JPanel faceContainer = new JPanel();
		faceContainer.setLayout( new BorderLayout() );
		faceContainer.add( BorderLayout.CENTER, face );
		faceContainer.setBackground( Color.red );
		faceContainer.setSize( icone.getIconWidth(), icone.getIconHeight() );
		faceContainer.setPreferredSize( faceContainer.getSize() );
		faceContainer.setOpaque( false );
		//setOpaque(false);
		setLayout(new BorderLayout());
		add(BorderLayout.WEST,faceContainer);
		add(BorderLayout.WEST,portIn);		
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
		f.getContentPane ().add (new presentationOUTImpl()) ;
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
