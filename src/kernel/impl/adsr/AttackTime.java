package kernel.impl.adsr;

import kernel.ADSRStrategie;
import kernel.impl.OutPortImpl;

public class AttackTime implements ADSRStrategie{

	public AttackTime( ADSR adsr ){
		this.adsr = adsr;
	}
	
	@Override
	public void state() {
		// TODO Auto-generated method stub
		int step;
		int input;
		if( !adsr.getInPorts().get( "gate" ).isEmpty() ){
			//System.out.println( "Attack time compute sample" );
			input = adsr.getInPorts().get( "gate" ).getValue();
			//System.out.println( "gate = " + input );
			if( input <= 0 ){
				step = ( 32768 / adsr.getAttackTime() );
				adsr.setSampleValue( ( ( adsr.getSampleValue() + step ) > 32768 )? 
						32768 : ( adsr.getSampleValue() + step ) );
				adsr.getOutPorts().get( "out" ).setValue( adsr.getSampleValue() );
				adsr.masterNotify();
				( ( OutPortImpl ) adsr.getOutPorts().get( "out" ) ).removeHead();
			} else {
				adsr.setState( 1 );
			}
		}
	}

	/**
	 * current adsr instancce
	 */
	private ADSR adsr;
}
