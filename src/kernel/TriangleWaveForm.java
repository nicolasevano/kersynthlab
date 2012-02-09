package kernel;

public class TriangleWaveForm implements VCOStrategie {

	public TriangleWaveForm( Module vco ){
		this.vco = ( VCO ) vco;
	}
	
	@Override
	public void waveForm() {
		// TODO Auto-generated method stub
		int frequency = 0;
		for( int i = 0; i < 100; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = 44100 / frequency;
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
	
	private int step;
	private int toggle = -1;
	private int sampleValue = 32768;
	private int samplePeriod;
	private VCO vco;

}
