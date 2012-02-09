package kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.VCO.WaveForm;




public class VCA implements Module {
	
	public VCA (){
		observers = new ArrayList<Observer>();
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "am", new InPortImpl() );
		inPorts.put( "in", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
		
	}

	@Override
	public void masterNotify() {
		for( Observer observer:observers ){
			observer.update();
		}
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub modulation de l'amplitude  en foncton de la valeur du potentiomètre
		
		int sample;
		for (int i = 0; i < 100; i++) {
			if( !inPorts.get( "in" ).isEmpty() ){
				sample = inPorts.get("in").getValue();
				//TODO deal with minus att
				if( !inPorts.get("am").isEmpty())
					sample = (att>0)? sample*att*inPorts.get("am").getValue():sample*inPorts.get("am").getValue()/Math.abs(att);
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
	
	public void setAttVCA(int att){
		this.att = att;
	}
	
	public int getAttVCA(){
		return this.att;
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
	
	public static final void main( String...args ){
		VCO vco = new VCO();
		VCA vca = new VCA();
		Out out = new Out();
		vco.addObserver( vca.getInPorts().get( "in" ) );
		vca.addObserver( out.getInPorts().get( "in" ) );
		vca.setAttVCA( -2 );
		vco.setAtt( 1 );
		vco.setBase( 8 );
		vco.setPitch( 1 );
		//vco.setWaveForm( WaveForm.SQUARE );
		vco.setWaveForm( WaveForm.SAW );
		//vco.setWaveForm( WaveForm.TRIANGLE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
		timeBase.addModuleObserver( vca );
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

	private Map< String,InPort > inPorts;

	private Map< String,OutPort > outPorts;

	private List<Observer> observers;
	
	private int att;
}


