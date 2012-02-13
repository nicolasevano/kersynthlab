package kernel.impl;


import kernel.Module;
import kernel.VCOStrategie;

/**
 * SawWaveForm implementation strategy
 * @author nicolas
 *
 */
public class SawWaveForm implements VCOStrategie{

	/**
	 * Public contructor.
	 * @param vco
	 */
	public SawWaveForm( Module vco ){
		this.vco = ( VCO ) vco;
	}
	
	/**
	 * WaveForm function design a saw signal on VCO output port.
	 */
	@Override
	public void waveForm() {
		// TODO Auto-generated method stub
		// TODO remove number sample rate value and use something else.
		//TODO Working however first sample doesn't appear. Fix it.
		int frequency = 0;
		for( int i = 0; i < 200; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = HorlogeImpl.sampleRate / frequency;
			step = ( 65536 / samplePeriod );
			if(begin){
				begin = false;
			}else {
			sampleValue = ( ( ( ( 65536 ) - Math.abs( 32768 + sampleValue ) ) ) >= step )?
					sampleValue + step : 32768;
			}
			//System.out.println("vco sample: " + sampleValue);
			vco.getOutPorts().get( "out" ).setValue( sampleValue );
			vco.masterNotify();
			( ( OutPortImpl ) vco.getOutPorts().get( "out" ) ).removeHead();
			if ( sampleValue == 32768 ){
				begin = true;
				sampleValue = -32768;
			}
		}
		
	}
	
	private boolean begin = true;
	
	/**
	 * Delta between two sample.
	 */
	private int step;
	
	/**
	 * Starting value.
	 */
	private int sampleValue = -32768;
	
	/**
	 * Number of sample on one period.
	 */
	private int samplePeriod;
	
	/**
	 * VCO reference for this saw strategy is working. 
	 */
	private VCO vco;
	
}
