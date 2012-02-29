package command;

import gui.APresentationModule;
import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Component;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Save installations (montages) which user create
 */

public class WriteInstallation extends Command {

	@Override
	public void execute( Point p ) {
		// TODO Auto-generated method stub
		PrintStream saveStream = null;
		try {
			saveStream = new PrintStream( new FileOutputStream( toUseForWrite ) );
			for( Component comp: ( ( PresentationModuleZone ) getPlan() ).getComponents() ){
				if( comp instanceof APresentationModule ){
					APresentationModule toSave = ( APresentationModule ) comp;
					saveStream.println( toSave );
				}
			}
			for( Component comp: ( ( PresentationModuleZone ) getPlan() ).getComponents() ){
				if( comp instanceof PresentationWire ){
					PresentationWire toSave = ( PresentationWire ) comp;
					saveStream.println( toSave );
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally { saveStream.close();	}
	}
	
	public File getToUseForWrite() {
		
		return toUseForWrite;
		
	}

	public void setToUseForWrite(File toUseForWrite) {
		
		this.toUseForWrite = toUseForWrite;
		
	}
	
	private File toUseForWrite;

}
