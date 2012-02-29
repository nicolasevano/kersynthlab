package gui.impl;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import kernel.impl.HorlogeImpl;

import stringloader.IConfigurationLoader;

import controler.CUserOption;

/**
 * Define menu bar
 * define elements in this menu bar
 */

public class PresentationUserOption extends JMenuBar{

	
	public PresentationUserOption(final IConfigurationLoader configuration) throws UnsupportedEncodingException{
		
		
		this.configuration = configuration;
		
		Properties properties = configuration.getProperties();
		language = configuration.getLanguage();
		
		if(language == "Chinese")
			file = new JMenu(new String(properties.getProperty("menu.option.file").getBytes("iso8859-1"), "utf-8"));
		else
			file = new JMenu(properties.getProperty("menu.option.file"));
		
		file.setMnemonic( KeyEvent.VK_F );
		if(language == "Chinese")
			file.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.option.file.description").getBytes("iso8859-1"), "utf-8"));
		else
			file.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.file.description"));
		this.add( file );
		
		if(language == "Chinese")
			save = new JMenuItem(new String(properties.getProperty("menu.file.save").getBytes("iso8859-1"), "utf-8"), KeyEvent.VK_S);
		else
			save = new JMenuItem(properties.getProperty("menu.file.save"), KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			save.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.file.save.description").getBytes("iso8859-1"), "utf-8"));
		else
			save.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.save.description"));
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					doSaveInstallation();
				}
		});
		file.add( save );
		
		if( language == "Chinese" )
			load = new JMenuItem(new String(properties.getProperty("menu.file.load").getBytes("iso8859-1"), "utf-8"),KeyEvent.VK_L);
		else
			load = new JMenuItem(properties.getProperty("menu.file.load"),KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			load.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.file.load.description").getBytes("iso8859-1"), "utf-8"));
		else
			load.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.load.description"));
		load.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					doLoadInstallation();
				}
		});
		file.add( load );
		
		if(language == "Chinese")
			start = new JMenuItem(new String(properties.getProperty("menu.file.start").getBytes("iso8859-1"), "utf-8"),KeyEvent.VK_A);
		else
			start = new JMenuItem(properties.getProperty("menu.file.start"),KeyEvent.VK_A);
		start.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			start.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.file.start.description").getBytes("iso8859-1"), "utf-8"));
		else
			start.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.start.description"));
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					control.startHorloge();
				}
		});
		file.add( start );
		
		if(language == "Chinese")
			stop = new JMenuItem(new String(properties.getProperty("menu.file.stop").getBytes("iso8859-1"), "utf-8"),KeyEvent.VK_O);
		else
			stop = new JMenuItem(properties.getProperty("menu.file.stop"),KeyEvent.VK_O);
		stop.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			stop.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.file.stop.description").getBytes("iso8859-1"), "utf-8"));
		else
			stop.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.file.stop.description"));
		stop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.stopHorloge();
			}
		});
		file.add( stop );
		
		
		if(language == "Chinese")
			config = new JMenu(new String(properties.getProperty("menu.option.config").getBytes("iso8859-1"), "utf-8"));
		else
			config = new JMenu(properties.getProperty("menu.option.config"));
		config.setMnemonic( KeyEvent.VK_C );
		if(language == "Chinese")
			config.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.option.config.description").getBytes("iso8859-1"), "utf-8"));
		else
			config.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.config.description"));
		this.add( config );
		
		if(language == "Chinese")
			bufferSize = new JMenuItem(new String(properties.getProperty("menu.config.bufferSize").getBytes("iso8859-1"), "utf-8"),KeyEvent.VK_B);
		else
			bufferSize = new JMenuItem(properties.getProperty("menu.config.bufferSize"),KeyEvent.VK_B);
		bufferSize.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_B, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			bufferSize.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.config.bufferSize.description").getBytes("iso8859-1"), "utf-8"));
		else
			bufferSize.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.config.bufferSize.description"));
		bufferSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeBufferSize();
				}
		});
		config.add( bufferSize );
		
		if(language == "Chinese")
			sampleRate = new JMenuItem(new String(properties.getProperty("menu.config.sampleRate").getBytes("iso8859-1"), "utf-8"),KeyEvent.VK_R);
		else
			sampleRate = new JMenuItem(properties.getProperty("menu.config.sampleRate"),KeyEvent.VK_R);
		sampleRate.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_R, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			sampleRate.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.config.sampleRate.description").getBytes("iso8859-1"), "utf-8"));
		else
			sampleRate.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.config.sampleRate.description"));
		sampleRate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
				control.changeSampleRate();
			}
		});
		config.add( sampleRate );
		
		if(language == "Chinese")
			about = new JMenu(new String(properties.getProperty("menu.option.about").getBytes("iso8859-1"), "utf-8"));
		else
			about = new JMenu(properties.getProperty("menu.option.about"));
		about.setMnemonic( KeyEvent.VK_O );
		if(language == "Chinese")
			about.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.option.about.description").getBytes("iso8859-1"), "utf-8"));
		else
			about.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.option.about.description"));
		this.add(about);
		
		if(language == "Chinese")
			aboutK = new JMenuItem(new String(properties.getProperty("menu.about").getBytes("iso8859-1"), "utf-8"),
                KeyEvent.VK_O);
		else
			aboutK = new JMenuItem(properties.getProperty("menu.about"),
	                KeyEvent.VK_O);
		aboutK.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		if(language == "Chinese")
			aboutK.getAccessibleContext().setAccessibleDescription(new String(properties.getProperty("menu.about.description").getBytes("iso8859-1"), "utf-8"));
		else
			aboutK.getAccessibleContext().setAccessibleDescription(properties.getProperty("menu.about.description"));
		aboutK.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {	//TODO
					try {
						new AboutBox(new javax.swing.JFrame(), true, configuration).show();
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		about.add( aboutK );
		fc.addChoosableFileFilter( new SynthFileFilter() );
		
		
	   sampleRateChose = new ComboBox(configuration);
		
	}
	
	public CUserOption getControl() {
		return control;
	}

	public void setControl( CUserOption control ) {
		this.control = control;
	}
	
	class SynthFileFilter extends FileFilter{
		
		public boolean accept(File f) {
			String extension = null;
			if (f.isDirectory()) {
				return true;
			}
			try{
				extension = f.getName().substring( f.getName().lastIndexOf("."), 
												   f.getName().length() );
			} catch(Exception e){}
			if (extension != null) {
				if (extension.equals( extentionAllowed ) ) {
	                	return true;
				} else {
					return false;
				}
			}

			return false;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		
		private static final String extentionAllowed = ".synth";
		
	}
	
	/**
	 * Dialog for changing sampleRate
	 */
	
	public class ComboBox extends JDialog implements ActionListener, ItemListener {

		
		public ComboBox(IConfigurationLoader configuration) throws UnsupportedEncodingException {
			String language = configuration.getLanguage();
			final String[] sampleRate = { "22050","44100" };

			
			
			JComboBox combobox = new JComboBox( sampleRate );
			Properties properties = configuration.getProperties();
			
			JButton button = new JButton();
			if(language == "Chinese")
				button = new JButton(new String(properties.getProperty("menu.config.sampleRate.change").getBytes("iso8859-1"), "utf-8"));
			else
				button = new JButton(properties.getProperty("menu.config.sampleRate.change"));
			
			
			setLayout(new FlowLayout());
			combobox.setSelectedIndex( ( HorlogeImpl.getSampleRate() == 44100 )? 0 : 1 );
			combobox.addItemListener( this );
			add( combobox );
			
			button.addActionListener( this );
			add( button );

			setSize(100, 120);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLocationRelativeTo( null );
			setVisible( false );
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			this.dispose();
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if ( arg0.getStateChange() == ItemEvent.SELECTED ) {
				JComboBox combo = (JComboBox) arg0.getSource();
				int index = combo.getSelectedIndex();
				HorlogeImpl.setSampleRate( ( index == 0 )? 22050 : 44100 );
			}
		}
		
		private static final long serialVersionUID = 1L;

	}
	
	public ComboBox getSampleRateChose() {
		return sampleRateChose;
	}

	public void setSampleRateChose(ComboBox sampleRateChose) {
		this.sampleRateChose = sampleRateChose;
	}
	
	public IConfigurationLoader getConfiguration() {
		return configuration;
	}

	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * Save user's installations (montages)
	 */
	
	private void doSaveInstallation(){
		
		int returnVal = fc.showOpenDialog( this );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
        	
        	fToUse = fc.getSelectedFile();
        	control.saveMontage( fToUse );
        	
        }
        
	}
	
	/**
	 * Load installations (montages) exist
	 */
	
	private void doLoadInstallation(){
		int returnVal = fc.showOpenDialog( this );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
        	
        	fToUse = fc.getSelectedFile();
        	control.loadMontage( fToUse );
        	
        }
	}
	
	private CUserOption control;
	
	/**menu*/
	private JMenu file;
	private JMenu config;
	private JMenu about;
	
	/**menu option*/
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem start;
	private JMenuItem stop;
	private JMenuItem bufferSize;
	private JMenuItem sampleRate;
	private JMenuItem aboutK;

	private static final long serialVersionUID = 1L;
	
	private IConfigurationLoader configuration;
	private final JFileChooser fc = new JFileChooser();
	private File fToUse;
	private ComboBox sampleRateChose;
	private String language;
}
