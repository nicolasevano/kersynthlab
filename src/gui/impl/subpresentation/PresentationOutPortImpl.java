package gui.impl.subpresentation;

import gui.IPresentationOutPort;
import gui.impl.PresentationModuleZone;
import gui.impl.PresentationSynthEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.COutPort;

public class PresentationOutPortImpl extends JPanel implements IPresentationOutPort{

	/**
	 * Define components of OutPort
	 * Class PresentationOutPortImpl implements interface IPresentationOutPort
	 */
	private static final long serialVersionUID = 1L;
	private static int largeur;
	private static int hauteur;
	protected ImageIcon icone ;
	protected JLabel face ;

	public PresentationOutPortImpl(){
		this.setBackground(Color.gray);
	
		icone = new ImageIcon ( this.getClass().getResource( "/images/port.png" ) ) ;
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
	
	public void setLocation(int x, int y){		
		super.setLocation( x, y );
		this.x = x;
		this.y = y;
	}
	
	public Point getLocation(){
		return new Point( x + getParent().getX(), y + getParent().getY() );
	}
	
	public void pain(Graphics g){
		super.paint( g );
		validate();
	}
	
	public PresentationModuleZone getModuZone(Container pane){
		if(pane == null) pane = this;
		Container result = pane.getParent();
		if ( result != null ){
			System.out.println( "A new round on getModule" );
			result =  getModuZone( result );
		} else {
			result = ( ( PresentationSynthEditor ) pane ).getModuleZone();
		}
		return ( PresentationModuleZone ) result;
	}
	
	public COutPort getControl() {
		return control;
	}

	public void setControl(COutPort control) {
		this.control = control;
	}
	
	/**
	 * x on PresentationModuleZone less x position of parent
	 */
	private int x;
	
	/**
	 * y on PresentationModuleZone less y position of parent
	 */
	private int y;
	
	private COutPort control;

}
