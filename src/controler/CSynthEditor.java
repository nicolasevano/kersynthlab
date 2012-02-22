package controler;

import gui.impl.PresentationSynthEditor;
import gui.impl.PresentationUserOption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import listener.ConfigurationListener;
import listener.IFileChangeListener;

//import solitaire.view.impl.PSolitaire;
import stringloader.ConfigurationLoader;
import stringloader.IConfigurationLoader;


/**
 * 
 * @author nicolas
 *
 */
public class CSynthEditor {

	/**
	 * Public constructor create each controler and presentation layer to launch  KerSynthSound application.
	 * @throws IOException
	 */
	public CSynthEditor() throws IOException{
		
		configuration = new ConfigurationLoader();
		configuration.load();
		IFileChangeListener configurationListener = new ConfigurationListener((CSynthEditor)this, configuration);
		try {
			configuration.addFileChangeListener(configurationListener, IConfigurationLoader.configurationFileName, 5000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		presentation = new PresentationSynthEditor(configuration);
		presentation.setControl( this );
		cUserOption = new CUserOption(configuration);
		presentation.setUserOption( cUserOption.getPresentation());
		cToolBoxes = new CToolBoxes( cUserOption, configuration );
		presentation.setToolBoxes( cToolBoxes.getPresentation());
		cModuleZone = new CModuleZone( cUserOption );
		presentation.setModuleZone( cModuleZone.getPresentation());
		cToolBoxes.setcModuleZone( cModuleZone );
		presentation.pack();
		
		
		//presentation = new PresentationUserOption(configuration);
		
		/*configuration.load();
		configuration.getProperties();
		System.out.println(configuration.getProperties());*/
		
		/*Properties prop = new Properties();
	    String fileName = "src/config/configuration.properties";
	    InputStream is = new FileInputStream(fileName);

	    prop.load(is);

	    System.out.println(prop.getProperty("menu.option.file"));*/
		
		/*configuration = new ConfigurationLoader();
		configuration.load();
		IFileChangeListener configurationListener = new ConfigurationListener(this, configuration);
		try {
			configuration.addFileChangeListener(configurationListener, IConfigurationLoader.configurationFileName, 5000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static final void main( String...args ) throws IOException{
		new CSynthEditor();
	}
	
	public PresentationSynthEditor getPresentation() {
		return presentation;
	}

	public void setPresentation( PresentationSynthEditor presentation ) {
		this.presentation = presentation;
	}
	
	/** Current SynthEditor presentation */
	private PresentationSynthEditor presentation;
	/** Current controler on moduleZone */
	private CModuleZone cModuleZone;
	/** Current controler on ToolsBoxes */
	private CToolBoxes cToolBoxes;
	/** Current controler on menu */
	private CUserOption cUserOption;
	
	
	private ConfigurationLoader configuration;
}