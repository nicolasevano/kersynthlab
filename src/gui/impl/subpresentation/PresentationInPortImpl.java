package gui.impl.subpresentation;


import gui.IPresentationInPort;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.CInPort;


public class PresentationInPortImpl extends JPanel implements IPresentationInPort{

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
	
	public CInPort getControl() {
		return control;
	}
	public void setControl(CInPort control) {
		this.control = control;
	}
	
//	public void setLocation(int x, int y){		
//		super.setLocation( x, y );
//		this.x = x;
//		this.y = y;
//	}
//	
//	public Point getLocation(){
//		return new Point( x + getParent().getX(), y + getParent().getY() );
//	}
	
	/**
	 * 29007655
	 */
	private CInPort control;
	private static final long serialVersionUID = 1L;
	private static int largeur = 0;
	private static int hauteur = 0;
	private int x;
	private int y;
	protected ImageIcon icone ;
	protected JLabel face ;
}
