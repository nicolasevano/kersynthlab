package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import controler.CModuleZone;
import controler.CToolBoxes;

public class ToolBoxes extends JPanel{

	public ToolBoxes(){

		vcoSelectedModule = new JButton( "VCO" );
		vcoSelectedModule.setMnemonic(KeyEvent.VK_O);
		vcoSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		
		vcaSelectedModule = new JButton( "VCA" );
		vcaSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_A );

		vcaSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}

		} );

		outSelectedModule = new JButton( "OUT" );
		outSelectedModule.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_U );

		outSelectedModule.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}

		} );
		setLayout( new GridLayout( 3,1 ) );
		 add( vcoSelectedModule );
		 add( vcaSelectedModule );
		 add( outSelectedModule );
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
	private JButton outSelectedModule;
	private CModuleZone cModuleZone;
	private CToolBoxes control;

}
