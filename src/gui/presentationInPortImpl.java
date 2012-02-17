package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class presentationInPortImpl extends JPanel implements iPresentationInPort{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	protected ImageIcon icone ;
	protected JLabel face ;
	
	public presentationInPortImpl(){
		this.setBackground(Color.gray);
		icone = new ImageIcon ( "images/port.png" ) ;
		face = new JLabel(icone);
		//face.setLocation (0, 0) ;
		largeur = icone.getIconWidth ();
		hauteur = icone.getIconHeight ()+9;
		face.setSize (largeur, hauteur) ;
		this.setLayout(new BorderLayout());
		add(BorderLayout.CENTER,face);
		face.setVisible (true) ;
		//setOpaque (false) ;
		setSize (face.getSize ()) ;
		//setSize (10,19) ;
		setPreferredSize (getSize ()) ;
		
	}
	
	//pour les ports: on a un Mpa<String, InPort>: operation getInPorts et getOutPorts
	
	
	
	
	public static void main (String args []) {

		JFrame f = new JFrame ("Test Affichage Port");
		f.getContentPane ().add (new presentationInPortImpl()) ;
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
