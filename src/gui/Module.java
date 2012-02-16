package gui;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JPanel;



public abstract class Module extends JPanel implements Transferable{
	public Point getOrigine() {
		return origine;
	}

	public void setOrigine(Point origine) {
		this.origine = origine;
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		Object result = null;
		if(flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)){
			result = this;
		} else {
			result = null;
		}
		return result;
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor []data = new DataFlavor[2];
		try{
			data[0] = new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType );
			data[1] = new DataFlavor( Module.class, null );
		} catch(java.lang.ClassNotFoundException e){}
		return data;
	}
	
	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		return ((arg0.isMimeTypeEqual( DataFlavor.javaJVMLocalObjectMimeType ) ) ||
				arg0.isMimeTypeEqual( new DataFlavor(Module.class, null)));
	}
	
	private Point origine;
	
	private static final long serialVersionUID = 1L;
}
