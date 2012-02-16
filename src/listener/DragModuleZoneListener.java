package listener;

//import gui.ZoneDeDessin;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public class DragModuleZoneListener implements DragSourceListener {

	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {
		// TODO Auto-generated method stub
//		if( arg0.getDropSuccess() ){
//			//should appear on command only
//			zoneDessin.remove( zoneDessin.getSelected() );
//			zoneDessin.validate();
//			zoneDessin.repaint();
//		}
	}

	@Override
	public void dragEnter(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DragSourceEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub

	}

//	public ZoneDeDessin getZoneDessin() {
//		return zoneDessin;
//	}
//
//	public void setZoneDessin(ZoneDeDessin zoneDessin) {
//		this.zoneDessin = zoneDessin;
//	}
//	
//	private ZoneDeDessin zoneDessin;
}

