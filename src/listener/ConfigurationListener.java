package listener;

import controler.CSynthEditor;
import controler.CUserOption;
import stringloader.IConfigurationLoader;

public class ConfigurationListener implements IFileChangeListener{
	
	public ConfigurationListener(CSynthEditor main,IConfigurationLoader configuration ){
		this.main = (CSynthEditor)main;
		this.configuration = configuration;
	}
	
	@Override
	public void fileChanged( String fileName ) {
		// TODO Auto-generated method stub
		configuration.load();
		//main.updateString();
	}

	private IConfigurationLoader configuration;
	private CSynthEditor main;
	
}
