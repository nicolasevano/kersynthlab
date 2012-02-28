package stringloader;

import java.io.FileNotFoundException;
import java.util.Properties;

import listener.IFileChangeListener;

public interface IConfigurationLoader {

	/**
	 * configuration properties file path of each displed string on application
	 */
	public static final String configurationFileName = "/config/configurationfr.properties";
	//public static final String configurationFileName = "src/config/configurationcn.properties";
	
	/**
	 * load operation
	 * load configuration file
	 */
	public abstract void load();

	/**
	 * addFileChangeListener operation
	 * add a listener on configuration file
	 * @param listener to add
	 * @param fileName name of configuration file
	 * @param period delay between to detection fo modification on configuration file
	 * @throws FileNotFoundException
	 */
	public abstract void addFileChangeListener(IFileChangeListener listener,
			String fileName, long period) throws FileNotFoundException;

	/**
	 * removeFileChangeListener operation
	 * remove a listener on configuration file
	 * @param listener to remove
	 * @param fileName configuration file name
	 */
	public abstract void removeFileChangeListener(IFileChangeListener listener,
			String fileName);

	/**
	 * getProperties operation
	 * @return Properties instance containing each read property from configuration file  
	 */
	public abstract Properties getProperties();

	public abstract String getLanguage();
}