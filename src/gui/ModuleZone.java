package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controler.CModuleZone;

public class ModuleZone extends JPanel{
	
	
	public ModuleZone(){
		setPreferredSize( new Dimension( 600,500 ) );
		setSize(600,500);
		setBackground( Color.white );
		//mandatory!!!
		setLayout( null );
		JPanel test = new JPanel();
		test.setBackground(Color.BLACK);
		test.setPreferredSize(new Dimension(100,100));
		test.setSize(100,100);
		test.setVisible(true);
		//test.setLayout(null);
		//Rectangle rectangle = new Rectangle();
		//rectangle.setBounds(0, 400, 100, 100);
		//rectangle.drawRect(0, 400, 100, 100);
		//((Graphics) test).drawRect(0, 400, 100, 100);
		//test.paint( test.getGraphics() );
		this.add(test,0);
		
		this.getComponent(0).setLocation( 0, this.getHeight() - 100 );
		//test.getGraphics().drawRect(0, 400, 100, 100);
		this.repaint();
	}
	
	public CModuleZone getControl() {
		return control;
	}

	public void setControl( CModuleZone control ) {
		this.control = control;
	}
	
	private CModuleZone control;

	
}
