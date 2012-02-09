
package kernel;

import java.util.Map;
import java.util.TreeMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class Out implements Module {

	public Out(){
		in = new InPortImpl();
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "in", in );
		af = new AudioFormat( sampleRate, 16, 1, true, false );
		try {
			sdl = AudioSystem.getSourceDataLine( af );
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return null;
		
	}

	//no use on sound card
	@Override
	public void addObserver(Observer toAdd) {
		
		// TODO Auto-generated method stub

	}

	//no use on sound card
	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub

	}

	public void start(){
		
		try {
			
			sdl.open( af );
			
		} catch (LineUnavailableException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		sdl.start();
	}
	
	public void stop(){
		sdl.stop();
		sdl.close();
	}
	
	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		int sample;
		
		for( int i = 0; i < duration; i++ ) {
			
			if( !inPorts.get( "in" ).isEmpty() ){
				
				sample = inPorts.get( "in" ).getValue();
				System.out.println( "sample: " + sample );
				sdl.write( new byte[] { ( byte ) ( sample & 0xFF ), ( byte ) ( ( sample & 0xFF00 ) >> 8 ) }, 
						   0, 2 );
				
			}
			
		}
		
		sdl.drain();
	}
	
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private InPort in;
	//TODO get from horloge
	private float sampleRate = 44100;
	private double duration = 100;
	private Map<String,InPort> inPorts;
	private AudioFormat af;
	private SourceDataLine sdl;
	
}
