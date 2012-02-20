package kernel.impl;

import static org.junit.Assert.*;
import kernel.InPort;
import kernel.Observer;
import kernel.Subject;
import kernel.Module;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VCOTest {
	private VCO vco;
	private InPortStub inPortStub;
	private InPort inPortImpl;
	
	public class InPortStub implements InPort{

		@Override
		public void update() {
			
			// call update de la valeur du port en entrée 	
			value = ( ( Module ) module ).getOutPorts().get( "out" ).getValue();
			
		}
		
		public void setModule(Subject module){
			this.module = module;
		}

		@Override
		public void setValue(int value) {
			// TODO Auto-generated method stub
			this.value = value;
		}

		@Override
		public int getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return (value == 0);
		}
				
		private Subject module;
		private int value = 0;
		
	}
	
	

	@Before
	public void setUp() throws Exception {
		HorlogeImpl.sampleRate = 44100;
		vco = new VCO();
		//inPortStub = new InPortStub();
		//TODO remove inportmpl initialisation as soon as 
		//Inport interface will be updated with setModule.
		inPortImpl = new InPortImpl();
		//vco.addObserver( inPortStub );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		vco.addObserver( inPortImpl );
	}

	@After
	public void tearDown() throws Exception {
		//vco.removeObserver(inPortStub);
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		vco.removeObserver(inPortImpl);
		vco=null;
		//inPortStub = null;
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		inPortImpl = null;
	}

	@Test
	public void testVCO() {
		assertNotNull(vco);
	}

	@Test
	public void testSetPitch() {
		vco.setPitch(2);
		assertEquals(2,vco.getPitch());
		
	}

	@Test
	public void testGetPitch() {
		vco.setPitch(2);
		assertEquals(2,vco.getPitch());
	}

	@Test
	public void testSetBase() {
		vco.setBase(16);
		assertEquals(16,vco.getBase());
	}

	@Test
	public void testGetBase() {
		vco.setBase(16);
		assertEquals(16,vco.getBase());
		
	}

	@Test
	public void testSetAtt() {
		vco.setAtt(50);
		assertEquals(50,vco.getAtt());
	}

	@Test
	public void testGetAtt() {
		vco.setAtt(50);
		assertEquals(50,vco.getAtt());
	}

	@Test
	public void testSetWaveForm() {
		vco.setWaveForm(WaveForm.SAW);
		assertEquals(WaveForm.SAW,vco.getWaveForm());
	}

	@Test
	public void testGetWaveForm() {
		vco.setWaveForm(WaveForm.SAW);
		assertEquals(WaveForm.SAW,vco.getWaveForm());
		
	}
	// comme les ports sont agrégés dans le constructeur 
	//on peut seulement venir vérifier que leur référence n'est pas nulle 
	@Test
	public void testGetInPorts() {
		assertNotNull(vco.getInPorts());
	}
	// idem que pour GetInPorts
	@Test
	public void testGetOutPorts() {
		assertNotNull(vco.getOutPorts());	
	}

	@Test
	public void testAddObserver() {
		vco.setWaveForm( WaveForm.SAW );
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt(1);
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
	}

	@Test
	public void testRemoveObserver() {
		//vco.removeObserver( inPortStub );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		vco.removeObserver( inPortImpl );
		vco.setWaveForm( WaveForm.SAW );
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt(1);
		vco.moduleFunction();
		//assertTrue( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		assertTrue( inPortImpl.isEmpty() );
	}

	@Test
	public void testModuleFunction() {
		vco.setWaveForm( WaveForm.SAW );
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt(1);
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule.
		assertFalse( inPortImpl.isEmpty() );
		vco.setWaveForm( WaveForm.TRIANGLE );
		//inPortStub.setValue( 0 );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		while( !inPortImpl.isEmpty() )inPortImpl.getValue();
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
		vco.setWaveForm( WaveForm.SQUARE );
		//inPortStub.setValue( 0 );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		while( !inPortImpl.isEmpty() )inPortImpl.getValue();
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
	}

	@Test
	public void testMasterNotify() {
		
		vco.setWaveForm( WaveForm.SAW );
		vco.setBase( 8 );
		vco.setPitch( 1 );
		vco.setAtt(1);
		vco.moduleFunction();
		//assertFalse( inPortStub.isEmpty() );
		//TODO remove line below as soon as 
		//Inport interface will be updated with setModule
		assertFalse( inPortImpl.isEmpty() );
		
	}

	

	@Test
	public void testComputeFrequency() {
		vco.setBase( 8 );
		vco.setPitch( 1 );
		assertEquals( 220, vco.computeFrequency() );
	}

}
