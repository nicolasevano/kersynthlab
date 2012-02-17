package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

//import command.Command;

//import listener.DessinListener;
//import listener.DessinMotionListener;
import listener.DragModuleZoneGestureListener;
import listener.DragModuleZoneListener;
//import listener.DragZoneDessinGestureListener;
//import listener.DragZoneDessinListener;
import listener.ModuleListener;
import listener.ModuleMotionListener;
//import listener.ModuleZoneClickListener;
import listener.ModuleZoneDropTargetListener;
//import listener.ModuleZoneTropListener;
//import listener.ZoneDeDessinDropTargetListener;
//import shape.Dessin;
import controler.CModuleZone;

public class ModuleZone extends JPanel{
	
	
	public ModuleZone(){
		setPreferredSize( new Dimension( 600,500 ) );
		setSize(600, 500);
		
		setBackground( Color.white );
		//mandatory!!!
		setLayout( null );
		
		mzdtl = new ModuleZoneDropTargetListener();
		//mzdtl.setZoneDessin(this);
		dropTarget = new DropTarget( this, mzdtl );
		//TODO One listener can done each of this both instantiation.
		aDL = new ModuleListener();
		( ( ModuleListener ) aDL).setCurrentPlan(this);
		aDML = new ModuleMotionListener();
		
		addMouseListener( aDL );
		addMouseMotionListener( aDML );
		dmzl = new DragModuleZoneListener();
		//dmzl.setZoneDessin( this );
		dragSource = new DragSource();
		dmzgl = new DragModuleZoneGestureListener();
		//dmzgl.setZoneDessin(this);
		dragSource.createDefaultDragGestureRecognizer(this, 
													  DnDConstants.ACTION_MOVE, 
													  dmzgl
													  );
		
	}
	
	public void setPoubelle(Poubelle poubelle) {
		this.poubelle = poubelle;
		this.add(this.poubelle,0);
		this.getComponent(0).setLocation(0,this.getHeight() - poubelle.getHeight());
		this.repaint();
	}
	
	public void addElement(Object o){
		
		add( ( Module ) o);
		validate();
		repaint();
		
	}
	
	/*public void setOUT(presentationOUTImpl out){
		this.out = out;
		this.add(this.out, 0);
		this.getComponent(0).setLocation(10, 10);
		this.repaint();
	}*/
	
	public void paint(Graphics gra){
		super.paint(gra);
		if(this.getComponent(0) != null && this.getComponentCount() == 1)
			this.getComponent(0).setLocation(0,this.getHeight() - poubelle.getHeight());
		else{
			Component [] Components = this.getComponents();
		}
	}
	
	public CModuleZone getControl() {
		return control;
	}

	public void setControl( CModuleZone control ) {
		this.control = control;
	}
	
	public Border getRaisedbevel() {
		return raisedbevel;
	}
	
	public Border getLoweredbevel() {
		return loweredbevel;
	}
	
	public MouseListener getaDL() {
		return aDL;
	}

	public void setaDL(MouseListener aDL) {
		this.aDL = aDL;
	}
	
	/**mouse listener used to defined origin point of current shape*/
	protected MouseListener aDL;
	
	/**mouse dragged listener used to compute motion of the current shape */
	protected MouseMotionListener aDML;
	
	protected DragModuleZoneListener dmzl;
	
	protected DragModuleZoneGestureListener dmzgl;
	
	//protected Command currentCommand;
	
	protected ModuleZoneDropTargetListener mzdtl;
	
	protected DropTarget dropTarget;
	
	private Module selected;
	
	private DragGestureEvent initialEvent;
	
	private DragSource dragSource;
	
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	private static final long serialVersionUID = 1L;
	
	private Color currentColor = Color.BLUE;
	
	
	
	private CModuleZone control;
	private Poubelle poubelle;
	//private presentationOUTImpl out;
	
}
