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
		setLayout(null);
		carre = new JCheckBox("Carrée");
		carre.setSize( 80,20 );
		triangle = new JCheckBox("Triangle");
		triangle.setSize( 80,20 );
		scie = new JCheckBox("Scie");
		scie.setSize( 80,20 );
		
		icone1 = new ImageIcon ( "images/signal-carre.jpg" ) ;
		signalcarre = new JLabel( icone1 );
		signalcarre.setSize( icone1.getIconWidth(), icone1.getIconHeight() );
		icone2 = new ImageIcon ( "images/signal-triangle.jpg" );
		signaltriangle = new JLabel( icone2 );
		signaltriangle.setSize( icone2.getIconWidth(), icone2.getIconHeight() );
		
		icone3 = new ImageIcon ( "images/signal-scie.jpg" );
		signalscie = new JLabel( icone3 );
		signalscie.setSize( icone3.getIconWidth(), icone3.getIconHeight() );
			
		/*setLayout(new GridLayout(2, 3));*/
		/*add(carre,BorderLayout.CENTER);
		add(triangle,BorderLayout.CENTER);
        add(scie,BorderLayout.CENTER);
        add(signalcarre,BorderLayout.CENTER);
        add(signaltriangle,BorderLayout.CENTER);
        add(signalscie,BorderLayout.CENTER);*/
		add( carre );
		add( triangle );
        add( scie );
        add( signalcarre );
        add( signaltriangle );
        add( signalscie );
        
        setVisible( true );
	}
	
	public void setLocation(){
		carre.setLocation( 0, 0 );
		triangle.setLocation( ( getWidth() / 2 ) - ( triangle.getWidth() / 2 ), 0 );
		scie.setLocation( getWidth() - scie.getWidth(), 0 );
		signalcarre.setLocation( 0,20 );
		signaltriangle.setLocation( ( getWidth() / 2 ) - ( triangle.getWidth() / 2 ), 20);
		signalscie.setLocation( getWidth() - signalscie.getWidth(), 20 );
	}
}
