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
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	protected ImageIcon icone ;
	protected JLabel face ;
	
	public presentationInPortImpl(){
		
		icone = new ImageIcon ("images/port.png") ;
		face = new JLabel(icone);
		
		largeur = icone.getIconWidth ();
		hauteur = icone.getIconHeight ()+9;
		face.setSize (largeur, hauteur) ;
		this.setLayout(new BorderLayout());
		add(BorderLayout.CENTER,face);
		face.setVisible (true) ;
		
		setSize (face.getSize ()) ;
		
		setPreferredSize (getSize ()) ;
		
	}	

}
