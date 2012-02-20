package kernel.impl.adsr;

import kernel.ADSRStrategie;
import kernel.impl.OutPortImpl;

public class SustainTime implements ADSRStrategie {

	public SustainTime(ADSR adsr){
		this.adsr = adsr;
	}
	@Override
	public void state() {
		// TODO Auto-generated method stub
		int input;
		if( !adsr.getInPorts().get( "gate" ).isEmpty() ){
			input = adsr.getInPorts().get( "gate" ).getValue();
			//System.out.println("gate = " + input);
			adsr.getOutPorts().get( "out" ).setValue( adsr.getSampleValue() );
			adsr.masterNotify();
			( ( OutPortImpl ) adsr.getOutPorts().get( "out" ) ).removeHead();
			if( input < 0){
				adsr.setState( 3 );
			}
		}

	}
	
	private ADSR adsr;

}
