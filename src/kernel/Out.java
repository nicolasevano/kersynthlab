
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

	@Override
	public void addObserver(Observer toAdd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		 
		AudioFormat af = new AudioFormat( sampleRate, 16, 1, true, false );
		SourceDataLine sdl;
		int sample;
		try {
			sdl = AudioSystem.getSourceDataLine( af );
			sdl.open( af );
			sdl.start();
			for( int i = 0; i < duration; i++ ) {
				if( !inPorts.get( "in" ).isEmpty() ){
					sample = inPorts.get( "in" ).getValue();
					System.out.println( "sample:" + sample );
					sdl.write( new byte[] { (byte) ( sample & 0xFF ), (byte) ( ( sample & 0xFF00) >> 8) }, 0, 2 );
				}
			}
			sdl.drain();
			sdl.stop();
			sdl.close();
		} catch ( LineUnavailableException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private InPort in;
	//TODO get from horloge
	float sampleRate = 44100;
	double duration = 100;
	private Map<String,InPort> inPorts;
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
		
	}
}
