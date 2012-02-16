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

public class InPortImplTest {
	private InPortImpl inPort;
	private ModuleStub moduleStub;
	
	class ModuleStub implements Module{
		public ModuleStub(){
			
			outPorts.put("out",new OutPortImpl());
			
		}

		@Override
		public void masterNotify() {
			for (Observer observer:observers ){
				observer.update();
			}
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addObserver(Observer toAdd) {
			// TODO Auto-generated method stub
			observers.add(toAdd);
			
		}

		@Override
		public void removeObserver(Observer toRemove) {
			// TODO Auto-generated method stub
			observers.remove(toRemove);
			
		}

		@Override
		public void moduleFunction() {
			// TODO Auto-generated method stub
			outPorts.get("out").setValue(10);
			this.masterNotify();
			((OutPortImpl)outPorts.get("out")).removeHead();
			
		}

		@Override
		public Map<String, InPort> getInPorts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, OutPort> getOutPorts() {
			// TODO Auto-generated method stub
			return outPorts;
		}
	
		List<Observer> observers = new ArrayList<Observer>();
		Map<String,OutPort> outPorts = new TreeMap<String,OutPort>();
		
		
	}
	

	@Before
	public void setUp() throws Exception {
		inPort = new InPortImpl();
		moduleStub = new ModuleStub();
		inPort.setModule(moduleStub);
		moduleStub.addObserver(inPort);
	}

	@After
	public void tearDown() throws Exception {
		inPort = null;
		moduleStub = null;
		
	}

	@Test
	public void testInPortImpl() {
		assertNotNull(inPort);
	}

	@Test
	public void testGetValue() {
		moduleStub.moduleFunction();
		assertEquals( 10, inPort.getValue() );
	}

	@Test
	public void testSetValue() {
		inPort.setValue(5);
		assertEquals( 5, inPort.getValue() );
	}

	@Test
	public void testIsEmpty() {
		assertTrue(inPort.isEmpty());
		inPort.setValue(5);
		assertFalse(inPort.isEmpty());
	}

	@Test
	public void testUpdate() {
		moduleStub.moduleFunction();
		assertEquals( 10, inPort.getValue() );
	}

}
