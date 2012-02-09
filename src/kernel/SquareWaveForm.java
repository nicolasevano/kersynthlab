package kernel;

public class SquareWaveForm implements VCOStrategie {
	
	public SquareWaveForm(Module vco){
		this.vco = ( VCO ) vco;
	}
	
	@Override
	public void waveForm() {
		// TODO remove number sample rate value and use something else.
		int frequency = 0;
		for( int i = 0; i < 100; i++ ){
			frequency = vco.computeFrequency();
			samplePeriod = 44100 / frequency;
			//System.out.println("samplePeriod:" + samplePeriod);
			vco.getOutPorts().get( "out" ).setValue( 
					( ( samplePeriod / 2 ) < counterPeriod ) ? 32768:-32768 
							);
			counterPeriod = ( counterPeriod < samplePeriod )? counterPeriod + 1 : 0 ;
			vco.masterNotify();
			( ( OutPortImpl ) vco.getOutPorts().get("out") ).removeHead();
			
		}
	}
	
	private int counterPeriod = 0;
	private int samplePeriod;
	private VCO vco;
}
