package kernel.impl;

import kernel.Module;
import kernel.VCOStrategie;

/**
 * TriangleWaveForm implementation strategy.
 * @author nicolas
 *
 */
public class TriangleWaveForm implements VCOStrategie {

	/**
	 * Public constructor
	 * @param vco
	 */
	public TriangleWaveForm( Module vco ){
		this.vco = ( VCO ) vco;
	}
	
	/**
	 * WaveForm function generate a triangle signal on vco output port 
	 * for which this current instance is working. 
	 */
	@Override
	public void waveForm() {
		// TODO Auto-generated method stub
		int frequency = 0;
		for( int i = 0; i < 100; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = HorlogeImpl.sampleRate / frequency;
			step = ( 32768 / samplePeriod ) * 4;
			step *= toggle;
			sampleValue = ( Math.abs( ( 32768 * toggle ) - sampleValue ) >= Math.abs( step ) )? 
					sampleValue + step : ( toggle * 32768 );
			vco.getOutPorts().get( "out" ).setValue( sampleValue );
			vco.masterNotify();
			( ( OutPortImpl ) vco.getOutPorts().get( "out" ) ).removeHead();
			if ( sampleValue == 32768 || sampleValue == -32768 ) toggle *= -1;
		}
	}
	
	/**
	 * Delta between two sample.
	 */
	private int step;
	
	/**
	 * Ramp toggle.
	 */
	private int toggle = -1;
	
	/**
	 * Beginning sample value.
	 */
	private int sampleValue = 32768;
	
	/**
	 * SamplePeriod number of sample on one generated period.
	 */
	private int samplePeriod;
	
	/**
	 * Current vco instance for which this strategy is working.
	 */
	private VCO vco;

}