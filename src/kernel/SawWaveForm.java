package kernel;

public class SawWaveForm implements VCOStrategie{

	public SawWaveForm( Module vco ){
		this.vco = ( VCO ) vco;
	}
	
	@Override
	public void waveForm() {
		// TODO Auto-generated method stub
		// TODO remove number sample rate value and use something else.
		//TODO Working however first sample doesn't appear. Fix it.
		int frequency = 0;
		for( int i = 0; i < 100; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = 44100 / frequency;
			step = ( 32768 / samplePeriod ) * 2;
			sampleValue = ( ( ( ( 32768*2 ) - Math.abs( 32768 + sampleValue ) ) ) >= step )?
					sampleValue + step : 32768;
			//System.out.println("vco sample: " + sampleValue);
			vco.getOutPorts().get( "out" ).setValue( sampleValue );
			vco.masterNotify();
			( ( OutPortImpl ) vco.getOutPorts().get( "out" ) ).removeHead();
			if ( sampleValue == 32768 ) sampleValue = -32768;
		}
		
	}
	private int step;
	private int sampleValue = -32768;
	private int samplePeriod;
	private VCO vco;
	
}
