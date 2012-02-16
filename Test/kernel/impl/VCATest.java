package kernel.impl;

import static org.junit.Assert.*;
import kernel.InPort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VCATest {
	private VCA vca;
	private InPort inPortImpl;

	@Before
	public void setUp() throws Exception {
		vca = new VCA ();
		inPortImpl = new InPortImpl();
		vca.addObserver(inPortImpl);
		
	}

	@After
	public void tearDown() throws Exception {
		vca.removeObserver(inPortImpl);
		vca = null;
		inPortImpl=null;
		
		
	}

	@Test
	public void testVCA() {
		assertNotNull(vca);
		
	}

	@Test
	public void testMasterNotify() {
		
		vca.setAttVCA(1);
		vca.getInPorts().get("in").setValue( 10 );
		vca.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
		
	}

	@Test
	public void testAddObserver() {
		vca.setAttVCA(1);
		vca.getInPorts().get("in").setValue( 10 );
		vca.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
		
	}

	@Test
	public void testRemoveObserver() {
		vca.setAttVCA(1);
		vca.moduleFunction();
		//assertTrue( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		assertTrue( inPortImpl.isEmpty() );
		
	}

	@Test
	public void testModuleFunction() {
		
		vca.setAttVCA(1);
		vca.getInPorts().get("in").setValue(10);
		vca.moduleFunction();
		assertEquals(10,inPortImpl.getValue());
		vca.setAttVCA(2);
		vca.getInPorts().get("in").setValue(10);
		vca.moduleFunction();
		assertEquals(20,inPortImpl.getValue());
		vca.setAttVCA(-2);
		vca.getInPorts().get("in").setValue(10);
		vca.moduleFunction();
		assertEquals(5,inPortImpl.getValue());
		
	}

	@Test
	public void testSetAttVCA() {
		vca.setAttVCA(1);
		assertEquals(1,vca.getAttVCA());
		
	}

	@Test
	public void testGetAttVCA() {
		vca.setAttVCA(1);
		assertEquals(1,vca.getAttVCA());
	}
	@Test
	public void testGetInPorts() {
		assertNotNull(vca.getInPorts());
	}
	// idem que pour GetInPorts
	@Test
	public void testGetOutPorts() {
		assertNotNull(vca.getOutPorts());	
	}
	
}
