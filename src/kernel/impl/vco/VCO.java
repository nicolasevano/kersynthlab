
package kernel.impl.vco;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.HorlogeSubject;
import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import kernel.VCOStrategie;
import kernel.impl.HorlogeImpl;
import kernel.impl.HorlogeImpl3;
import kernel.impl.InPortImpl;
import kernel.impl.Out;
import kernel.impl.OutPortImpl;

/**
 * VCO module implementation.
 * @author nicolas
 *
 */
public class VCO implements Module {

	/**
	 * WaveForm definition
	 * @author nicolas
	 *
	 */
	public static enum WaveForm{ SQUARE, SAW, TRIANGLE, SINUS };
	
	/**
	 * Public constructor.
	 */
	public VCO(){
		observers = new ArrayList<Observer>();
		strategies = new TreeMap<WaveForm,VCOStrategie>();
		strategies.put( WaveForm.SQUARE, new SquareWaveForm( this ) );
		strategies.put( WaveForm.SAW, new SawWaveForm( this ) );
		strategies.put( WaveForm.TRIANGLE, new TriangleWaveForm( this ) );
		//TODO add and implement other waveform
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "fm", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
	}
	
	public void setPitch( int pitch ) {
		this.pitch = pitch;
	}

	public int getPitch() {
		return this.pitch;
	}

	public void setBase( int base ) {
		this.base = base;
	}

	public int getBase() {
		return this.base;
	}

	public void setAtt( int att ) {
		this.att = att;
	}

	public int getAtt() {
		return this.att;
	}

	public void setWaveForm( WaveForm waveFormSelected ){
		this.waveFormSelected = waveFormSelected;
	}
	
	public WaveForm getWaveForm(){
		return waveFormSelected;
	}
	
	/**
	 * GetInPorts function return current map in port module of VCO instance.
	 * @return Map<String, Inport> contains each pair name and in port of this VCO instance. 
	 */
	@Override
	public Map< String,InPort > getInPorts() {
		// TODO Auto-generated method stub
		return inPorts;
	}

	/**
	 * GetOutPorts function return current map out port module of VCO instance.
	 * @return Map<String, Outport> contains each pair name and out port of this VCO instance. 
	 */
	@Override
	public Map< String,OutPort > getOutPorts() {
		// TODO Auto-generated method stub
		return outPorts;
	}

	/**
	 * Add a new in port subscriber to this VCO instance.
	 * @param toAdd new in port subscriber.
	 */
	@Override
	public void addObserver(Observer toAdd) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
		( ( InPortImpl )toAdd ).setModule( this );
	}

	/**
	 * Remove a subscriber to this VCO instance.
	 * @param toRemove in port subscriber to remove.
	 */
	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	/**
	 * VCO module function generate the selected wave form on this output port. 
	 */
	@Override
	public synchronized void moduleFunction() {
		// TODO Auto-generated method stub
		strategies.get( waveFormSelected ).waveForm();
	}
	
	/**
	 * Notify each in port subscriber of this module.
	 */
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
		for( Observer observer:observers ){
			observer.update();
		}
	}
	
	public static final void main( String...args ){
		VCO vco = new VCO();
		Out out = new Out();
		vco.addObserver( out.getInPorts().get( "in" ) );
		vco.setAtt( 1 );
		vco.setBase( 8 );
		vco.setPitch( 10 );
		vco.setWaveForm( WaveForm.SQUARE );
		//vco.setWaveForm( WaveForm.SAW );
		//vco.setWaveForm( WaveForm.TRIANGLE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
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
	
	public int getSampleComputer() {
		return sampleComputer;
	}

	public void setSampleComputer(int sampleComputer) {
		this.sampleComputer = sampleComputer;
	}
	
	/**
	 * ComputeFrequence VCO function, compute output signal frequency
	 * @return int VCO output signal frequency.
	 */
	public int computeFrequency(){
		return ( int )(
				( 8 / base ) * 220 * pitch * 
				Math.pow( 2, ( ( !inPorts.get( "fm" ).isEmpty() )? 
						att * inPorts.get( "fm" ).getValue() : 0  ) )
				);
	}
	
	/**
	 * current VCO base value
	 */
	private int base;

	/**
	 * current vco att value
	 */
	private int att;

	/**
	 * current pitch value
	 */
	private int pitch;
	
	/**
	 * current selected wave form strategy
	 */
	private WaveForm waveFormSelected;
	
	/**
	 * Contains each pair name and in port of this VCO instance.
	 */
	private Map< String,InPort > inPorts;
	
	/**
	 * Contains each pair name and out port of this VCO instance.
	 */
	private Map< String,OutPort > outPorts;
	
	/**
	 * waveForm generator container
	 */
	private Map<WaveForm,VCOStrategie> strategies;
	
	/**
	 * In port subcriber list on this VCO instance.
	 */
	private List<Observer> observers;
	
	private int sampleComputer = 1;

}
