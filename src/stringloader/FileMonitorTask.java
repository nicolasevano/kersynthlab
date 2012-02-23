package stringloader;

import java.io.File;
import java.util.TimerTask;

import listener.IFileChangeListener;

public class FileMonitorTask extends TimerTask {
	
	public FileMonitorTask(IFileChangeListener listener,File monitoredFile){
		this.listener = listener;
		this.monitoredFile = monitoredFile;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastModified = monitoredFile.lastModified();
		if (lastModified != this.lastModified) {
			this.lastModified = lastModified;
			fireFileChangeEvent(this.listener, this.monitoredFile.getName());
		}
	}
	
	private void fireFileChangeEvent(IFileChangeListener listener,String fileName){
		listener.fileChanged( fileName );
	}
	
	private File monitoredFile;
	private long lastModified;
	private IFileChangeListener listener;
	
}
