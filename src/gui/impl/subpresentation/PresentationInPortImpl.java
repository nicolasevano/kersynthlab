package gui.impl.subpresentation;


import gui.IPresentationInPort;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.CInPort;

/**
 * Define properties for displaying InPort
 * class PresentationInPortImpl implements interface IPresentationInPort
 */

public class PresentationInPortImpl extends JPanel implements IPresentationInPort{

	public PresentationInPortImpl(){
		
		icone = new ImageIcon ( this.getClass().getResource( "/images/port.png" ) ) ;
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
	
	public CInPort getControl() {
		return control;
	}
	public void setControl(CInPort control) {
		this.control = control;
	}

	/**
	 * 29007655
	 */
	private CInPort control;
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	protected ImageIcon icone ;
	protected JLabel face ;
}
