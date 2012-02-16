package listener;

//import gui.ZoneDeDessin;

import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

public class ModuleZoneDropTargetListener extends DropTargetAdapter{

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
//		zoneDessin.setBorder( zoneDessin.getLoweredbevel() );
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
//		zoneDessin.setBorder( zoneDessin.getRaisedbevel() );
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
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
//
//	private ZoneDeDessin zoneDessin;
}
