package gui.impl;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Onde extends JPanel {
	
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox triangle;
	private JCheckBox carre;
	private JCheckBox scie;
	ImageIcon icone1;
	ImageIcon icone2;
	ImageIcon icone3;
	JLabel signalcarre;
	JLabel signaltriangle;
	JLabel signalscie;
	static int largeur;
	static int hauteur;
	static int largeur2;
	static int hauteur2;

	public Onde() {		
		
		carre = new JCheckBox("Carrée");
		triangle = new JCheckBox("triangle");
		scie = new JCheckBox("Scie");
		
		icone1 = new ImageIcon ("images/signal-carre.jpg") ;
		signalcarre = new JLabel(icone1);
		
		icone2 = new ImageIcon ("images/signal-triangle.jpg") ;
		signaltriangle = new JLabel(icone2);
		
		icone3 = new ImageIcon ("images/signal-scie.jpg");
		signalscie = new JLabel(icone3);
			
		setLayout(new GridLayout(2, 3));
		add(carre,BorderLayout.CENTER);
		add(triangle,BorderLayout.CENTER);
        add(scie,BorderLayout.CENTER);
        add(signalcarre,BorderLayout.CENTER);
        add(signaltriangle,BorderLayout.CENTER);
        add(signalscie,BorderLayout.CENTER);
       
        
        setVisible(true);
	}

}
