package kernel.impl.adsr;

import kernel.ADSRStrategie;
import kernel.impl.OutPortImpl;

public class DelayTime implements ADSRStrategie {

	public DelayTime( ADSR adsr ){
		
		this.adsr = adsr;
		
	}
	
	@Override
	public void state() {
		// TODO Auto-generated method stub
		int step;
		int input;
		if( !adsr.getInPorts().get( "gate" ).isEmpty() ){
			input = adsr.getInPorts().get( "gate" ).getValue();
			if( input > 0 && adsr.getSampleValue() > adsr.getSustainVoltage() ){
				step = ( 32768 - adsr.getSustainVoltage() ) / adsr.getDelayTime();
				adsr.setSampleValue( 
						( ( adsr.getSampleValue() - step ) > adsr.getSustainVoltage() )?
								( adsr.getSampleValue() - step ) : adsr.getSustainVoltage() 
								    );
				adsr.getOutPorts().get( "out" ).setValue( adsr.getSampleValue() );
				adsr.masterNotify();
				( ( OutPortImpl ) adsr.getOutPorts().get( "out" ) ).removeHead();
				if( adsr.getSampleValue() == adsr.getSustainVoltage() ) adsr.setState( 2 );
			} else {
				adsr.setState( 3 );
			}
		} 
	}

	private ADSR adsr;
}
