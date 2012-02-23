package gui.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import controler.CSynthEditor;

/**
 * 
 * @author nicolas
 *
 */
public class PresentationSynthEditor extends JFrame{
	
	/**
	 * Public constructor.
	 */
	public PresentationSynthEditor(){
		super( "KerSynthSound synthetisor editor:" );
		this.addWindowListener( new Finisher() );
		this.getContentPane().setLayout( new BorderLayout() );
		this.setPreferredSize( new Dimension( 1024, 800 ) );
		this.setSize( new Dimension( 1024, 800 ) );
		this.setVisible(true);
		this.pack();
	}
	
	/**
	 * 
	 * @author nicolas
	 * close properly application
	 */
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
	
	public PresentationModuleZone getModuleZone(){
		return this.moduleZone;
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
	
	/**
	 * Current control on this presentation layer.
	 */
	private CSynthEditor control;
	/**
	 * Current module zone presentation.
	 */
	private PresentationModuleZone moduleZone;
	
	/**
	 * Current tool boxes presentation.
	 */
	private PresentationToolBoxes toolBoxes;
	
	/**
	 * Current user option.
	 */
	private PresentationUserOption userOption;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
