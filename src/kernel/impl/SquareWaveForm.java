package kernel.impl;

import kernel.Module;
import kernel.VCOStrategie;

/**
 * SquareWaveForm strategy implementation.
 * @author nicolas
 *
 */
public class SquareWaveForm implements VCOStrategie {
	
	/**
	 * Public constructor
	 * @param vco
	 */
	public SquareWaveForm(Module vco){
		this.vco = ( VCO ) vco;
	}
	
	/**
	 * waveForm function design a square signal on vco output port on which this strategy is working
	 */
	@Override
	public void waveForm() {
		// TODO remove number sample rate value and use something else.
		int frequency = 0;
		for( int i = 0; i < 100; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = HorlogeImpl.sampleRate / frequency;
			//System.out.println("samplePeriod:" + samplePeriod);
			vco.getOutPorts().get( "out" ).setValue( 
					( ( samplePeriod / 2 ) < counterPeriod ) ? 32768:-32768 
							);
			counterPeriod = ( counterPeriod < samplePeriod )? counterPeriod + 1 : 0 ;
			vco.masterNotify();
			( ( OutPortImpl ) vco.getOutPorts().get("out") ).removeHead();
			
		}
	}
	
	/**
	 * Sample period counter.
	 */
	private int counterPeriod = 0;
	
	/**
	 * Number of sample on one period.
	 */
	private int samplePeriod;
	
	/**
	 * VCO instance on which this square strategy is working. 
	 */
	private VCO vco;
}
