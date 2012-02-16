package kernel.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OutPortImplTest {
	private OutPortImpl outPort;
	private ModuleStub moduleStub;
	
	class ModuleStub implements Module{
		
		public ModuleStub(){
			
			
		}
		
		public void setOutPort( OutPortImpl outPort ){
			//add instance of OutPortImpl to module stub
			outPorts.put("out",outPort);
			
		}
		
		public OutPort getOutPort(){
			return outPorts.get( "out" );
		}
		
		@Override
		public void masterNotify() {
			//call update on each observer
			for (Observer observer:observers ){
				observer.update();
			}
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addObserver(Observer toAdd) {
			// TODO Auto-generated method stub
			//add an observer on module stub
			observers.add(toAdd);
			
		}

		@Override
		public void removeObserver(Observer toRemove) {
			// TODO Auto-generated method stub
			//remove an observer on module stub
			observers.remove(toRemove);
			
		}

		@Override
		public void moduleFunction() {
			// TODO Auto-generated method stub
			//set a value to ten on current outPort of this stub
			outPorts.get( "out" ).setValue(10);
			//this.masterNotify();
			//((OutPortImpl)outPorts.get("out")).removeHead();
			
		}

		@Override
		public Map<String, InPort> getInPorts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, OutPort> getOutPorts() {
			// TODO Auto-generated method stub
			//return each out port on this instance
			return outPorts;
		}
		
		//list each observer on this module
		List<Observer> observers = new ArrayList<Observer>();
		
		//map outPorts contains each out port of this module 
		Map<String,OutPort> outPorts = new TreeMap<String,OutPort>();
		
		
	}
	

	
	@Before
	public void setUp() throws Exception {
		outPort = new OutPortImpl();
		moduleStub = new ModuleStub();
		moduleStub.setOutPort( outPort );
	}

	@After
	public void tearDown() throws Exception {
		moduleStub = null;
		outPort = null;
	}

	@Test
	public void testOutPortImpl() {
		//check if outPortImpl constructor return an 
		//instance of OutPortImpl
		assertNotNull(outPort);
	}

	@Test
	public void testGetValue() {
		moduleStub.moduleFunction();
		// l'oracle vérifie que le port de sortie
		//renvoie bien la valeur 10
		assertEquals(10,outPort.getValue());
		
	}

	@Test
	public void testSetValue() {
		outPort.setValue(5);
		assertEquals(5,outPort.getValue());
	}

	@Test
	// verifie que quand on met une valeur
	//on supprime la valeur en tête du FIFO
	public void testRemoveHead() {
		outPort.setValue(6);
		outPort.setValue(7);
		assertEquals(6,outPort.getValue());
		outPort.removeHead();
		assertEquals(7,outPort.getValue());
		
	}

	@Test
	// check if all value on outPort FIFO  are removed 
	public void testClear() {
		outPort.setValue(6);
		outPort.setValue(7);
		assertEquals(6,outPort.getValue());
		outPort.clear();
		outPort.setValue(8);
		assertEquals(8,outPort.getValue());
	}

}
