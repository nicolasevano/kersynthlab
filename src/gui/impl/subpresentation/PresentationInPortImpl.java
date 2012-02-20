package gui.impl.subpresentation;


import gui.IPresentationInPort;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PresentationInPortImpl extends JPanel implements IPresentationInPort{

	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	protected ImageIcon icone ;
	protected JLabel face ;
	
	public PresentationInPortImpl(){
		
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
