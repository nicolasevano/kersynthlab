package gui;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JPanel;


public class Reglage extends JPanel{

	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	
	private presentationMolette att;
	private presentationMolette pitch;
	private presentationMolette base;
	
	public Reglage(){
		
		att = new presentationMolette(SigneAffichage.negatif, 7, "Att");
		pitch = new presentationMolette(SigneAffichage.positif, 100, "Pitch");
		base = new presentationMolette(SigneAffichage.puissance, 7, "Base");
		
		//Panel pane = new Panel();
		//getPreferredSize();
		//setSize(140, 14);
		setLayout(new GridLayout(1, 3));
		add(att);
		add(pitch);
        add(base);
       
        
        setVisible(true);
        
	}

}
