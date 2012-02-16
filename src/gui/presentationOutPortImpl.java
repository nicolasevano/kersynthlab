package port;


import java.awt.Color;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class presentationOutPortImpl extends JPanel implements iPresentationOutPort{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur;
	private static int hauteur;
	protected ImageIcon icone ;
	protected JLabel face ;

	public presentationOutPortImpl(){
		this.setBackground(Color.black);
		icone = new ImageIcon ("images/port.png") ;
		face = new JLabel(icone);
		largeur = icone.getIconWidth ();
		hauteur = icone.getIconHeight ();
		face.setSize (largeur, hauteur) ;
		add(face);
		face.setVisible (true) ;
		setOpaque (false) ;
		setSize (face.getSize ()) ;
		setPreferredSize (getSize ()) ;
		
	}
	public static void main (String args []) {

		JFrame f = new JFrame ("Test Affichage Port");
		f.getContentPane ().add (new presentationInPortImpl()) ;
		f.addWindowListener (new WindowAdapter () {
			public void windowClosing (WindowEvent e) {
				System.exit (0) ;
			}
		}) ;
		f.pack () ;
		f.setVisible (true) ;
	}

}
