package kernel.impl;

import static org.junit.Assert.*;

import java.util.Map;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HorlogeImplTest {
	private HorlogeImpl horlogeImpl;
	private Module moduleStub1,moduleStub2;

	public class ModuleStub implements Module{

		@Override
		public void masterNotify() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addObserver(Observer toAdd) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeObserver(Observer toRemove) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void moduleFunction() {
			// TODO Auto-generated method stub
			moduleFuntionCall = true;
		}

		@Override
		public Map<String, InPort> getInPorts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, OutPort> getOutPorts() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public boolean moduleFuntionCall = false;
	}
	@Before
	public void setUp() throws Exception {
		
		horlogeImpl = new HorlogeImpl();
		moduleStub1 = new ModuleStub();
		moduleStub2 = new ModuleStub();
		horlogeImpl.addModuleObserver( moduleStub1 );
		horlogeImpl.addModuleObserver( moduleStub2 );
		
	}

	@After
	public void tearDown() throws Exception {
		horlogeImpl.removeModuleObserver( moduleStub1 );
		horlogeImpl.removeModuleObserver( moduleStub2 );
		horlogeImpl = null;
		moduleStub1 = null;
		moduleStub2 = null;
	}

	@Test
	public void testHorlogeImpl() {
		assertNotNull( horlogeImpl );
	}

	@Test
	public void testAddModuleObserver() {
		horlogeImpl.tick();
		assertTrue( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertTrue( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
	}

	@Test
	public void testRemoveModuleObserver() {
		horlogeImpl.removeModuleObserver( moduleStub1 );
		horlogeImpl.tick();
		assertFalse( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertTrue( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
	}

	@Test
	public void testTick() {
		assertFalse( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertFalse( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
		horlogeImpl.tick();
		assertTrue( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertTrue( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
	}

	@Test
	public void testStart() {
		
		horlogeImpl.start();
		try {
			Thread.sleep( 40 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertTrue( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
		horlogeImpl.stop();
		try {
			Thread.sleep( 40 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testStop() {
		
		horlogeImpl.start();
		try {
			Thread.sleep( 40 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertTrue( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
		horlogeImpl.stop();
		try {
			Thread.sleep( 40 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		( ( ModuleStub ) moduleStub1 ).moduleFuntionCall = false;
		( ( ModuleStub ) moduleStub2 ).moduleFuntionCall = false;
		
		try {
			Thread.sleep( 40 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse( ( ( ModuleStub ) moduleStub1 ).moduleFuntionCall );
		assertFalse( ( ( ModuleStub ) moduleStub2 ).moduleFuntionCall );
	}

	@Test
	public void testGetSampleRate() {
		horlogeImpl.setSampleRate( 44100 );
		assertEquals(44100, horlogeImpl.getSampleRate() );
	}

	@Test
	public void testSetSampleRate() {
		horlogeImpl.setSampleRate( 44100 );
		assertEquals(44100, horlogeImpl.getSampleRate() );
	}
}
