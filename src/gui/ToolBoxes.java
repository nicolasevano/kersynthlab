package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import presentation.presentationOUTImpl;

import controler.CModuleZone;
import controler.COUT;
import controler.CToolBoxes;

public class ToolBoxes extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ToolBoxes() throws IOException{{

		BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
		
		//button = new JButton(new ImageIcon(buttonIcon));
		//vcoSelectedModule = new JButton( "VCO" );
		vcoSelectedModule = new JButton();
		vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
		vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		vcoSelectedModule.setContentAreaFilled(false);
		vcoSelectedModule.setBackground(Color.white);
		
		vcoSelectedModule.setMnemonic(KeyEvent.VK_O);
		vcoSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//if(UIManager.getColor( "Button.background" ) == Color.white)
					//vcoSelectedModule.setBackground(Color.blue);
					//((JButton)arg0.getSource()).getParent().setBackground(Color.red);
				//Color buttonColor = vcoSelectedModule.getBackground();
				
				//vcoSelectedModule.setBackground(Color.blue);
				 if(vcoSelectedModule.getBackground() == Color.white)
				 {
					// ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCOp.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.white);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				/* else
				 {
					 try {
							BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
							vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
							vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							vcoSelectedModule.setContentAreaFilled(false);
							vcoSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
				//vcoSelectedModule.setBackground(Color.red);
			}
			
			

		});
		
		
		BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
		vcaSelectedModule = new JButton();
		vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
		vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		vcaSelectedModule.setContentAreaFilled(false);
		vcaSelectedModule.setBackground(Color.white);
		//vcaSelectedModule = new JButton( "VCA" );
		vcaSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_A );

		vcaSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 if(vcaSelectedModule.getBackground() == Color.white)
				 {
					// ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCAp.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.white);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				/* else
				 {
					 try {
							BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
							vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
							vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							vcaSelectedModule.setContentAreaFilled(false);
							vcaSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
			}

		} );
		
		BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
		vcfSelectedModule = new JButton();
		vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
		vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		vcfSelectedModule.setContentAreaFilled(false);
		vcfSelectedModule.setBackground(Color.white);
		//vcfSelectedModule = new JButton( "VCF" );
		vcfSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_F );

		vcfSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 if(vcfSelectedModule.getBackground() == Color.white)
				 {
					// ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCFp.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.white);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 /*else
				 {
					 try {
							BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
							vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
							vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							vcfSelectedModule.setContentAreaFilled(false);
							vcfSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
			}

		} );

		BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
		outSelectedModule = new JButton();
		outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
		outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		outSelectedModule.setContentAreaFilled(false);
		outSelectedModule.setBackground(Color.white);
		//outSelectedModule = new JButton( "OUT" );
		outSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_U );

		outSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//JPanel pOUT = new presentationOUTImpl();
				//add();
				//pOUT.setBackground(Color.black);
				//pOUT.setSize(30, 40);
				/*moduleZone.add(pOUT);
				pOUT.setVisible (true);
				moduleZone.repaint();*/
				
				//cOUT = new COUT();
				//presentation.setPoubelle( cOUT.getPresentation() );
				
				 if(outSelectedModule.getBackground() == Color.white)
				 {
					 
					 // ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUTp.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.white);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 /*else
				 {
					 try {
							BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
							outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
							outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							outSelectedModule.setContentAreaFilled(false);
							outSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
			}

		} );
		
		BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
		adsrSelectedModule = new JButton();
		adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
		adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		adsrSelectedModule.setContentAreaFilled(false);
		adsrSelectedModule.setBackground(Color.white);
		//adsrSelectedModule = new JButton( "ADSR" );
		adsrSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_D );

		adsrSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 if(adsrSelectedModule.getBackground() == Color.white)
				 {
					// ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSRp.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.white);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 /*else
				 {
					 try {
							BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
							adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
							adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							adsrSelectedModule.setContentAreaFilled(false);
							adsrSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
			}

		} );
		
		BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
		repliSelectedModule = new JButton();
		repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
		repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
		repliSelectedModule.setContentAreaFilled(false);
		repliSelectedModule.setBackground(Color.white);
		//repliSelectedModule = new JButton( "Replicator" );
		repliSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_R );

		repliSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 if(repliSelectedModule.getBackground() == Color.white)
				 {
					// ((JButton)arg0.getSource()).setBackground(Color.red);
					 try {
						BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouReplip.jpg"));
						repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
						repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						repliSelectedModule.setContentAreaFilled(false);
						repliSelectedModule.setBackground(Color.black);
						
						BufferedImage buttonVCOIcon = ImageIO.read(new File("images/bouVCO.jpg"));
						vcoSelectedModule.setIcon(new ImageIcon(buttonVCOIcon));
						vcoSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcoSelectedModule.setContentAreaFilled(false);
						vcoSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCAIcon = ImageIO.read(new File("images/bouVCA.jpg"));
						vcaSelectedModule.setIcon(new ImageIcon(buttonVCAIcon));
						vcaSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcaSelectedModule.setContentAreaFilled(false);
						vcaSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonVCFIcon = ImageIO.read(new File("images/bouVCF.jpg"));
						vcfSelectedModule.setIcon(new ImageIcon(buttonVCFIcon));
						vcfSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						vcfSelectedModule.setContentAreaFilled(false);
						vcfSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonOUTIcon = ImageIO.read(new File("images/bouOUT.jpg"));
						outSelectedModule.setIcon(new ImageIcon(buttonOUTIcon));
						outSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						outSelectedModule.setContentAreaFilled(false);
						outSelectedModule.setBackground(Color.white);
						
						BufferedImage buttonADSRIcon = ImageIO.read(new File("images/bouADSR.jpg"));
						adsrSelectedModule.setIcon(new ImageIcon(buttonADSRIcon));
						adsrSelectedModule.setBorder(BorderFactory.createEmptyBorder());
						adsrSelectedModule.setContentAreaFilled(false);
						adsrSelectedModule.setBackground(Color.white);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 /*else
				 {
					 try {
							BufferedImage buttonRepliIcon = ImageIO.read(new File("images/bouRepli.jpg"));
							repliSelectedModule.setIcon(new ImageIcon(buttonRepliIcon));
							repliSelectedModule.setBorder(BorderFactory.createEmptyBorder());
							repliSelectedModule.setContentAreaFilled(false);
							repliSelectedModule.setBackground(Color.white);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }*/
			}

		} );
		
		setLayout( new GridLayout( 6,1 ) );
		setBackground(Color.white);
		 add( vcoSelectedModule );
		 add( vcaSelectedModule );
		 add( vcfSelectedModule );
		 add( outSelectedModule );
		 add( adsrSelectedModule );
		 add( repliSelectedModule );
	}}

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
	private JButton repliSelectedModule;
	private CModuleZone cModuleZone;
	private CToolBoxes control;
	private ModuleZone presentation;
	private COUT cOUT;

}
