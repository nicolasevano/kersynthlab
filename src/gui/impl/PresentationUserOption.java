package gui.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import listener.ConfigurationListener;
import listener.IFileChangeListener;

import stringloader.ConfigurationLoader;
import stringloader.IConfigurationLoader;

import controler.CUserOption;

public class PresentationUserOption extends JMenuBar{

	
	public PresentationUserOption(IConfigurationLoader configuration){
		
		
		this.configuration = configuration;
		
		Properties properties = configuration.getProperties();
		file = new JMenu(properties.getProperty("menu.option.file"));
		//file = new JMenu( "File" );
		file.setMnemonic( KeyEvent.VK_F );
		/*file.getAccessibleContext().setAccessibleDescription(
				"option courante du montage"
		);*/
		file.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.file.description"));
		this.add( file );
		
		/*save = new JMenuItem("save montage",
                KeyEvent.VK_S);*/
		save = new JMenuItem(properties.getProperty("menu.file.save"), KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.ALT_MASK));
		/*save.getAccessibleContext().setAccessibleDescription(
				"sauvegarder un montage");*/
		save.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.save.description"));
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					control.saveMontage();
				}
		});
		file.add( save );
		
		/*load = new JMenuItem("load montage",
                KeyEvent.VK_L);*/
		load = new JMenuItem(properties.getProperty("menu.file.load"),KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, ActionEvent.ALT_MASK));
		/*load.getAccessibleContext().setAccessibleDescription(
				"charger un montage");*/
		load.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.load.description"));
		load.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.loadMontage();
				}
		});
		file.add( load );
		
		/*start = new JMenuItem("launch montage",
                KeyEvent.VK_A);*/
		start = new JMenuItem(properties.getProperty("menu.file.start"),KeyEvent.VK_A);
		start.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.ALT_MASK));
		/*start.getAccessibleContext().setAccessibleDescription(
				"démarrer montage");*/
		start.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.start.description"));
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					control.startHorloge();
				}
		});
		file.add( start );
		
		/*stop = new JMenuItem("arr montage",
                KeyEvent.VK_O);*/
		stop = new JMenuItem(properties.getProperty("menu.file.stop"),KeyEvent.VK_O);
		stop.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		/*stop.getAccessibleContext().setAccessibleDescription(
				"arrêt montage");*/
		stop.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.stop.description"));
		stop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				}
		});
		file.add( stop );
		
		
		//config = new JMenu( "Config" );
		config = new JMenu(properties.getProperty("menu.option.config"));
		config.setMnemonic( KeyEvent.VK_C );
		/*config.getAccessibleContext().setAccessibleDescription(
				"option courante du montage"
		);*/
		config.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.config.description"));
		this.add( config );
		
		/*bufferSize = new JMenuItem("delaie demarrage carte son",
                KeyEvent.VK_B);*/
		bufferSize = new JMenuItem(properties.getProperty("menu.config.bufferSize"),KeyEvent.VK_B);
		bufferSize.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_B, ActionEvent.ALT_MASK));
		/*bufferSize.getAccessibleContext().setAccessibleDescription(
				"delaie demarrage carte son");*/
		bufferSize.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.config.bufferSize.description"));
		bufferSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeBufferSize();
				}
		});
		config.add( bufferSize );
		
		/*sampleRate = new JMenuItem("fruence d'hantillonnage",
                KeyEvent.VK_R);*/
		sampleRate = new JMenuItem(properties.getProperty("menu.config.sampleRate"),KeyEvent.VK_R);
		sampleRate.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_R, ActionEvent.ALT_MASK));
		/*sampleRate.getAccessibleContext().setAccessibleDescription(
				"fréquence d'échantillonnage");*/
		sampleRate.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.config.sampleRate.description"));
		sampleRate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeSampleRate();
				}
		});
		config.add( sampleRate );
		
		
		//about = new JMenu( "About" );
		about = new JMenu(properties.getProperty("menu.option.about"));
		about.setMnemonic( KeyEvent.VK_O );
		/*about.getAccessibleContext().setAccessibleDescription(
				"notre produit et notre groupe"
		);*/
		about.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.about.description"));
		this.add(about);
		
		/*aboutK = new JMenuItem("about KerSynthSound",
                KeyEvent.VK_O);*/
		aboutK = new JMenuItem(properties.getProperty("menu.about"),
                KeyEvent.VK_O);
		aboutK.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		/*aboutK.getAccessibleContext().setAccessibleDescription(
				"notre produit et notre groupe");*/
		aboutK.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.about.description"));
		aboutK.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					new AboutBox(new javax.swing.JFrame(), true).show();
				}
		});
		about.add( aboutK );
		
		//this.updateString();
	}
	
	public CUserOption getControl() {
		return control;
	}

	public void setControl( CUserOption control ) {
		this.control = control;
	}
	
	/*public void updateString(){
		Properties properties = configuration.getProperties();
		file.setText( properties.getProperty("menu.option.file", "File"));
		//file.getAccessibleContext().setAccessibleDescription(
			//	properties.getProperty("menu.description",
				//		               "menu de jeu permet de lancer, sauvegarder ou charger une partie"));
		//save.setText( properties.getProperty() );
		/*newGame.getAccessibleContext().setAccessibleDescription(
				properties.getProperty("menu.option.newgame.description","Crée une nouvelle partie"));
		saveGame.setText( properties.getProperty("menu.option.savegame","Sauvegarder la partie") );
		loadGame.setText(properties.getProperty("menu.option.loadgame","Charger une partie"));*/
	/*	file.repaint();
	}*/
	
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

	private static final long serialVersionUID = 1L;
	
	
	private IConfigurationLoader configuration;
	private CUserOption userOption;
}
