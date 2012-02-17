package gui.impl;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JPanel;


public class Reglage extends JPanel{

	public Reglage(){
		
		att = new PresentationMolette(SigneAffichage.negatif, 7, "Att");
		pitch = new PresentationMolette(SigneAffichage.positif, 100, "Pitch");
		base = new PresentationMolette(SigneAffichage.puissance, 7, "Base");
		
		//Panel pane = new Panel();
		//getPreferredSize();
		//setSize(140, 14);
		//setLayout(new GridLayout(1, 3));
		setLayout( null );
		add( att );
		add( pitch );
        add( base );
        setVisible( true );
        
	}
	
	public void setLocation(){
		att.setLocation( ( getWidth() / 6 ) - ( att.getWidth() / 2 ),
				         ( getHeight() / 2 ) - ( att.getHeight() / 2 ) );
		pitch.setLocation( ( getWidth() / 2 ) - ( pitch.getWidth() / 2 ),
		                   ( getHeight() / 2 ) - ( pitch.getHeight() / 2 ) );
		base.setLocation( getWidth() - base.getWidth(),
				          ( getHeight() / 2 ) - ( base.getHeight() / 2 ) );
	}
	
	public PresentationMolette getAtt() {
		return att;
	}

	public void setAtt(PresentationMolette att) {
		this.att = att;
	}

	public PresentationMolette getPitch() {
		return pitch;
	}

	public void setPitch(PresentationMolette pitch) {
		this.pitch = pitch;
	}

	public PresentationMolette getBase() {
		return base;
	}

	public void setBase(PresentationMolette base) {
		this.base = base;
	}
	
	private PresentationMolette att;
	private PresentationMolette base;
	private PresentationMolette pitch;
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	
}
