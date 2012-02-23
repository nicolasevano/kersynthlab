package gui.impl.subpresentation;

//import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;
//import gui.impl.subpresentation.PresentationPort;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.geom.QuadCurve2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controler.CWire;


public class PresentationWire extends JPanel{

	/**
	 * public constructor
	 * @param outPort
	 * @param pDest
	 */
	public PresentationWire(PresentationOutPortImpl outPort, Point pDest){
		
		this.outPort = outPort;
		this.pInit = new Point( ( outPort.getLocation().x + ( outPort.getWidth() / 2 ) ) , 
								( outPort.getLocation().y + ( outPort.getHeight() / 2 ) ) );
		this.pDest = pDest;
		setOpaque( false );
		setSize( ( outPort.getWidth() / 2 ), ( outPort.getHeight() / 2 ) );
		setBorder(BorderFactory.createLineBorder(Color.black));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forme = new QuadCurve2D.Double();
		
	}
	
	/**
	 * Draw wire on panel.
	 */
	public void paint( Graphics g ){
		Graphics2D g2 = (Graphics2D)g;
		// Antialiazing
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		// Accelerate graphic rending
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_SPEED);
		g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_SPEED);
		g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
		g2.setRenderingHint(RenderingHints.KEY_DITHERING,RenderingHints.VALUE_DITHER_DISABLE);
		// Compute beginning point and end point of the curve
		int x1 = pInit.x;
		int y1 = pInit.y;
		int x2 = pDest.x;
		int y2 = pDest.y;
		//Intermediate Point
		int xinter = Math.abs( x2-x1 ) / 2;
		int yinter = Math.max( y2,y1 ) + 40;
		
		// define the curve
		forme.setCurve( x1, y1, xinter, yinter, x2, y2);
		System.out.println("ComputeSize 1[x=" + x1 +",y="+ y1 +"]");
		System.out.println("ComputeSize 2[x=" + x2 +",y="+ y2 +"]");
		setSize( Math.max( x1, x2 ) + 5, Math.max( y1, yinter ) );
		g2.setStroke( new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND ) );
		g2.setPaint( Color.BLACK );
		g2.draw( forme );
	}
	
	/**
	 * getter
	 * @return
	 */
	public PresentationOutPortImpl getOutPort() {
		return outPort;
	}

	/**
	 * setter
	 * @param outPort
	 */
	public void setOutPort(PresentationOutPortImpl outPort) {
		this.outPort = outPort;
	}

	/**
	 * getter
	 * @return
	 */
	public Point getpDest() {
		return this.pDest;
	}

	/**
	 * setter
	 * @param pDest
	 */
	public void setpDest(Point pDest) {
		this.pDest = pDest;
	}

	/**
	 * getter
	 * @return pInit
	 */
	public Point getpInit() {
		return this.pInit;
	}

	/**
	 * setter
	 * @param pInit
	 */
	public void setpInit(Point pInit) {
		this.pInit = pInit;
	}
	
	/**
	 * getter
	 * @return inPort
	 */
	public PresentationInPortImpl getInPort() {
		return this.inPort;
	}

	/**
	 * setter
	 * @param inPort
	 */
	public void setInPort(PresentationInPortImpl inPort) {
		this.inPort = inPort;
		if( inPort.getControl() != null ){
			if(inPort.getControl().getInport() != null ){
				control.setInport( inPort.getControl().getInport() );
			} else {
				System.out.println("inport null!");
			}
		} else {
			System.out.println("inport control null!");
		}
	}
	
	/**
	 * getter
	 * @return control
	 */
	public CWire getControl() {
		return this.control;
	}

	/**
	 * setter
	 * @param control
	 */
	public void setControl(CWire control) {
		this.control = control;
	}
	
	public MouseListener getWireListener() {
		return wireListener;
	}

	public void setWireListener(MouseListener wireListener) {
		
		this.wireListener = wireListener;
		this.addMouseListener( this.wireListener );
		
	}
	
	/**
	 * private membre
	 */
	
	/**
	 * wire beginning point
	 */
	private Point pInit;

	/**
	 * wire point end point
	 */
	private Point pDest;

	/**
	 * output port of wire
	 */
	private PresentationOutPortImpl outPort;

	/**
	 * input port of wire
	 */
	private PresentationInPortImpl inPort;
	
	private CWire control;
	
	/**
	 * wire geometric shape
	 */
	private QuadCurve2D.Double forme;
	
	private MouseListener wireListener;
	
	private static final long serialVersionUID = 1L;

}
