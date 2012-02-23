package gui.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controler.CUserOption;

public class PresentationUserOption extends JMenuBar{

	public PresentationUserOption(){
		file = new JMenu( "File" );
		file.setMnemonic( KeyEvent.VK_F );
		file.getAccessibleContext().setAccessibleDescription(
				"option courante du montage"
		);
		this.add( file );
		
		save = new JMenuItem("save montage",
                KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.ALT_MASK));
		save.getAccessibleContext().setAccessibleDescription(
				"sauvegarder un montage");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					control.saveMontage();
				}
		});
		file.add( save );
		
		load = new JMenuItem("load montage",
                KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, ActionEvent.ALT_MASK));
		load.getAccessibleContext().setAccessibleDescription(
				"charger un montage");
		load.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.loadMontage();
				}
		});
		file.add( load );
		
		start = new JMenuItem("launch montage",
                KeyEvent.VK_A);
		start.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.ALT_MASK));
		start.getAccessibleContext().setAccessibleDescription(
				"démarrer montage");
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					control.startHorloge();
				}
		});
		file.add( start );
		
		stop = new JMenuItem("arr montage",
                KeyEvent.VK_O);
		stop.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		stop.getAccessibleContext().setAccessibleDescription(
				"arrêt montage");
		stop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				control.stopHorloge();
				}
		});
		file.add( stop );
		
		
		config = new JMenu( "Config" );
		config.setMnemonic( KeyEvent.VK_C );
		config.getAccessibleContext().setAccessibleDescription(
				"option courante du montage"
		);
		this.add( config );
		
		bufferSize = new JMenuItem("delaie demarrage carte son",
                KeyEvent.VK_B);
		bufferSize.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_B, ActionEvent.ALT_MASK));
		bufferSize.getAccessibleContext().setAccessibleDescription(
				"delaie demarrage carte son");
		bufferSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeBufferSize();
				}
		});
		config.add( bufferSize );
		
		sampleRate = new JMenuItem("fruence d'hantillonnage",
                KeyEvent.VK_R);
		sampleRate.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_R, ActionEvent.ALT_MASK));
		sampleRate.getAccessibleContext().setAccessibleDescription(
				"fréquence d'échantillonnage");
		sampleRate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeSampleRate();
				}
		});
		config.add( sampleRate );
		
		
		about = new JMenu( "About" );
		about.setMnemonic( KeyEvent.VK_O );
		about.getAccessibleContext().setAccessibleDescription(
				"notre produit et notre groupe"
		);
		this.add(about);
		
		aboutK = new JMenuItem("about KerSynthSound",
                KeyEvent.VK_O);
		aboutK.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		aboutK.getAccessibleContext().setAccessibleDescription(
				"notre produit et notre groupe");
		aboutK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					new AboutBox(new javax.swing.JFrame(), true).show();
				}
		});
		about.add( aboutK );
	}
	
	public CUserOption getControl() {
		return control;
	}

	public void setControl( CUserOption control ) {
		this.control = control;
	}
	
	private CUserOption control;
	
	//menu
	private JMenu file;
	private JMenu config;
	private JMenu about;
	
	//menu option
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem start;
	private JMenuItem stop;
	private JMenuItem bufferSize;
	private JMenuItem sampleRate;
	private JMenuItem aboutK;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
