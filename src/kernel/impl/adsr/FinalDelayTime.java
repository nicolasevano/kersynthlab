package kernel.impl.adsr;

import kernel.ADSRStrategie;
import kernel.impl.OutPortImpl;

public class FinalDelayTime implements ADSRStrategie {

	public FinalDelayTime( ADSR adsr ){
		this.adsr = adsr;
	}
	
	@Override
	public void state() {
		// TODO Auto-generated method stub
		int step;
		int input;
		if( !adsr.getInPorts().get( "gate" ).isEmpty() ){
			input = adsr.getInPorts().get( "gate" ).getValue();
			if( input < 0 && adsr.getSampleValue() > adsr.getSustainVoltage() ){
				step = ( adsr.getSustainVoltage() ) / adsr.getFinalDelayTime();
				adsr.setSampleValue( 
						( ( adsr.getSampleValue() - step ) > 0 )?
								( adsr.getSampleValue() - step ) : 0 
								    );
				adsr.getOutPorts().get( "out" ).setValue( adsr.getSampleValue() );
				adsr.masterNotify();
				( ( OutPortImpl ) adsr.getOutPorts().get( "out" ) ).removeHead();
			} else {
				adsr.setState( 0 );
			}
		} 
	}

	private ADSR adsr;
}
