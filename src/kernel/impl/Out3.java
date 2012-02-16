
package kernel.impl;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;

/**
 * Out module implementation.
 * @author nicolas
 *
 */
class Out3 implements Module {

	/**
	 * Public constructor.
	 */
	public Out3(){
		in = new InPortImpl();
		inPorts = new TreeMap<String,InPort>();
		timer = new Timer();
		inPorts.put( "in", in );
	}
	
	/**
	 * GetInPorts function return current map in port module of Out instance.
	 */
	@Override
	public Map<String, InPort> getInPorts() {
		
		// TODO Auto-generated method stub
		return inPorts;
		
	}

	
	//no use on sound card
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

	/**
	 * Start function switch on audio stream.
	 */
	public void start(){
		
		try {
			
			af = new AudioFormat( HorlogeImpl3.sampleRate, 16, 1, true, false );
			sdl = AudioSystem.getSourceDataLine( af );
			/*sdl.open( af, 10000 );*/
			sdl.open( af );
		} catch (LineUnavailableException e) {
			System.out.println("exception on openning stream");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		sdl.start();
		isALive = true;
        timer.schedule (new TimerTask() {
            public void run(){
            	moduleFunction();
            }
        }, bufferSize );
	}
	
	/**
	 * Stop function switch off audio stream.
	 */
	public void stop(){
		isALive = false;
		timer.cancel();
	}
	
	/**
	 * ModuleFunction of out current instance.
	 */
	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		int sample;
		System.out.println( "sound card launched!" );
		int oldsample = 0;
		while( isALive ) {
			
			if( !inPorts.get( "in" ).isEmpty() ){
				try{
					sample = inPorts.get( "in" ).getValue();
					System.out.println( "sample: " + sample );
					sdl.write( new byte[] { ( byte ) ( sample & 0xFF ), ( byte ) ( ( sample & 0xFF00 ) >> 8 ) }, 
								0, 2 );
					oldsample = sample;
				}catch(java.util.NoSuchElementException nsee){
					sdl.write( new byte[] { ( byte ) ( oldsample & 0xFF ), ( byte ) ( ( oldsample & 0xFF00 ) >> 8 ) }, 
							   0, 2 );
					System.out.println("exception");
				}
				//
			}else{
				System.out.println("input empty!");
			}
			
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
		System.out.println( "finish" );
	}
	
	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * isALive function.
	 * @return boolean return true if out is on.
	 */
	public boolean isALive() {
		return isALive;
	}
	
	/**
	 * GetBufferSize function return size in ms of current out instance.
	 * @return bufferSize function
	 */
	public int getBufferSize() {
		return bufferSize;
	}

	/**
	 * SetBufferSize function set buffer size in ms of current out instance.
	 * @param bufferSize
	 */
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
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
	
	/**
	 * IsALive true if input stream sound card is open.
	 */
	private boolean isALive = false;
	
	/**
	 * Buffer size in ms (delay between sample consumption and activation).
	 */
	private int bufferSize = 600;

	/**
	 * Internal moduleFunction launch only for out.
	 */
	private Timer timer;
	
}
