package kernel.impl;

import static org.junit.Assert.*;
import kernel.InPort;
import kernel.impl.VCO.WaveForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleWaveFormTest {
	private VCO vco;
	private InPort inPortImpl;

	@Before
	public void setUp() throws Exception {
		HorlogeImpl.setSampleRate( 44100 );
		vco = new VCO();
		inPortImpl = new InPortImpl();
		vco.addObserver( inPortImpl );
	}

	@After
	public void tearDown() throws Exception {
		vco.removeObserver( inPortImpl );
		vco = null;
		inPortImpl = null;
	}

	@Test
	public void testWaveForm() {
		vco.setWaveForm(WaveForm.TRIANGLE);
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt( 1 );
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertEquals( (32768-654),inPortImpl.getValue() );
		vco.moduleFunction();
		assertEquals( (32768-654*2), inPortImpl.getValue() );
	}

}
