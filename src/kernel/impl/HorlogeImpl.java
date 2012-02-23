package kernel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kernel.HorlogeObserver;
import kernel.HorlogeSubject;

/**
 * Horloge ( implementation bis ) sequential one thread only
 * @author Nicolas
 *
 */
public class HorlogeImpl implements HorlogeSubject{

	/**
	 * Public constructor.
	 */
	public HorlogeImpl(){
		observers = new ArrayList<HorlogeObserver>();
		timerScheduler = Executors.newCachedThreadPool();
	}
	
	/**
	 * Add a new observers on this clock instance.
	 */
	@Override
	public void addModuleObserver(HorlogeObserver toAdd) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
	}

	/**
	 * Remove one observer on this clock current instance.
	 */
	@Override
	public void removeModuleObserver(HorlogeObserver toRemove) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	/**
	 * Call each moduleFunction of each clock observers.
	 */
	@Override
	public synchronized void tick() {
		// TODO Auto-generated method stub
		for( final HorlogeObserver observer : observers ){
			// TODO Auto-generated method stub
			observer.moduleFunction();
			//System.out.println(" Call one module function. ");
		}
	}
	
	/**
	 * Start function launch clock synchronization of each clock module observer.
	 */
	@Override
	public void start(){
		for(final HorlogeObserver observer : observers){
			if( observer instanceof Out ){
				( ( Out ) observer ).start();
			}
		}
		Callable<Integer> ordonancer = new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				isALive = true;
				System.out.println( " Launch ordonancer." );
				// TODO Auto-generated method stub
				while( isALive ){
					tick();
				}
				return 0;
			}
		};
		timerScheduler.submit( ordonancer );
		System.out.println( "Horloge started!" );
	}
	
	/**
	 * Stop function break clock synchronization of each module observer.
	 */
	@Override
	public void stop(){
		isALive = false;
		//timerScheduler.shutdown();
		timerScheduler.shutdownNow();
		for(final HorlogeObserver observer : observers){
			
			if( observer instanceof Out ){
				( ( Out ) observer).stop();
			}
			
		}
		System.out.println( "Horloge stopped!" );
	}
	
	public static int getSampleRate(){
		return HorlogeImpl.sampleRate;
	}
	
	
	public static void setSampleRate( int sampleRate ){
		HorlogeImpl.sampleRate = sampleRate;
	}
	
	/**
	 * sampleRate: sample rate production on sound card
	 */
	protected static int sampleRate;
	
	/**
	 * Clock observer list.
	 */
	private List<HorlogeObserver> observers;
	
	/**
	 * Module function clock observer launcher. 
	 */
	private ExecutorService timerScheduler;
	
	/**
	 * When clock is started this boolean is set to true, otherwise false.
	 */
	private boolean isALive = false;

}
