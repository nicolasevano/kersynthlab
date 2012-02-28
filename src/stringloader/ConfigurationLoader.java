package stringloader;

import java.io.File;
import java.io.FileInputStream;
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
	
	/* (non-Javadoc)
	 * @see solitaire.stringloader.IConfigurationLoader#load()
	 */
	@SuppressWarnings("unused")
	public void load(){
		properties = new Properties();
		//FileInputStream input = null;
		InputStream input = null;
		try{
			//String fileName = "src/config/configuration.properties";
			
			//InputStreamReader in= new InputStreamReader(Parser.class.getResourceAsStream(dataFile),"UTF-8");
			
			//input = new FileInputStream(Parser.class.getResourceAsStream(configurationFileName), "GBK");
			input = this.getClass().getResourceAsStream(configurationFileName);
			//input = new FileInputStream(configurationFileName);
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
	
	

	/* (non-Javadoc)
	 * @see solitaire.stringloader.IConfigurationLoader#addFileChangeListener(solitaire.listener.IFileChangeListener, java.lang.String, long)
	 */
	public void addFileChangeListener(IFileChangeListener listener,String fileName,long period)
	throws FileNotFoundException {
		removeFileChangeListener(listener, fileName);
		FileMonitorTask task = new FileMonitorTask( listener, new File( configurationFileName ) );
		timerEntries.put(fileName + listener.hashCode(), task);
		timer.schedule(task, period, period);
	}

	/* (non-Javadoc)
	 * @see solitaire.stringloader.IConfigurationLoader#removeFileChangeListener(solitaire.listener.IFileChangeListener, java.lang.String)
	 */
	public void removeFileChangeListener(IFileChangeListener listener,String fileName) {
		FileMonitorTask task = (FileMonitorTask)
		timerEntries.remove(fileName+listener.hashCode());
		if (task != null) {
			task.cancel();
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.stringloader.IConfigurationLoader#getProperties()
	 */
	public Properties getProperties(){
		return properties;
	}
	
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
