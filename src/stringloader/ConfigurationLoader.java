package stringloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TreeMap;

import listener.IFileChangeListener;

public class ConfigurationLoader implements IConfigurationLoader {
	
	public ConfigurationLoader(){
		timer = new Timer();
	}
	
	/**
	 * Read configuration file
	 */
	
	@SuppressWarnings("unused")
	public void load(){
		properties = new Properties();
		InputStream input = null;
		try{
			input = this.getClass().getResourceAsStream(configurationFileName);
			if(configurationFileName == "/config/configurationcn.properties")
			{
				this.setLanguage("Chinese");
			}
			else
			{
				this.setLanguage("English or French");
			}
			properties.load( input );
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Monitor if configuration file has been changed
	 */

	public void addFileChangeListener(IFileChangeListener listener,String fileName,long period)
	throws FileNotFoundException {
		removeFileChangeListener(listener, fileName);
		FileMonitorTask task = new FileMonitorTask( listener, new File( configurationFileName ) );
		timerEntries.put(fileName + listener.hashCode(), task);
		timer.schedule(task, period, period);
	}

	public void removeFileChangeListener(IFileChangeListener listener,String fileName) {
		FileMonitorTask task = (FileMonitorTask)
		timerEntries.remove(fileName+listener.hashCode());
		if (task != null) {
			task.cancel();
		}
	}
	
	public Properties getProperties(){
		return properties;
	}
	/**
	 * Get which language we use:
	 * 	English, French or Chinese
	 * @param language
	 */
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}


	private String language;
	
	private Properties properties;
	
	private Map<String,FileMonitorTask> timerEntries = new TreeMap<String,FileMonitorTask>();
	
	public Timer timer;
	
}
