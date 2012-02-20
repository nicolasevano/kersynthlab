package gui.impl.subpresentation;

//package port;


import gui.IPresentationOutPort;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PresentationOutPortImpl extends JPanel implements IPresentationOutPort{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur;
	private static int hauteur;
	protected ImageIcon icone ;
	protected JLabel face ;

	public PresentationOutPortImpl(){
		this.setBackground(Color.gray);
	
		icone = new ImageIcon ("images/port.png") ;
		face = new JLabel(icone);
		largeur = icone.getIconWidth ();
		hauteur = icone.getIconHeight ();
		face.setSize (largeur, hauteur) ;
		this.setLayout(new BorderLayout());
		//add(,face);
		add(face,BorderLayout.CENTER);
		face.setVisible (true) ;
		setOpaque (false) ;
		setSize (face.getSize ()) ;
		setPreferredSize (getSize ()) ;
		
	}
/*	public static void main (String args []) {

		JFrame f = new JFrame ("Test Affichage Port");
		f.getContentPane ().add (new presentationInPortImpl()) ;
		f.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent e) {
				System.exit (0) ;
			}
		}) ;
		f.pack () ;
		f.setVisible (true) ;
	} */

}
