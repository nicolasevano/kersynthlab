package kernel.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OutTest {
	private Out out;
	

	@Before
	public void setUp() throws Exception {
		// affectation de la référence out
		out = new Out();
	}

	@After
	public void tearDown() throws Exception {
		out = null;
	}
	@Test
	public void testOut() {
		assertNotNull(out);		
	}

	@Test
	public void testGetInPorts() {
		assertNotNull(out.getInPorts());
	}
}
