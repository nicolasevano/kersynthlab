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

import kernel.impl.vco.VCO;

import controler.CWire;


public class PresentationWire extends JPanel{

	/**
	 * public constructor
	 * @param outPort
	 * @param pDest
	 */
	public PresentationWire( PresentationOutPortImpl outPort, Point pDest ){
		
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
	
	public PresentationWire( String savedOne ){
		System.out.println("Create wire with a saved one!");
		String [] savedWire = savedOne.split( "\\|" );
		String pInitInfo = savedWire[ this.pInitIndex ];
		int pInitX = 
			Integer.valueOf( ( ( pInitInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
		int pInitY =
			Integer.valueOf( ( ( pInitInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ].split( "," )[ 1 ] );
		String pDestInfo = savedWire[ this.pDestIndex ];
		int pDestX = 
			Integer.valueOf( ( ( pDestInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
		int pDestY = 
			Integer.valueOf( ( ( pDestInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ].split( "," )[ 1 ] );
		String positionInfo = savedWire[ this.positionIndex ];
		int xLocation = 
			Integer.valueOf( ( ( positionInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 0 ].split( "," )[ 1 ] );
		int yLocation = 
			Integer.valueOf( ( ( positionInfo.split( ":" ) )[ 1 ].split( ";" ) )[ 1 ].split( "," )[ 1 ] );
		String inPortInfo = savedWire[ this.inportIndex ];
		this.inPortId = Integer.valueOf( ( ( inPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
        String outPortInfo = savedWire[ this.outportIndex ];
        this.outPortId = Integer.valueOf( ( ( outPortInfo.split( ":" ) )[ 1 ].split( "," ) )[ 1 ] );
		this.pInit = new Point( pInitX , pInitY );
		this.pDest = new Point( pDestX , pDestY );
		setOpaque( false );
		setSize( 120, 120 );
		setBorder( BorderFactory.createLineBorder( Color.black ) );
		setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
		forme = new QuadCurve2D.Double();
		setLocation( xLocation, yLocation );
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
		forme.setCurve( x1, y1, xinter, yinter, x2, y2 );
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
	
	@Override
	public String toString() {
		
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append( "Wire:|" );
		result.append( "Inport:" );
		result.append( "in," ).append( inPort.getControl().getId() ).append( "|" );
		result.append( "Outport:" );
		result.append( "out," ).append( outPort.getControl().getId() ).append( "|" );
		result.append( "Pinit:" );
		result.append( "xPinit," ).append( pInit.x ).append( ";" );
		result.append( "yPinit," ).append( pInit.y ).append( "|" );
		result.append( "Pdest:" );
		result.append( "xPdest," ).append( pDest.x ).append( ";" );
		result.append( "yPdest," ).append( pDest.y ).append( "|" );
		result.append( "Position:" );
		result.append( "x," ).append( this.getLocation().x ).append( ";" );
		result.append( "y," ).append( this.getLocation().y ).append( "|" );
		return result.toString();
		
	}
	
	public int getInportID() {
		return inPortId;
	}

	public void setInportID(int inportID) {
		this.inPortId = inportID;
	}
	
	public int getOutPortId() {
		return outPortId;
	}

	public void setOutPortId(int outPortId) {
		this.outPortId = outPortId;
	}
	
	/**
	 * private member
	 */
	private int nameIndex = 0;
	private int inportIndex = 1;
	private int outportIndex = 2;
	private int pInitIndex = 3;
	private int pDestIndex = 4;
	private int positionIndex = 5;
	private int inPortId;
	private int outPortId;

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
