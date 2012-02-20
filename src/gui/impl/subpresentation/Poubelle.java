package gui.impl.subpresentation;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.CModuleZone;
import controler.CPoubelle;


public class Poubelle extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Poubelle(){
		
		setPreferredSize( new Dimension( 88,120 ) );
		setBackground(Color.white);
		
		ImageIcon imaPou = new ImageIcon("images/poubelle2.jpg");
		JLabel poubelle = new JLabel(imaPou);
		setSize(88,120);
		add(poubelle);
		poubelle.setVisible(true);
		this.setVisible(true);
		this.repaint();
	}
	
	
	public CModuleZone getcModuleZone() {
		return cModuleZone;
	}
	public void setcModuleZone( CModuleZone cModuleZone ){
		this.cModuleZone = cModuleZone;
	}

	public CPoubelle getControl() {
		return control;
	}

	public void setControl(CPoubelle control){
		this.control = control;
	}

	private CModuleZone cModuleZone;
	private CPoubelle control;
}
