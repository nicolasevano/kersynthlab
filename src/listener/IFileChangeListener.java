package listener;
/**
 * IFileChangeListener
 * @author nicolas
 *
 */
public interface IFileChangeListener {
	
	/**
	 * fileChanged operation
	 * called when configuration file has changed
	 * @param fileName String
	 */
	public void fileChanged(String fileName);
}
