package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controler.COUT;

public class presentationOUTImpl extends Module {
	
	public presentationOUTImpl(){
		this.setBackground( Color.BLACK );
		this.setPreferredSize( new Dimension( 240, 200 ) );
		//this.setLayout( new GridLayout( 1,2 ) );
		/*this.setOpaque( true );*/
		this.setSize( 240,200 );
		//ImageIcon port = new ImageIcon( "images/port.png" );
		lIn = new JLabel( new ImageIcon( "images/port.png" ) );
		this.add( lIn,0 );
		lIn.setVisible( true );
		
		//lBaffle = new JLabel( new ImageIcon( "images/baffle.png" ) );
		//this.add( lBaffle );
		//lBaffle.setVisible( true );
		this.setVisible( true );
		//this.setIgnoreRepaint( true );
		this.repaint();
	}
	
	public void setControl( COUT cOut ){
		this.cOut = cOut;  
	}
	
	private COUT getControl(){
		return this.cOut;
	}
	
	//@Override
	public void paint( Graphics rectangle ) {
		super.paint( rectangle );
		//rectangle.fillRect( super.getOrigine().x, super.getOrigine().y, getWidth(), getHeight() );
		//Component [] Components = this.getComponents();
		//for(int i = 0; i < Components.length; i++){
		//	Components[i].repaint();
		//}
		lIn.setLocation( this.getOrigine().x, this.getOrigine().y );
		lIn.repaint();
	}
	
	public void paintComponent(Graphics g){
		//ici, mon code de surcharge
		super.paintComponent( g );
		lIn.setLocation( this.getOrigine().x, this.getOrigine().y );
		lIn.repaint();
		//Component [] Components = this.getComponents();
		//for(int i = 0; i < Components.length; i++){
		//	Components[i].repaint();
		//}
	}
	
	private COUT cOut;
	private JLabel lBaffle;
	private JLabel lIn;
}
