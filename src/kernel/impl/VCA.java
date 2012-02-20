package kernel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.HorlogeSubject;
import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;



/**
 * VCA module implementation
 * @author sylvie
 *
 */
public class VCA implements Module {
	
	/**
	 * Public constructor.
	 */
	public VCA (){
		
		observers = new ArrayList<Observer>();
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "am", new InPortImpl() );
		inPorts.put( "in", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
		
	}

	/**
	 * Notify each in port subscriber of this module.
	 */
	@Override
	public void masterNotify() {
		for( Observer observer:observers ){
			observer.update();
		}
		// TODO Auto-generated method stub

	}

	/**
	 * Add a new in port subscriber to this VCA instance.
	 * @param toAdd new in port subscriber.
	 */
	@Override
	public void addObserver( Observer toAdd ) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
		( ( InPortImpl )toAdd ).setModule( this );
	}

	/**
	 * Remove a subscriber to this VCA instance.
	 * @param toRemove in port subscriber to remove.
	 */
	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	/**
	 * VCA module function amplify or divide input signal on this output port
	 */
	@Override
	public synchronized void moduleFunction() {
		// TODO Auto-generated method stub modulation de l'amplitude en foncton de la valeur 
		//du potentiomètre
		
		int sample;
		for ( int i = 0; i < sampleComputer; i++ )/*while(true)*/ {
			if( !inPorts.get( "in" ).isEmpty() ){
				sample = inPorts.get( "in" ).getValue();
				//TODO deal with minus att
				if( !inPorts.get( "am" ).isEmpty())
					sample = (att>0)? sample*att*inPorts.get( "am" ).getValue():
						sample*inPorts.get( "am" ).getValue()/Math.abs(att);
				else 
					sample = (att>0)? sample*att:sample/Math.abs(att);
				if (sample>32768) sample = 32768;
				if (sample<-32768) sample = -32768;
				//System.out.println( "sample:" + sample );
				outPorts.get( "out" ).setValue( sample );
				masterNotify();
				( ( OutPortImpl ) outPorts.get( "out" ) ).removeHead();
			}			
		}

	}
	
	/**
	 * Change att factor.
	 * @param att new att factor.
	 */
	public void setAttVCA(int att){
		this.att = att;
	}
	
	/**
	 * Get att factor.
	 * @return att factor.
	 */
	public int getAttVCA(){
		return this.att;
	}
	
	/**
	 * GetInPorts function return current map in port module of VCA instance.
	 * @return Map<String, Inport> contains each pair name and in port of this VCA instance. 
	 */
	@Override
	public Map<String, InPort> getInPorts() {
		// TODO Auto-generated method stub
		return inPorts;
	}

	/**
	 * GetOutPorts function return current map out port module of VCA instance.
	 * @return Map<String, Outport> contains each pair name and out port of this VCA instance. 
	 */
	@Override
	public Map<String, OutPort> getOutPorts() {
		// TODO Auto-generated method stub
		return outPorts;
	}
	
	public static final void main( String...args ){
		VCO vco = new VCO();
		VCA vca = new VCA();
		Out out = new Out();
		vco.addObserver( vca.getInPorts().get( "in" ) );
		vca.addObserver( out.getInPorts().get( "in" ) );
		vca.setAttVCA( -16 );
		vco.setAtt( 1 );
		vco.setBase( 8 );
		vco.setPitch( 30 );
		//out.setBufferSize( 2000 );
		//vco.setWaveForm( WaveForm.SQUARE );
		//vco.setWaveForm( WaveForm.SAW );
		vco.setWaveForm( WaveForm.TRIANGLE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
		timeBase.addModuleObserver( vca );
		timeBase.addModuleObserver( out );
		HorlogeImpl.setSampleRate( 44100 );
		( ( HorlogeImpl ) timeBase ).start();
		try {
			Thread.sleep( 60000 );
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		( ( HorlogeImpl ) timeBase ).stop();
		System.exit(0);
	}
	
	public void setSampleComputer(int sampleComputer) {
		this.sampleComputer = sampleComputer;
	}
	
	/**
	 * Contains each pair name and in port of this VCA instance.
	 */
	private Map< String,InPort > inPorts;

	/**
	 * Contains each pair name and out port of this VCA instance.
	 */
	private Map< String,OutPort > outPorts;

	/**
	 * In port subcriber list on this VCA instance.
	 */
	private List<Observer> observers;
	
	/**
	 * Att parameter factor should be 8,4,2,1,-2,-4,-8.
	 */
	private int att;
	
	private int sampleComputer = 1;

}


