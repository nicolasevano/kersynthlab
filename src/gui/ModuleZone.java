package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controler.CModuleZone;

public class ModuleZone extends JPanel{
	
	
	public ModuleZone(){
		setPreferredSize( new Dimension( 600,500 ) );
		setBackground( Color.white );
		//mandatory!!!
		setLayout( null );
	}
	
	public CModuleZone getControl() {
		return control;
	}

	public void setControl( CModuleZone control ) {
		this.control = control;
	}
	
	private CModuleZone control;

	
}
