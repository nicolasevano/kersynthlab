package kernel.impl.adsr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.ADSRStrategie;
import kernel.HorlogeSubject;
import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import kernel.impl.HorlogeImpl;
import kernel.impl.InPortImpl;
import kernel.impl.Out;
import kernel.impl.OutPortImpl;
import kernel.impl.VCA;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;

public class ADSR implements Module {

	public ADSR(){
		observers = new ArrayList<Observer>();
		strategies = new TreeMap<Integer,ADSRStrategie>();
		strategies.put( 0, new AttackTime( this ) );
		strategies.put( 1, new DelayTime( this ) );
		strategies.put( 2, new SustainTime( this ) );
		strategies.put( 3, new FinalDelayTime( this ) );
		//TODO add and implement other state
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "gate", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
		this.state = 0;
	}
	
	@Override
	public Map<String, InPort> getInPorts() {
		// TODO Auto-generated method stub
		return inPorts;
	}

	@Override
	public Map<String, OutPort> getOutPorts() {
		// TODO Auto-generated method stub
		return outPorts;
	}

	/**
	 * Add a new in port subscriber to this ADSR instance.
	 * @param toAdd new in port subscriber.
	 */
	@Override
	public void addObserver( Observer toAdd ) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
		( ( InPortImpl )toAdd ).setModule( this );
	}

	/**
	 * Remove a subscriber to this ADSR instance.
	 * @param toRemove in port subscriber to remove.
	 */
	@Override
	public void removeObserver( Observer toRemove ) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		for( Observer observer:observers ){
			observer.update();
		}
	}

	@Override
	public synchronized void moduleFunction() {
		// TODO Auto-generated method stub
		//System.out.println(" adsr compute a sample ");
		strategies.get( this.getState() ).state();
	}
	
	public int getAttackTime() {
		return attackTime;
	}

	public void setAttackTime( int attackTime ) {
		this.attackTime = attackTime;
	}
	
	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime( int delayTime ) {
		this.delayTime = delayTime;
	}
	
	public int getSustainVoltage() {
		return sustainVoltage;
	}

	public void setSustainVoltage( int sustainVoltage ) {
		this.sustainVoltage = sustainVoltage;
	}

	public int getFinalDelayTime() {
		return finalDelayTime;
	}

	public void setFinalDelayTime( int finalDelayTime ) {
		this.finalDelayTime = finalDelayTime;
	}
	
	public int getState() {
		return this.state;
	}

	public void setState( int state ) {
		this.state = state;
	}
	
	public int getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue( int sampleValue ) {
		this.sampleValue = sampleValue;
		//System.out.println( "sampleValue = " + sampleValue );
	}
	
	public static final void main( String...args ){
		VCO vco = new VCO();
		Out out = new Out();
		ADSR adsr = new ADSR();
		VCA vca = new VCA();
		vco.addObserver( adsr.getInPorts().get( "gate" ) );
		adsr.addObserver( vca.getInPorts().get( "in" ) );
		vca.addObserver( out.getInPorts().get( "in" ) );
		vca.setAttVCA( -4 );
		vco.setAtt( 1 );
		vco.setBase( 4 );
		vco.setPitch( 10 );
		vco.setWaveForm( WaveForm.SQUARE );
		adsr.setAttackTime( 100 );
		adsr.setDelayTime( 50 );
		adsr.setSustainVoltage( 22384 );
		adsr.setFinalDelayTime( 50 );
		//vco.setWaveForm( WaveForm.SAW );
		//vco.setWaveForm( WaveForm.TRIANGLE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
		timeBase.addModuleObserver( vca );
		timeBase.addModuleObserver( adsr );
		timeBase.addModuleObserver( out );
		//out.setBufferSize( 2000 );
		HorlogeImpl.setSampleRate( 44100 );
		( ( HorlogeImpl ) timeBase ).start();
		try {
			Thread.sleep( 20000 );
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		( ( HorlogeImpl ) timeBase ).stop();
	}
	
	/**
	 * Contains each pair name and in port of this ADSR instance.
	 */
	private Map< String,InPort > inPorts;
	
	/**
	 * Contains each pair name and out port of this ADSR instance.
	 */
	private Map< String,OutPort > outPorts;

	/**
	 * In port subcriber list on this VCO instance.
	 */
	private List<Observer> observers;
	
	/** 
	 * Number of sample compute by moduleFunction when it call 
	 */
	//private int sampleComputer = 1;
	
	/**
	 * current sample value 
	 */
	private int sampleValue = 0;
	
	/**
	 * WaveForm generator container
	 */
	private Map<Integer,ADSRStrategie> strategies;
	
	/**
	 * Sample number in attack time delay.
	 */
	private int attackTime;
	
	/**
	 * Sample number in delay time
	 */
	private int delayTime;
	
	/**
	 * Sample amplitude in sustain voltage
	 */
	private int sustainVoltage;
	
	/**
	 * Sample number in final delay time
	 */
	private int finalDelayTime;
	
	/**
	 * current adsr time.
	 */
	private int state = 0;

}
