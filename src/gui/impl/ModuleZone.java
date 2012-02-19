package gui.impl;

import gui.Module;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import command.Command;
import command.DeleteModule;


import listener.ModuleListener;
import listener.ModuleMotionListener;
import controler.CModuleZone;

public class ModuleZone extends JPanel{
	
	
	public ModuleZone(){
		setPreferredSize( new Dimension( 600,500 ) );
		setSize(600, 500);
		
		setBackground( Color.white );
		//mandatory!!!
		setLayout( null );
		
		aDL = new ModuleListener();
		( ( ModuleListener ) aDL ).setCurrentPlan( this );
		aDML = new ModuleMotionListener();
		( ( ModuleMotionListener ) aDML ).setCurrentPlan( this );
		addMouseListener( aDL );
		addMouseMotionListener( aDML );
		
	}
	
	public void setPoubelle(Poubelle poubelle) {
		this.poubelle = poubelle;
		this.add(this.poubelle,0);
		Command deleteCommand = new DeleteModule();
		( ( DeleteModule ) deleteCommand).setPoubelle(this.poubelle);
		deleteCommand.setPlan(this);
		( ( ModuleListener ) aDL ).setDeleteCommand( deleteCommand );
		this.getComponent(0).setLocation(0,this.getHeight() - poubelle.getHeight());
		this.repaint();
	}
	
	public void addElement(Object o){
		
		add( ( Module ) o);
		validate();
		repaint();
		
	}
	
	public void paint(Graphics gra){
		super.paint(gra);
		poubelle.setLocation(0,this.getHeight() - poubelle.getHeight());
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

	public void setaDL( MouseListener aDL ) {
		this.aDL = aDL;
	}
	
	public Module getSelected(){
		return selected;
	}
	
	public void setSelected( Module selected ){
		this.selected = selected;
	}
	/**mouse listener used to defined origin point of current shape*/
	protected MouseListener aDL;
	
	/**mouse dragged listener used to compute motion of the current shape */
	protected MouseMotionListener aDML;
	
	private Module selected;
	
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	private static final long serialVersionUID = 1L;
	
	private CModuleZone control;
	
	private Poubelle poubelle;
	
}
