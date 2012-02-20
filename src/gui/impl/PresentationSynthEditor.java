package gui.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import controler.CSynthEditor;

public class PresentationSynthEditor extends JFrame{
	public PresentationSynthEditor(){
		super( "KerSynthSound synthetisor editor:" );
		this.addWindowListener( new Finisher() );
		this.getContentPane().setLayout( new BorderLayout() );
		this.setPreferredSize( new Dimension( 1024, 800 ) );
		this.setSize( new Dimension( 1024, 800 ) );
		this.setVisible(true);
		this.pack();
	}
	
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}
	
	public CSynthEditor getControl() {
		return control;
	}

	public void setControl(CSynthEditor control) {
		this.control = control;
	}
	
	public void setModuleZone(PresentationModuleZone moduleZone) {
		this.moduleZone = moduleZone;
		this.getContentPane().add( this.moduleZone, BorderLayout.CENTER );
		this.getContentPane().repaint();
		this.repaint();
	}
	
	public void setToolBoxes(PresentationToolBoxes toolBoxes) {
		this.toolBoxes = toolBoxes;
		this.getContentPane().add( this.toolBoxes, BorderLayout.EAST );
		this.getContentPane().repaint();
		this.repaint();
	}
	
	public void setUserOption(PresentationUserOption userOption) {
		this.userOption = userOption;
		this.setJMenuBar( this.userOption );
		this.repaint();
	}
	
	
	private CSynthEditor control;
	private PresentationModuleZone moduleZone;
	private PresentationToolBoxes toolBoxes;
	private PresentationUserOption userOption;

}
