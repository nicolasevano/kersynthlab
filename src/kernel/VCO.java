
package kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class VCO implements Module {

	public static enum WaveForm{ SQUARE, SAW, TRIANGLE, SINUS };
	
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

	public void setAtt(int att) {
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
	
	@Override
	public Map< String,InPort > getInPorts() {
		// TODO Auto-generated method stub
		return inPorts;
	}

	@Override
	public Map< String,OutPort > getOutPorts() {
		// TODO Auto-generated method stub
		return outPorts;
	}

	@Override
	public void addObserver(Observer toAdd) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
		( ( InPortImpl )toAdd ).setModule( this );
	}

	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		strategies.get( waveFormSelected ).waveForm();
	}
	
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
		vco.setPitch( 1 );
		//vco.setWaveForm( WaveForm.SQUARE );
		vco.setWaveForm( WaveForm.SAW );
		//vco.setWaveForm( WaveForm.TRIANGLE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
		timeBase.addModuleObserver( out );
		( ( HorlogeImpl ) timeBase ).start();
		try {
			Thread.sleep( 5000 );
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		( ( HorlogeImpl ) timeBase ).stop();
	}
	
	protected int computeFrequency(){
		return ( int )(
				( 8 / base ) * 220 * pitch * 
				Math.pow( 2, ( ( !inPorts.get( "fm" ).isEmpty() )? 
						att * inPorts.get( "fm" ).getValue() : 0  ) )
				);
	}
	
	private int base;

	private int att;

	private int pitch;
	
	private WaveForm waveFormSelected;
	
	private Map< String,InPort > inPorts;
	
	private Map< String,OutPort > outPorts;
	
	private Map<WaveForm,VCOStrategie> strategies;
	
	private List<Observer> observers;

}
