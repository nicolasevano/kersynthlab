package kernel.impl.replicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import kernel.impl.InPortImpl;
import kernel.impl.OutPortImpl;

public class Replicator implements Module{

	/**
	 * Public constructor.
	 */
	public Replicator(){
		
		observers = new ArrayList<Observer>();
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "in", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
		
	}
	
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
		for( Observer observer:observers ){
			observer.update();
		}
		
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
		int sample;
		if( !inPorts.get( "in" ).isEmpty() ){
			sample = inPorts.get( "in" ).getValue();
			outPorts.get( "out" ).setValue( sample );
			masterNotify();
			( ( OutPortImpl ) outPorts.get( "out" ) ).removeHead();
		}
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
	
}
