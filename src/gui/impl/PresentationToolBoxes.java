package gui.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import listener.ModuleListener;

import command.Command;
import command.CreateADSR;
import command.CreateOut;
import command.CreateReplicator;
import command.CreateVCA;
import command.CreateVCF;
import command.CreateVCO;

import controler.CModuleZone;
import controler.CToolBoxes;

public class PresentationToolBoxes extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public PresentationToolBoxes() throws IOException{
		
		vcoSelectedModule = new JButton();
		builtButton( vcoSelectedModule, 0 );		
		vcaSelectedModule = new JButton();
		builtButton( vcaSelectedModule, 1 );
		vcfSelectedModule = new JButton();
		builtButton( vcfSelectedModule, 2 );
		outSelectedModule = new JButton();
		builtButton( outSelectedModule, 3 );
		adsrSelectedModule = new JButton();
		builtButton( adsrSelectedModule, 4 );		
		//repliSelectedModule = new JButton();
		//builtButton( repliSelectedModule, 5 );
		//setLayout( new GridLayout( 6,1 ) );
		setLayout( new GridLayout( 5,1 ) );
		setBackground(Color.white);
		add( vcoSelectedModule );
		add( vcaSelectedModule );
		add( vcfSelectedModule );
		add( outSelectedModule );
		add( adsrSelectedModule );
	}

	private void builtButton(final JButton toBuild,final int index){
		toBuild.setMnemonic( keyEvents.get(index) );
		setButtonImages( toBuild, Color.white, new File(imageUnselected.get(index) ) );
		toBuild.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( toBuild.getBackground() == Color.white )
				{
					setButtonImages( vcoSelectedModule,   ( index == 0 )?Color.black:Color.white, new File( ( index == 0 )? imageSelected.get( 0 ) : imageUnselected.get( 0 ) ) );
					setButtonImages( vcaSelectedModule,   ( index == 1 )?Color.black:Color.white, new File( ( index == 1 )? imageSelected.get( 1 ) : imageUnselected.get( 1 ) ) );
					setButtonImages( vcfSelectedModule,   ( index == 2 )?Color.black:Color.white, new File( ( index == 2 )? imageSelected.get( 2 ) : imageUnselected.get( 2 ) ) );
					setButtonImages( outSelectedModule,   ( index == 3 )?Color.black:Color.white, new File( ( index == 3 )? imageSelected.get( 3 ) : imageUnselected.get( 3 ) ) );
					setButtonImages( adsrSelectedModule,  ( index == 4 )?Color.black:Color.white, new File( ( index == 4 )? imageSelected.get( 4 ) : imageUnselected.get( 4 ) ) );
					//setButtonImages( repliSelectedModule, ( index == 5 )?Color.black:Color.white, new File( ( index == 5 )? imageSelected.get( 5 ) : imageUnselected.get( 5 ) ) );
				}
				commands.get( index ).setPlan( control.getcModuleZone().getPresentation() );
				commands.get( index ).setHorloge( control.getCmenu().getHorloge() );
				( ( ModuleListener ) control.getcModuleZone().getPresentation().getaDL() ).setCommand( commands.get( index ) );
				
			}

		} );
	}
	
	private void setButtonImages( JButton buttonToSet, Color colorToSet, File image ){
		// ((JButton)arg0.getSource()).setBackground(Color.red);
		try {
			BufferedImage buttonRepliIcon = ImageIO.read( image );
			buttonToSet.setIcon( new ImageIcon( buttonRepliIcon ) );
			buttonToSet.setBorder( BorderFactory.createEmptyBorder() );
			buttonToSet.setContentAreaFilled( false );
			buttonToSet.setBackground( colorToSet );

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public CModuleZone getcModuleZone() {
		return cModuleZone;
	}
	public void setcModuleZone( CModuleZone cModuleZone ){
		this.cModuleZone = cModuleZone;
	}

	public CToolBoxes getControl() {
		return control;
	}

	public void setControl(CToolBoxes control){
		this.control = control;
	}

	private JButton vcoSelectedModule;
	private JButton vcaSelectedModule;
	private JButton vcfSelectedModule;
	private JButton outSelectedModule;
	private JButton adsrSelectedModule;
	//private JButton repliSelectedModule;
	private CModuleZone cModuleZone;
	private CToolBoxes control;
	//private COUT cOUT;
	private List<Integer> keyEvents = new ArrayList<Integer>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add( KeyEvent.VK_O );
		add( KeyEvent.VK_A );
		add( KeyEvent.VK_F );
		add( KeyEvent.VK_U );
		add( KeyEvent.VK_D );
		//add( KeyEvent.VK_R );
	}};
	
	private List<String> imageUnselected = new ArrayList<String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add( "images/bouVCO.jpg" );
		add( "images/bouVCA.jpg" );
		add( "images/bouVCF.jpg" );
		add( "images/bouOUT.jpg" );
		add( "images/bouADSR.jpg" );
		//add( "images/bouRepli.jpg" );
	}};
	
	private List<String> imageSelected = new ArrayList<String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add( "images/bouVCOp.jpg" );
		add( "images/bouVCAp.jpg" );
		add( "images/bouVCFp.jpg" );
		add( "images/bouOUTp.jpg" );
		add( "images/bouADSRp.jpg" );
		//add( "images/bouReplip.jpg" );
	}};
	
	private List<Command> commands = new ArrayList<Command>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add( new CreateVCO() );
		add( new CreateVCA() );
		add( new CreateVCF() );
		add( new CreateOut() );
		add( new CreateADSR() );
		//add( new CreateReplicator() );
	}};
}
