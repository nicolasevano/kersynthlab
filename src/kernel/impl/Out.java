package kernel.impl;

import java.util.Map;
import java.util.TreeMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;

public class Out implements Module{
	
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
	public void masterNotify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub
		
	}
	
	public void start(){
		try {
			
			af = new AudioFormat( HorlogeImpl.getSampleRate(), 16, 1, true, false );
			sdl = AudioSystem.getSourceDataLine( af );
			/*sdl.open( af, 10000 );*/
			sdl.open( af );
		} catch (LineUnavailableException e) {
			System.out.println("exception on openning stream");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println( "Sound card launched!" );
		sdl.start();
	}
	
	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		int sample;
		//System.out.println( "Sound card transfert function!" );
		int oldsample = 0;
		if( !inPorts.get( "in" ).isEmpty() ){
			try{
				sample = inPorts.get( "in" ).getValue();
				//System.out.println( "sample: " + sample );
				sdl.write( 
						new byte[] { ( byte ) ( sample & 0xFF ), ( byte ) ( ( sample & 0xFF00 ) >> 8 ) }, 
						0, 2 );
				oldsample = sample;
			}catch(java.util.NoSuchElementException nsee){
				sdl.write( 
						new byte[] { ( byte ) ( oldsample & 0xFF ), ( byte ) ( ( oldsample & 0xFF00 ) >> 8 ) }, 
						0, 2 );
				//System.out.println("Exception");
			}
			//
		}else{
			//System.out.println("Input empty!");
		}
	}
	
	public void stop(){
		sdl.drain();
		sdl.stop();
		sdl.close();
		System.out.println( "finish" );
	}
	/**
	 * In InPort current in port of out instance.
	 */
	private InPort in;

	/**
	 * InPorts map contain each in port of out instance. 
	 */
	private Map<String,InPort> inPorts;
	
	/**
	 * Af AudioFormat used to open stream on sound card.
	 */
	private AudioFormat af;
	
	/**
	 * Sdl SourceDataLine input stream on sound card.
	 */
	private SourceDataLine sdl;
}
