package kernel.impl;

import static org.junit.Assert.*;
import kernel.InPort;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SawWaveFormTest {
	
	private VCO vco;
	private InPort inPortImpl;
	// on ne peut pas tester SawWave Form sans avoir testé VCO et vice versa
	
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
		vco.setWaveForm(WaveForm.SAW);
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt( 1 );
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertEquals( -32768,inPortImpl.getValue() );
		vco.moduleFunction();
		assertEquals( (327-32768) , inPortImpl.getValue() );
	}

}
